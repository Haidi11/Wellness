package jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mail.Mail;
import vmesniki.MailVmesnik;
import vmesniki.NasvetVmesnik;

@ManagedBean(name = "mail")
@SessionScoped
public class MailModel {
	private Mail novMail = new Mail();
	
	@EJB
	MailVmesnik ejb;
	
	public void poslji(String to, String subject, String body) {
		novMail.setMailPrejemnika(to);
		novMail.setPredmet(subject);
		novMail.setVsebina(body);
		ejb.poslji(novMail.getMailPrejemnika(), novMail.getPredmet(), novMail.getVsebina());
	}

	public Mail getNovMail() {
		return novMail;
	}

	public void setNovMail(Mail novMail) {
		this.novMail = novMail;
	}
}
