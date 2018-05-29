package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vao.Dogodek;
import vao.Nasvet;
import vao.Oseba;
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
	
	public List<Nasvet> najdiNasveteUporabnika(int id) {
		Query q = em.createQuery("select o from Oseba_Nasvet o where o.Oseba_ID= :id");
		q.setParameter("id", id);
		return  q.getResultList();
	}

}
