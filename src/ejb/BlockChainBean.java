package ejb;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		System.out.println("tocka: " + t.getId() + ", oseba: " + t.getIdOseba() + ", dogodek: " + t.getIdDogodek());
		try {
			shraniBlockChain(new Block(t.getId(), t.getIdOseba(), t.getIdDogodek(), prejsnjiHash));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String najdiPrejsnjiHash() {
		Block o =  (Block) em.createQuery("select b from Block b order by b.timeStamp desc").getResultList().get(0);
		String prejsnjiHash = o.getHash();
		if (prejsnjiHash==null) {
			initialBlock();
			Block a =  (Block) em.createQuery("select b from Block b order by b.timeStamp desc").getResultList().get(0);
			 prejsnjiHash =  a.getHash();
		}
		
		return prejsnjiHash;
	}
	private void initialBlock() {
		Block temp=new Block();
		temp.setHash("9u");
		em.persist(temp);
		
	}
	public void shraniBlockChain(Block block) {
		em.persist(block);
	}
}
