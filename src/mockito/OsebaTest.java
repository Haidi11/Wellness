package mockito;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ejb.DogodekBean;
import ejb.OsebaBean;
import vao.Oseba;

@RunWith(MockitoJUnitRunner.class)
public class OsebaTest {

	@Mock
	EntityManager em;

	@Mock
	OsebaBean os;

	@Mock
	Oseba oseba;

	@Before
	public void setup() {
		
	}

	/*
	 * Preverjamo dodajanje osebe v pb Test se mora uspešno izvest
	 */
	@Test
	public void testiranjeDodajanjaOsebe() {
		os.dodajOsebo(oseba);
		Integer osebaId = oseba.getIdOseba();
		Assert.assertNotNull(osebaId);
	}

	/*
	 * Preverjamo dodajanje osebe z id-jem, ki v bazi že obstaja Test mora failat,
	 * prožiti se mora illigal argumneta izjema
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testiranjeDodajanjaOsebeZObstojecimID() {
		oseba.setIdOseba(1);
		os.dodajOsebo(oseba);
		Assert.assertEquals(1, oseba.getIdOseba());
	}

	/*
	 * Preverjamo primer v katerem je id osebe 0, kar ne more bit Test mora failat,
	 * prožiti se mora null pointer izjema
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testiranjeDodajanjaOsebeZIDNull() {
		oseba.setIdOseba(0);
		os.dodajOsebo(oseba);
	}

	/*
	 * Preverimo ali metoda vrne seznam vseh oseb Test mora ne sme failat
	 */
	@Test
	public void testiranjePridobivanjaSezamaOSeb() {
		List<Oseba> trenutniSeznam = new ArrayList<>();
		trenutniSeznam = os.vrniSeznamVsehOseb();
		Assert.assertNotNull(trenutniSeznam);
	}

	/*
	 * Preverimo kaj se zgodi če je velikost seznama 0 Test moramora failat, prožit
	 * se mora null pointer izjema
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testiranjePridobivanjaSezamaOSebSizeNull() {
		List<Oseba> trenutniSeznam = new ArrayList<>();
		when(os.vrniSeznamVsehOseb()).thenReturn(trenutniSeznam);
		trenutniSeznam = os.vrniSeznamVsehOseb();
		Assert.assertEquals(0, trenutniSeznam.size());
	}

	/*
	 * Preverjamo če meotda vrne seznam, velikost lista ne sme biti null Test ne sme
	 * failat
	 */
	@Test
	public void testiranjePridobivanjaTopUporabnika() {
		List<Oseba> trenutniSeznam = os.topUporabnik();
		Assert.assertNotNull(trenutniSeznam.size());
	}

	/*
	 * Preverjamo če meotda vrne seznam, velikost mora biti 0
	 * test mora failat, prožit se mora null pointer izjema
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testiranjePridobivanjaTopUporabnikaVrneNull() {
		List<Oseba> trenutniSeznam = new ArrayList<>();
		when(os.topUporabnik()).thenReturn(trenutniSeznam);
		trenutniSeznam = os.topUporabnik();
		Assert.assertEquals(0, trenutniSeznam.size());
	}
}
