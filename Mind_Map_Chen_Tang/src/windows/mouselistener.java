package windows;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class mouselistener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		Zidingyi one =(Zidingyi)e.getSource();//获得鼠标点击的当前thisone
		System.out.println("Lock "+one.mas);//看看是否点中了
		Panscroll panscroll=(Panscroll)one.getParent();
		panscroll.Setthisone(one);
	    int clickTimes = e.getClickCount();
	    if (clickTimes == 2) {
	    	System.out.println("double click");
			String inputValue = JOptionPane.showInputDialog("input the content");
			one.stringSet(inputValue);
			one.getParent().revalidate();
			one.getParent().repaint();
			System.out.println(one.mas);}
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
