package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class Zidingyi extends JComponent {
	String shape = "Ovol";
	Color yanse = Color.white;
	Color yanse1=Color.black;
	String mas="input the content";//×Ö·û´®ÄÚÈÝ
	int OK ;
	int extra;
	int originsize=15;
	Zidingyi dad=null;
	LinkedList<Zidingyi> sons=new LinkedList<Zidingyi >();
	int x = 1000; int z=1000;int w;int h;//×ÖÌå¿òÎ»ÖÃ
	int size;
	public Zidingyi()
	{
	this.setBounds(50,50,10,10);
	this.addMouseListener(new mouselistener());
	}
	
	
	
	public void computeSize() {
		Graphics2D g2 =(Graphics2D)this.getGraphics();
		FontRenderContext context = g2.getFontRenderContext ();
		Font f= new Font ("Î¢ÈíÑÅºÚ",Font.BOLD,30);
		Rectangle2D bounds = f.getStringBounds(mas, context);
		 w=bounds.getBounds().width;
		 h=bounds.getBounds().height;
	}
	

	
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		Font f= new Font ("Î¢ÈíÑÅºÚ",Font.PLAIN,30);
		g2.setFont(f);
		size =f.getSize();
		FontRenderContext context = g2.getFontRenderContext ();
		Rectangle2D bounds = f.getStringBounds(mas, context);
		LineMetrics	 metrics =f.getLineMetrics(mas, context);
		double descent =metrics.getDescent();
		double ascent = - bounds.getY();
		double y =(-bounds.getHeight());
		double basey= ascent +y -descent;
		this.setSize(w+size+extra, h+size);
		g2.setColor(this.yanse1);//ÉèÖÃ×ÖÌå¿òÑÕÉ«
		if(this.shape=="Ovol")
		{
			g2.fillOval(0, 0, w+size+extra, h+size);
		}
		else if (this.shape=="Rectangle")
		{
			g2.fillRect(size/2-8,size/2-4,w+16+extra,h+8);
		}
		else if (this.shape=="Rounded rectangle")
		{
			g2.fillRoundRect(size/2-8,size/2-8,w+16+extra,h+16,50,50);
		}
		else if (this.shape=="polygon")
		{
				int px[]= {size/2-8,size/2-8,size/2+w/2+extra/2,size/2+w+8+extra,size/2+w+8+extra,size/2+w/2+extra/2};
				int py[]= {size/2,size/2+h,size/2+h*5/4,size/2+h,size/2,size/2-h/4};
				g2.fillPolygon(px, py, 6);
		}
		g2.setColor(this.yanse);//ÉèÖÃ×ÖÌåÑÕÉ«
		g2.drawString(mas, originsize, (int) (15-y-descent));//ÏÔÊ¾×Ö·û´®
		if (OK==1)
		{
			g2.fillOval(15,21, 30, 30);
		}
		else if (OK==0)
		{
			
		}
		else {}
	}
	
	public void setShape(String a)
	{
		this.shape= a;
	}
	public void setYanse(Color b)
	{
		this.yanse = b;
	}
	public void setYanse1(Color b)
	{
		this.yanse1 = b;
	}
	public void stringSet(String a)
	{
		this.mas=a;
	}
	public void locationset(int a,int b)
	{
		//this.x=a;this.z=b;
		this.setLocation(new Point(a,b));
	}
	public void setdad(Zidingyi a)
	{
		this.dad=a;
	}
	public void addson(Zidingyi a)
	{
		this.sons.add(a);
		a.dad=this;
	}
	public LinkedList<Zidingyi> getsons(Zidingyi a)
	{
		return a.sons;
	}
	public int getx()
	{
		return this.x;
	}
	public int getw()
	{
		return this.w;
	}
	public int getsize()
	{
		return this.size;
	}
	public int geth()
	{
		return this.h;
	}
	public int getz()
	{
		return this.z;
	}
	public String getmas()
	{
		return this.mas;
	}
	public Color getYanse()
	{
		return this.yanse;
	}
	public Color getYanse1()
	{
		return this.yanse1;
	}
	public String getShape()
	{
		return this.shape;
	}
	public int getLeavesCount() {
		int count = 0;
		if(this.sons.isEmpty()) {
			count = 1;
		}
		else {
			Iterator<Zidingyi> iterator = sons.iterator();
			while(iterator.hasNext()) {
				Zidingyi son = iterator.next();
				count += son.getLeavesCount();
			}
		}
		return count;
	}
	
	public LinkedList<Zidingyi> getLeafPoints(){
		LinkedList<Zidingyi> points = new LinkedList<Zidingyi>();
		Iterator<Zidingyi> iterator = this.sons.iterator();
		while(iterator.hasNext()) {
			Zidingyi item = iterator.next();
			if(item.sons.isEmpty()) {
				points.add(item);
			}
			else {
				points.addAll(item.getLeafPoints());				}
		}
		
		return points;
		
	}
	public int getwidth() {
		int count = 0;
		if(this.dad==null) {
			//count += this.w+this.size;
		}
		else {
			Zidingyi ccc= this.dad;
			count = ccc.getWidth()+ccc.getwidth()+50;
			}
//		System.out.println(count);
		return count;
		
	}
	
	public void setOK(int a)
	{
		if (a==1)
		{
			this.OK=1;
			this.extra=40;
			this.originsize=50;
		}
		else if (a==0)
		{
			this.OK=0;
			this.extra=0;
			this.originsize=15;
		}
	}

	

}
