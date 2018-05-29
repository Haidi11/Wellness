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
	
	public List<Nasvet> getVseNasveteAvtorja(int id){
		return ejb.getNasveteAvtorja(id);
	}
	
	public void dodajNovNasvet() {
		long timeStamp = new Date().getTime();
		novNasvet.setTimeStamp(timeStamp);
		ejb.dodajNasvet(novNasvet);
		novNasvet = new Nasvet();
	}
	
	private Principal vrniAvtorja() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	/*public List<Nasvet> getVrniVseNasveteAvtoja() {
		PaketZaPrikazNasvetov p = ejb.sezamDogodkovZaUporabnika(vrniAvtorja().ge)
		prijave = p.getSeznamRazredov();
		// System.out.println(prijave);
		return p.getSeznam();
	}*/
	
	public void izbrisiNasvet(Nasvet izbranNasvet) {
		ejb.brisiNasvet(izbranNasvet);
	}

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
