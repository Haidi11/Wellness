package mail;

public class Mail {
	

	private String mailP;
	private String predmet;
	private String vsebina;
	

	
	public Mail() {
		this.mailP="";
		this.vsebina="";
		this.predmet="";
		
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
	public String getMailP() {
		return mailP;
	}
	public void setMailP(String mailP) {
		this.mailP = mailP;
	}

}
