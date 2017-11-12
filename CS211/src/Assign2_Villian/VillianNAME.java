package Assign2_Villian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VillianNAME extends JFrame implements KeyListener {
	JRadioButton chk = new JRadioButton("Female");
	JRadioButton chk1 = new JRadioButton("Male");
	ButtonGroup g = new ButtonGroup();
	JLabel G = new JLabel("Gender : ");
	JLabel FN = new JLabel("Firstname");
	JLabel LN = new JLabel("Lastname");
	JLabel BD = new JLabel("Birthday");
	JLabel name = new JLabel("My Villian Name");
	JTextField fn = new JTextField(15);
	JTextField ln = new JTextField(15);
	JTextField bd = new JTextField(2);
	JComboBox<String> month ;
	JButton say = new JButton("Say My Name");
	JPanel top = new JPanel();
	JPanel bot = new JPanel();
	JPanel firstL = new JPanel();
	JPanel secondL = new JPanel();
	JPanel thirdL = new JPanel();
	JPanel fouthL = new JPanel();
	private String V, I, L, N;

	public VillianNAME() {
		g.add(chk);
		g.add(chk1);
		chk.setSelected(true);
		chk.setBackground(Color.LIGHT_GRAY);
		chk1.setBackground(Color.LIGHT_GRAY);
		fn.setForeground(Color.RED);
		ln.setForeground(Color.GREEN);
		month = new JComboBox<>(new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"});
		month.setEditable(false);
		top.setLayout(new GridLayout(4, 0));
		top.setBorder(new TitledBorder(new LineBorder(Color.MAGENTA), "Input Your Infomation"));
		top.setBackground(Color.LIGHT_GRAY);
		bot.setBackground(Color.GRAY);
		firstL.setBackground(Color.LIGHT_GRAY);
		secondL.setBackground(Color.LIGHT_GRAY);
		thirdL.setBackground(Color.LIGHT_GRAY);
		fouthL.setBackground(Color.LIGHT_GRAY);
		firstL.setLayout(new FlowLayout());
		firstL.add(G);
		firstL.add(chk);
		firstL.add(chk1);
		secondL.setLayout(new FlowLayout());
		secondL.add(FN);
		secondL.add(fn);
		secondL.add(LN);
		secondL.add(ln);
		thirdL.setLayout(new FlowLayout());
		thirdL.add(BD);
		thirdL.add(bd);
		thirdL.add(month);
		fouthL.setLayout(new FlowLayout());
		fouthL.add(say);
		top.add(firstL);
		top.add(secondL);
		top.add(thirdL);
		top.add(fouthL);
		bot.add(name);
		name.setForeground(Color.BLUE);
		name.setFont(new Font("Tahoma", Font.BOLD, 25));
		bd.addKeyListener(this);
		say.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstname = fn.getText();
				String lastname = ln.getText();
				int birthday = Integer.parseInt(bd.getText());
				String Month = (String) month.getSelectedItem();
				if (chk.isSelected()) {
					if (firstname.startsWith("A") || firstname.startsWith("B") || firstname.startsWith("C")
							|| firstname.startsWith("D") || firstname.startsWith("E")) {
						V = "Red";
					} else if (firstname.startsWith("F") || firstname.startsWith("G") || firstname.startsWith("H")
							|| firstname.startsWith("I") || firstname.startsWith("J")) {
						V = "Poison";
					} else if (firstname.startsWith("K") || firstname.startsWith("L") || firstname.startsWith("M")
							|| firstname.startsWith("N") || firstname.startsWith("O")) {
						V = "Star";
					} else if (firstname.startsWith("P") || firstname.startsWith("Q") || firstname.startsWith("R")
							|| firstname.startsWith("S") || firstname.startsWith("T")) {
						V = "Green";
					} else if (firstname.startsWith("U") || firstname.startsWith("V") || firstname.startsWith("W")
							|| firstname.startsWith("X") || firstname.startsWith("Y")) {
						V = "Storm";
					} else if (firstname.startsWith("Z")) {
						V = "Perfect";
					}
				} else if (chk1.isSelected()) {
					if (firstname.startsWith("A") || firstname.startsWith("B") || firstname.startsWith("C")
							|| firstname.startsWith("D") || firstname.startsWith("E")) {
						V = "Dark";
					} else if (firstname.startsWith("F") || firstname.startsWith("G") || firstname.startsWith("H")
							|| firstname.startsWith("I") || firstname.startsWith("J")) {
						V = "Black";
					} else if (firstname.startsWith("K") || firstname.startsWith("L") || firstname.startsWith("M")
							|| firstname.startsWith("N") || firstname.startsWith("O")) {
						V = "Crazed";
					} else if (firstname.startsWith("P") || firstname.startsWith("Q") || firstname.startsWith("R")
							|| firstname.startsWith("S") || firstname.startsWith("T")) {
						V = "Sonic";
					} else if (firstname.startsWith("U") || firstname.startsWith("V") || firstname.startsWith("W")
							|| firstname.startsWith("X") || firstname.startsWith("Y")) {
						V = "Devil";
					} else if (firstname.startsWith("Z")) {
						V = "Feral";
					}

				}
				if (lastname.startsWith("A") || lastname.startsWith("B") || lastname.startsWith("C")
						|| lastname.startsWith("D") || lastname.startsWith("E")) {
					I = "Warrior";
				} else if (lastname.startsWith("F") || lastname.startsWith("G") || lastname.startsWith("H")
						|| lastname.startsWith("I") || lastname.startsWith("J")) {
					I = "Doctor";
				} else if (lastname.startsWith("K") || lastname.startsWith("L") || lastname.startsWith("M")
						|| lastname.startsWith("N") || lastname.startsWith("O")) {
					I = "Killer";
				} else if (lastname.startsWith("P") || lastname.startsWith("Q") || lastname.startsWith("R")
						|| lastname.startsWith("S") || lastname.startsWith("T")) {
					I = "Profressor";
				} else if (lastname.startsWith("U") || lastname.startsWith("V") || lastname.startsWith("W")
						|| lastname.startsWith("X") || lastname.startsWith("Y")) {
					I = "Beast";
				} else if (lastname.startsWith("Z")) {
					I = "Cyborg";
				}
				if (birthday >= 1 && birthday <= 3) {
					L = "The Trickster";
				} else if (birthday >= 4 && birthday <= 6) {
					L = "The Destroyer";
				} else if (birthday >= 7 && birthday <= 9) {
					L = "The Ruler";
				} else if (birthday >= 10 && birthday <= 12) {
					L = "The Richest";
				} else if (birthday >= 13 && birthday <= 15) {
					L = "The Horror";
				} else if (birthday >= 16 && birthday <= 18) {
					L = "The Rogue";
				} else if (birthday >= 19 && birthday <= 21) {
					L = "The Silencer";
				} else if (birthday >= 22 && birthday <= 24) {
					L = "The Assasin";
				} else if (birthday >= 25 && birthday <= 27) {
					L = "The Survivor";
				} else if (birthday >= 28 && birthday <= 30) {
					L = "The Immortal";
				} else if (birthday == 31) {
					L = "Master";
				}
				if (Month.equalsIgnoreCase("January")) {
					N = "of Men";
				} else if (Month.equalsIgnoreCase("February")) {
					N = "of Death";
				} else if (Month.equalsIgnoreCase("March")) {
					N = "of Humanity";
				} else if (Month.equalsIgnoreCase("April")) {
					N = "of Mars";
				} else if (Month.equalsIgnoreCase("May")) {
					N = "of Galaxy";
				} else if (Month.equalsIgnoreCase("June")) {
					N = "of the Living";
				} else if (Month.equalsIgnoreCase("July")) {
					N = "of Freedom";
				} else if (Month.equalsIgnoreCase("August")) {
					N = "of Fate";
				} else if (Month.equalsIgnoreCase("September")) {
					N = "of Asia";
				} else if (Month.equalsIgnoreCase("October")) {
					N = "of Destiny";
				} else if (Month.equalsIgnoreCase("November")) {
					N = "of Gotham";
				} else if (Month.equalsIgnoreCase("December")) {
					N = "of the Stars";
				}
				name.setText(V + " " + I + " " + L + " " + N);
			}

		});
		setTitle("What is Your villian name?");
		setLayout(new BorderLayout());
		add(top, BorderLayout.CENTER);
		add(bot, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		//setSize(500, 300);
		setVisible(true);

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			JOptionPane pane = new JOptionPane();
			pane.setMessageType(JOptionPane.ERROR_MESSAGE);
			int BirthDay = Integer.parseInt(bd.getText());
			if (month.getSelectedItem().equals("January") || month.getSelectedItem().equals("March")
					|| month.getSelectedItem().equals("May") || month.getSelectedItem().equals("July")
					|| month.getSelectedItem().equals("August") || month.getSelectedItem().equals("October")
					|| month.getSelectedItem().equals("December")) {
				if (BirthDay <= 0 || BirthDay > 31) {
					bd.setText(null);
					JOptionPane.showMessageDialog(null, "Day must be in range 1-31 "+month.getSelectedItem());
				}
			} else if (month.getSelectedItem().equals("April") || month.getSelectedItem().equals("June")
					|| month.getSelectedItem().equals("September") || month.getSelectedItem().equals("November")) {
				if (BirthDay <= 0 || BirthDay > 30) {
					bd.setText(null);
					JOptionPane.showMessageDialog(null, "Day must be in range 1-30 "+month.getSelectedItem());
				} else {
					if (BirthDay <= 0 || BirthDay > 29) {
						bd.setText(null);
						JOptionPane.showMessageDialog(null, "Day must be in range 1-29 "+month.getSelectedItem());
					}
				}
			}
		} catch (NumberFormatException i) {
			JOptionPane pane = new JOptionPane();
			pane.setMessageType(JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Day must be Integer");
			bd.setText(null);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public static void main(String[] args) {
		VillianNAME VN = new VillianNAME();
	}
}
