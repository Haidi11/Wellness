package vmesniki;

import java.util.List;

import javax.ejb.Local;

import block.Block;
import vao.Tocke;

@Local
public interface BlockChainVmesnik {
 void shrani(Tocke t) ;
 List<Block> getVseBlokiZaOsebo(int id);
}
