package tools;

public class EmailModel {
	private String sender;
	private String subject;
	private String content;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void emailModel(String sender, String subject, String content) {
		this.sender = sender;
		this.subject = subject;
		this.content = content;

	}
}
