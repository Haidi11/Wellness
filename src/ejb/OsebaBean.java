package ejb;

import vao.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import vmesniki.OsebaVmesnik;

@Stateless
public class OsebaBean implements OsebaVmesnik{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void dodajOsebo(Oseba o) {
        entityManager.persist(o);
    }

    @Override
    public void odstraniOsebo(Oseba o) {
        entityManager.remove(o);
    }

    @Override
    public List<Oseba> vrniSeznamVsehOseb() {
        return entityManager.createQuery("select o from Oseba o").getResultList();
    }
    
    @Override 
    public Oseba topUporabnik() { 
      Oseba temo = (Oseba) entityManager.createQuery("select e from Oseba e where e.tocke=(select max(o.tocke) from Oseba o)") 
        .getSingleResult(); 
       
      return temo; 
       
       
    } 
   
    @Override 
    public Oseba topMesecniUporanbik() { 
      Oseba temo = (Oseba) entityManager.createQuery("select e from Oseba e where MONTH(e.)").setParameter("mesec", GregorianCalendar.getInstance().get(Calendar.MONTH)+1) 
            .getSingleResult(); 
     
  return null; 
    } 
}
