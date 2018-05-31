package jsf;

import javax.ejb.EJB;

import vmesniki.MailVmesnik;
import vmesniki.NasvetVmesnik;

public class MailModel implements MailVmesnik {
	
	@EJB
	MailVmesnik ejb;

	@Override
	public void poslji(String to, String subject, String body) {
		ejb.poslji(to, subject, body);
	}
	

}
