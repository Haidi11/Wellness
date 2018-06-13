package organizacijskaStruktura;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vmesniki.OsebaVmesnik;

@ManagedBean(name = "struktura")
@RequestScoped
public class Struktura implements Serializable {
	private TreeNode root;

	@EJB
	OsebaVmesnik ov;

	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("Root", null);
		TreeNode moj = new MojNode("Vodstvo", root, ov);
		TreeNode nodeKadrovska = new MojNode("Kadrovska služba", root, ov);
		TreeNode nodeZaposleni = new DefaultTreeNode("Zaposleni", root);
		TreeNode nodeOrganizatorji = new MojNode("Organizatorji dogodkov", root, ov);


		TreeNode A = new MojNode("Infrormatiki", nodeZaposleni, ov);
		TreeNode B= new MojNode("Finance", nodeZaposleni, ov);
		TreeNode C = new MojNode("Razvojni oddelek", nodeZaposleni, ov);
		

	}

	public TreeNode getRoot() {
		return root;
	}
}
