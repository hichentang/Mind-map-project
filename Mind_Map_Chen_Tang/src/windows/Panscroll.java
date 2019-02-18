package windows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panscroll extends JPanel{
	public static Zidingyi thisone;
	public static Zidingyi copyone;
	public static String copymas;
	public static Color copyYanse;
	public static Color copyYanse1;
	public static String copyshape;
	public static int copyOK;
	public static Zidingyi root;
	public void Setthisone(Zidingyi a)
	{
		this.thisone=a;
	}
	public static Zidingyi Getthisone()
	{
		return thisone;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		super.paintComponent(g2);
		Stroke stroke=new BasicStroke(3.0f);
		g2.setStroke(stroke);
		g2.setPaint(Color.green);
		if(this.root==null) {}
		else
		{
			line(g,this.root);
		}
	}
	public void line(Graphics g,Zidingyi a) {
		{
			if ( !a.sons.isEmpty())
			{
			LinkedList<Zidingyi> aaa=a.getsons(a);
			Iterator<Zidingyi> iterator = aaa.iterator();
			while (iterator.hasNext())
			{
				Zidingyi ccc=iterator.next();
				int x1=a.getX()+a.getw()+a.getsize()+a.extra;
				int y1=a.getY()+(a.geth()+a.getsize())/2;
				int x2= ccc.getX();
				int y2=ccc.getY()+ccc.geth()/2+ccc.getsize()/2;
				g.drawLine(x1,y1,x2,y2);
				line( g,ccc);
				revalidate();
				repaint();
			}
			}
		}

	}
}
