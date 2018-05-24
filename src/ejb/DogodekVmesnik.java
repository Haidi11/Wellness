package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import vao.Dogodek;

@Local
public interface DogodekVmesnik {
	void dodajDogodek(Dogodek dogodek);
	void odstraniDogodek(Dogodek dogodek);
	ArrayList<Dogodek> sezamDogodkov();
	void podrobnoDogodek(Dogodek dogodek);
}
