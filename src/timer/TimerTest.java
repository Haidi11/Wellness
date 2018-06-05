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
	
	@Schedule(second="*/2")
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
	
	public void nastaviMail(String email) throws Exception {
		Poslji poslji = new Poslji();
		poslji.posljiMail(email, "Obvestilo", "Jutri se izvede vas dogodek.");
	}
	
	public void najdiEmailZaDogodek(int idDogodka) {
		em.createQuery("select ds from dogodek_oseba ds join Dogodek d where ds.idDogodek = :id");
	}
	
	public void sprehodiSeCezDogodke(ArrayList<Dogodek> dogodki) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
		for(int i = 0; i < dogodki.size();i++) {
			if(dateFormatter.format(dogodki.get(i).getDatumZacetka().equals(dateFormatter.format(enDanPrej(dogodki.get(i).getDatumZacetka())))) != null) {
				int idDogodkaEnDanPrej = dogodki.get(i).getIdDogodek();
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
