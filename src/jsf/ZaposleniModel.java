package jsf;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;
import vmesniki.DogodekVmesnik;
import vmesniki.OsebaVmesnik;

@ManagedBean(name = "zaposleni")
@SessionScoped
public class ZaposleniModel {

	private Dogodek dogodekPodrobno;

	@PostConstruct
	public void naredi() {
		dogodekPodrobno = new Dogodek();

	}

	@EJB
	OsebaVmesnik ov;

	@EJB
	DogodekVmesnik dv;


	// prikaz podrobnosti
	public void prikaziPodrobno(Dogodek d) {
		this.dogodekPodrobno = d;

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

	// za prikaz imena, vloge
	public Oseba getUporabnik() {
		return dv.najdiPoUporabniskemImenu(vrniUporabnika().getName());
	}
	//vrne tocke v pravilnem sklonu
	public String tockeSklon(int t) {
		if(t>2)
			return " točkami";
		if(t==2)
			return " točkama";
		return " točko";
		
	}
	
	public String odjavi() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// System.out.println("odjava");
		return "index.xhtml?faces-redirect=true";
	}

	// prikaz tock na index za uporabnika z najvec tockami
	public List<Oseba> getTopUporabnik() {
		return ov.topUporabnik();

	}

	// prikaz tock za top mesecnega uporabnika
	public List<Oseba> getTopMesecniUporabnik() {
		return ov.topMesecniUporanbik();

	}

	// ce je prvic
	public void prvic() {
		if (ov.vrniSeznamVsehOseb().size() == 0) {
			Oseba o = new Oseba();
			o.setDatumRojstva(Calendar.getInstance());
			o.setDatumZaposlitve(Calendar.getInstance());
			o.setDavcnaStevilka("4wfw");
			o.setEmail("nekaj@nekaj.com");
			o.setEMSO("9i9494944");
			o.setIme("Luka");
			o.setOddelek("Razvojni oddelek");
			o.setPriimek("Luka");
			o.setSpol("M");
			o.setGeslo("luka");
			o.setUporabniskoIme("luka");
			o.setTelefonskaStevilka("i99i");
			o.setVloga("kadrovska");
			
			Oseba o1 = new Oseba();
			o1.setDatumRojstva(Calendar.getInstance());
			o1.setDatumZaposlitve(Calendar.getInstance());
			o1.setDavcnaStevilka("56795");
			o1.setEmail("nekaj@nekaj.com");
			o1.setEMSO("9876543");
			o1.setIme("Timi");
			o1.setOddelek("Finance");
			o1.setPriimek("Timotej");
			o1.setSpol("M");
			o1.setGeslo("timi11");
			o1.setUporabniskoIme("timi");
			o1.setTelefonskaStevilka("090080070");
			o1.setVloga("zaposleni");
			
			Oseba o2 = new Oseba();
			o2.setDatumRojstva(Calendar.getInstance());
			o2.setDatumZaposlitve(Calendar.getInstance());
			o2.setDavcnaStevilka("56795");
			o2.setEmail("nekaj@nekaj.com");
			o2.setEMSO("9876543");
			o2.setIme("Eva");
			o2.setOddelek("Infrormatiki");
			o2.setPriimek("Horvat");
			o2.setSpol("Z");
			o2.setGeslo("eva");
			o2.setUporabniskoIme("eva");
			o2.setTelefonskaStevilka("123");
			o2.setVloga("zaposleni");
			
			Oseba o3 = new Oseba();
			o3.setDatumRojstva(Calendar.getInstance());
			o3.setDatumZaposlitve(Calendar.getInstance());
			o3.setDavcnaStevilka("090899431232");
			o3.setEmail("y@x.com");
			o3.setEMSO("1234567");
			o3.setIme("Tilen");
			o3.setOddelek("Informatiki");
			o3.setPriimek("Brum");
			o3.setSpol("M");
			o3.setGeslo("tilen");
			o3.setUporabniskoIme("tilen");
			o3.setTelefonskaStevilka("080123");
			o3.setVloga("zaposleni");
			
			Oseba o4 = new Oseba();
			o4.setDatumRojstva(Calendar.getInstance());
			o4.setDatumZaposlitve(Calendar.getInstance());
			o4.setDavcnaStevilka("090899431232");
			o4.setEmail("miha@mihec.com");
			o4.setEMSO("1234567");
			o4.setIme("Miha");
			o4.setOddelek("Finance");
			o4.setPriimek("G");
			o4.setSpol("M");
			o4.setGeslo("miha");
			o4.setUporabniskoIme("miha");
			o4.setTelefonskaStevilka("9876");
			o4.setVloga("zaposleni");
			
			Oseba o5 = new Oseba();
			o5.setDatumRojstva(Calendar.getInstance());
			o5.setDatumZaposlitve(Calendar.getInstance());
			o5.setDavcnaStevilka("090899431232");
			o5.setEmail("mojca@m.com");
			o5.setEMSO("1234567");
			o5.setIme("Mojca");
			o5.setOddelek("Finance");
			o5.setPriimek("Donato");
			o5.setSpol("Z");
			o5.setGeslo("mojca");
			o5.setUporabniskoIme("mojca");
			o5.setTelefonskaStevilka("123");
			o5.setVloga("zaposleni");
			
			Oseba o6 = new Oseba();
			o6.setDatumRojstva(Calendar.getInstance());
			o6.setDatumZaposlitve(Calendar.getInstance());
			o6.setDavcnaStevilka("112");
			o6.setEmail("mojca@m.com");
			o6.setEMSO("1234567");
			o6.setIme("Matic");
			o6.setOddelek("Finance");
			o6.setPriimek("Don Vito");
			o6.setSpol("M");
			o6.setGeslo("matic");
			o6.setUporabniskoIme("matic");
			o6.setTelefonskaStevilka("113");
			o6.setVloga("organizator");
			
			

			ov.dodajOsebo(o);
			ov.dodajOsebo(o1);
			ov.dodajOsebo(o2);
			ov.dodajOsebo(o3);
			ov.dodajOsebo(o4);
			ov.dodajOsebo(o5);
			ov.dodajOsebo(o6);
		}
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
