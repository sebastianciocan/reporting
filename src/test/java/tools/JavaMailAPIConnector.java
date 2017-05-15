package tools;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

public class JavaMailAPIConnector {

	private String mailStoreProtocol = "";
	private String imaps = "";
	private String imapEmailCom = "";
	private String emailAddress = "";
	private String password = "";
	
	
	public JavaMailAPIConnector (String mailStoreProtocol, String imaps, String imapEmailCom, String emailAddress, String password) {

		this.mailStoreProtocol = mailStoreProtocol;
		this.imaps = imaps;
		this.imapEmailCom = imapEmailCom;
		this.emailAddress = emailAddress;
		this.password = password;
		
	}
	

	// get link 
	public String getLinkFromEmail(String emailtext, String begin, String end) {
		String value = "";
		
		Pattern pattern = Pattern.compile(begin + "(.*?)" + end);
		Matcher matcher = pattern.matcher(emailtext);
		if (matcher.find()) {
			value = matcher.group(1).trim();
		}else
			System.out.println("String doesn't match the pattern");
		
		return value;
	}
	
	
	// search for a specific email 
	public EmailModel searchEmail(String emailAddressFrom, String subject) {
		EmailModel emailModel = new EmailModel();
		Message[] message = getEmails();
		
		for (int i = 0; i < message.length; i++) {
			try {
				Address address =  message[i].getFrom()[0];
			    if (address.toString().contains(emailAddressFrom) && !(message[i].isSet(Flags.Flag.SEEN))
							&& message[i].getSubject().contains(subject)) {
					emailModel.setContent(getTextFromMessage(message[i]));
					emailModel.setSubject(message[i].getSubject());
					emailModel.setSender(message[i].getFrom()[0].toString());
					break;
			    }			 
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emailModel;
	}
	
	// retrieve text from message
	private String getTextFromMessage(Message message) {
		String textFromMessage = "";
		try {
			textFromMessage = "subject: " + message.getSubject() + "\n" + "from: " + message.getFrom()[0] + "\n";
			if (message.isMimeType("text/plain")){
				textFromMessage = message.getContent().toString();
			}else if(message.isMimeType("multipart/*")) {
				MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
				for (int i = 0; i < mimeMultipart.getCount(); i ++) {
					BodyPart bodyPart = mimeMultipart.getBodyPart(i);
					String html = (String) bodyPart.getContent().toString();
					textFromMessage = textFromMessage + "\n" + org.jsoup.Jsoup.parse(html).text();
				}
			}
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textFromMessage;
	}

	//connecting to gmail inbox
	private Message[] getEmails() {
		
		// get the session for ensureing commnunication with email server
		Properties props = System.getProperties();
		props.setProperty(mailStoreProtocol, imaps);
		Session session = Session.getDefaultInstance(props, null);
		
		Message[] messages = null;
		try {
			
			// get a store object that uses the imap protocol
			Store store = session.getStore(imaps);
			
			// connect to your account - now we can model folder messages from account 
			store.connect(imapEmailCom, emailAddress, password);

			// get inbox folder
			Folder folder = store.getFolder("INBOX");
			
			// open folder
			folder.open(Folder.READ_WRITE);
			
			// with messages object we can model the email message/content
			messages = folder.getMessages();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return messages;
	}	
}
