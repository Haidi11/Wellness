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
	public void brisiNasvet(Nasvet nasvet) {
		Nasvet temp = em.find(Nasvet.class, nasvet.getIdNasvet());
		em.remove(temp);
	}

	@Override
	public void urediNasvet(Nasvet n) {
		Nasvet temp = em.find(Nasvet.class, n.getIdNasvet());
		temp.setNasvet(n.getNasvet());
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
	public int najdiIdAvtorja(String ime) {
		Query q = em.createQuery("select o.idOseba from Oseba o where o.uporabniskoIme= :ime");
		q.setParameter("ime", ime);
		int id = (int) q.getResultList().get(0);
		return id;
	}

	@Override
	public List<Nasvet> getNasveteAvtorja(int id) {
		Query q = em.createQuery("select n from Nasvet n join n.avtor o where o.id= :id ");
		q.setParameter("id", id);
		return (List<Nasvet>) q.getResultList();
	}

	@Override
	public void dodajNasvet(Nasvet nasvet) {
		em.persist(nasvet);
		// TODO Auto-generated method stub
	}

	@Override
	public Nasvet najdiPoIdAvtorja(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nasvet> getVseNasveteAvtorja() {
		// TODO Auto-generated method stub
		return null;
	}
}
