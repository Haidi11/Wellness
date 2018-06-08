package junitTestiranje;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import timer.TimerZaObvescanje;

public class TimerTest {
	TimerZaObvescanje timer;
	 @Before 
	 public void initialize() {
	       new TimerZaObvescanje();
	    }

	 @Test(expected=NullPointerException.class)
	  public void posiljanjeMaila() throws Exception { 
		boolean bol = timer.poslji();
		assertTrue("mail poslan ob pravilnem casu",bol);
		assertFalse("mail poslan ob nepravilnem casu ali pa sploh ne",bol);
	  }
}
