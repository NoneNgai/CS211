package Assignment4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StoryWriterFrame extends JFrame implements ActionListener{
	JPanel main,top,topleft,topright,bot;
	JLabel pagelabel,thispage;
	JTextField field;
	JButton insertB,insertA,load,save;
	JTextArea area;
	JFileChooser chooser;
	ParagraphReaderWriter reader = new ParagraphReaderWriter();
	public StoryWriterFrame() {
		main = new JPanel();
		top = new JPanel();
		topleft = new JPanel();
		topright = new JPanel();
		bot = new JPanel();
		pagelabel = new JLabel("Go to page :");
		field = new JTextField(3);
		thispage = new JLabel("Total: 0 paragraphs");
		insertB = new JButton("Insert Before");
		insertA = new JButton("Insert After");
		area = new JTextArea();
		load = new JButton("Load");
		save = new JButton("Save");
		area.setBorder(new TitledBorder(new LineBorder(null),"Untitled"));
		main.setLayout(new BorderLayout());
		main.setPreferredSize(new Dimension(550, 300));
		top.setBorder(new TitledBorder(new LineBorder(null),"Paage#"));
		top.setLayout(new BorderLayout());
		top.add(topleft, BorderLayout.WEST);
		top.add(topright, BorderLayout.CENTER);
		topleft.setLayout(new FlowLayout(FlowLayout.LEFT));
		topleft.add(pagelabel);
		topleft.add(field);
		topleft.add(thispage);
		topright.setLayout(new FlowLayout(FlowLayout.CENTER));
		topright.add(insertB);
		topright.add(insertA);
		bot.add(load);
		bot.add(save);
		main.add(top, BorderLayout.NORTH);
		main.add(area, BorderLayout.CENTER);
		main.add(bot, BorderLayout.SOUTH);
		this.add(main);
		insertB.setEnabled(false);
		insertA.setEnabled(false);
		save.setEnabled(false);
		insertA.setActionCommand("InsertAfter");
		insertB.setActionCommand("InsertBefore");
		load.setActionCommand("Load");
		save.setActionCommand("Save");
		insertA.addActionListener(this);
		insertB.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);
		field.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	
			}
			
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						area.setText(reader.get(Integer.parseInt(field.getText())-1));
					}
					catch(Exception ee) {
						JOptionPane.showMessageDialog(null, "Invalid Page Number");
					}
				}
			}
		});
	}
	public static void main(String[] args) {
		StoryWriterFrame frame = new StoryWriterFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Story Writer");
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("InsertAfter")) {
			for(int i=reader.size();i>Integer.parseInt(field.getText());i--) {
				reader.getStringList().add(i, reader.get(i-1));
				reader.getStringList().remove(i);
			}
			reader.getStringList().add(Integer.parseInt(field.getText()), " ");
			thispage.setText("Total: "+reader.size() +" paragraphs");
		}
		if(e.getActionCommand().equals("InsertBefore")) {
			for(int i=reader.size();i>=Integer.parseInt(field.getText());i--) {
				reader.getStringList().add(i, reader.get(i-1));
				reader.getStringList().remove(i);
			}
			reader.getStringList().add(Integer.parseInt(field.getText())-1, " ");
			thispage.setText("Total: "+reader.size() +" paragraphs");
			
		}
		if(e.getActionCommand().equals("Load")) {
			area.setText("");
			field.setText("");
			reader.clear();
			chooser = new JFileChooser();
			if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				area.setBorder(new TitledBorder(new LineBorder(null),chooser.getSelectedFile().getName()));
				try {
					reader.readFile(chooser.getSelectedFile(), true);
					thispage.setText("Total: "+reader.size() +" paragraphs");
					area.setText(reader.get(0));
					field.setText("1");
					insertA.setEnabled(true);
					insertB.setEnabled(true);
					save.setEnabled(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		}
		if(e.getActionCommand().equals("Save")) {
			chooser = new JFileChooser();
			if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
				reader.writerFile(chooser.getSelectedFile());
			}
			
		}
		
	}
}
