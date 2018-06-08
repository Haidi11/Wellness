package ejb;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import block.Block;
import vao.Tocke;
import vmesniki.BlockChainVmesnik;

@Stateless
public class BlockChainBean implements BlockChainVmesnik {
	public static int tezavnost = 0;

	@PersistenceContext
	EntityManager em;

	@Override
	public void shrani(Tocke t) {
		String prejsnjiHash = najdiPrejsnjiHash();
		//System.out.println("tocka: " + t.getStTock() + ", oseba: " + t.getIdOseba() + ", dogodek: " + t.getIdDogodek());
		try {
			shraniBlockChain(new Block(t.getStTock(), t.getIdOseba(), t.getIdDogodek(), prejsnjiHash));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String najdiPrejsnjiHash() {
		List<Block> seznam =  em.createQuery("select b from Block b order by b.timeStamp desc").getResultList();
		
		if (seznam.size()==0) {	
			return " ";
		}
			
		return seznam.get(0).getHash();
	}
	
	public void shraniBlockChain(Block block) {
		em.persist(block);
	}
	
	public List<Block> getVseBlokiZaOsebo(int id) {
		 Query q = em.createQuery("select b from Block b where b.idOseba= :id");
		 q.setParameter("id", id);
		 return q.getResultList();
	}
}
