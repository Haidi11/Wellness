package jsf;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import vao.Tekmovanje;
import vmesniki.DogodekVmesnik;
import vmesniki.OsebaVmesnik;
import vmesniki.TekmovanjeVmesnik;

@ManagedBean(name = "tekmovanje")
@SessionScoped
public class TekmovanjeModel {

	@EJB
	TekmovanjeVmesnik tv;
	
	@EJB
	DogodekVmesnik dv;

	@EJB
	OsebaVmesnik ov;

	private Tekmovanje novoTekmovanje = new Tekmovanje();

	public void dodajTekmovanje() {
		novoTekmovanje.setLastnik(dv.najdiPoUporabniskemImenu(vrniUporabnika().getName()));
		tv.dodajTekmovanje(novoTekmovanje);
		novoTekmovanje = new Tekmovanje();

	}
	
	
	private  Map<String,String> tipi;
	@PostConstruct
	public void init() {
		tipi =tv.vrniTipe();
		
		
	}

	public List<Tekmovanje> getMojaTekmovanja() {
		 List<Tekmovanje> list=tv.vrniMojaTekmovanja(dv.najdiPoUporabniskemImenu(vrniUporabnika().getName()).getIdOseba());
		 
		return list;
	}

	public String zmagovalci(Tekmovanje a) {
		if(a==null)
			return "";
		
		return tv.najdiPoId(a.getId()).getIzpisZmagovalci();

	}

	// potrdi zmagovalca tekmovanja
	public void ustavi(Tekmovanje t) {
		tv.koncajTekmovanje(t);

	}

	// vrne uporabnika
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}

	public List<Tekmovanje> getVsaTekmovanja() {
		return tv.vrniVsaTekmovanja();

	}

	public Tekmovanje getNovoTekmovanje() {
		return novoTekmovanje;
	}

	public void setNovoTekmovanje(Tekmovanje novoTekmovanje) {
		this.novoTekmovanje = novoTekmovanje;
	}

	public Map<String, String> getTipi() {
		return tipi;
	}

	public void setTipi(Map<String, String> tipi) {
		this.tipi = tipi;
	}

}
