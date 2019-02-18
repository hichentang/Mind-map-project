package windows;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Cancelhighlight extends AbstractAction{
	Panscroll panscroll=null;
	public Cancelhighlight (Panscroll a)
	{
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(panscroll.thisone==null) {}
		else {
		panscroll.thisone.setOK(0);

		panscroll.revalidate();
		panscroll.repaint();
		}
	}

}
