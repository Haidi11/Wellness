package ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vao.Dogodek;
import vao.Oseba;

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
	
	@Override
	public void izberiDogodek(Dogodek d, String uporabniskoIme) {
		Dogodek temp = em.find(Dogodek.class,d.getIdDogodek());
		
		temp.getUdelezenci().add(najdiPoUporabniskemImenu(uporabniskoIme));
		
	}
	
	@Override
	public Oseba najdiPoUporabniskemImenu(String u) {
		Query q = em.createQuery("select o from Oseba o where o.uporabniskoIme= :u");
		q.setParameter("u", u);
			
		return (Oseba) q.getResultList().get(0);
	}

}
