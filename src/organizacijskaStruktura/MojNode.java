package organizacijskaStruktura;

import java.util.List;

import javax.ejb.EJB;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vao.Oseba;
import vmesniki.OsebaVmesnik;


public class MojNode extends DefaultTreeNode{
	
	 
	 OsebaVmesnik ov;
	 
	 public MojNode(Object data, TreeNode parent, OsebaVmesnik ov) {
		 super(data, parent);
		 this.ov=ov;
		  sestavi();
	 }

	 
	 private void sestavi() {
		 List<Oseba> seznam = ov.vrniOsebeOddelek((String)super.getData());
		 	
		for(Oseba o : seznam) {
//			super.getChildren().add(new MojNode(o.getOddelek(),this));

		      super.getChildren().add(new DefaultTreeNode(o.getIme() + " " + o.getPriimek()));
		}
		
	 }
}
