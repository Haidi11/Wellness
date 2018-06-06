package jsf;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import vmesniki.BlockChainVmesnik;
import vmesniki.NasvetVmesnik;
import block.Block;

@ManagedBean(name = "blok")
@SessionScoped
public class BlockChainModel {
	@EJB
	NasvetVmesnik nv;
	
	@EJB
	BlockChainVmesnik bv;
	
	List<Block> seznamBlokov = new ArrayList<>();
	
	private Principal vrniAvtorja() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	public List<Block> getSeznamBlokovOsebe() {
		int id = nv.najdiIdAvtorja(vrniAvtorja().getName());
		seznamBlokov = bv.getVseBlokiZaOsebo(id);
		return seznamBlokov;
	}

	public List<Block> getSeznamBlokov() {
		return seznamBlokov;
	}

	public void setSeznamBlokov(List<Block> seznamBlokov) {
		this.seznamBlokov = seznamBlokov;
	}
}
