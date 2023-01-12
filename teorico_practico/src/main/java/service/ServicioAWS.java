package service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import model.EnvioEmail;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.RawMessage;
import software.amazon.awssdk.services.ses.model.SendRawEmailRequest;
import software.amazon.awssdk.services.ses.model.SesException;

@Service("ServicioAWS")
public class ServicioAWS {

	public boolean enviarEmail(EnvioEmail email) throws MessagingException, IOException, javax.mail.MessagingException {
		
		String sender = email.getSender();
		String recipient = email.getRecipient();
		String subject = email.getSubject();
		String bodyText = email.getBodyText();
		String bodyHTML = email.getBodyHTML();
		
		Region region = Region.US_EAST_1;
		
		SesClient client = SesClient.builder()
	            .region(region)
	            .credentialsProvider(ProfileCredentialsProvider.create())
	            .build();
 
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage message = new MimeMessage(session);

// Add subject, from and to lines.
		message.setSubject(subject, "UTF-8");
		message.setFrom(new InternetAddress(sender));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

// Create a multipart/alternative child container.
		MimeMultipart msgBody = new MimeMultipart("alternative");

// Create a wrapper for the HTML and text parts.
		MimeBodyPart wrap = new MimeBodyPart();

// Define the text part.
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(bodyText, "text/plain; charset=UTF-8");

// Define the HTML part.
		MimeBodyPart htmlPart = new MimeBodyPart();
		htmlPart.setContent(bodyHTML, "text/html; charset=UTF-8");

// Add the text and HTML parts to the child container.
		msgBody.addBodyPart(textPart);
		msgBody.addBodyPart(htmlPart);

// Add the child container to the wrapper object.
		wrap.setContent(msgBody);

// Create a multipart/mixed parent container.
		MimeMultipart msg = new MimeMultipart("mixed");

// Add the parent container to the message.
		message.setContent(msg);

// Add the multipart/alternative part to the message.
		msg.addBodyPart(wrap);

		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			message.writeTo(outputStream);
			ByteBuffer buf = ByteBuffer.wrap(outputStream.toByteArray());

			byte[] arr = new byte[buf.remaining()];
			buf.get(arr);

			SdkBytes data = SdkBytes.fromByteArray(arr);
			RawMessage rawMessage = RawMessage.builder().data(data).build();

			AwsRequestOverrideConfiguration myConf = AwsRequestOverrideConfiguration.builder()
					.credentialsProvider(ProfileCredentialsProvider.create()).build();

			SendRawEmailRequest rawEmailRequest = SendRawEmailRequest.builder().rawMessage(rawMessage)
					.overrideConfiguration(myConf).build();

			client.sendRawEmail(rawEmailRequest);
			client.close();
			return true;
			

		} catch (SesException e) {
			return false;
		}
	}
}
