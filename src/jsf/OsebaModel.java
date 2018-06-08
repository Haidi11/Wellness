package jsf;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vao.Oseba;
import vmesniki.OsebaVmesnik;

@ManagedBean(name="osebe")
@SessionScoped
public class OsebaModel {

	//ejb za upravljanje z entitetami
	@EJB
	OsebaVmesnik ejb;
	
	//oseba na katero se navezujejoo prazna polja ko odpres spletno aplikacijo
	private Oseba novaOseba= new Oseba();
	
	//vrne vse osebe
	public List<Oseba> getVrniVseOsebe(){
		
		return ejb.vrniSeznamVsehOseb();
	}
	
	//dodaj osebo, ter naredi novo, da se polja resetirajo
	public void dodajOsebo() {
		ejb.dodajOsebo(novaOseba);
		novaOseba= new Oseba();
	}
	
	//oddelki in vloge
	private  Map<String,String> oddelki;
	private  Map<String,String> vloga;
	@PostConstruct
	public void init() {
		oddelki =ejb.vrniOddelke();
		vloga= ejb.vrniVloge();
		
	}
	
	public Oseba getNovaOseba() {
		return novaOseba;
	}

	public void setNovaOseba(Oseba novaOseba) {
		this.novaOseba = novaOseba;
	}
	
	
	public  Map<String, String> getOddelki() {
		return oddelki;
	}

	public  void setOddelki(Map<String, String> oddelki) {
		oddelki = oddelki;
	}

	public Map<String, String> getVloga() {
		return vloga;
	}

	public void setVloga(Map<String, String> vloga) {
		this.vloga = vloga;
	}

	
	
	
}
