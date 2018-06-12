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

import ejb.DogodekBean;
import vao.Dogodek;

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

	@Test
	public void testiranjeDodajanjaDogodka() throws Exception {
		dogodekBean = Mockito.mock(DogodekBean.class);
		dogodekBean.em = Mockito.mock(EntityManager.class);
		dogodek = new Dogodek("test","to je test za mockito",5);
		Mockito.verify(dogodekBean.em).persist(dogodek);
		Integer dogodekId = dogodek.getIdDogodek();
		Assert.assertNotNull(dogodekId); 
		/*Dogodek dogodek = Mockito.mock(Dogodek.class);
		dogodek = new Dogodek();
		Mockito.when(em.getTransaction()).thenReturn(et);
		Mockito.when(emf.createEntityManager()).thenReturn(em);
		dogodekBean.dodajDogodek(dogodek);
		Mockito.verify(em, Mockito.times(1)).persist(dogodek);*/
	}

	/*@Test
	public void testiranjeBrisanjaDogodka() throws Exception {
		dogodek = Mockito.mock(Dogodek.class);
		Mockito.when(em.getTransaction()).thenReturn(et);
		Mockito.when(emf.createEntityManager()).thenReturn(em);
		dogodekBean.odstraniDogodek(dogodek);
		Mockito.verify(em, Mockito.times(1)).persist(dogodek);
	}*/

	/*@Test
	public void testiranjePridobivanjaPodrobnostiDogodka() throws Exception {
		Dogodek dogodek = Mockito.mock(Dogodek.class);
		Mockito.when(em.getTransaction()).thenReturn(et);
		Mockito.when(emf.createEntityManager()).thenReturn(em);
		dogodekBean.podrobnoDogodek(dogodek);
		Mockito.verify(em, Mockito.times(1)).persist(dogodek);
	}*/
	
	@Test(expected=java.lang.NullPointerException.class)
	public void napakaKoIdDogodkaNeObstaja() {
		dogodekBean = new DogodekBean();
		dogodek = new Dogodek();
		dogodek.setIdDogodek(6);
		dogodekBean.dodajDogodek(dogodek);
		Assert.assertNull(dogodek);
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void napakaKoIdDogodkaZeObstaja() {
		dogodekBean = new DogodekBean();
		dogodek = new Dogodek();
		dogodek.setIdDogodek(8);
		dogodekBean.dodajDogodek(dogodek);
		Assert.assertNotNull(dogodek);
	}
	
	@Test(expected=java.lang.NullPointerException.class)
	public void prazenSeznamDogodkov() {
		List<Dogodek> seznamDogodkov = new ArrayList<>();
		dogodekBean = new DogodekBean();
		dogodek = new Dogodek();
		seznamDogodkov = dogodekBean.sezamDogodkov();
		//Assert.assertNull(seznamDogodkov);
		Mockito.verify(seznamDogodkov);
	}
}
