package service;

import org.java.api.aws.ses.SESClientBuilder;
import org.java.api.aws.ses.SESEmailMessage;

import com.amazonaws.regions.Regions;

public class AWSService {

	private final String defaultFromEmail = "youremail@example.com"; // This should be an AWS verified email address.
	private final String defaultFromName = "Your Name"; // Your name. This will be displayed in the "From" section of
														// the email message.
	private final String awsAccessKeyId = "AWS Access Key Id"; // Needs to be obtained from AWS.
	private final String awsSecretAccessKey = "AWS Secret Access Key"; // Needs to be obtained from AWS.
	private final Regions awsRegion = Regions.US_WEST_2; // AWS region used for sending emails from your account.

	// This will initialize the AWS Client.
	SESClientBuilder awsClient = new SESClientBuilder(defaultFromName, defaultFromEmail, awsRegion, awsAccessKeyId,
			awsSecretAccessKey);

	// Use this method to compose your email message. You can also write your own
	// wrapper class for this method.
	public SESEmailMessage composeMessage() {
		SESEmailMessage message = new SESEmailMessage();
		message.setTo(""); // Comma separated list of emails.
		message.setCc(""); // Optional CC. Set to null if not required. Or ignore it completely.
		message.setBcc(""); // Optional BCC. Set to null if not required. Or ignore it completely.
		message.setSubject(""); // Subject of your message.
		message.setBody(""); // String with your message content. Also accepts HTML content.
		// message.setFileList(someFileList); // Collection of java.io.File objects. These will be sent as attachments.
		return message;
	}

	// This method will send your email message.
	public boolean sendEmail(SESEmailMessage message) {
		if (awsClient.sendEmail(message))
			return true;
		else
			return false;
	}

	// If you want to add a nice HTML footer to your message.
	public boolean sendEmailWithFooter(SESEmailMessage message, String extraFooter) {
		if (awsClient.sendEmail(message, extraFooter))
			return true;
		else
			return false;
	}

	// If you want to add a different reply-to address to your message.
	public boolean sendEmailWithFooter(SESEmailMessage message, String senderName, String senderEmailAddress) {
		if (awsClient.sendEmail(message, senderName, senderEmailAddress))
			return true;
		else
			return false;
	}

	// If you want to add a nice HTML footer, and a different reply-to address to
	// your message.
	public boolean sendEmailWithFooter(SESEmailMessage message, String extraFooter, String senderName,
			String senderEmailAddress) {
		if (awsClient.sendEmail(message, extraFooter, senderName, senderEmailAddress))
			return true;
		else
			return false;
	}

}
