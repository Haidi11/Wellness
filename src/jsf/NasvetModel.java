package jsf;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Nasvet;
import vao.Oseba;
import vmesniki.NasvetVmesnik;

@ManagedBean(name = "nasvet")
@SessionScoped
public class NasvetModel {
	private Nasvet novNasvet = new Nasvet();
	private String prijave;
	
	@EJB
	NasvetVmesnik ejb;
	
	public List<Nasvet> getVseNasvete(){
		return ejb.seznamVsehNasvetov();
	}
	
	public void preusmeriNaUrejanje() {
	}
	
	private Principal vrniAvtorja() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	public int idAvtorja () {
		String ime = vrniAvtorja().getName();
		int id = ejb.najdiIdAvtorja(ime);
		return id;
	}
	

	public List<Nasvet> getVseNasveteAvtorja(){
		int id = idAvtorja ();
		return ejb.getNasveteAvtorja(id);
	}
	
	public void dodajNovNasvet() {
		long timeStamp = new Date().getTime();
		int id = idAvtorja ();
		Oseba o = new Oseba(id);
		novNasvet.setAvtor(o);
		novNasvet.setTimeStamp(timeStamp);
		ejb.dodajNasvet(novNasvet);
		novNasvet = new Nasvet();
	}
	
	public void izbrisiNasvet(Nasvet izbranNasvet) {
		ejb.brisiNasvet(izbranNasvet);
	}
	
	public void urediNasvete(String novNasvet) {
		int idNasveta = idAvtorja();
		ejb.urediNasvet(idNasveta, novNasvet);
	};

	public Nasvet getNovNasvet() {
		return novNasvet;
	}

	public void setNovNasvet(Nasvet novNasvet) {
		this.novNasvet = novNasvet;
	}
	
	public void getNasveteUporabnika(Nasvet novNasvet) {
		this.novNasvet = novNasvet;
	}
}
