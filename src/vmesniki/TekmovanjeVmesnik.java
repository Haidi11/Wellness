package vmesniki;

import java.util.List;

import javax.ejb.Local;

import vao.Tekmovanje;

@Local
public interface TekmovanjeVmesnik {

	List<Tekmovanje> vrniVsaTekmovanja();

	void dodajTekmovanje(Tekmovanje novoTekmovanje);

	void koncajTekmovanje(Tekmovanje t);

	List<Tekmovanje> vrniMojaTekmovanja(int id);

	
	
}
