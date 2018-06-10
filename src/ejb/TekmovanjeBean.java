package ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
		temp.getZmagovalec().size();

		return temp.getTekmovanja();

	}

	@Override
	public void koncajTekmovanje(Tekmovanje t) {

		if (t == null)
			return;
		Tekmovanje tekmovanje = em.find(Tekmovanje.class, t.getId());

		tekmovanje.setZmagovalci(topMesecniUporanbik(tekmovanje));

	}

	// poisce vse tocke ki so bile dane v danem mescu in letu
	private Set<Oseba> topMesecniUporanbik(Tekmovanje tekmovanje) {
		List<Block> seznam = em.createQuery("select e from Block e").getResultList();
		List<Block> seznamBlokovTaMesec = dobiSeznamBlokovZaTaMesec(seznam, tekmovanje.getMesec(),
				tekmovanje.getLeto());

		if (seznamBlokovTaMesec.size() == 0) {
			return new HashSet<Oseba>();

		}

		List<Oseba> osebe = ov.vrniSeznamVsehOseb();

		for (Block b : seznamBlokovTaMesec) {
			for (Oseba o : osebe) {
				if (b.getIdOseba() == o.getIdOseba()) {
					o.setStTockTaMesec(o.getStTockTaMesec() + b.getStTock());

				}
			}
		}
		if (tekmovanje.getTip() != null)
			if (tekmovanje.getTip().equals("top"))
				return uporabnikZNajvecTockami2(osebe);

		return uporabnikiZDovoljTockami2(osebe, tekmovanje.getPotrebneTocke());

	}

	// poisce uporabnike ki imajo dovolj tock
	private List<Oseba> uporabnikiZDovoljTockami(List<Oseba> osebe, int tocke) {
		List<Oseba> seznam = new ArrayList<>();

		for (Oseba o : osebe) {
			if (o.getStTockTaMesec() >= tocke) {
				seznam.add(o);
			}

		}
		return seznam;
	}

	private Set<Oseba> uporabnikiZDovoljTockami2(List<Oseba> osebe, int tocke) {
		Set<Oseba> seznam = new HashSet<>();

		for (Oseba o : osebe) {
			if (o.getStTockTaMesec() >= tocke) {
				seznam.add(o);
			}

		}
		return seznam;
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

	private Set<Oseba> uporabnikZNajvecTockami2(List<Oseba> osebe) {
		Oseba top = osebe.get(0);

		for (Oseba o : osebe) {
			if (top.getStTockTaMesec() < o.getStTockTaMesec()) {
				top = o;

			}

		}

		Set<Oseba> seznamIste = new HashSet<>();

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

	@Override
	public Tekmovanje najdiPoId(int id) {
		return em.find(Tekmovanje.class, id);

	}

	@Override
	public Map<String, String> vrniTipe() {
		Map<String, String> tipi = new LinkedHashMap<>();

		tipi.put("", "");
		tipi.put("Oseba z največ točkami", "top");
		tipi.put("Potrebno število točk", "limit");

		return tipi;
	}

	@Override
	public String poisciNaslednjoNagrado(String name) {
		Oseba o = dv.najdiPoUporabniskemImenu(name);
		int tocke = steviloTockTaMesec(o.getIdOseba());
		List<Tekmovanje> seznam = em
				.createQuery("select o from Tekmovanje o where o.tip='limit' and o.potrebneTocke > :tocke")
				.setParameter("tocke", tocke).getResultList();

		return najmanjPotrebnihTock(seznam);

	}

	// vrne zapis o najmanjsemu stevilu potrebnih tock
	private String najmanjPotrebnihTock(List<Tekmovanje> seznam) {

		if (seznam == null)
			return "";
		if (seznam.size() == 0)
			return "";

		int temp = seznam.get(0).getPotrebneTocke();

		for (Tekmovanje t : seznam) {
			if (t.getPotrebneTocke()<temp)
				temp=t.getPotrebneTocke();

		}
			return napisi12krat(temp);
	}
	
	private String napisi12krat(int t) {
		
		String ret="";
		
		for (int i = 0; i < 12; i++) {
			ret+=t+", ";
			
		}
		return ret;
	}

	// vrne stevilo tock ki jih je uporabnik z id dobil ta mesec
	private int steviloTockTaMesec(int id) {
		List<Block> seznam = em.createQuery("select e from Block e where e.idOseba= :id").setParameter("id", id)
				.getResultList();
		List<Block> seznamBlokovTaMesec = ov.dobiSeznamBlokovZaTaMesec(seznam);

		if (seznamBlokovTaMesec.size() == 0) {
			return 0;

		}

		int ret = 0;

		for (Block b : seznamBlokovTaMesec) {

			ret += b.getStTock();

		}

		return ret;

	}

}
