package windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class Buttomshape  implements ItemListener,ActionListener
{
	JComboBox b;
	public Buttomshape (JComboBox b)
	{
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
		Zidingyi a= Panscroll.Getthisone();
		if((String)b.getSelectedItem()=="Ovol")
		{
			a.setShape("Ovol");
			a.repaint();
		}
		if ((String)b.getSelectedItem()=="Rectangle")
		{
			a.setShape("Rectangle");
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="Rounded rectangle")
		{
			a.setShape("Rounded rectangle");
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="polygon")
		{
			a.setShape("polygon");
			a.repaint();
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	
}
