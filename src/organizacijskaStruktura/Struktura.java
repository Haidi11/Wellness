package organizacijskaStruktura;

import java.io.Serializable;
import java.nio.file.NotDirectoryException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
@ManagedBean(name="struktura")
@SessionScoped
public class Struktura implements Serializable{
	 private TreeNode root;
     
	    @PostConstruct
	    public void init() {
	        root = new DefaultTreeNode("Root", null);
//	        TreeNode nodeVodstvo = new DefaultTreeNode("Vodstvo", root);
//	        TreeNode nodeKadrovska = new DefaultTreeNode("Kadrovska služba", root);
//	        TreeNode nodeZaposleni= new DefaultTreeNode("Zaposleni", root);
//	        TreeNode nodeOrganizatorji= new DefaultTreeNode("Organizatorji dogodkov", root);
//	         
//	        TreeNode node00 = new DefaultTreeNode("Node 0.0", nodeZaposleni);
//	        TreeNode node01 = new DefaultTreeNode("Node 0.1", nodeZaposleni);
//	         
//	        TreeNode node10 = new DefaultTreeNode("Node 1.0", nodeZaposleni );
//	         
//	        node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
//	        node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
//	        node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
//	        node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
	       
	    }
	 
	    public TreeNode getRoot() {
	        return root;
	    }
}
