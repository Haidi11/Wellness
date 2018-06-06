package timer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jms.Poslji;
import vao.Dogodek;
import vao.Oseba;
import vmesniki.DogodekVmesnik;
import vmesniki.TimerSessionBeanRemote;


@Singleton
@Startup
public class TimerTest {
	
	@EJB
	DogodekVmesnik ejb;
	
		@Resource
	    TimerService timerService;
	
	    @PostConstruct
	    public void initialize() {
	        timerService.createTimer(0, 4000, "Every four second timer with no delay");
	        System.out.println("4s so minile.");
	    }
	    @Timeout
	    public void programmaticTimeout(Timer timer) throws Exception {
	        System.out.println("ProgrammaticScheduler:: in programmaticTimeout");
	        List<Dogodek>dogodki = ejb.sezamDogodkov();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
			for(int i = 0; i < dogodki.size();i++) {
				System.out.println("Datum zacetka dogodka: "+dogodki.get(i).getDatumZacetka());
				System.out.println("en dan prej: "+enDanPrej(dogodki.get(i).getDatumZacetka()));
				System.out.println("trenutniCas: "+Calendar.getInstance().getTime());
				if(Calendar.getInstance().getTime().equals(enDanPrej(dogodki.get(i).getDatumZacetka()) != null)) {
					List<Oseba> udelezenci = dogodki.get(i).getUdelezenci();
					for (int j = 0; j < udelezenci.size(); j++) {
						System.out.println("udelezenci: "+ udelezenci.get(j).getIdOseba());
						posljiMail("sduper587@gmail.com");
					}
				}else {
					System.out.println("Jutri ni nobenih dogodkov.");
				}
			}
	
	    }
	
	public java.util.Date enDanPrej(Calendar cal) {
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	public void posljiMail(String email) throws Exception {
		Poslji poslji = new Poslji();
		poslji.posljiMail(email, "Obvestilo", "Jutri se izvede vas dogodek.");
	}

	
	private static final Logger logger = Logger
	        .getLogger("com.sun.tutorial.javaee.ejb.timersession.TimerSessionBean");
	
}
