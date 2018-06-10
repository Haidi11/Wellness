package jsf;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import orodja.PaketTocke;
import vao.Oseba;
import vmesniki.DogodekVmesnik;
import vmesniki.NasvetVmesnik;
import vmesniki.OsebaVmesnik;
import vmesniki.TekmovanjeVmesnik;

@ManagedBean(name = "profil")
@RequestScoped
public class ProfilUporabnikaModel {
	private ZaposleniModel zd = new ZaposleniModel();
	private Oseba oseba;
	private String tocke;
	private String oznake;
	private String naslednjaNagrada;
	
	@EJB
	NasvetVmesnik nv;
	
	@EJB
	OsebaVmesnik ov;
	
	@EJB
	DogodekVmesnik dv;
	
	@EJB
	TekmovanjeVmesnik tv;
	
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	
	
	@PostConstruct
	public void podatkiOsebe() {
		oseba =  dv.najdiPoUporabniskemImenu(vrniUporabnika().getName());
		pridobiTocke();
		poisciNaslednjoNagrado();
	}
	
	private void poisciNaslednjoNagrado() {
		naslednjaNagrada=tv.poisciNaslednjoNagrado(vrniUporabnika().getName());
		
	}



	public void shraniUrejenoOseno( ) {
		ov.shraniUrejenoOsebo(oseba);
	}
	public void spremeniGeslo( ) {
		ov.spremeniGeslo(oseba);
	}
	
	//priobi tocke, sesteje za vsak mesec za posameznega uporabnika
	public void pridobiTocke() {
		PaketTocke temp = ov.vrniTockeZaUporabnika(vrniUporabnika().getName());
		tocke = temp.getTocke();
		oznake = temp.getOznake();
		
	}
	
	public Oseba getOseba() {
		return oseba;
	}

	public void setOseba(Oseba oseba) {
		this.oseba = oseba;
	}


	public String getTocke() {
		return tocke;
	}


	public void setTocke(String tocke) {
		this.tocke = tocke;
	}


	public String getOznake() {
		return oznake;
	}


	public void setOznake(String oznake) {
		this.oznake = oznake;
	}



	public String getNaslednjaNagrada() {
		return naslednjaNagrada;
	}



	public void setNaslednjaNagrada(String naslednjaNagrada) {
		this.naslednjaNagrada = naslednjaNagrada;
	}
	
	
}
