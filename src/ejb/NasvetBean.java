package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import orodja.PaketZaPrikazNasvetov;
import orodja.PaketZaprikazDogodkov;
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

	@Override
	public PaketZaPrikazNasvetov sezamDogodkovZaUporabnika(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nasvet> getNasveteAvtorja(int id) {
		Query q = em.createQuery("select o from Naslov o where o.fk_avtor= :id");
		q.setParameter("id", id);
		return  q.getResultList();
	}

	@Override
	public Nasvet najdiPoIdAvtorja(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Override
	public Oseba najdiPoIdAvtorja(int id) {
		Query q = em.createQuery("select o from Naslov o where o.fk_avtor= :id");
		q.setParameter("id", id);
		return (Oseba) q.getResultList().get(0);
	}
	
	@Override
	public PaketZaPrikazNasvetov sezamDogodkovZaUporabnika(String ime) {
		PaketZaPrikazNasvetov p = new PaketZaPrikazNasvetov();
		String str = "";
		// uporabnik z dogodki
		Oseba temp = najdiPoIdAvtorja(ime);
		List<Nasvet> nasveti =  seznamVsehNasvetov();
		return p;
	}*/

}
