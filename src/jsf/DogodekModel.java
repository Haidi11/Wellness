package jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

	
	
	
	
	//izbira dogodka za prikaz na strani za podrobnosti
	public String izberiDogodek(Dogodek d) {
		this.izbranDogodek=d;
		return "podrobnostiDogodek.xhtml";
	}
	
	//dodajanje novega dogodka
	public void dodajDogodek() {
		ejb.dodajDogodek(novDogodek);
		novDogodek = new Dogodek();
	}
	
	//prikaz sveh dogodkov
	public List<Dogodek> getVrniVseDogodke() {
		return ejb.sezamDogodkov();
	}
	
	//prikaz dogodkov z dodanimi lastnostmi o prijavljenosti
	public List<Dogodek> getVrniVseDogodkeZaUporabnika() {
		return ejb.sezamDogodkov();
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
