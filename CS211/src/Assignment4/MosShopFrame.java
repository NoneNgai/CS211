package Assignment4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MosShopFrame extends JFrame implements ActionListener{
	JPanel panel,left,right,top,bot,center;
	JMenuBar Menubar;
	JMenu menu;
	JMenuItem load,save,exit;
	JButton New,Update;
	JComboBox<String> name;
	JLabel namel,img;
	JTextArea Name,Nutrient,Price;
	JScrollPane scroll;
	JFileChooser chooser;
	FileFilter filter;
	ImageIcon icon;
	FoodList list = new FoodList();
	public MosShopFrame() {
		panel = new JPanel();
		center = new JPanel();
		top = new JPanel();
		bot = new JPanel();
		left = new JPanel();
		right = new JPanel();
		Menubar = new JMenuBar();
		menu = new JMenu("File");
		load = new JMenuItem("Load");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		New = new JButton("New");
		Update = new JButton("Update");
		name = new JComboBox<>();
		namel = new JLabel("Food list");
		img = new JLabel();
		Name = new JTextArea();
		Nutrient = new JTextArea();
		Price = new JTextArea();
		scroll = new JScrollPane(Nutrient);
		load.setActionCommand("Load");
		load.addActionListener(this);
		save.setActionCommand("Save");
		save.addActionListener(this);
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		New.setActionCommand("New");
		New.addActionListener(this);
		Update.setActionCommand("Update");
		Update.addActionListener(this);
		name.setActionCommand("Box");
		name.addActionListener(this);
		left.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}	
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}	
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
				if(e.getButton()== MouseEvent.BUTTON1) {
				chooser = new JFileChooser();
				filter = new FileNameExtensionFilter ("*.jpg,*.gif,*.png","jpg","gif","png");
				chooser.setFileFilter(filter);
				if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File directory = chooser.getCurrentDirectory();
					icon = new ImageIcon(directory.getAbsolutePath() + "\\" +chooser.getName(chooser.getSelectedFile()));
					img.setIcon(icon);
				}
				}
			}
			});
		Name.setBorder(new TitledBorder(new LineBorder(null),"Name"));
		Nutrient.setBorder(new TitledBorder(new LineBorder(null),"Nutrition Facts"));
		Price.setBorder(new TitledBorder(new LineBorder(null),"Price"));
		top.add(New);
		top.add(Update);
		left.setLayout(new GridBagLayout());
		left.setBorder(new TitledBorder(new LineBorder(null),"Image"));
		left.add(img);
		right.setLayout(new BorderLayout());
		right.add(Name, BorderLayout.NORTH);
		right.add(scroll, BorderLayout.CENTER);
		right.add(Price, BorderLayout.SOUTH);
		bot.add(namel);
		bot.add(name);
		center.setLayout(new GridLayout(0, 2));
		center.add(left);
		center.add(right);
		panel.setPreferredSize(new Dimension(550, 350));
		panel.setLayout(new BorderLayout());
		panel.add(center, BorderLayout.CENTER);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bot, BorderLayout.SOUTH);
		menu.add(load);
		menu.add(save);
		menu.add(exit);
		Menubar.add(menu);
		this.add(panel);
		this.setJMenuBar(Menubar);
		
	}
	public static void main(String[] args) {
		MosShopFrame frame = new MosShopFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Mos Shop");
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("Load")) {
			name.removeAllItems();
			list.loadList();
			for (int i = 0; i < list.getFoodList().size(); i++) {
				name.addItem(list.get(i).getName());
			}
		}
		if(e.getActionCommand().equalsIgnoreCase("Save")) {
			list.saveList();
		}
		if(e.getActionCommand().equalsIgnoreCase("Exit")) {
			System.exit(1);
		}
		if(e.getActionCommand().equalsIgnoreCase("New")) {
			list.add(new Food("", 0.0, "", null));
			img.setIcon(null);
			Name.setText("");
			Nutrient.setText("");
			Price.setText("");
			name.addItem("");
			name.setSelectedIndex(list.getFoodList().size()-1);
		}
		if(e.getActionCommand().equalsIgnoreCase("Update")) {
			int i = name.getSelectedIndex();
			list.get(i).setName(Name.getText());
			list.get(i).setDetails(Nutrient.getText());
			list.get(i).setIcon((ImageIcon)img.getIcon());
			list.get(i).setPrice(Double.parseDouble(Price.getText()));
			name.removeAllItems();
			for (int j = 0; j < list.getFoodList().size(); j++) {
				name.addItem(list.get(j).getName());
			}
			name.setSelectedIndex(i);
		}
		if(e.getActionCommand().equalsIgnoreCase("Box")) {
			for(int i=0;i<list.getFoodList().size();i++) {
				if(name.getSelectedIndex()==i) {
					Name.setText(list.get(i).getName());
					Nutrient.setText(list.get(i).getDetails());
					Price.setText(String.valueOf(list.get(i).getPrice()));
					img.setIcon(list.get(i).getIcon());
				}
			}
		}
		
	}

}
