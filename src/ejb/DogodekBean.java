package ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vao.Dogodek;

@Stateless
public class DogodekBean implements DogodekVmesnik {
	 @PersistenceContext
	    EntityManager em;

	@Override
	public void dodajDogodek(Dogodek dogodek) {
		em.persist(dogodek);
		System.out.println("Dogodek dodan: "+dogodek.getNaziv());
		
	}

	@Override
	public void odstraniDogodek(Dogodek dogodek) {
		em.remove(dogodek);
		
	}

	@Override
	public ArrayList<Dogodek> sezamDogodkov() {
		return (ArrayList<Dogodek>) em.createQuery("select d from Dogodek d").getResultList();
	}

	
	@Override
	public void podrobnoDogodek(Dogodek dogodek) {
		// TODO Auto-generated method stub
		
	}
	
	

}
