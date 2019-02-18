package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Buttom implements ItemListener,ActionListener{
	JComboBox b;
	public Buttom (JComboBox b)
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
		Zidingyi c= Panscroll.Getthisone();
		if((String)b.getSelectedItem()=="Yellow")
		{
			c.setYanse(Color.yellow);
			c.repaint();
		}
		if ((String)b.getSelectedItem	()=="Red")
		{
			c.setYanse(Color.red);
			c.repaint();
			}
		if ((String)b.getSelectedItem()=="Blue")
		{
			c.setYanse(Color.blue);
			c.repaint();
			}
		if ((String)b.getSelectedItem()=="Green")
		{
			c.setYanse(Color.green);
			c.repaint();
			}
		if ((String)b.getSelectedItem()=="White")
		{
			c.setYanse(Color.white);
			c.repaint();
			}
		if ((String)b.getSelectedItem()=="Black")
		{
			c.setYanse(Color.black);
			c.repaint();
			}
		}
		// TODO Auto-generated method stub
		
	}
	
}
