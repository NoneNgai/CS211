package Assignment3_ElementGameCards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel {
	JPanel Game,GameScore,GameC,GameP;
	JLabel ScoresP,ScoresC,IDp,IDc,PlayerIcon,ComputerIcon;
	ImageIcon Starter;
	int PlayerScores = 0,ComputerScores = 0;
	public GamePanel() {
		Starter = new ImageIcon("Player.png");
		Game = new JPanel();
		GameScore = new JPanel();
		GameC = new JPanel();
		GameP = new JPanel();
		ScoresP = new JLabel("Player "+ PlayerScores);
		ScoresC = new JLabel("Computer "+ ComputerScores);
		IDp = new JLabel("Me");
		IDc = new JLabel("Computer");
		PlayerIcon = new JLabel(Starter);
		ComputerIcon = new JLabel(Starter);
		GameScore.setLayout(new GridLayout());
		GameScore.add(ScoresC);
		GameScore.add(ScoresP);
		GameScore.setBorder(new LineBorder(Color.MAGENTA,5));
		GameScore.setBackground(null);
		GameC.add(ComputerIcon);
		GameC.add(IDc);
		GameC.setBorder(new LineBorder(Color.BLUE,5));
		GameC.setBackground(null);
		GameP.add(PlayerIcon);
		GameP.add(IDp);
		GameP.setBorder(new LineBorder(Color.GREEN,5));
		GameP.setBackground(null);
		Game.setLayout(new GridLayout(0, 3));
		Game.add(GameScore);
		Game.add(GameC);
		Game.add(GameP);
		this.add(Game);

	}

}
