package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;

@Stateless
public class DogodekBean implements DogodekVmesnik {
	@PersistenceContext
	EntityManager em;

	@Override
	public void dodajDogodek(Dogodek dogodek) {
		em.persist(dogodek);
		// System.out.println("Dogodek dodan: "+dogodek.getNaziv());

	}

	@Override
	public void odstraniDogodek(Dogodek dogodek) {
		em.remove(dogodek);

	}

	@Override
	public ArrayList<Dogodek> sezamDogodkov() {
		return (ArrayList<Dogodek>) em.createQuery("select d from Dogodek d").getResultList();
	}

	// zakaj je to tu?
	@Override
	public void podrobnoDogodek(Dogodek dogodek) {
		// TODO Auto-generated method stub

	}
	//prijava na dogodek, kjer se ob klicu prijavljenega uporabnika le tega odjavi
	@Override
	public void izberiDogodek(Dogodek d, String uporabniskoIme) {
		Dogodek temp = em.find(Dogodek.class, d.getIdDogodek());
		Oseba o = najdiPoUporabniskemImenu(uporabniskoIme);
		
		if(temp.getUdelezenci().contains(o)){
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
		PaketZaprikazDogodkov p= new PaketZaprikazDogodkov();
		String str="";
		// uporabnik z dogodki
		Oseba temp = najdiPoUporabniskemImenu(name);
		//System.out.println(temp.getDogodki());
		List<Dogodek> dogodki = sezamDogodkov();
		// primerjaj in uredi tiste
		for (Dogodek d : dogodki) {
			
				if (temp.getDogodki().contains(d)) {
					d.setPrijavljen("Odjavi");
					str+= "prijavljen,";
				}else {
					str+= "neprijavljen,";
			}
		}
		p.setSeznamRazredov(str.substring(0, str.length()-1));
		p.setSeznam(dogodki);
		// vrni
		return p;
	}

}
