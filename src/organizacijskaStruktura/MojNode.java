package organizacijskaStruktura;

import javax.ejb.EJB;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vao.Oseba;
import vmesniki.OsebaVmesnik;

public class MojNode extends DefaultTreeNode{
	
	 @EJB
	 OsebaVmesnik ov;
	 
	 public MojNode(Object data, TreeNode parent) {
		 super(data, parent);
		 
		  init();
	 }

	 
	 private void init() {
		for(Oseba o: ov.vrniOsebeOddelek(super.getData())) {
			super.getChildren().add(new MojNode(o.getOddelek(),this));
		}
		 
	 }
}
