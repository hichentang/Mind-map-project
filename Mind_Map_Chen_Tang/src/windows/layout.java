package windows;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Iterator;
import java.util.LinkedList;

public class layout  implements LayoutManager{
	Panscroll panscroll=null;
	public layout(Panscroll a )
	{
		this.panscroll=a;
	}
    public void layoutContainer(Container parent) {

    	
    	for(int i=0;i<panscroll.getComponentCount();i++) {
    		
    		Zidingyi temp = (Zidingyi)panscroll.getComponent(i);
    		temp.computeSize();
    	}
    	
    	if (panscroll.root == null){}
    	else {
    		

    		Iterator<Zidingyi> points = panscroll.root.getLeafPoints().iterator();
    		int height=(panscroll.root.h+panscroll.root.size+20)*panscroll.root.getLeavesCount();
    		int j = 0;
    		
    		
    		while(points.hasNext()) {
    			Zidingyi point = points.next();
    			int y= 500-height/2+(panscroll.root.h+panscroll.root.size+20)*j+(panscroll.root.h+panscroll.root.size+20)/2;
    			int x=500+point.getwidth();
    			j++;
    			point.setLocation(x,y);
    		}//设置叶子节点的坐标
    		
    		
	    	int count = parent.getComponentCount();
	    	
	    	for (int i=0;i<count;i++) {
	    		
	    		Zidingyi com = (Zidingyi)parent.getComponent(i);
	    		
	    		if( !com.sons.isEmpty()) {
	    			Iterator<Zidingyi> sons = com.sons.iterator();
	    			int totalHeight = 0;
	    			while(sons.hasNext()) {
	    				Zidingyi son = sons.next();
	    				totalHeight += son.getY();
	    			}
	    			com.setLocation(500+com.getwidth(),totalHeight/com.sons.size());
	    			
	    		}
	    	}//设置非叶子节点的坐标
	    	
	    	panscroll.root.setLocation(500,500);
	    	
    	}
    	
    	
    	
    }
    

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
