package windows;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;

public class action extends AbstractAction{
	Panscroll panscroll=null;
	int a=0;
	public action (Panscroll a)
	{
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Zidingyi ccc= new Zidingyi();
		if (panscroll.thisone==null&&panscroll.root==null)
		{
			panscroll.add(ccc);
			panscroll.root = ccc;
			panscroll.thisone=ccc;
		}
		else
		{
			panscroll.add(ccc);
			panscroll.thisone.addson(ccc);
//			ccc.setdad(panscroll.thisone);

		}
		panscroll.revalidate();
		panscroll.repaint();

	}
	}
