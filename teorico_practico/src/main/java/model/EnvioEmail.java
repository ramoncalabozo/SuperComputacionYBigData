package model;


public class EnvioEmail {
	private String sender;
	private String recipient;
	private String subject;
	private String bodyText;
	private String bodyHTML;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getBodyHTML() {
		return bodyHTML;
	}

	public void setBodyHTML(String bodyHTML) {
		this.bodyHTML = bodyHTML;
	}
}
