package jsf;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import vmesniki.*;
import vao.Dogodek;
import vao.Oseba;

@ManagedBean(name = "dogodek")
@SessionScoped
public class DogodekModel implements Serializable {

	private static final long serialVersionUID = 4158584015534953569L;

	@EJB
	DogodekVmesnik ejb;

	private Dogodek novDogodek = new Dogodek();
	private Dogodek izbranDogodek;
	
	private Calendar potekUra= Calendar.getInstance();
	private Calendar uraZacetka= Calendar.getInstance();
	private Calendar uraKonca= Calendar.getInstance();
	
	

	//vrne dogodke prijavljenega uporabnika
	public List<Dogodek> getMojiDogodki(){
		
		return ejb.vrniMojeDogodke(getUporabnik().getIdOseba());
	}
	//vrne osebe ki so prijavljene na dogodek
	public List<Oseba> getVrniPrijavljeneOsebeNaDogodek(){
		//return ejb.vrniMojeUdelezence(izbranDogodek.getIdDogodek());
		if(izbranDogodek==null)
			return new ArrayList<>();
		
		izbranDogodek = ejb.vrniMojDogodek(izbranDogodek.getIdDogodek());
		
		return izbranDogodek.getUdelezenci();
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

	public Dogodek najdiDogodek(String id) {
		return null;
	}


	public void dodajDogodek() {
		novDogodek.setIdLastnik(getUporabnik().getIdOseba());
		novDogodek.getDatumZacetka().set(novDogodek.getDatumZacetka().get(Calendar.YEAR),
				novDogodek.getDatumZacetka().get(Calendar.MONTH), novDogodek.getDatumZacetka().get(Calendar.DATE), uraZacetka.get(Calendar.HOUR_OF_DAY)-1, uraZacetka.get(Calendar.MINUTE));
		
		novDogodek.getDatumPrijave().set(novDogodek.getDatumPrijave().get(Calendar.YEAR),
				novDogodek.getDatumPrijave().get(Calendar.MONTH), novDogodek.getDatumPrijave().get(Calendar.DATE), potekUra.get(Calendar.HOUR_OF_DAY)-1, potekUra.get(Calendar.MINUTE));
		
		novDogodek.getDatumKonca().set(novDogodek.getDatumKonca().get(Calendar.YEAR),
				novDogodek.getDatumKonca().get(Calendar.MONTH), novDogodek.getDatumKonca().get(Calendar.DATE), uraKonca.get(Calendar.HOUR_OF_DAY)-1, uraKonca.get(Calendar.MINUTE));
		
		ejb.dodajDogodek(novDogodek);
		
		potekUra= Calendar.getInstance();
		uraZacetka= Calendar.getInstance();
		uraKonca= Calendar.getInstance();
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
	//vrne prijavljenega uporabnika
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	//vrne prijavljeno osebo
	public Oseba getUporabnik() {
		return ejb.najdiPoUporabniskemImenu(vrniUporabnika().getName());
		
	}
	
	
	//potrdi udelezbo na dogodek
	public void potrdiUdelezbo(Oseba o) {
		ejb.potrdiUdelezbo(izbranDogodek, o); //id uporabnika, st tock
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


	public String izbranDogodekI(int id) {
		ejb.podrobnoDogodek(id);
		return "podrobnostiDogodek.xhtml";
	}
	public DogodekVmesnik getEjb() {
		return ejb;
	}
	public void setEjb(DogodekVmesnik ejb) {
		this.ejb = ejb;
	}
	public Calendar getPotekUra() {
		return potekUra;
	}
	public void setPotekUra(Calendar potekUra) {
		this.potekUra = potekUra;
	}
	public Calendar getUraZacetka() {
		return uraZacetka;
	}
	public void setUraZacetka(Calendar uraZacetka) {
		this.uraZacetka = uraZacetka;
	}
	public Calendar getUraKonca() {
		return uraKonca;
	}
	public void setUraKonca(Calendar uraKonca) {
		this.uraKonca = uraKonca;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
