package mail;

import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import vmesniki.MailVmesnik;

@Stateless
@Resource(name= "java:/jboss/mail/gmail")
public class MailBean implements MailVmesnik {
	
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
			System.out.println("ne gre poslat :( ");
		}	
	}
}
	
	

