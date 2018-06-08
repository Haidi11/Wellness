package junitTestiranje;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import ejb.DogodekBean;
import timer.TimerZaObvescanje;

public class Dogodki {
	Calendar cal;
	DogodekBean db;

	@Before
	public void initialize() {
		db = new DogodekBean();
	}

	@Test(expected = NullPointerException.class)
	public void posiljanjeMaila() throws Exception {
		
	}
	
	@Test(expected = NullPointerException.class)
	public void casZaOdjavoTest() throws Exception {
		
	}
}
