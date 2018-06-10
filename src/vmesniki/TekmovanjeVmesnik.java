package vmesniki;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import vao.Tekmovanje;

@Local
public interface TekmovanjeVmesnik {

	List<Tekmovanje> vrniVsaTekmovanja();

	void dodajTekmovanje(Tekmovanje novoTekmovanje);

	void koncajTekmovanje(Tekmovanje t);

	List<Tekmovanje> vrniMojaTekmovanja(int id);

	Tekmovanje najdiPoId(int id);

	Map<String, String> vrniTipe();

	String poisciNaslednjoNagrado(String name);

	
	
}
