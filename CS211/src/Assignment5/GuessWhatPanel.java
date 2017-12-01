package Assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GuessWhatPanel extends JPanel implements ActionListener, MouseListener {
	private boolean click = false;
	ShapePanel player1 = new ShapePanel(), player2 = new ShapePanel(), player3 = new ShapePanel(),
			computer1 = new ShapePanel(), computer2 = new ShapePanel(), computer3 = new ShapePanel();
	HashSet<Shape> setPlayer = new HashSet<>();
	HashSet<Shape> setComputer = new HashSet<>();
	JComboBox<ShapeType> shape;
	JComboBox<MyColor> color;
	JLabel attemp, correct;
	JButton guess, newgame, set;
	private boolean click1, click2, click3;
	private int score = 0;
	private int Attemp = 4;
	private boolean com1=true,com2=true,com3=true;

	public GuessWhatPanel() {
		this.setLayout(new BorderLayout());
		this.add(RightPanel(), BorderLayout.EAST);
		this.add(LeftPanel(), BorderLayout.WEST);
		this.add(CenterPanel(), BorderLayout.CENTER);
	}

	private JPanel RightPanel() {
		JPanel panel = new JPanel();
		newgame = new JButton("New");
		set = new JButton("Set to Shape");
		guess = new JButton("Guess");
		JLabel label = new JLabel("Choose Shape Info");
		shape = new JComboBox<>();
		color = new JComboBox<>();
		newgame.setActionCommand("Newgame");
		set.setActionCommand("Set");
		guess.setActionCommand("Guess");
		newgame.addActionListener(this);
		set.addActionListener(this);
		guess.addActionListener(this);
		panel.setPreferredSize(new Dimension(150, 250));
		shape.addItem(ShapeType.SQUARE);
		shape.addItem(ShapeType.CIRCLE);
		shape.addItem(ShapeType.TRIANGLE);
		color.addItem(MyColor.BLUE);
		color.addItem(MyColor.GREEN);
		color.addItem(MyColor.RED);
		panel.add(newgame);
		panel.add(label);
		panel.add(shape);
		panel.add(color);
		panel.add(set);
		panel.add(guess);
		return panel;
	}

	private JPanel LeftPanel() {
		JPanel panel = new JPanel();
		attemp = new JLabel(Attemp + " Attemp Left");
		correct = new JLabel("Correct : " + score);
		panel.setPreferredSize(new Dimension(150, 250));
		panel.add(attemp);
		panel.add(correct);
		return panel;
	}

	private JPanel CenterPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 200));
		player1.setShape(new Shape(ShapeType.TRIANGLE, MyColor.BLUE));
		player1.setShow(true);
		player2.setShape(new Shape(ShapeType.TRIANGLE, MyColor.RED));
		player2.setShow(true);
		player3.setShape(new Shape(ShapeType.TRIANGLE, MyColor.GREEN));
		player3.setShow(true);
		player1.addMouseListener(this);
		player2.addMouseListener(this);
		player3.addMouseListener(this);
		shuffle();
		shuffle();
		panel.setLayout(new GridLayout(2, 3));
		panel.add(computer1);
		panel.add(computer2);
		panel.add(computer3);
		panel.add(player1);
		panel.add(player2);
		panel.add(player3);
		return panel;
	}

	public void shuffle() {
		setPlayer.clear();
		setComputer.clear();
		Random r = new Random();
		while (setComputer.size() < 3) {
			Shape ss = null;
			int ran1 = r.nextInt(3);
			int ran2 = r.nextInt(3);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (ran1 == 0) {
						if (ran2 == 0) {
							ss = new Shape(ShapeType.CIRCLE, MyColor.BLUE);
						} else if (ran2 == 1) {
							ss = new Shape(ShapeType.CIRCLE, MyColor.GREEN);
						} else if (ran2 == 2) {
							ss = new Shape(ShapeType.CIRCLE, MyColor.RED);
						}
					} else if (ran1 == 1) {
						if (ran2 == 0) {
							ss = new Shape(ShapeType.SQUARE, MyColor.BLUE);
						} else if (ran2 == 1) {
							ss = new Shape(ShapeType.SQUARE, MyColor.GREEN);
						} else if (ran2 == 2) {
							ss = new Shape(ShapeType.SQUARE, MyColor.RED);
						}
					} else if (ran1 == 2) {
						if (ran2 == 0) {
							ss = new Shape(ShapeType.TRIANGLE, MyColor.BLUE);
						} else if (ran2 == 1) {
							ss = new Shape(ShapeType.TRIANGLE, MyColor.GREEN);
						} else if (ran2 == 2) {
							ss = new Shape(ShapeType.TRIANGLE, MyColor.RED);
						}
					}
				}
			}

			if (setComputer.size() == 0) {
				setComputer.add(ss);
				computer1.setShape(ss);
			} else if (setComputer.size() == 1) {
				setComputer.add(ss);
				computer2.setShape(ss);
			} else if (setComputer.size() == 2) {
				setComputer.add(ss);
				computer3.setShape(ss);
			}
		}
		setPlayer.add(player1.getShape());
		setPlayer.add(player2.getShape());
		setPlayer.add(player3.getShape());
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Newgame")) {
			com1 = true;
			com2 = true;
			com3 = true;
			player1.setShape(new Shape(ShapeType.TRIANGLE, MyColor.BLUE));
			player2.setShape(new Shape(ShapeType.CIRCLE, MyColor.RED));
			player3.setShape(new Shape(ShapeType.SQUARE, MyColor.GREEN));
			guess.setEnabled(true);
			set.setEnabled(true);
			Attemp = 4;
			score = 0;
			computer1.setShow(false);
			computer2.setShow(false);
			computer3.setShow(false);
			attemp.setText(Attemp + " Attemp Left");
			correct.setText("Correct : " + score);
			shuffle();
			repaint();
		}
		if (e.getActionCommand().equals("Set")) {
			setPlayer.clear();
			Shape s;
			if (click == false) {
				JOptionPane.showMessageDialog(null, "Select Shape First");
			} else {
				if (click1) {
					s = new Shape((ShapeType) shape.getSelectedItem(), (MyColor) color.getSelectedItem());
					player1.setShape(s);
				} else if (click2) {
					s = new Shape((ShapeType) shape.getSelectedItem(), (MyColor) color.getSelectedItem());
					player2.setShape(s);
				} else if (click3) {
					s = new Shape((ShapeType) shape.getSelectedItem(), (MyColor) color.getSelectedItem());
					player3.setShape(s);
				}
			}
			setPlayer.add(player1.getShape());
			setPlayer.add(player2.getShape());
			setPlayer.add(player3.getShape());
			repaint();
		}
		if (e.getActionCommand().equals("Guess")) {
			
				if (com1&&(computer1.getShape().equals(player1.getShape())||computer1.getShape().equals(player2.getShape())||computer1.getShape().equals(player3.getShape()))) {
					computer1.setShow(true);
					score += 1;
					com1 = false;
				}
				if (com2&&(computer2.getShape().equals(player1.getShape())||computer2.getShape().equals(player2.getShape())||computer2.getShape().equals(player3.getShape()))) {
					computer2.setShow(true);
					score += 1;
					com2 = false;
				}
				if (com3&&(computer3.getShape().equals(player1.getShape())||computer3.getShape().equals(player2.getShape())||computer3.getShape().equals(player3.getShape()))) {
					computer3.setShow(true);
					score += 1;
					com3 = false;
				}
			if (Attemp > 0) {
				Attemp -= 1;
			} 
			if(Attemp==0) {
				JOptionPane.showMessageDialog(null, "No Attemp Left. You Lose.");
				guess.setEnabled(false);
				set.setEnabled(false);
				computer1.setShow(true);
				computer2.setShow(true);
				computer3.setShow(true);
			}
			if (score == 3) {
				JOptionPane.showMessageDialog(null, "Victory!!!");
				guess.setEnabled(false);
				set.setEnabled(false);
			}
			attemp.setText(Attemp + " Attemp Left");
			correct.setText("Correct : " + score);
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		click1 = false;
		click2 = false;
		click3 = false;
		if (e.getSource().equals(player1)) {
			click = false;
			click1 = true;
			if (e.getButton() == MouseEvent.BUTTON1) {
			if (click == false) {
				click = true;
			} else if (click == true) {
				click = false;
			}
			}
		}
		if (e.getSource().equals(player2)) {
			click = false;
			click2 = true;
			if (e.getButton() == MouseEvent.BUTTON1) {
			if (click == false) {
				click = true;
			} else if (click == true) {
				click = false;
			}
			}
		}

		if (e.getSource().equals(player3)) {
			click = false;
			click3 = true;
			if (e.getButton() == MouseEvent.BUTTON1) {
			if (click == false) {
				click = true;
			} else if (click == true) {
				click = false;
			}
			}
		}
		if (click1 == true) {
			player1.setBackground(Color.CYAN);
			player1.setBorder(new LineBorder(Color.MAGENTA, 3));
			click2 = false;
			click3 = false;
			player2.setBackground(null);
			player3.setBackground(null);
			player2.setBorder(new LineBorder(Color.black, 3));
			player3.setBorder(new LineBorder(Color.black, 3));
		} else if (click2 == true) {
			player2.setBackground(Color.CYAN);
			player2.setBorder(new LineBorder(Color.MAGENTA, 3));
			click1 = false;
			click3 = false;
			player1.setBackground(null);
			player3.setBackground(null);
			player1.setBorder(new LineBorder(Color.black, 3));
			player3.setBorder(new LineBorder(Color.black, 3));
		} else if (click3 == true) {
			player3.setBackground(Color.CYAN);
			player3.setBorder(new LineBorder(Color.MAGENTA, 3));
			click1 = false;
			click2 = false;
			player1.setBackground(null);
			player2.setBackground(null);
			player1.setBorder(new LineBorder(Color.black, 3));
			player2.setBorder(new LineBorder(Color.black, 3));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
