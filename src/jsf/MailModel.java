package jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mail.Mail;
import vmesniki.MailVmesnik;
import vmesniki.NasvetVmesnik;
import vmesniki.PosljiVmesnik;

@ManagedBean(name = "mail")
@SessionScoped
public class MailModel {
	private Mail novMail = new Mail();
	private String njihovMail;
	@EJB
	PosljiVmesnik pv;
	
	//tega zdaj vec ne rabimo
	@EJB
	MailVmesnik ejb;

	public void posljiJMS() {
		novMail.setMailP("wellness.keks@gmail.com");
		novMail.setVsebina("Oseba za mailom: " +  njihovMail + " nam sporoča naslednje:  " + novMail.getVsebina());
		pv.poslji(novMail);
		
	}

	public Mail getNovMail() {
		return novMail;
	}

	public void setNovMail(Mail novMail) {
		this.novMail = novMail;
	}

	public String getNjihovMail() {
		return njihovMail;
	}

	public void setNjihovMail(String njihovMail) {
		this.njihovMail = njihovMail;
	}
}
