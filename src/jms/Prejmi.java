package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import vmesniki.MailVmesnik;



@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class Prejmi implements MessageListener {

	@EJB
	MailVmesnik mv;
	
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage tm = (ObjectMessage) message;
			try {

				
				Sporocilo s = (Sporocilo) tm.getObject();
				mv.poslji(s);
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Prispelo je neznano sporocilo.");
		}

	}

}
