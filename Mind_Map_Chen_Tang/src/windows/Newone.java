package windows;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Newone extends AbstractAction{
	Panscroll panscroll=null;
	public Newone(Panscroll a)
	{
		super("New");
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(panscroll.thisone==null) {}
		else {
	     
	     Deleteaction removeall=new Deleteaction(panscroll);
	     panscroll.thisone=panscroll.root;
	     removeall.deletesons(panscroll.thisone);
	     panscroll.remove(panscroll.thisone);
			panscroll.thisone=null;
			panscroll.root=null;
			panscroll.revalidate();
			panscroll.repaint();
			
		}
	}

}
