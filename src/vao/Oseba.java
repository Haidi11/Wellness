package vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Oseba")
public class Oseba {

    private int id;
    private String ime;
    private String priimek;
    private String email;
    private boolean orgaizatorDoodkov;

    public boolean isOrgaizatorDoodkov() {
        return orgaizatorDoodkov;
    }

    public void setOrgaizatorDoodkov(boolean orgaizatorDoodkov) {
        this.orgaizatorDoodkov = orgaizatorDoodkov;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}