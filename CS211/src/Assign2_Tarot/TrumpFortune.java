package Assign2_Tarot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TrumpFortune extends JFrame {
	private ImageIcon back = new ImageIcon("Backplatev2.1.png");
	JPanel TarotResult = new JPanel();
	TrumpFortunePanel TarotPanel = new TrumpFortunePanel();
	JButton shuf = new JButton("Shuffle");
	JLabel maincard = new JLabel("Your main card is : ");
	JLabel supportcard = new JLabel("Your supporting card is : ");
	JLabel result = new JLabel("");

	public TrumpFortune() {
		this.setTitle("Select 2 cards to predict your love");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(TarotPanel, BorderLayout.CENTER);
		this.add(TarotResult, BorderLayout.EAST);
		this.add(shuf, BorderLayout.SOUTH);
		this.pack();
		TarotPanel.setBackground(Color.BLACK);
		shuf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TarotPanel.getOne().setIcon(back);
				TarotPanel.getTwo().setIcon(back);
				TarotPanel.getThree().setIcon(back);
				TarotPanel.getFour().setIcon(back);
				TarotPanel.getFive().setIcon(back);
				TarotPanel.getSix().setIcon(back);
				TarotPanel.getSeven().setIcon(back);
				TarotPanel.getEight().setIcon(back);
				TarotPanel.getOne().setBorder(null);
				TarotPanel.getTwo().setBorder(null);
				TarotPanel.getThree().setBorder(null);
				TarotPanel.getFour().setBorder(null);
				TarotPanel.getFive().setBorder(null);
				TarotPanel.getSix().setBorder(null);
				TarotPanel.getSeven().setBorder(null);
				TarotPanel.getEight().setBorder(null);
				TarotPanel.getResult().setText("");
				TarotPanel.getMaincard().setText("");
				TarotPanel.getSupportcard().setText("");
				TarotPanel.shuffle();
				TarotPanel.setClicked1(false);
				TarotPanel.setClicked2(false);
				TarotPanel.setClicked3(false);
				TarotPanel.setClicked4(false);
				TarotPanel.setClicked5(false);
				TarotPanel.setClicked6(false);
				TarotPanel.setClicked7(false);
				TarotPanel.setClicked8(false);
				TarotPanel.setCntclick(0);	
			}
		});
	}

	public static void main(String[] args) {
		TrumpFortune f = new TrumpFortune();
	}
}
