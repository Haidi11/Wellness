package mockito;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TestMock  {
	@Mock
	Bar bar;

	@Test
	 public void test() throws Exception {   
		int rezultat = bar.racun(1, 1);
		assertEquals(2,rezultat);
	    } 
	 @BeforeAll
	    static void beforeAll() {
	        System.out.println("Before all test methods");
	    }
	 
	    @BeforeEach
	    void beforeEach() {
	        System.out.println("Before each test method");
	    }
	 
	    @AfterEach
	    void afterEach() {
	        System.out.println("After each test method");
	    }
	 
	    @AfterAll
	    static void afterAll() {
	        System.out.println("After all test methods");
	    }
	 
	    @Test
	    @DisplayName("First test")
	    void firstTest() {
	        System.out.println("First test method");
	    }
	 
	    @Test
	    @DisplayName("Second test")
	    void secondTest() {
	        System.out.println("Second test method");
	    }
	    
}
