package Assignment4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StoryReaderFrame extends JFrame implements ActionListener {
	JMenuBar Bar;
	JMenu Menu;
	JMenuItem open, exit;
	JPanel top, bot, main, left, right;
	JTextArea area;
	JLabel numofpage, thispage, mostfre;
	JButton prev, next;
	private String nameFile = "Untitled";
	JFileChooser chooser;
	private ArrayList<String> List;
	public StoryReaderFrame() {
		List = new ArrayList<>();
		
		Bar = new JMenuBar();
		Menu = new JMenu("File");
		open = new JMenuItem("Open");
		exit = new JMenuItem("Exit");
		top = new JPanel();
		bot = new JPanel();
		main = new JPanel();
		left = new JPanel();
		right = new JPanel();
		area = new JTextArea();
		numofpage = new JLabel("Total: 0 paragraphs");
		thispage = new JLabel("0");
		mostfre = new JLabel("");
		prev = new JButton("<");
		next = new JButton(">");
		Bar.add(Menu);
		Menu.add(open);
		Menu.add(exit);
		this.setJMenuBar(Bar);
		open.setActionCommand("Open");
		exit.setActionCommand("Exit");
		prev.setActionCommand("Prev");
		next.setActionCommand("Next");
		open.addActionListener(this);
		exit.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		prev.setEnabled(false);
		next.setEnabled(false);
		main.setLayout(new BorderLayout());
		main.setPreferredSize(new Dimension(500, 400));
		top.setLayout(new BorderLayout());
		top.setBorder(new TitledBorder(new LineBorder(null), "Page#"));
		left.add(prev);
		left.add(thispage);
		left.add(next);
		right.setLayout(new GridBagLayout());
		right.add(numofpage);
		top.add(left, BorderLayout.WEST);
		top.add(right, BorderLayout.CENTER);
		area.setBorder(new TitledBorder(new LineBorder(null), nameFile));
		bot.setLayout(new FlowLayout(FlowLayout.LEFT));
		bot.setBorder(new TitledBorder(new LineBorder(null), "Paragraph summary"));
		bot.add(mostfre);
		main.add(top, BorderLayout.NORTH);
		main.add(area, BorderLayout.CENTER);
		main.add(bot, BorderLayout.SOUTH);
		this.add(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			List.clear();
			ParagraphReader reader = new ParagraphReader();
			chooser = new JFileChooser();
			if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				area.setBorder(new TitledBorder(new LineBorder(null),chooser.getSelectedFile().getName()));
				try {
					reader.readFile(chooser.getSelectedFile(), true);
					numofpage.setText("Total: "+reader.size()+" paragraph");
					area.setText(reader.get(0));
					thispage.setText("1");
					mostfre.setText("Most freq char: "+TextFreqHelper.findMostCommonChar(reader.get(0)));
					for(int i=0;i<reader.size();i++) {
						
						List.add(reader.get(i));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(List.size()>1)
			next.setEnabled(true);
		}
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		if (e.getActionCommand().equals("Prev")) {
			thispage.setText(String.valueOf(Integer.parseInt(thispage.getText())-1));
			area.setText(List.get(Integer.parseInt(thispage.getText())-1));
			mostfre.setText("Most freq char: "+TextFreqHelper.findMostCommonChar(List.get(Integer.parseInt(thispage.getText())-1)));
			if(Integer.parseInt(thispage.getText())==1)
				prev.setEnabled(false);
			else
				prev.setEnabled(true);
			if(Integer.parseInt(thispage.getText())==List.size())
				next.setEnabled(false);
			else
				next.setEnabled(true);
		}
		if (e.getActionCommand().equals("Next")) {
			thispage.setText(String.valueOf(Integer.parseInt(thispage.getText())+1));
			area.setText(List.get(Integer.parseInt(thispage.getText())-1));
			mostfre.setText("Most freq char: "+TextFreqHelper.findMostCommonChar(List.get(Integer.parseInt(thispage.getText())-1)));
			if(Integer.parseInt(thispage.getText())==List.size())
				next.setEnabled(false);
			else
				next.setEnabled(true);
			if(Integer.parseInt(thispage.getText())==1)
				prev.setEnabled(false);
			else
				prev.setEnabled(true);
		}

	}

	public static void main(String[] args) {
		StoryReaderFrame frame = new StoryReaderFrame();
		frame.setTitle("Story Reader");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}

}
