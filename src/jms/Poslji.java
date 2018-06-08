package jms;

import javax.ejb.Stateless;
import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

import mail.Mail;
import vmesniki.PosljiVmesnik;


@Stateless
public class Poslji implements PosljiVmesnik{
	
	public void posljiMail(String email, String zadeva, String telo) throws Exception {

		InitialContext ctx = new InitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:/ConnectionFactory");
		QueueConnection cnn = factory.createQueueConnection("guest", "guest");
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);

		sender.send(session.createObjectMessage(new Sporocilo(email, zadeva, telo)), DeliveryMode.PERSISTENT, 3, 10000);

		// sender.send(session.createTextMessage("DAJMO!"));

		// sporocilo, ki ni trajno
		// Message m=session.createTextMessage("NETRAJNO SPOROCILO");
		// sender.send(m,DeliveryMode.NON_PERSISTENT,3,2000);

		// sporocilo, ki je trajno
		// m=session.createTextMessage("TRAJNO SPOROCILO");
		// sender.send(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();

	}	
	
	
	
	
		public void poslji(Mail mail)  {
			try {
				posljiMail(mail.getMailP(),mail.getPredmet(),mail.getVsebina());
			} catch (Exception e) {
				System.out.println("nekaj ne dela (Poslji.poslji(...))");
				e.printStackTrace();
			}
			
		}
	

}
