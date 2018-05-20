package jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.DogodekVmesnik;
import vao.Dogodek;
import vao.Oseba;

@ManagedBean(name="dogodek")
@SessionScoped
public class DogodekModel {
	
	@EJB
	DogodekVmesnik ejb;
	
	private Dogodek novDogodek= new Dogodek();
	
public List<Dogodek> getVrniVseDogodke(){
		
		return ejb.sezamDogodkov();
	}
	
	public void dodajDogodek() {
		ejb.dodajDogodek(novDogodek);
		novDogodek= new Dogodek();
	}


}
