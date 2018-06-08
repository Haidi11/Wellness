package organizacijskaStruktura;

import java.util.List;

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

	 
	 public MojNode() {
		// TODO Auto-generated constructor stub
	}


	public void sestavi() {
		 List<Oseba> seznam = ov.vrniOsebeOddelek((String)super.getData());
		 System.out.println("Seznam: "+seznam);
		for(Oseba o : seznam) {
//			super.getChildren().add(new MojNode(o.getOddelek(),this));

		      super.getChildren().add(new DefaultTreeNode(o.getIme() + " " + o.getPriimek()));
		}
		
	 }
	
	
}
