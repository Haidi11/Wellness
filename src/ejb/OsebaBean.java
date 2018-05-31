package ejb;

import vao.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import block.Block;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import vmesniki.OsebaVmesnik;

@Stateless
public class OsebaBean implements OsebaVmesnik {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void dodajOsebo(Oseba o) {
		entityManager.persist(o);
	}

	@Override
	public void odstraniOsebo(Oseba o) {
		entityManager.remove(o);
	}

	@Override
	public List<Oseba> vrniSeznamVsehOseb() {
		return entityManager.createQuery("select o from Oseba o").getResultList();
	}

	@Override
	public Oseba topUporabnik() {
		Oseba temo = (Oseba) entityManager
				.createQuery("select e from Oseba e where e.tocke=(select max(o.tocke) from Oseba o)")
				.getResultList().get(0);

		return temo;

	}

	@Override
	public Oseba topMesecniUporanbik() {
		List<Block> seznam = entityManager.createQuery("select e from Block e").getResultList();
		List<Block> seznamBlokovTaMesec = dobiSeznamBlokovZaTaMesec(seznam);
		
		if(seznamBlokovTaMesec.size()==0) {
			return new Oseba();
			
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

	private Oseba uporabnikZNajvecTockami(List<Oseba> osebe) {
		Oseba top=osebe.get(0);
		
		for(Oseba o : osebe) {
			if(top.getStTockTaMesec()<o.getStTockTaMesec()) {
				top=o;
								
			}
			
		}
		return top;
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
}
