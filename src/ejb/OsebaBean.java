package ejb;

import vao.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
      Oseba temo = (Oseba) entityManager.createQuery("select e from Oseba e where MONTH(e.) and e.tocke = max(e.tocke)") 
        .getSingleResult(); 
       
      return temo; 
       
       
    } 
   
    @Override 
    public Oseba topMesecniUporanbik() { 
//      Oseba temo = (Oseba) entityManager.createQuery("select max(e.dateProcessed) from Oseba e ").setParameter("mesec", GregorianCalendar.getInstance().get(Calendar.MONTH)) 
//            .getSingleResult(); 
  //   
  return null; 
    } 
}
