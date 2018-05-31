package mail;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.annotation.Resource;

import vmesniki.MailVmesnik;

@Stateless
public class MailBean implements MailVmesnik {
<<<<<<< Updated upstream
	@Resource(name= "java:/jboss/mail/gmail")
=======
>>>>>>> Stashed changes
	private Session session;
	public MailBean() {}
	
	@Override
	public void poslji(String to, String subject, String body) {
		
		try {
			Message msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject(subject);
			msg.setText(body);
			Transport.send(msg);
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.println("ne gre poslat :( ");
		}	
	}
}
	
	

