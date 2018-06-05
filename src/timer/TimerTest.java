package timer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jms.Poslji;
import vao.Dogodek;
import vao.Oseba;

import vmesniki.TimerSessionBeanRemote;

@Stateless
public class TimerTest implements TimerSessionBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	public List<Dogodek> seznamDogodkov(){
		List<Dogodek> seznamDogodekovInOseb = new ArrayList<Dogodek>();
		seznamDogodekovInOseb = em.createQuery("select * from dogodek d").getResultList();
		System.out.println(seznamDogodekovInOseb);
		return seznamDogodekovInOseb;
	}
	
	public java.util.Date enDanPrej(Calendar cal) {
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	public void posljiMail(String email) throws Exception {
		Poslji poslji = new Poslji();
		poslji.posljiMail(email, "Obvestilo", "Jutri se izvede vas dogodek.");
	}
	
	public void najdiEmailZaDogodek(int idDogodka) {
		em.createQuery("select d.");
	}
	
	@Schedule(minute="*/2")
	public void sprehodiSeCezDogodke(List<Dogodek> dogodki) throws Exception {
		dogodki = seznamDogodkov();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
		for(int i = 0; i < dogodki.size();i++) {
			if(dateFormatter.format(dogodki.get(i).getDatumZacetka().equals(dateFormatter.format(enDanPrej(dogodki.get(i).getDatumZacetka())))) != null) {
				List<Oseba> udelezenci = dogodki.get(i).getUdelezenci();
				for (int j = 0; j < udelezenci.size(); j++) {
					posljiMail(udelezenci.get(j).getEmail());
				}
			}
		}
	}
	
	 @Resource
	   private SessionContext context;
	 
	 @Override
	 public void ustvariTimer(long trajanje) {
		   context.getTimerService().createTimer(trajanje, "Hello World!");
		}
	 
	   @Timeout
	   public void timeOutHandler(Timer timer){
	      System.out.println("timeoutHandler : " + timer.getInfo());        
	      timer.cancel();
	   }
}
