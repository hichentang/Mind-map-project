package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Fileread extends AbstractAction{
	Document document=null;
	Panscroll panscroll=null;
	public Fileread(Panscroll a)
	{
		super("Read");
		this.panscroll=a;
	}
	public Zidingyi readFile(Element o)
	{
		Zidingyi zidingyiroot=new Zidingyi();
		if(o==null) {}
		else 
		{	
			if (panscroll.thisone==null&&panscroll.root==null)
			{
				panscroll.add(zidingyiroot);
				panscroll.root = zidingyiroot;
				panscroll.thisone=zidingyiroot;
			}
			else
			{
				
				panscroll.add(zidingyiroot);

			}

			panscroll.thisone=zidingyiroot;
			NodeList list1=o.getElementsByTagName("mas");
			Element mas =(Element)list1.item(0);
			String mas0 =  mas.getTextContent();
			zidingyiroot.stringSet(mas0);
			System.out.println(mas0);
			
			NodeList list2=o.getElementsByTagName("Yanse");
			Element Yanse =(Element)list2.item(0);
			String Yanse0 =  Yanse.getTextContent();
			int a=Integer.valueOf(Yanse0);
			Color a1=new Color(a);
			zidingyiroot.setYanse(a1);
			
			NodeList list3=o.getElementsByTagName("Yanse1");
			Element Yanse1 =(Element)list3.item(0);
			String Yanse10 =  Yanse1.getTextContent();
			int b=Integer.valueOf(Yanse10);
			Color b1=new Color(b);
			zidingyiroot.setYanse1(b1);
			
			
			NodeList list4=o.getElementsByTagName("Shape");
			Element Shape =(Element)list4.item(0);
			String Shape0 =  Shape.getTextContent();
			if(Shape0=="Ovol")
			{
				zidingyiroot.setShape("Ovol");
				zidingyiroot.repaint();
			}
			if (Shape0=="Rectangle")
			{
				zidingyiroot.setShape("Rectangle");
				zidingyiroot.repaint();
				}
			if (Shape0=="Rounded rectangle")
			{
				zidingyiroot.setShape("Rounded rectangle");
				zidingyiroot.repaint();
				}
			if (Shape0=="polygon")
			{
				zidingyiroot.setShape("polygon");
				zidingyiroot.repaint();
				}
			
			
			NodeList list5=o.getElementsByTagName("OK");
			Element OK =(Element)list5.item(0);
			String OK0 =  OK.getTextContent();
			int c=Integer.valueOf(OK0);
			zidingyiroot.setOK(c);
			
			NodeList list6=o.getElementsByTagName("Child");

			if(list6.getLength()==0) {return zidingyiroot;}
			
			
				Element ccc=(Element)list6.item(0);
				NodeList list=ccc.getChildNodes();
				int i;
				
				for(i=0;i<list.getLength();i++)
				{
					Element bbb=(Element) list.item(i);
				zidingyiroot.addson(readFile(bbb));
				}

				
			
			
			panscroll.revalidate();
			panscroll.repaint();
		}
		return zidingyiroot;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG|JFileChooser.FILES_AND_DIRECTORIES );  
		jfc.showSaveDialog(panscroll); 
		File file=jfc.getSelectedFile();
		
		if (file==null) {return;}
		try 
		{
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder = factory.newDocumentBuilder();  
			
			if(panscroll.thisone==null) {}
			else {
		     
		     Deleteaction removeall=new Deleteaction(panscroll);
		     panscroll.thisone=panscroll.root;
		     removeall.deletesons(panscroll.thisone);
		     panscroll.remove(panscroll.thisone);
				panscroll.thisone=null;
				panscroll.root=null;
				panscroll.revalidate();
				panscroll.repaint();
			}
				
			document = builder.parse(new File(file.getPath())); 
			readFile(document.getDocumentElement());
			System.out.println("Read Successfully");
		}
		catch (ParserConfigurationException e1) {  
            e1.printStackTrace();  
        } catch (SAXException e1) {  
            e1.printStackTrace();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        } 
		
	}

}
