package ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import block.Block;
import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;
import vao.Tocke;
import vmesniki.*;

@Stateless
public class DogodekBean implements DogodekVmesnik {
	@EJB
	BlockChainVmesnik bc;

	@PersistenceContext
	EntityManager em;

	@Override
	public void dodajDogodek(Dogodek dogodek) {
		em.persist(dogodek);
		// System.out.println("Dogodek dodan: "+dogodek.getNaziv());

	}

	@Override
	public void odstraniDogodek(Dogodek dogodek) {
		Dogodek temp = em.find(Dogodek.class, dogodek.getIdDogodek());
		em.remove(temp);

	}

	@Override
	public ArrayList<Dogodek> sezamDogodkov() {
		return (ArrayList<Dogodek>) em.createQuery("select d from Dogodek d").getResultList();
	}

	@Override
	public Dogodek podrobnoDogodek(int dogodekID) {
		Dogodek najdenDogodek;
		najdenDogodek = em.find(Dogodek.class, dogodekID);
		System.out.println("najden dogodek: " + najdenDogodek.getNaziv());
		return najdenDogodek;
	}

	@Override
	public void izberiDogodek(Dogodek d, String uporabniskoIme) {
		Dogodek temp = em.find(Dogodek.class, d.getIdDogodek());
		Oseba o = najdiPoUporabniskemImenu(uporabniskoIme);

		if (temp.getUdelezenci().contains(o)) {
			temp.getUdelezenci().remove(o);
			return;
		}

		temp.getUdelezenci().add(o);

	}

	@Override
	public Oseba najdiPoUporabniskemImenu(String u) {
		Query q = em.createQuery("select o from Oseba o where o.uporabniskoIme= :u");
		q.setParameter("u", u);

		return (Oseba) q.getResultList().get(0);
	}

	@Override
	public PaketZaprikazDogodkov sezamDogodkovZaUporabnika(String name) {
		PaketZaprikazDogodkov p = new PaketZaprikazDogodkov();
		String str = "";
		// uporabnik z dogodki
		Oseba temp = najdiPoUporabniskemImenu(name);
		// System.out.println(temp.getDogodki());
		List<Dogodek> dogodki = sezamDogodkov();
		// primerjaj in uredi tiste
		for (Dogodek d : dogodki) {
			if (temp.getDogodki().contains(d)) {
				d.setPrijavljen("Odjavi");
				str += "prijavljen,";
			} else {
				str += "neprijavljen,";
			}
			if (casZaOdjavoPotekel(d.getDatumPrijave())) {
				d.setGumbPrijava(true);
			}
		}
		// preveri ce je rok za odjavo ze potekel

		p.setSeznamRazredov(str.substring(0, str.length() - 1));
		p.setSeznam(dogodki);
		// vrni
		return p;
	}

	// preveri ce je cas za odjavo potekel
	private boolean casZaOdjavoPotekel(Calendar c) {
		Calendar zdaj = Calendar.getInstance();
		// System.out.println(zdaj.get(Calendar.HOUR_OF_DAY)+ ":" +
		// zdaj.get(Calendar.MINUTE) );

		if (c.before(zdaj)) {
			return true;
		}
		return false;

	}

	@Override
	public List<Dogodek> vrniMojeDogodke(int id) {
		Query q = em.createQuery("select d from Dogodek d where d.idLastnik= :id");
		q.setParameter("id", id);

		return q.getResultList();

	}

	@Override
	public Dogodek dogodek(int idDogodek) {
		return em.find(Dogodek.class, idDogodek);
	}

	@Override
	public List<Oseba> vrniMojeUdelezence(int idDogodek) {
		List<Oseba> o = em.find(Dogodek.class, idDogodek).getUdelezenci();
		o.size();
		return o;
	}

	// vrni z stevilom prijavljenih
	@Override
	public Dogodek vrniMojDogodek(int idDogodek) {
		Dogodek d = em.find(Dogodek.class, idDogodek);
		d.setSteviloPrijavljenih(d.getUdelezenci().size());
		for (Oseba o : d.getUdelezenci()) {
			if (tockeDane(o, d)) {
				o.setUdelezba("Udelezba potrjena");
				o.setGumbUdelezba(true);
			} else {
				o.setGumbUdelezba(false);
				o.setUdelezba("Potrdi udeležbo");
			}

		}
		return d;
	}

	// preveri ce so tocke ze bile podeljene
	private boolean tockeDane(Oseba o, Dogodek d) {
		// Query q = em.createQuery("select d from Tocke d where d.idOseba = :idOseba
		// and d.idDogodek= :idDogodek");
		// q.setParameter("idOseba", o.getIdOseba());
		// q.setParameter("idDogodek", d.getIdDogodek());
		Query q = em.createQuery("select d from Block d where d.idOSeba = :idOseba and d.idDogodek= :idDogodek");
		q.setParameter("idOseba", o.getIdOseba());
		q.setParameter("idDogodek", d.getIdDogodek());

		// List<Tocke> l = new ArrayList<Tocke>();
		// l = q.getResultList();
		// if (l == null) {
		// return false;
		// } else if (l.isEmpty()) {
		// return false;
		//
		// } else {
		// return true;
		// }

		List<Block> b = new ArrayList<Block>();
		b = q.getResultList();
		if (b == null) {
			return false;
		} else if (b.isEmpty()) {
			return false;

		} else {
			return true;
		}

	}

	// potrdi udelezbo na dogodku tako da zapise dogodek in osebo v tocke in osebi
	// pristeje tocke
	@Override
	public void potrdiUdelezbo(Dogodek izbranDogodek, Oseba o) {
		System.out.println("Zacetek potrditve ");
		Oseba os = em.find(Oseba.class, o.getIdOseba());
		os.setTocke(os.getTocke() + izbranDogodek.getTocke());
		Tocke t = new Tocke();

		// em.persist(t);
		t.setIdDogodek(izbranDogodek.getIdDogodek());
		t.setIdOseba(o.getIdOseba());
		bc.shrani(t);
	}

	@Override
	public void podrobnoDogodek(Dogodek dogodek) {
		// TODO Auto-generated method stub

	}
}
