package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Filewrite extends AbstractAction{
	Document document=null;
	Panscroll panscroll=null;
	public Filewrite(Panscroll a)
	{
		super("Save");
		this.panscroll=a;
	}
	public Element saveFile(Zidingyi o) {
		Element root=null;
	if(o==null) {}
	else {

    root = document.createElement("root");
    
    Element mas= document.createElement("mas");
    mas.setTextContent(o.mas);
    root.appendChild(mas);
    
    Element Yanse= document.createElement("Yanse");
    int a= o.yanse.getRGB();
    Yanse.setTextContent(String.valueOf(a));
    root.appendChild(Yanse);
    
    Element Yanse1= document.createElement("Yanse1");
    int b= o.yanse1.getRGB();
    Yanse1.setTextContent(String.valueOf(b));
    root.appendChild(Yanse1);
    
    Element Shape= document.createElement("Shape");
    Shape.setTextContent(o.shape);
    root.appendChild(Shape);
    
    Element OK= document.createElement("OK");
    OK.setTextContent(String.valueOf(o.OK));
    root.appendChild(OK);
    
    Element child =document.createElement("Child");
    
    Iterator<Zidingyi> iterator = o.getsons(o).iterator();
    while (iterator.hasNext())
	{
		Zidingyi ccc=iterator.next();
		child.appendChild(saveFile(ccc));
	}
    root.appendChild(child);
    
	}
        return root;
	}

	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.SAVE_DIALOG);  
		jfc.showSaveDialog(panscroll); 
		File file=jfc.getSelectedFile();
		String fname = jfc.getName(file);
		file=new File(jfc.getCurrentDirectory(),fname+".xml");  
		 try {
			FileOutputStream fos = new FileOutputStream(file);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (file==null) {return;}

		try {
			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();  
		     DocumentBuilder builder = factory.newDocumentBuilder();
		     document = builder.newDocument();
		     

			saveFile(Panscroll.root);
		     document.appendChild(saveFile(Panscroll.root)); 	
		     TransformerFactory transformerFactory = TransformerFactory.newInstance();  
		     
		     Transformer transformer;
			transformer = transformerFactory.newTransformer();
			 transformer.setOutputProperty("encoding", "UTF-8");  
		     transformer.transform(new DOMSource(document), new StreamResult(new File(file.getPath()))); 
		     
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
}
