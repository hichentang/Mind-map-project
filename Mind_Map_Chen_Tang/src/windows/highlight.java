package windows;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class highlight extends AbstractAction {
	Panscroll panscroll=null;
	public highlight (Panscroll a)
	{
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(panscroll.thisone==null) {}
		else {
		panscroll.thisone.setOK(1);

		panscroll.revalidate();
		panscroll.repaint();
		}
	}	


}
