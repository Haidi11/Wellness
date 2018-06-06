package timer;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import vao.Dogodek;
import vao.Oseba;
import vmesniki.DogodekVmesnik;
import vmesniki.PosljiVmesnik;

@Startup
@Singleton
public class TimerZaObvescanje {

	@EJB
	DogodekVmesnik dv;

	@EJB
	PosljiVmesnik pv;

//	@Resource
//	TimerService timerService;
//
//	@PostConstruct
//	public void initialize() {
//		System.out.println("init");
//		//poslji();
//		timerService.createTimer(0, 86400, "Delay 20 seconds then every 6 seconds timer");
//	}

	
    @Schedule(second = "*", minute = "*", hour = "4", persistent = false)
	private void poslji() {
		System.out.println("poslji");
		for (Dogodek d : dv.sezamDogodkov()) {


			
			if (1 == ((int)d.getDatumZacetka().get(Calendar.DAY_OF_YEAR) - (int)Calendar.getInstance().get(Calendar.DAY_OF_YEAR))) {
				System.out.println("nasel datum");
				
				
				for (Oseba o : d.getUdelezenci()) {
					try {
						pv.posljiMail(o.getEmail(), "Obvestilo na dogodek: " + d.getNaziv(), "Obveščamo vas da, je jutri dogodek: "+d.getNaziv() + ", na keterega ste se prijavili. Dogodek se začne ob: " + d.getIzpisiZacetek()+
				" in traja do: " + d.getIzpisiKonca());
						
						dv.shraniObvestilo(o.getIdOseba(), d.getIdDogodek());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}

		}
	}
	
//	@Timeout
//	public void programmaticTimeout(Timer timer) {
//		System.out.println("ne");
//
//		poslji();
//
//		
//	}

}
