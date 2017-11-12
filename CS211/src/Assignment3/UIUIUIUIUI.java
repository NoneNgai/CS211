package Assignment3;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UIUIUIUIUI extends JFrame implements ActionListener{
	JPanel TOP,BOT,MAIN;
	JButton[] PLAY;
	JLabel[] COM;
	JButton Start;
	UIUIUIPANEL panel = new UIUIUIPANEL();
	Card card = new Card();
	Random r = new Random();
	private ArrayList<Element> computer = new  ArrayList<>() ;
	private ArrayList<Element> player = new  ArrayList<>() ;
	private int count = 0;
	public UIUIUIUIUI() {
		count = 0;
		TOP = new JPanel();
		BOT = new JPanel();
		MAIN = new JPanel();
		COM = new JLabel[4];
		PLAY = new JButton[4];
		Start = new JButton("Start");
		for(int i=0;i<4;i++) {
			COM[i] = new JLabel();
			PLAY[i] = new JButton();
			PLAY[i].addActionListener(this);
			card.shuffleCard();
			player.add(card.getCardonTop());
			PLAY[i].setText(player.get(i).toString());
			computer.add(card.getCardonTop());
			COM[i].setText(computer.get(i).toString());
			
			TOP.add(COM[i]);
			BOT.add(PLAY[i]);
		}
		TOP.setLayout(new GridLayout(0, 6));
		TOP.setBorder(new TitledBorder(new LineBorder(null),"Computer"));
		BOT.setLayout(new GridLayout(0, 6));
		BOT.setBorder(new TitledBorder(new LineBorder(null),"Player"));
		MAIN.setLayout(new BorderLayout());
		MAIN.add(TOP, BorderLayout.NORTH);
		MAIN.add(panel, BorderLayout.CENTER);
		MAIN.add(BOT, BorderLayout.SOUTH);
		MAIN.add(Start, BorderLayout.EAST);
		this.add(MAIN);
		Start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				player.clear();
				computer.clear();
				count = 0;
				panel.setComputerScores(0);
				panel.setPlayerScores(0);
				panel.setScoresLabel();
				for(int i=0;i<4;i++) {
					card.newDeck();
					card.shuffleCard();
					player.add(card.getCardonTop());
					PLAY[i].setText(player.get(i).toString());
					PLAY[i].setEnabled(true);
					card.shuffleCard();
					computer.add(card.getCardonTop());
					COM[i].setText(computer.get(i).toString());
				}
			}
		});
	}
	public static void main(String[] args) {
		UIUIUIUIUI fff = new UIUIUIUIUI();
		fff.setVisible(true);
		fff.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fff.pack();
		fff.setTitle("Card game");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<4; i++){
			if(e.getSource().equals(PLAY[i]) ){
				PLAY[i].setText(" "); PLAY[i].setEnabled(false);
				panel.setPlayerLabel(player.get(i).toString());
				COM[count].setText(" ");
				panel.setComLabel(computer.get(i).toString());
				if(player.get(i).compare(computer.get(count))<0){
					System.out.println("1");
					panel.setComputerScores(1);
				}
				else if(player.get(i).compare(computer.get(count))>0){
					panel.setPlayerScores(1);
					System.out.println("2");
				}
				panel.setScoresLabel();
				count++;
			}
		}
		if(count==4){
			panel.resultTell();
		}
	}
}
