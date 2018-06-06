package ejb;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import block.Block;
import vao.Oseba;
import vao.Tekmovanje;
import vmesniki.DogodekVmesnik;
import vmesniki.OsebaVmesnik;
import vmesniki.TekmovanjeVmesnik;

@Stateless
public class TekmovanjeBean implements TekmovanjeVmesnik {

	@PersistenceContext
	EntityManager em;

	@EJB
	DogodekVmesnik dv;
	@EJB
	OsebaVmesnik ov;

	@Override
	public List<Tekmovanje> vrniVsaTekmovanja() {
		return em.createQuery("select o from Tekmovanje o").getResultList();

	}

	@Override
	public void dodajTekmovanje(Tekmovanje novoTekmovanje) {
		em.persist(novoTekmovanje);
	}
	@Override
	public List<Tekmovanje> vrniMojaTekmovanja(int id) {
		Oseba temp = em.find(Oseba.class, id);
		temp.getTekmovanja().size();
		return temp.getTekmovanja();

	}

	@Override
	public void koncajTekmovanje(Tekmovanje t) {

		Tekmovanje temp = em.find(Tekmovanje.class, t.getId());
		temp.setZmagovalec(topMesecniUporanbik(temp.getMesec(), temp.getLeto()).getIdOseba());
	
	}

	// poisce vse tocke ki so bile dane v danem mescu in letu

	private Oseba topMesecniUporanbik(int mesec, int leto) {
		List<Block> seznam = em.createQuery("select e from Block e").getResultList();
		List<Block> seznamBlokovTaMesec = dobiSeznamBlokovZaTaMesec(seznam, mesec, leto);

		if (seznamBlokovTaMesec.size() == 0) {
			return new Oseba();

		}

		List<Oseba> osebe = ov.vrniSeznamVsehOseb();

		for (Block b : seznamBlokovTaMesec) {
			for (Oseba o : osebe) {
				if (b.getIdOseba() == o.getIdOseba()) {
					o.setStTockTaMesec(o.getStTockTaMesec() + b.getStTock());

				}
			}
		}

		return uporabnikZNajvecTockami(osebe).get(0);
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
	private List<Block> dobiSeznamBlokovZaTaMesec(List<Block> seznam, int mesec, int leto) {
		List<Block> seznamLjudiTaMesec = new ArrayList<>();
		for (Block b : seznam) {
			Calendar datum = Calendar.getInstance();
			datum.setTimeInMillis(b.getTimeStamp());

			if (datum.get(Calendar.YEAR) == leto) {
				if (datum.get(Calendar.MONTH) == (mesec - 1)) {
					seznamLjudiTaMesec.add(b);
				}

			}

		}
		return seznamLjudiTaMesec;

	}
	
	

}
