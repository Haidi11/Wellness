package vmesniki;

import javax.ejb.Local;

import mail.Mail;

@Local
public interface PosljiVmesnik {

	void poslji(Mail mail);
	void posljiMail(String email, String zadeva, String telo) throws Exception;
}
