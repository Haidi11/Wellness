package jsf;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import vao.Nasvet;
import vmesniki.DogodekVmesnik;
import vmesniki.NasvetVmesnik;

@ManagedBean(name = "nasvet")
@SessionScoped
public class NasvetModel {
	private Nasvet novNasvet = new Nasvet();
	private Nasvet nasvetPodrobno;
	private Nasvet uredinasvet;

	@EJB
	NasvetVmesnik nv;
	@EJB
	DogodekVmesnik dv;
	
	public List<Nasvet> getVseNasvete(){
		return nv.seznamVsehNasvetov();
	}
	
	public void preusmeriNaUrejanje() {
	}
	
	private Principal vrniAvtorja() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	public int idAvtorja () {
		String ime = vrniAvtorja().getName();
		int id = nv.najdiIdAvtorja(ime);
		return id;
	}
	

	public List<Nasvet> getVseNasveteAvtorja(){
		int id = idAvtorja ();
		return nv.getNasveteAvtorja(id);
	}
	
	public void dodajNovNasvet() {
		novNasvet.setAvtor(dv.najdiPoUporabniskemImenu(vrniAvtorja().getName()));
		novNasvet.setTimeStamp(new Date().getTime());
		nv.dodajNasvet(novNasvet);
		
		novNasvet = new Nasvet();
	}
	
	public void izbrisiNasvet(Nasvet izbranNasvet) {
		nv.brisiNasvet(izbranNasvet);
	}
	
	
	public String urediNasvet(Nasvet a) {
		uredinasvet=a;
		
		return "urediNasvet2.xhtml";
	}
	public String podrobno(Nasvet n) {
		nasvetPodrobno=n;
		return "nasvetPodrobno.xhtml";
	}
	
	public String shraniUrejenNasvet( ) {
		nv.dodajUrejenNasvet(uredinasvet);
		return "nasveti.xhtml";
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

	public Nasvet getNasvetPodrobno() {
		return nasvetPodrobno;
	}

	public void setNasvetPodrobno(Nasvet nasvetPodrobno) {
		this.nasvetPodrobno = nasvetPodrobno;
	}

	public Nasvet getUredinasvet() {
		return uredinasvet;
	}

	public void setUredinasvet(Nasvet uredinasvet) {
		this.uredinasvet = uredinasvet;
	}
}