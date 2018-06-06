package ejb;

import vao.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.validator.constraints.Email;

import com.sun.org.apache.bcel.internal.generic.NEW;

import block.Block;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import vmesniki.OsebaVmesnik;

@Stateless
public class OsebaBean implements OsebaVmesnik {

	@PersistenceContext
	EntityManager em;

	@Override
	public void dodajOsebo(Oseba o) {
		em.persist(o);
	}

	@Override
	public void odstraniOsebo(Oseba o) {
		em.remove(o);
	}

	@Override
	public List<Oseba> vrniSeznamVsehOseb() {
		return em.createQuery("select o from Oseba o").getResultList();
	}

	@Override
	public List<Oseba> topUporabnik() {
		List<Oseba> seznam = em.createQuery("select e from Oseba e where e.tocke=(select max(o.tocke) from Oseba o)")
				.getResultList();

		return seznam;

	}

	// poisce vse tocke ki so bile dane ta mesec in nastavi vsoto uporabnikom
	@Override
	public List<Oseba> topMesecniUporanbik() {
		List<Block> seznam = em.createQuery("select e from Block e").getResultList();
		List<Block> seznamBlokovTaMesec = dobiSeznamBlokovZaTaMesec(seznam);

		if (seznamBlokovTaMesec.size() == 0) {
			return new ArrayList<>();

		}

		List<Oseba> osebe = vrniSeznamVsehOseb();

		for (Block b : seznamBlokovTaMesec) {
			for (Oseba o : osebe) {
				if (b.getIdOseba() == o.getIdOseba()) {
					o.setStTockTaMesec(o.getStTockTaMesec() + b.getStTock());

				}
			}
		}

		return uporabnikZNajvecTockami(osebe);
	}

	// poisci uporabnika z najvec tockami ta mesec
	private List<Oseba> uporabnikZNajvecTockami(List<Oseba> osebe) {
		Oseba top = osebe.get(0);

		for (Oseba o : osebe) {
			if (top.getStTockTaMesec() < o.getStTockTaMesec()) {
				top = o;

			}

		}

		List<Oseba> seznamIste = new ArrayList<>();

		for (Oseba o : osebe) {
			if (o.getStTockTaMesec() == top.getStTockTaMesec()) {
				seznamIste.add(o);

			}

		}

		return seznamIste;
	}

	// dobi seznam blokov za ta mesec
	private List<Block> dobiSeznamBlokovZaTaMesec(List<Block> seznam) {
		List<Block> seznamLjudiTaMesec = new ArrayList<>();
		for (Block b : seznam) {
			Calendar datum = Calendar.getInstance();
			datum.setTimeInMillis(b.getTimeStamp());

			if (datum.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
				if (datum.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)) {
					seznamLjudiTaMesec.add(b);
				}

			}

		}
		return seznamLjudiTaMesec;

	}

	@Override
	public Oseba najdiPoId(int id) {
		return em.find(Oseba.class, id);

	}

	@Override
	public boolean jeZasedeno(String o) {
		if (em.createQuery("select e from Oseba e where e.uporabniskoIme = :uime)").setParameter("uime", o).getResultList().size() == 0) {
			return false;

		}
		return true;

		
	}

	@Override
	public List<Oseba> vrniOsebeOddelek(String data) {
			return em.createQuery("select e from Oseba e where e.oddelek=:oddelek").setParameter("oddelek", data).getResultList();
	
	}
}
