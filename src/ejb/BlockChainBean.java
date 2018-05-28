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
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int tezavnost = 0;
	Block block;
	
	@PersistenceContext
	EntityManager em; 

	@Override
	public void shrani(Tocke t) {
		String prejsnjiHash = najdiPrejsnjiHash();
		System.out.println("tocka: " + t.getId() + ", oseba: " + t.getIdOseba() + ", dogodek: " + t.getIdDogodek());
		try {
			blockchain.add(new Block(t.getId(), t.getIdOseba(), t.getIdDogodek(), prejsnjiHash));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i == blockchain.size(); i++) {
			if (i == 0) {
				block.setPrejsnjiHash("0");
				try {
					blockchain.get(i).rudarjenjeBloka(tezavnost);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hash trenutnega bloka: " + blockchain.get(i).getHash() + ", idTocke: "
						+ blockchain.get(i).getIdTocke());
			}
			try {
				blockchain.get(i).rudarjenjeBloka(tezavnost);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hash trenutnega bloka: " + blockchain.get(i).getHash() + ", idTocke: "
					+ blockchain.get(i).getIdTocke());

		}
	}
	
	public String najdiPrejsnjiHash() {
		String prejsnjiHash = (String) em.createQuery("select b from Block b order by b.timestamp desc").getResultList().get(0);
		return prejsnjiHash;
	}
	
	public void shraniBlockChain(Block block) {
		em.persist(block);
	}
}
