package windows;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedList;
public class Deleteaction extends AbstractAction{
	Panscroll panscroll=null;
	int a=0;
	public Deleteaction (Panscroll a)
	{
		this.panscroll=a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (panscroll.thisone==null) {}
		else
		{
			if (panscroll.thisone==panscroll.root)
			{
				deletesons(panscroll.thisone);
				panscroll.remove(panscroll.thisone);
				panscroll.thisone=null;
				panscroll.root=null;
				panscroll.revalidate();
				panscroll.repaint();
			}
			else {
			deletesons(panscroll.thisone);
			panscroll.thisone.dad.sons.remove(panscroll.thisone);
			panscroll.remove(panscroll.thisone);
			panscroll.thisone=panscroll.thisone.dad;
			panscroll.revalidate();
			panscroll.repaint();
//			panscroll.remove(panscroll.thisone);
//			panscroll.thisone.dad.sons.remove();
			}
		}
		
	}
	public void deletesons(Zidingyi aaa)
	{
		Iterator<Zidingyi> iterator = aaa.sons.iterator();
		while(iterator.hasNext()) {
			Zidingyi item = iterator.next();
			if(!item.sons.isEmpty()) {
				deletesons(item);
				item.sons.clear();
			}
				panscroll.remove(item);	
		}
		aaa.sons.clear();
		
	}
}
