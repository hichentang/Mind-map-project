package windows;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Ctrlv extends AbstractAction{
	Panscroll panscroll=null;
	public Ctrlv (Panscroll a)
	{
		this.panscroll=a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Zidingyi ccc= new Zidingyi();
		if (panscroll.thisone==null) {}
		else 
		{
			panscroll.add(ccc);
			ccc.stringSet(panscroll.copymas);
			ccc.setYanse(panscroll.copyYanse);
			ccc.setYanse1(panscroll.copyYanse1);
			ccc.setShape(panscroll.copyshape);
			ccc.setOK(panscroll.copyOK);
			panscroll.thisone.addson(ccc);
			ccc.setdad(panscroll.thisone);
			panscroll.revalidate();
			panscroll.repaint();
		}
	}

}
