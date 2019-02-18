package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class Buttom1  implements ItemListener,ActionListener
{
	JComboBox b;
	public Buttom1 (JComboBox b)
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
		if((String)b.getSelectedItem()=="Yellow")
		{
			a.setYanse1(Color.yellow);
			a.repaint();
		}
		if ((String)b.getSelectedItem()=="Red")
		{
			a.setYanse1(Color.red);
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="Blue")
		{
			a.setYanse1(Color.blue);
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="Green")
		{
			a.setYanse1(Color.green);
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="White")
		{
			a.setYanse1(Color.white);
			a.repaint();
			}
		if ((String)b.getSelectedItem()=="Black")
		{
			a.setYanse1(Color.black);
			a.repaint();
			}
		}
		// TODO Auto-generated method stub
		
	}
	
}
