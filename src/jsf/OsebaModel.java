package jsf;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import vmesniki.*;
import vmesniki.*;
import vao.Oseba;

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
	//oddelki 
	private  Map<String,String> oddelki;
	@PostConstruct
	public void init() {
		oddelki =ejb.vrniOddelke();
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

	
	
	
}
