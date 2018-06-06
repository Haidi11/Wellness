package mail;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jms.Sporocilo;

import javax.annotation.Resource;

import vmesniki.MailVmesnik;

@Stateless
public class MailBean implements MailVmesnik {

	@Resource(name= "java:/jboss/mail/gmail")

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
			System.out.println("mail uspesno poslan :)"); 
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.println("ne gre poslat :( ");
		}	
	}

	@Override
	public void poslji(Sporocilo s) {
		poslji(s.getEmail(),s.getZadeva(),s.getTelo());
		
	}
}
	
	

