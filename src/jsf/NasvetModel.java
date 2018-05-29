package jsf;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import vao.Nasvet;
import vmesniki.NasvetVmesnik;

@ManagedBean(name = "nasvet")
@SessionScoped
public class NasvetModel {
	private Nasvet novNasvet = new Nasvet();
	
	@EJB
	NasvetVmesnik ejb;
	
	public List<Nasvet> getVseNasvete(){
		return ejb.seznamVsehNasvetov();
	}
	
	public void dodajNovNasvet() {
		long timeStamp = new Date().getTime();
		novNasvet.setTimeStamp(timeStamp);
		ejb.dodajNasvet(novNasvet);
		novNasvet = new Nasvet();
	}

	public Nasvet getNovNasvet() {
		return novNasvet;
	}

	public void setNovNasvet(Nasvet novNasvet) {
		this.novNasvet = novNasvet;
	}
}
