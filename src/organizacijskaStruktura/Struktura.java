package organizacijskaStruktura;

import java.io.Serializable;
import java.nio.file.NotDirectoryException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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


		TreeNode A = new MojNode("oddelek A", nodeZaposleni, ov);
		TreeNode B= new MojNode("oddelek B", nodeZaposleni, ov);
		TreeNode C = new MojNode("oddelek C", nodeZaposleni, ov);
		// TreeNode nodeVodstvo = new DefaultTreeNode("Vodstvo", root);
		// TreeNode nodeKadrovska = new DefaultTreeNode("Kadrovska služba", root);
		// TreeNode nodeZaposleni= new DefaultTreeNode("Zaposleni", root);
		// TreeNode nodeOrganizatorji= new DefaultTreeNode("Organizatorji dogodkov",
		// root);
		//
		// TreeNode node00 = new DefaultTreeNode("Node 0.0", nodeZaposleni);
		// TreeNode node01 = new DefaultTreeNode("Node 0.1", nodeZaposleni);
		//
		// TreeNode node10 = new DefaultTreeNode("Node 1.0", nodeZaposleni );
		//
		// node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
		// node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
		// node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
		// node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));

	}

	public TreeNode getRoot() {
		return root;
	}
}
