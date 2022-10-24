import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener , MouseListener{
	
	JButton addPath;
	JButton launcher;
	JButton btn0;
	JButton btn1;
	JButton saver;
	
	JTextField textField;
	JTextField textField1;
	JFileChooser fc;
	JFileChooser fc2;
	JLabel label1;
	JLabel label2;
	JLabel pic;
	JCheckBox checkBox;
	JComboBox comboBox;
	
	File fp;
	File fp2;
	String path;
	String comma;
	String str1;
	String str2;
	String [] ext = {".txt",".pdf",".dwg",".jpg","Wpisz",""};
	Object ext1;
	Importer imp;
	
	MyFrame(){
		
		this.setTitle("An exquisite finder for files in a folder");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(665, 340);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		
		ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("FACES.JPG")));
		this.setIconImage(image.getImage());
		
		ImageIcon iI = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Copyright-All-Rights-Reserved-Symbol-PNG-Image.png")));
		Image img1 = iI.getImage();
		Image img2 = img1.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		iI = new ImageIcon(img2);	
				
		pic = new JLabel(iI);
		pic.setBounds(210,10,130,130);
		pic.setVisible(true);
			
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.cyan,3);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(0x4A588A));
		panel1.setBounds(0, 0, 300, 300);
		panel1.setVisible(true);
		panel1.setBorder(border);	
				
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(0x4A588A));
		panel2.setBounds(300, 0, 350, 150);
		panel2.setVisible(true);	
		panel2.setBorder(border);
	
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(new Color(0x4A588A));
		panel3.setBounds(300, 150, 350, 150);
		panel3.setVisible(true);
		panel3.setBorder(border);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		label2 = new JLabel();
		label2.setText("<html>"
	            + "<p><font size=-1>All Rights Reserved</p>"
	            + "<p><font size=-1>2022 Author: Micha³ Chodacki</p>"
	            + "</html>");
		label2.setFont(new Font("Chuj",Font.ITALIC,20));
		label2.setBackground(Color.gray);
		label2.setForeground(new Color(0x000000));
		label2.setVisible(true);
		label2.setBounds(10,60,180,130);
		//label2.setOpaque(true);
		
		label1 = new JLabel();
		label1.setText("<html>"
	            + "<h3>Here's the ultimate file finder.</h3>"
	            + "<p><font size=-1>1. Copy the full path for searching.</p>"
	            + "<p><font size=-1>2. Press the Add button</p>"
	            + "<p><font size=-1>3. Browse to add a txt list with passwords</p>"
	            + "<p><font size=-1>4. Start the search engine with the start button.</p>"
	            + "<p><font size=-1>5. Save a text file with search results.</font></p>"
	            + "<p></p>"
	            + "<p><font size=-1>Caution!</p>"
	            + "<p><font size=-1>- It may take a while to build up a long list of files</font></p>"
	            + "<p><font size=-1>- The search engine does not look in subdirectories or the directories themselves</font></p>"
	            + "<p><font size=-1>- You can enter the extension for the search manually or enter a blank field</font></p>"
	            + "<p><font size=-1>- You can remove duplicate lines for the added list</font></p>"
	            + "<p><font size=-1>- The search engine can add a comma at the end of each line</font></p>"
	            + "</html>");
		
		label1.setFont(new Font("Font1",Font.ITALIC,20));
		label1.setBackground(Color.gray);
		label1.setForeground(new Color(0x000000));
		label1.setBounds(10, 0, 280, 290);
	//	label1.setVerticalAlignment(JLabel.TOP);
		label1.setVisible(true);
		
		addPath = new JButton("Add");
		addPath.addActionListener(this);
		addPath.setBounds(10,10,100,25);
		addPath.setFocusable(false);
		
		launcher = new JButton("Start");
		launcher.addActionListener(this);
		launcher.setBounds(10,80,100,25);
		launcher.setFocusable(false);
		
		btn0 = new JButton ("Browse");
		btn0.addActionListener(this);
		btn0.setBounds(10,45,100,25);
		btn0.setFocusable(false);
		
		btn1 = new JButton ("Remove duplicates");
		btn1.addActionListener(this);
		btn1.setBounds(120,115,120,25);
		btn1.setFocusable(false);
		btn1.setVisible(true);
				
		saver = new JButton ("Save");
		saver.addActionListener(this);
		saver.setBounds(10,115,100,25);
		saver.setFocusable(false);
		saver.setVisible(true);
		
		checkBox = new JCheckBox();
		checkBox.setText("Add a comma");
		checkBox.setBounds(120,80,220,25);
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Font1",Font.ITALIC,15));
		checkBox.setBackground(Color.black);
		checkBox.setForeground(new Color(0xffffff));
		checkBox.setSelected(true);
		
		comboBox = new JComboBox(ext);
		comboBox.addActionListener(this);
		comboBox.setBounds(250,115,90,25);
		comboBox.setFont(new Font("Font1",Font.ITALIC,15));
		comboBox.setBackground(Color.black);
		comboBox.setForeground(new Color(0xffffff));
		comboBox.setEditable(true);
		
		textField = new JTextField();
		textField.setBounds(120,10,220,25);
		textField.setForeground(new Color(0xffffff));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.white);
		textField.setText("Copy the search path here");
		textField.setFont(new Font("Font1",Font.ITALIC,15));
		textField.addMouseListener(this);
		
		textField1 = new JTextField();
		textField1.setBounds(120,45,220,25);
		textField1.setForeground(new Color(0xffffff));
		textField1.setBackground(Color.black);
		textField1.setCaretColor(Color.white);
		textField1.setFont(new Font("Font1",Font.ITALIC,15));
		textField1.addMouseListener(this);
		
		panel1.add(label1);
		panel2.add(pic);
		panel2.add(label2);
		panel3.add(addPath);
		panel3.add(textField);
		panel3.add(btn0);
		panel3.add(textField1);
		panel3.add(launcher);
		panel3.add(checkBox);
		panel3.add(comboBox);
		panel3.add(btn1);
		panel3.add(saver);
	//	this.revalidate();
		this.repaint();
		this.setVisible(true);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addPath) {
		textField.getText();
		str2=textField.getText();
		}
		
		if(e.getSource()==btn0) {	
			fc = new JFileChooser();
			int resp = fc.showOpenDialog(null); 
			if(resp == JFileChooser.APPROVE_OPTION);
			fp = new File(fc.getSelectedFile().getAbsolutePath());
			str1 = fp.toString();
			textField1.setText(str1);
			System.out.println(fp);
			
		}if(e.getSource()==launcher){
			System.out.println(str2);
			if(str2==null || str2==textField.getText()) {
				JOptionPane.showMessageDialog
				(null, "No path was entered for the search engine","Default path", JOptionPane.WARNING_MESSAGE);
				
			} else {
			Importer importList = new Importer ();
			importList.reader(str1);	
			
			if(importList.getInsertMe()==false) {
				fc2 = new JFileChooser();
				int resp2 = fc2.showSaveDialog(null);
				
			if(resp2 == JFileChooser.APPROVE_OPTION) {
				fp2 =  new File(fc2.getSelectedFile().getAbsolutePath());
				
			if(checkBox.isSelected() == true) {
				comma = ",";
			}else {
				comma ="";
			}
			Lister fetchData = new Lister();
			fetchData.dataHolder(importList.getStorage1(),gettextField(),fp2,comma,comboBox.getSelectedItem());
			System.out.println(gettextField());
				}	
			}
		}
	}
		if(e.getSource()==btn1){
			
			imp = new Importer ();
			imp.reader(str1);	
			imp.doubleRemove();
		}
		if(e.getSource()==saver) {
			
			imp.saver(str1);
			
			fc2 = new JFileChooser();
			int resp2 = fc2.showSaveDialog(null);
			if(resp2 == JFileChooser.APPROVE_OPTION) {
				fp2 =  new File(fc2.getSelectedFile().getAbsolutePath());
			}
		}
		if(e.getSource()==comboBox) {
			ext1 = comboBox.getSelectedItem();
		}
	}

	public final String gettextField() {
		return textField.getText();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		textField.selectAll();	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
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
}
