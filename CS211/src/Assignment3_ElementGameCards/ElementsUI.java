package Assignment3_ElementGameCards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ElementsUI extends JFrame implements ActionListener {
	Element ele;
	JPanel Player, Computer;
	JLabel ScoresP, ScoresC, IDp, IDc;
	JButton Start;
	JLabel[] Com;
	JButton[] Play;
	GamePanel Game;
	private int Playercnt = 1, Computercnt = 0, cnt = 0;
	Card card;
	public ElementsUI() {
		Com = new JLabel[6];
		Play = new JButton[6];
		Game = new GamePanel();
		Player = new JPanel();
		Computer = new JPanel();
		Player.setBorder(new TitledBorder(new LineBorder(null), "Player"));
		Player.setLayout(new GridLayout(0, 6));
		Computer.setBorder(new TitledBorder(new LineBorder(null), "Computer"));
		Computer.setLayout(new GridLayout(0, 6));
		Start = new JButton("Start");
		Start.setActionCommand("Start");
		Start.addActionListener(this);
		card = new Card();
		this.setLayout(new BorderLayout());
		this.add(Computer, BorderLayout.NORTH);
		this.add(Player, BorderLayout.SOUTH);
		this.add(Game, BorderLayout.CENTER);
		this.add(Start, BorderLayout.EAST);
		for (int j = 0; j < 6; j++) {
			Com[j] = new JLabel();
			Play[j] = new JButton();
			Com[j].setBorder(new LineBorder(null));
			Com[j].setIcon(card.List(Computercnt));
			Com[j].setHorizontalAlignment(SwingConstants.CENTER);
			Play[j].setIcon(card.List(Playercnt));
			Play[j].setActionCommand("Play" + j);
			Play[j].addActionListener(this);
			Computer.add(Com[j]);
			Player.add(Play[j]);
			Playercnt += 2;
			Computercnt += 2;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			cnt=0;
			card.Shuffle();
			Game.PlayerIcon.setIcon(Game.Starter);
			Game.ComputerIcon.setIcon(Game.Starter);
			Playercnt = 1;
			Computercnt = 0;
			for (int i = 0; i < 6; i++) {
				Com[i].setIcon(card.List(Computercnt));
				Play[i].setIcon(card.List(Playercnt));
				Playercnt += 2;
				Computercnt += 2;
				Com[i].setEnabled(true);
				Play[i].setEnabled(true);
			}
			Game.PlayerScores = 0;
			Game.ComputerScores = 0;
			Game.ScoresP.setText("Player " + Game.PlayerScores);
			Game.ScoresC.setText("Computer " + Game.ComputerScores);
		}
		if (e.getActionCommand().equals("Play0")) {
			Play[0].setEnabled(false);
			Com[cnt].setEnabled(false);
			compareTo(0);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
		if (e.getActionCommand().equals("Play1")) {
			Play[1].setEnabled(false);
			Com[cnt].setEnabled(false);
			compareTo(1);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
		if (e.getActionCommand().equals("Play2")) {
			Play[2].setEnabled(false);		
			Com[cnt].setEnabled(false);
			compareTo(2);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
		if (e.getActionCommand().equals("Play3")) {
			Play[3].setEnabled(false);
			Com[cnt].setEnabled(false);
			compareTo(3);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
		if (e.getActionCommand().equals("Play4")) {
			Play[4].setEnabled(false);
			Com[cnt].setEnabled(false);
			compareTo(4);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
		if (e.getActionCommand().equals("Play5")) {
			Play[5].setEnabled(false);
			Com[cnt].setEnabled(false);
			compareTo(5);
			Game.ScoresP.setText("Player "+ Game.PlayerScores);
			Game.ScoresC.setText("Computer "+ Game.ComputerScores);
			if (cnt == 5) {
				result();
			}
			cnt++;
		}
	}
	public void result() {
		if (Game.ComputerScores > Game.PlayerScores) {
			JOptionPane.showMessageDialog(null, "!DEFEAT!");
		} else if (Game.ComputerScores < Game.PlayerScores) {
			JOptionPane.showMessageDialog(null, "!VICTORY!");
		} else if (Game.ComputerScores == Game.PlayerScores) {
			JOptionPane.showMessageDialog(null, "!DRAW!");
		}
	}
	public void compareTo(int index) {
		if (Play[index].getIcon().equals(ele.WATER.getImage())) {
			if(Com[cnt].getIcon().equals(ele.WIND.getImage())) {
				if(ele.WATER.Compare(ele.WIND)==-1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WATER.getImage());
				Game.ComputerIcon.setIcon(ele.WIND.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.EARTH.getImage())) {
				if(ele.WATER.Compare(ele.EARTH)==-1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WATER.getImage());
				Game.ComputerIcon.setIcon(ele.EARTH.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.FIRE.getImage())) {
				if(ele.WATER.Compare(ele.FIRE)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WATER.getImage());
				Game.ComputerIcon.setIcon(ele.FIRE.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.WATER.getImage())) {
				if(ele.WATER.Compare(ele.WATER)==0) {}
				Game.PlayerIcon.setIcon(ele.WATER.getImage());
				Game.ComputerIcon.setIcon(ele.WATER.getImage());
			}
		} else if (Play[index].getIcon().equals(ele.WIND.getImage())) {
			if(Com[cnt].getIcon().equals(ele.WATER.getImage())) {
				if(ele.WIND.Compare(ele.WATER)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WIND.getImage());
				Game.ComputerIcon.setIcon(ele.WATER.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.EARTH.getImage())) {
				if(ele.WIND.Compare(ele.EARTH)==-1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WIND.getImage());
				Game.ComputerIcon.setIcon(ele.EARTH.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.FIRE.getImage())) {
				if(ele.WIND.Compare(ele.FIRE)==-1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.WIND.getImage());
				Game.ComputerIcon.setIcon(ele.FIRE.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.WIND.getImage())) {
				if(ele.WIND.Compare(ele.WIND)==1) {}
				Game.PlayerIcon.setIcon(ele.WIND.getImage());
				Game.ComputerIcon.setIcon(ele.WIND.getImage());
	
			}
		} else if (Play[index].getIcon().equals(ele.EARTH.getImage())) {
			if(Com[cnt].getIcon().equals(ele.WATER.getImage())) {
				if(ele.EARTH.Compare(ele.WATER)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.EARTH.getImage());
				Game.ComputerIcon.setIcon(ele.WATER.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.WIND.getImage())) {
				if(ele.EARTH.Compare(ele.WIND)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.EARTH.getImage());
				Game.ComputerIcon.setIcon(ele.WIND.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.FIRE.getImage())) {
				if(ele.EARTH.Compare(ele.FIRE)==1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.EARTH.getImage());
				Game.ComputerIcon.setIcon(ele.FIRE.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.EARTH.getImage())) {
				if(ele.EARTH.Compare(ele.EARTH)==0) {}
				Game.PlayerIcon.setIcon(ele.EARTH.getImage());
				Game.ComputerIcon.setIcon(ele.EARTH.getImage());
			}
		} else if (Play[index].getIcon().equals(ele.FIRE.getImage())) {
			if(Com[cnt].getIcon().equals(ele.WATER.getImage())) {
				if(ele.FIRE.Compare(ele.WATER)==-1) {
				Game.ComputerScores+=1;}
				Game.PlayerIcon.setIcon(ele.FIRE.getImage());
				Game.ComputerIcon.setIcon(ele.WATER.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.WIND.getImage())) {
				if(ele.FIRE.Compare(ele.WIND)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.FIRE.getImage());
				Game.ComputerIcon.setIcon(ele.WIND.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.EARTH.getImage())) {
				if(ele.FIRE.Compare(ele.EARTH)==1) {
				Game.PlayerScores+=1;}
				Game.PlayerIcon.setIcon(ele.FIRE.getImage());
				Game.ComputerIcon.setIcon(ele.EARTH.getImage());
			}
			else if(Com[cnt].getIcon().equals(ele.FIRE.getImage())) {
				if(ele.FIRE.Compare(ele.FIRE)==0) {}
				Game.PlayerIcon.setIcon(ele.FIRE.getImage());
				Game.ComputerIcon.setIcon(ele.FIRE.getImage());
			}
		}
	}

	public static void main(String[] args) {
		ElementsUI fff = new ElementsUI();
		fff.setVisible(true);
		fff.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fff.pack();
		fff.setTitle("Card Game");
	}

}
