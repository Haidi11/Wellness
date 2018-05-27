package orodja;

import java.util.List;

import vao.Dogodek;

public class PaketZaprikazDogodkov {

	private String seznamRazredov;
	private List<Dogodek> seznam;
	
	public String getSeznamRazredov() {
		return seznamRazredov;
	}
	public void setSeznamRazredov(String seznamRazredov) {
		this.seznamRazredov = seznamRazredov;
	}
	public List<Dogodek> getSeznam() {
		return seznam;
	}
	public void setSeznam(List<Dogodek> seznam) {
		this.seznam = seznam;
	}
}
