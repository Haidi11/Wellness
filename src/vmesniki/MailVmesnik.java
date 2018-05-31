package vmesniki;

import javax.ejb.Local;

@Local
public interface MailVmesnik {
	 void poslji(String to, String subject, String body);
}
