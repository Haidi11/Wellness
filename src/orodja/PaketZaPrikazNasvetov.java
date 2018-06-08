package orodja;

import java.util.List;

import vao.Nasvet;

public class PaketZaPrikazNasvetov {
	private String seznamNasvetov;
	private List<Nasvet> seznam;
	
	public String getSeznamNasvetov() {
		return seznamNasvetov;
	}
	public void setSeznamNasvetov(String seznamNasvetov) {
		this.seznamNasvetov = seznamNasvetov;
	}
	public List<Nasvet> getSeznam() {
		return seznam;
	}
	public void setSeznam(List<Nasvet> seznam) {
		this.seznam = seznam;
	}
}
