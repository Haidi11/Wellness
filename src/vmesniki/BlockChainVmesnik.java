package vmesniki;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Local;

import vao.Tocke;

@Local
public interface BlockChainVmesnik {
 void shrani(Tocke t) ;
}
