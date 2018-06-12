package mockito;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ejb.DogodekBean;
import vao.Dogodek;
import vao.Oseba;

@RunWith(MockitoJUnitRunner.class)
public class DogodkiTest {
	@Mock
	private Dogodek dogodek;
	
	@Mock
	private DogodekBean dogodekBean;
	
	@Mock
	private EntityManager em;

	@Mock
	private EntityManagerFactory emf;

	@Mock
	private EntityTransaction et;

	/*Preverjamo dodajanje dogodka
	 * test ne sme failat*/
	@Test
	public void testiranjeDodajanjaDogodka() throws Exception {
		dogodekBean.dodajDogodek(dogodek);
		Integer dogodekId =dogodek.getIdDogodek();
		Assert.assertNotNull(dogodekId);
	}


	/*Preverjamo odstranjevanje dogodka
	 * test ne sme failat*/
	@Test
	public void testiranjeBrisanjaDogodka() throws Exception {
		dogodek = Mockito.mock(Dogodek.class);
		Mockito.when(em.getTransaction()).thenReturn(et);
		Mockito.when(emf.createEntityManager()).thenReturn(em);
		dogodekBean.odstraniDogodek(dogodek);
		//Mockito.verify(em).remove(dogodek);
	}

	/*@Test
	public void testiranjePridobivanjaPodrobnostiDogodka() throws Exception {
		Dogodek dogodek = Mockito.mock(Dogodek.class);
		Mockito.when(em.getTransaction()).thenReturn(et);
		Mockito.when(emf.createEntityManager()).thenReturn(em);
		dogodekBean.podrobnoDogodek(dogodek);
		Mockito.verify(em, Mockito.times(1)).persist(dogodek);
	}*/
	
	/*Test preveri kaj se zgodi če iščemo uporabnika z id-jem ki ne obstaja
	 * Test faila z izjemo NullPointerException*/
	@Test(expected=java.lang.NullPointerException.class)
	public void napakaKoIdDogodkaNeObstaja() {
		dogodek.setIdDogodek(0);
		dogodekBean.dodajDogodek(dogodek);
		Assert.assertNotNull(dogodek.getIdDogodek());
	}
	
	/*Test preveri če želimo dodati uporabnika z id-jem ki v bazi že obstaja
	 * Test faila z izjemo IndexOutOfBoundsException*/
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void napakaKoIdDogodkaZeObstaja() {
		List<Dogodek> trenutniSeznamDogodkov = new ArrayList<Dogodek>();
		trenutniSeznamDogodkov = dogodekBean.sezamDogodkov();
		int prvid = trenutniSeznamDogodkov.get(0).getIdDogodek();
		dogodek.setIdDogodek(prvid);
		dogodekBean.dodajDogodek(dogodek);
		Assert.assertEquals(trenutniSeznamDogodkov.get(0).getIdDogodek(), prvid);
	}
	
	/*Test preveri kaj se zgodi če dobimo prazen seznam dogodkov
	 * test faila z izjemo NullPointerException */
	@Test(expected=java.lang.NullPointerException.class)
	public void prazenSeznamDogodkov() {
		ArrayList<Dogodek> trenutniSeznam = new ArrayList<>();
		when(dogodekBean.sezamDogodkov()).thenReturn(trenutniSeznam);
		Assert.assertEquals(0, trenutniSeznam.size());
	}
}
