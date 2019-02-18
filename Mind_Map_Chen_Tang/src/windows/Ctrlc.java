package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Ctrlc extends AbstractAction{
	Panscroll panscroll=null;
	public Ctrlc (Panscroll a)
	{
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (panscroll.thisone==null) {}
		else
		{
			panscroll.copymas=panscroll.thisone.mas;
			panscroll.copyYanse=panscroll.thisone.yanse;
			panscroll.copyYanse1=panscroll.thisone.yanse1;
			panscroll.copyshape=panscroll.thisone.shape;
			panscroll.copyOK=panscroll.thisone.OK;
			System.out.println("Copy "+panscroll.copymas);
		}
	}

}
