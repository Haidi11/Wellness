package vao;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Dogodek {

	@Id
	@GeneratedValue
	private int idDogodek;
	private String naziv;
	private Date datumOd;
	private Date datumDo;
	
	 @ManyToMany(cascade = { 
		        CascadeType.PERSIST, 
		        CascadeType.MERGE
		    })
		    @JoinTable(name = "dogodek_oseba",
		        joinColumns = @JoinColumn(name = "idDogodek"),
		        inverseJoinColumns = @JoinColumn(name = "idOseba")
		    )
	public List <Oseba> udelezenci;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Date getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}
	public Date getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}
	
	public int getIdDogodek() {
		return idDogodek;
	}
	public void setIdDogodek(int idDogodek) {
		this.idDogodek = idDogodek;
	}
	
	public List<Oseba> getUdelezenci() {
		return udelezenci;
	}
	public void setUdelezenci(List<Oseba> udelezenci) {
		this.udelezenci = udelezenci;
	}
	
}
