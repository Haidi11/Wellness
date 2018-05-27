package jsf;

import java.security.Principal;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import ejb.DogodekVmesnik;
import vao.Dogodek;
import vao.Oseba;

@ManagedBean(name = "dogodek")
@SessionScoped
public class DogodekModel {

	@EJB
	DogodekVmesnik ejb;

	private Dogodek novDogodek = new Dogodek();
	private Dogodek izbranDogodek;
	

	//vrne dogodke prijavljenega uporabnika
	public List<Dogodek> getMojiDogodki(){
		
		return ejb.vrniMojeDogodke(getUporabnik().getIdOseba());
	}
	//vrne osebe ki so prijavljene na dogodek
	public List<Oseba> getVrniPrijavljeneOsebeNaDogodek(){
		//return ejb.vrniMojeUdelezence(izbranDogodek.getIdDogodek());
		Dogodek temp = ejb.vrniMojDogodek(izbranDogodek.getIdDogodek());
		izbranDogodek=temp;
		return temp.getUdelezenci();
	}
	
	//izbira dogodka za prikaz na strani za podrobnosti
	public String izberiDogodek(Dogodek d) {
		this.izbranDogodek=d;
		return "podrobnostiDogodek.xhtml";
	}
	
	//izbira dogodka za prikaz na strani za podrobnosti
		public String izberiDogodekKotLastnik(Dogodek d) {
			this.izbranDogodek=ejb.dogodek(d.getIdDogodek());
			return "mojDogodek.xhtml";
		}
	
	//dodajanje novega dogodka
	public void dodajDogodek() {
		novDogodek.setIdLastnik(getUporabnik().getIdOseba());
		ejb.dodajDogodek(novDogodek);
		novDogodek = new Dogodek();
	}
	
	//prikaz vseh dogodkov
	public List<Dogodek> getVrniVseDogodke() {
		return ejb.sezamDogodkov();
	}
	//izbris dogodka
	public void izbrisiDogodek(Dogodek d) {
		ejb.odstraniDogodek(d);
	}
	
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	public Oseba getUporabnik() {
		return ejb.najdiPoUporabniskemImenu(vrniUporabnika().getName());
		
	}
	
	
	/*
	 * getterji, setterji
	 */
	
	
	public Dogodek getNovDogodek() {
		return novDogodek;
	}

	public void setNovDogodek(Dogodek novDogodek) {
		this.novDogodek = novDogodek;
	}

	public Dogodek getIzbranDogodek() {
		return izbranDogodek;
	}

	public void setIzbranDogodek(Dogodek izbranDogodek) {
		this.izbranDogodek = izbranDogodek;
	}

}
