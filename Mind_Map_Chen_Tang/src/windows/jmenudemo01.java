package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
public class jmenudemo01 {
public static Panscroll panscroll;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame1=new JFrame("Mind_Map");
		frame1.addWindowListener(new MyWindowEventHandle());//监听窗口
		JMenu menu1 = new JMenu("File");
		JMenuBar bar1= new JMenuBar();

		JMenuItem item7= new JMenuItem ("Save");
		item7.setAction(new Filewrite(panscroll));

		JMenuItem item11= new JMenuItem ("Import");
		
		JMenuItem item1=new JMenuItem("New");
		
		menu1.add(item1);
		
		menu1.add(item7);

		menu1.add(item11);

		JPanel pan= new JPanel();
		Font haha = new Font ("微软雅黑",Font.BOLD,30);
		pan.setLayout(new BorderLayout(4,4));//主panel布局
		JPanel pan2= new JPanel();//创建Pan2
		pan2.setBackground(Color.blue);
		pan2.setPreferredSize(new Dimension (50, 70));  
		pan.add(pan2,BorderLayout.NORTH);
		JPanel pan3= new JPanel();//创建pan3
		pan3.setBackground(Color.red);
		pan3.setPreferredSize(new Dimension(200,100));
		pan.add(pan3,BorderLayout.EAST);
		JLabel wordcolor = new JLabel("font color");
		//wordcolor.setFont(haha);
		JComboBox ziti = new JComboBox();//创建字体栏
		ziti.addItem("White");
		ziti.addItem("Yellow");
		ziti.addItem("Blue");
		ziti.addItem("Green");
		ziti.addItem("Red");
		ziti.addItem("Black");
		pan3.add(wordcolor);
		pan3.add(ziti);
		JLabel backcolor= new JLabel ("Background Color");
		JComboBox zitikuang = new JComboBox();//创建字体框颜色
		zitikuang.addItem("Black");
		zitikuang.addItem("Yellow");
		zitikuang.addItem("Blue");
		zitikuang.addItem("Green");
		zitikuang.addItem("Red");
		zitikuang.addItem("White");
		pan3.add(backcolor);
		pan3.add(zitikuang);
		JLabel windowshape = new JLabel("Shape");
		JComboBox kuangshape = new JComboBox();
		kuangshape.addItem("Ovol");
		kuangshape.addItem("Rectangle");
		kuangshape.addItem("Rounded rectangle");
		kuangshape.addItem("polygon");
		pan3.add(windowshape);
		pan3.add(kuangshape);
		ziti.setBounds(10000, 100000, 10000, 51000);
		JPanel pan4= new JPanel();//创建pan4
		pan4.setBackground(Color.GREEN);
		pan4.setPreferredSize(new Dimension(100,70));
		pan.add(pan4,BorderLayout.SOUTH);
		JPanel panmain=new JPanel();
		pan.add(panmain);
		panmain.setBackground(Color.yellow);
		panmain.setLayout(new BorderLayout());
		JTabbedPane tab = null;//创建tabbedpanel
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel pantab2=new JPanel();
		pantab2.setLayout(new BorderLayout());
		JScrollPane roll1 =null;//创建滚动条1
		panscroll = new Panscroll();
		panscroll.setPreferredSize(new Dimension(2000,2000));
		//panscroll.add(new JButton("测试"));
		panscroll.setLayout(null);
		roll1 = new JScrollPane(panscroll,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tab.addTab("yoyo",roll1);
		panmain.add(tab);//添加tabbedpan
		frame1.add(pan);
		bar1.add(menu1);

		frame1.setSize(1000, 1000);
		frame1.setJMenuBar(bar1);
		frame1.setVisible(true);
		Buttom but = new Buttom (ziti);
		Buttom1 butt = new Buttom1 (zitikuang);
		Buttomshape buttt= new Buttomshape (kuangshape);
		
		
		kuangshape.addItemListener(buttt);
		ziti.addItemListener(but);
		zitikuang.addItemListener(butt);
		
		
		
		InputMap im1 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//添加监听
		ActionMap am1 =pan.getActionMap();
		KeyStroke k1= KeyStroke .getKeyStroke('q');
		im1.put(k1, "temp");
		am1.put("temp", new action(panscroll));
		panscroll.setLayout(new layout(panscroll));
		
		
		
		item11.setAction(new Fileread(panscroll));
		item1.addActionListener(new Newone(panscroll));
		
		InputMap im2 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//删除监听
		ActionMap am2 =pan.getActionMap();
		KeyStroke k2= KeyStroke .getKeyStroke('d');
		im1.put(k2, "xixi");
		am1.put("xixi", new Deleteaction(panscroll));
		
		InputMap im3 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//复制监听
		ActionMap am3 =pan.getActionMap();
		KeyStroke k3= KeyStroke .getKeyStroke('c');
		im1.put(k3, "lala");
		am1.put("lala", new Ctrlc(panscroll));
		
		InputMap im4 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//黏贴
		ActionMap am4 =pan.getActionMap();
		KeyStroke k4= KeyStroke .getKeyStroke('v');
		im1.put(k4, "yiyi");
		am1.put("yiyi", new Ctrlv(panscroll));

		InputMap im5 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//高亮监听
		ActionMap am5 =pan.getActionMap();
		KeyStroke k5= KeyStroke .getKeyStroke('t');
		im1.put(k5, "qeqe");
		am1.put("qeqe", new highlight(panscroll));
		
		InputMap im6 = pan.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//删除高亮监听
		ActionMap am6 =pan.getActionMap();
		KeyStroke k6= KeyStroke .getKeyStroke('y');
		im1.put(k6, "1212");
		am1.put("1212", new Cancelhighlight(panscroll));
	}

}
