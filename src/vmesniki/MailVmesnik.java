package vmesniki;

import javax.ejb.Local;

import jms.Sporocilo;

@Local
public interface MailVmesnik {
	void poslji(String to, String subject, String body);
	void poslji(Sporocilo s);
}
