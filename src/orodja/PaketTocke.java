package orodja;

public class PaketTocke {
	private String tocke;
	private String oznake;

	public PaketTocke(String tocke, String oznake) {
		this.tocke = tocke;
		this.oznake = oznake;

	}

	public String getTocke() {
		return tocke;
	}

	public void setTocke(String tocke) {
		this.tocke = tocke;
	}

	public String getOznake() {
		return oznake;
	}

	public void setOznake(String oznake) {
		this.oznake = oznake;
	}

}
