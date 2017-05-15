package tools;

import org.yecht.Data;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sebastianciocan on 5/15/2017.
 */
public class JavaMail {

    private String mailStoreProtocol = "";
    private String imaps = "";
    private String imapEmailCom = "";
    private String username = "";
    private String password = "";

    public JavaMail(String mailStoreProtocol,String imaps, String imapEmailCom, String username, String password){
        this.mailStoreProtocol = mailStoreProtocol;
        this.imapEmailCom = imapEmailCom;
        this.imaps = imaps;
        this.username = username;
        this.password = password;
    }

    public Message[] getEmails(){
        Properties properties = System.getProperties();

        properties.setProperty(mailStoreProtocol,imaps);

        Session session = Session.getDefaultInstance(properties,null);

        Message[] messages = null;
        try{
            Store store = session.getStore();

            store.connect(imapEmailCom,username,password);

            Folder folder = store.getFolder("INBOX");

            folder.open(Folder.READ_WRITE);

            messages = folder.getMessages();
        }
        catch (MessagingException e){
            System.out.println(e);
        }
        return messages;
    }
    public String getTextFromMessages(Message message){
        String textFromMessages = "";
        try{
            textFromMessages = "subject: " + message.getSubject() + "\n" + "from: " + message.getFrom()[0] + "\n";
            if(message.isMimeType("text/plain")){
                textFromMessages = message.getContent().toString();
            }else if(message.isMimeType("multipart/*")){
                MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                for(int i = 0; i< message.getSize(); i++){
                    BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                    String html = bodyPart.getContent().toString();
                    textFromMessages = textFromMessages + "\n" + org.jsoup.Jsoup.parse(html).text();
                }
            }
        }
        catch (MessagingException | IOException e){
            System.out.println(e);
        }
        return textFromMessages;
    }
    public EmailModel searchEmail(String emailAddressFrom, String subject){
        EmailModel emailModel = new EmailModel();
        Message[] messages = getEmails();

        for(int i = 0; i < messages.length;i++){
            try{
                Address address = messages[i].getFrom()[0];
                if(address.toString().contains(emailAddressFrom) && !(messages[i].isSet(Flags.Flag.SEEN)) && messages[i].getSubject().contains(subject)){
                    emailModel.setSubject(messages[i].getSubject());
                    emailModel.setContent(getTextFromMessages(messages[i]));
                    emailModel.setSender(messages[i].getFrom()[0].toString());
                }
            }
            catch (MessagingException e){
                System.out.println(e);
            }
        }
        return emailModel;
    }
}
