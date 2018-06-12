package mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import block.Block;
import block.Podpis;

public class BlockChain {
	Podpis podpis ;	
	Block block;
	
	 @Test(expected=NullPointerException.class)
	  public void podanRazredPodpis_koSeKliceMetoda_MoraVrnitiException() throws Exception { 
		 podanRazredPodpis();
		 podpis.generiranjePodpisa(null);
	    assertNull("Zgodi se nullpointer",podpis.generiranjePodpisa(null));
	  }
	 
	 @Test(expected=NoSuchAlgorithmException.class)
	  public void podanRazredPodpis_koSeKliceMetoda_MoraVrnitiString() throws Exception { 
		podanRazredPodpis();
		String rezulat = podpis.generiranjePodpisa("null0124");
	    assertEquals( "5f0e7e52d02f4492fa10ab59ab2a9bed79c79af88b7bce902c45ce4df2ac9535", rezulat);
	  }
	 
	 private void podanRazredPodpis() {
		    podpis = new Podpis();
		  }
	 
	 @Test(expected=NoSuchAlgorithmException.class)
	  public void racunanjeHashaTest() throws NoSuchAlgorithmException, UnsupportedEncodingException { 
		String hash = block.izracunHash();
		assertEquals( "5f0e7e52d02f4492fa10ab59ab2a9bed79c79af88b7bce902c45ce4df2ac9535", hash);
	  }
	 
	 @Test(expected=NoSuchAlgorithmException.class)
	  public void rudarjenjeTest() throws NoSuchAlgorithmException, UnsupportedEncodingException { 
		block.rudarjenjeBloka(0);
		
	  }
}
