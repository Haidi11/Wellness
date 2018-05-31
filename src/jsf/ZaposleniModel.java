package jsf;

import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import vmesniki.*;
import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;

@ManagedBean(name = "zaposleni")
@SessionScoped
public class ZaposleniModel {

	private Dogodek dogodekPodrobno;
	
	
	@PostConstruct
	public void naredi() {
		dogodekPodrobno= new Dogodek();
		
	}

	@EJB
	OsebaVmesnik ov; 
	   

	
	@EJB
	DogodekVmesnik dv;

	//prikaz podrobnosti
	public void prikaziPodrobno(Dogodek d) {
		this.dogodekPodrobno=d;
		
	}
	
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
	
	
	public String odjavi() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
//System.out.println("odjava");
		return "index.xhtml?faces-redirect=true";
	}
	
	//prikaz tock na index za uporabnika z najvec tockami 
	  public Oseba getTopUporabnik() { 
	    return ov.topUporabnik(); 
	     
	  } 
	  //prikaz tock za top mesecnega uporabnika 
	  public Oseba getTopMesecniUporabnik() { 
	    return ov.topMesecniUporanbik(); 
	   
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

	public Dogodek getDogodekPodrobno() {
		return dogodekPodrobno;
	}

	public void setDogodekPodrobno(Dogodek dogodekPodrobno) {
		this.dogodekPodrobno = dogodekPodrobno;
	}

	

}
