package ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vao.Dogodek;
import vao.Nasvet;
import vmesniki.NasvetVmesnik;

@Stateless
public class NasvetBean implements NasvetVmesnik {
	
	 @PersistenceContext
	    EntityManager em;

	@Override
	public void dodajNasvet(Nasvet nasvet) {
		em.persist(nasvet);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void brisiNasvet(Nasvet nasvet) {
		Nasvet temp = em.find(Nasvet.class, nasvet.getIdNasvet());
		em.remove(temp);		
	}

	@Override
	public void urediNasvet(Nasvet nasvet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Nasvet> seznamVsehNasvetov() {
		return (ArrayList<Nasvet>) em.createQuery("select n from Nasvet n").getResultList();
	}

}
