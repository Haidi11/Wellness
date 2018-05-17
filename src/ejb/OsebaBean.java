package ejb;

import vao.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
}
