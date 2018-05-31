package mail;

public class Mail {
	
	private String mailPrejemnika;
	private String predmet;
	private String vsebina;
	
	public String getMailPrejemnika() {
		return mailPrejemnika;
	}
	public void setMailPrejemnika(String mailPrejemnika) {
		this.mailPrejemnika = mailPrejemnika;
	}
	public String getPredmet() {
		return predmet;
	}
	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}
	public String getVsebina() {
		return vsebina;
	}
	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}
}
