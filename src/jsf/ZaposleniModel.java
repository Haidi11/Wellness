package jsf;

import java.security.Principal;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ejb.DogodekVmesnik;
import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;

@ManagedBean(name = "zaposleni")
@SessionScoped
public class ZaposleniModel {

	@EJB
	DogodekVmesnik dv;

	// za prikaz stilov glede na prijavljenost
	private String prijave;

	// pridobi uporabnika
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}

	// uporabnik izbere dogodek, ta se doda na njegov seznam dogodkov
	public void izberiDogodek(Dogodek d) {
		Principal p = vrniUporabnika();
		dv.izberiDogodek(d, p.getName());
	}

	// prikaz dogodkov z dodanimi lastnostmi o prijavljenosti
	public List<Dogodek> getVrniVseDogodkeZaUporabnika() {
		PaketZaprikazDogodkov p = dv.sezamDogodkovZaUporabnika(vrniUporabnika().getName());
		prijave = p.getSeznamRazredov();
		// System.out.println(prijave);
		return p.getSeznam();
	}
	
	//za prikaz imena, vloge
	public Oseba getUporabnik() {
		return dv.najdiPoUporabniskemImenu(vrniUporabnika().getName());
		
	}

	/*
	 * getterji, setterji
	 */
	public String getPrijave() {
		return prijave;
	}

	public void setPrijave(String prijave) {
		this.prijave = prijave;
	}

}
