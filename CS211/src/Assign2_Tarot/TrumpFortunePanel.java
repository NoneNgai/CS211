package Assign2_Tarot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TrumpFortunePanel extends JPanel {
	JPanel rightpanelresult = new JPanel();
	JPanel leftpanel = new JPanel();
	JPanel rightpanel = new JPanel();
	JLabel maincard = new JLabel("");
	JLabel supportcard = new JLabel("");
	JLabel result = new JLabel("");
	private ImageIcon back, magician, empress, hierophant, lover, chariot, hermit, wheel, star, Fmagician, Fempress,
			Fhierophant, Flover, Fchariot, Fhermit, Fwheel, Fstar;
	private JButton one, two, three, four, five, six, seven, eight;
	private int main, sup, cntclick = 0;
	private boolean isClicked1 = false;
	private boolean isClicked2 = false;
	private boolean isClicked3 = false;
	private boolean isClicked4 = false;
	private boolean isClicked5 = false;
	private boolean isClicked6 = false;
	private boolean isClicked7 = false;
	private boolean isClicked8 = false;
	Random r = new Random();
	Integer[] ran = new Integer[8];

	public JLabel getMaincard() {
		return maincard;
	}

	public JLabel getSupportcard() {
		return supportcard;
	}

	public JLabel getResult() {
		return result;
	}

	public int getMain() {
		return main;
	}

	public int getSup() {
		return sup;
	}

	public void setClicked1(boolean isClicked1) {
		this.isClicked1 = isClicked1;
	}

	public void setClicked2(boolean isClicked2) {
		this.isClicked2 = isClicked2;
	}

	public void setClicked3(boolean isClicked3) {
		this.isClicked3 = isClicked3;
	}

	public void setClicked4(boolean isClicked4) {
		this.isClicked4 = isClicked4;
	}

	public void setClicked5(boolean isClicked5) {
		this.isClicked5 = isClicked5;
	}

	public void setClicked6(boolean isClicked6) {
		this.isClicked6 = isClicked6;
	}

	public void setClicked7(boolean isClicked7) {
		this.isClicked7 = isClicked7;
	}

	public void setClicked8(boolean isClicked8) {
		this.isClicked8 = isClicked8;
	}

	public JButton getOne() {
		return one;
	}

	public JButton getTwo() {
		return two;
	}

	public JButton getThree() {
		return three;
	}

	public JButton getFour() {
		return four;
	}

	public JButton getFive() {
		return five;
	}

	public JButton getSix() {
		return six;
	}

	public JButton getSeven() {
		return seven;
	}

	public JButton getEight() {
		return eight;
	}

	public void setCntclick(int cntclick) {
		this.cntclick = cntclick;
	}

	public int getCntclick() {
		return cntclick;
	}

	public void shuffle() {
		for (int i = 0; i < 8; i++) {
			ran[i] = i;
		}
		Collections.shuffle(Arrays.asList(ran));
		leftpanel.removeAll();
		for (int i = 0; i < 8; i++)
			switch (ran[i]) {
			case 0:
				leftpanel.add(one);
				break;
			case 1:
				leftpanel.add(two);
				break;
			case 2:
				leftpanel.add(three);
				break;
			case 3:
				leftpanel.add(four);
				break;
			case 4:
				leftpanel.add(five);
				break;
			case 5:
				leftpanel.add(six);
				break;
			case 6:
				leftpanel.add(seven);
				break;
			case 7:
				leftpanel.add(eight);
				break;
			}
	}

	public TrumpFortunePanel() {
		back = new ImageIcon("Backplatev2.1.png");
		magician = new ImageIcon("Magician.png");
		empress = new ImageIcon("Empress.png");
		hierophant = new ImageIcon("Hierophant.png");
		lover = new ImageIcon("Lover.png");
		chariot = new ImageIcon("Chariot.png");
		hermit = new ImageIcon("Hermit.png");
		wheel = new ImageIcon("Wheel.png");
		star = new ImageIcon("TheStar.png");
		Fmagician = new ImageIcon("FlipMagician.png");
		Fempress = new ImageIcon("FlipEmpress.png");
		Fhierophant = new ImageIcon("FlipHierophant.png");
		Flover = new ImageIcon("FlipLover.png");
		Fchariot = new ImageIcon("FlipChariot.png");
		Fhermit = new ImageIcon("FlipHermit.png");
		Fwheel = new ImageIcon("FlipWheel.png");
		Fstar = new ImageIcon("FlipTheStar.png");
		one = new JButton(back);
		two = new JButton(back);
		three = new JButton(back);
		four = new JButton(back);
		five = new JButton(back);
		six = new JButton(back);
		seven = new JButton(back);
		eight = new JButton(back);
		rightpanel.setBackground(Color.BLACK);
		leftpanel.setPreferredSize(new Dimension(750, 590));
		leftpanel.setLayout(new GridLayout(2, 4));
		shuffle();
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked1 == false && cntclick < 2) {
					one.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						one.setIcon(magician);
					} else {
						one.setIcon(Fmagician);
					}
					isClicked1 = true;
					if (cntclick == 0)
						main = 1;
					else if (cntclick == 1)
						sup = 1;
					cntclick++;

				} else if (isClicked1 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}

				if (cntclick == 2) {
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 1) {
						supportcard.setText("Your supporting card is : Magician");
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && one.getIcon() == magician
									|| two.getIcon() == Fempress && one.getIcon() == Fmagician)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish.</html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that</html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && one.getIcon() == magician
									|| three.getIcon() == Fhierophant && one.getIcon() == Fmagician)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && one.getIcon() == magician
									|| four.getIcon() == Flover && one.getIcon() == Fmagician)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && one.getIcon() == magician
									|| five.getIcon() == Fchariot && one.getIcon() == Fmagician)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && one.getIcon() == magician
									|| six.getIcon() == Fhermit && one.getIcon() == Fmagician)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && one.getIcon() == magician
									|| seven.getIcon() == Fwheel && one.getIcon() == Fmagician)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && one.getIcon() == magician
									|| eight.getIcon() == Fstar && one.getIcon() == Fmagician)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked2 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked7 = true;
					isClicked8 = true;
				}

			}
		});
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked2 == false && cntclick < 2) {
					two.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						two.setIcon(empress);
					} else {
						two.setIcon(Fempress);
					}
					isClicked2 = true;
					if (cntclick == 0)
						main = 2;
					else if (cntclick == 1)
						sup = 2;
					cntclick++;

				} else if (isClicked2 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 2) {
						supportcard.setText("Your supporting card is : Empress");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && two.getIcon() == empress
									|| one.getIcon() == Fmagician && two.getIcon() == Fempress)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (two.getIcon() == empress && three.getIcon() == hierophant
									|| two.getIcon() == Fempress && three.getIcon() == Fhierophant)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && two.getIcon() == empress
									|| four.getIcon() == Flover && two.getIcon() == Fempress)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && two.getIcon() == empress
									|| five.getIcon() == Fchariot && two.getIcon() == Fempress)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && two.getIcon() == empress
									|| six.getIcon() == Fhermit && two.getIcon() == Fempress)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortone");
							if (seven.getIcon() == wheel && two.getIcon() == empress
									|| seven.getIcon() == wheel && two.getIcon() == Fempress)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && two.getIcon() == empress
									|| eight.getIcon() == Fstar && two.getIcon() == Fempress)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked7 = true;
					isClicked8 = true;
				}
			}
		});
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked3 == false && cntclick < 2) {
					three.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						three.setIcon(hierophant);
					} else {
						three.setIcon(Fhierophant);
					}
					isClicked3 = true;
					if (cntclick == 0)
						main = 3;
					else if (cntclick == 1)
						sup = 3;
					cntclick++;
				} else if (isClicked3 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 3) {
						supportcard.setText("Your supporting card is : Hierophant");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && three.getIcon() == hierophant
									|| one.getIcon() == Fmagician && two.getIcon() == Fhierophant)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");

						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && three.getIcon() == hierophant
									|| two.getIcon() == Fempress && three.getIcon() == Fhierophant)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && three.getIcon() == hierophant
									|| four.getIcon() == Flover && three.getIcon() == Fhierophant)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && three.getIcon() == hierophant
									|| five.getIcon() == Fchariot && three.getIcon() == Fhierophant)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && three.getIcon() == hierophant
									|| six.getIcon() == Fhermit && three.getIcon() == Fhierophant)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && three.getIcon() == hierophant
									|| seven.getIcon() == Fwheel && three.getIcon() == Fhierophant)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && three.getIcon() == hierophant
									|| eight.getIcon() == Fstar && three.getIcon() == Fhierophant)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked7 = true;
					isClicked8 = true;
				}
			}
		});
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked4 == false && cntclick < 2) {
					four.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						four.setIcon(lover);
					} else {
						four.setIcon(Flover);
					}
					isClicked4 = true;
					if (cntclick == 0)
						main = 4;
					else if (cntclick == 1)
						sup = 4;
					cntclick++;
				} else if (isClicked4 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 4) {
						supportcard.setText("Your supporting card is : Lover");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && four.getIcon() == lover
									|| one.getIcon() == Fmagician && four.getIcon() == Flover)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");

						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && four.getIcon() == lover
									|| two.getIcon() == Fempress && four.getIcon() == Flover)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && four.getIcon() == lover
									|| three.getIcon() == Fhierophant && four.getIcon() == Flover)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && four.getIcon() == lover
									|| five.getIcon() == Fchariot && four.getIcon() == Flover)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && four.getIcon() == lover
									|| six.getIcon() == Fhermit && four.getIcon() == Flover)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && four.getIcon() == lover
									|| seven.getIcon() == Fwheel && four.getIcon() == Flover)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && four.getIcon() == lover
									|| eight.getIcon() == Fstar && four.getIcon() == Flover)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked3 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked7 = true;
					isClicked8 = true;
				}
			}
		});
		five.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked5 == false && cntclick < 2) {
					five.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						five.setIcon(chariot);
					} else {
						five.setIcon(Fchariot);
					}
					isClicked5 = true;
					if (cntclick == 0)
						main = 5;
					else if (cntclick == 1)
						sup = 5;
					cntclick++;
				} else if (isClicked5 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 5) {
						supportcard.setText("Your supporting card is : Chariot");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && five.getIcon() == chariot
									|| one.getIcon() == Fmagician && five.getIcon() == Fchariot)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");
						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && five.getIcon() == chariot
									|| two.getIcon() == Fempress && five.getIcon() == Fchariot)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && five.getIcon() == chariot
									|| three.getIcon() == hierophant && five.getIcon() == Fchariot)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && five.getIcon() == chariot
									|| four.getIcon() == Flover && five.getIcon() == Fchariot)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && five.getIcon() == chariot
									|| six.getIcon() == Fhermit && five.getIcon() == Fchariot)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && five.getIcon() == chariot
									|| seven.getIcon() == Fwheel && five.getIcon() == Fchariot)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && five.getIcon() == chariot
									|| eight.getIcon() == Fstar && five.getIcon() == Fchariot)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked6 = true;
					isClicked7 = true;
					isClicked8 = true;
				}
			}
		});
		six.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked6 == false && cntclick < 2) {
					six.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						six.setIcon(hermit);
					} else {
						six.setIcon(Fhermit);
					}
					isClicked6 = true;
					if (cntclick == 0)
						main = 6;
					else if (cntclick == 1)
						sup = 6;
					cntclick++;
				} else if (isClicked6 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 6) {
						supportcard.setText("Your supporting card is : Hermit");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && six.getIcon() == hermit
									|| one.getIcon() == Fmagician && six.getIcon() == Fhermit)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");

						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && six.getIcon() == hermit
									|| two.getIcon() == Fempress && six.getIcon() == Fhermit)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && six.getIcon() == hermit
									|| three.getIcon() == hierophant && six.getIcon() == Fhermit)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && six.getIcon() == hermit
									|| four.getIcon() == Flover && six.getIcon() == Fhermit)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && six.getIcon() == hermit
									|| five.getIcon() == Fchariot && six.getIcon() == Fhermit)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && six.getIcon() == hermit
									|| seven.getIcon() == Fwheel && six.getIcon() == Fhermit)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && six.getIcon() == hermit
									|| eight.getIcon() == Fstar && six.getIcon() == Fhermit)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked7 = true;
					isClicked8 = true;
				}

			}
		});
		seven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked7 == false && cntclick < 2) {
					seven.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						seven.setIcon(wheel);
					} else {
						seven.setIcon(Fwheel);
					}
					isClicked7 = true;
					if (cntclick == 0)
						main = 7;
					else if (cntclick == 1)
						sup = 7;
					cntclick++;
				} else if (isClicked7 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked8 == false)
						if (r.nextInt(2) == 0) {
							eight.setIcon(star);
						} else {
							eight.setIcon(Fstar);
						}
					if (sup == 7) {
						supportcard.setText("Your supporting card is : Wheel Of Fortune");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && seven.getIcon() == wheel
									|| one.getIcon() == Fmagician && two.getIcon() == Fwheel)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");
						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && seven.getIcon() == wheel
									|| two.getIcon() == Fempress && seven.getIcon() == Fwheel)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && seven.getIcon() == wheel
									|| three.getIcon() == hierophant && seven.getIcon() == Fwheel)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && seven.getIcon() == wheel
									|| four.getIcon() == Flover && seven.getIcon() == Fwheel)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && seven.getIcon() == wheel
									|| five.getIcon() == Fchariot && seven.getIcon() == Fwheel)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && seven.getIcon() == wheel
									|| six.getIcon() == Fhermit && seven.getIcon() == Fwheel)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 8) {
							maincard.setText("Your main card is : The Star");
							if (eight.getIcon() == star && seven.getIcon() == wheel
									|| eight.getIcon() == Fstar && seven.getIcon() == Fwheel)
								result.setText(
										"<html>Your love is on its way to be fulfilled. The happiness is just a moment away </html>");
							else
								result.setText(
										"<html>You cannot hope for anything. Do not ask about his/her feeling. The answer will hurt you. </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked8 = true;
				}

			}
		});
		eight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked8 == false && cntclick < 2) {
					eight.setBorder(new LineBorder(Color.BLACK, 5));
					if (r.nextInt(2) == 0) {
						eight.setIcon(star);
					} else {
						eight.setIcon(Fstar);
					}
					isClicked8 = true;
					if (cntclick == 0)
						main = 8;
					else if (cntclick == 1)
						sup = 8;
					cntclick++;
				} else if (isClicked8 == true && cntclick < 2) {
					JOptionPane.showMessageDialog(null, "Card is already selected");
				} else if (cntclick == 2) {
					JOptionPane.showMessageDialog(null, "The prediction is already done. Please shuffle.");
				}
				if (cntclick == 2) {
					if (isClicked1 == false)
						if (r.nextInt(2) == 0) {
							one.setIcon(magician);
						} else {
							one.setIcon(Fmagician);
						}
					if (isClicked2 == false)
						if (r.nextInt(2) == 0) {
							two.setIcon(empress);
						} else {
							two.setIcon(Fempress);
						}
					if (isClicked3 == false)
						if (r.nextInt(2) == 0) {
							three.setIcon(hierophant);
						} else {
							three.setIcon(Fhierophant);
						}
					if (isClicked4 == false)
						if (r.nextInt(2) == 0) {
							four.setIcon(lover);
						} else {
							four.setIcon(Flover);
						}
					if (isClicked5 == false)
						if (r.nextInt(2) == 0) {
							five.setIcon(chariot);
						} else {
							five.setIcon(Fchariot);
						}
					if (isClicked6 == false)
						if (r.nextInt(2) == 0) {
							six.setIcon(hermit);
						} else {
							six.setIcon(Fhermit);
						}
					if (isClicked7 == false)
						if (r.nextInt(2) == 0) {
							seven.setIcon(wheel);
						} else {
							seven.setIcon(Fwheel);
						}
					if (sup == 8) {
						supportcard.setText("Your supporting card is : The Star");
						if (main == 1) {
							maincard.setText("Your main card is : Magician");
							if (one.getIcon() == magician && eight.getIcon() == star
									|| one.getIcon() == Fmagician && eight.getIcon() == Fstar)
								result.setText(
										"<html>Your love is perfect and your wishes is about to come true. This is a happy time for your love.</html>");
							else
								result.setText(
										"<html>This love is still complicated and hard to understand. You are not certain of his/her feeling. Helps from your friends are needed</html>");
						}
						if (main == 2) {
							maincard.setText("Your main card is : Empress");
							if (two.getIcon() == empress && eight.getIcon() == star
									|| two.getIcon() == Fempress && eight.getIcon() == Fstar)
								result.setText(
										"<html>Be careful of your feeling. This is not a good period. You love will not be as joyful as you wish. </html>");
							else
								result.setText(
										"<html>You will be hurted by his indifference. Be patient and tolerate that </html>");
						}
						if (main == 3) {
							maincard.setText("Your main card is : Hierophant");
							if (three.getIcon() == hierophant && eight.getIcon() == star
									|| three.getIcon() == Fhierophant && eight.getIcon() == Fstar)
								result.setText(
										"<html>You are falling in love. Only the thought of your love is on your mind at this time. Your friends can help you. Hurry and go talk to them. </html>");
							else
								result.setText("<html>Your love is slipping away. Hurry and take action. </html>");
						}
						if (main == 4) {
							maincard.setText("Your main card is : Lover");
							if (four.getIcon() == lover && eight.getIcon() == star
									|| four.getIcon() == Flover && eight.getIcon() == Fstar)
								result.setText(
										"<html>Clear as day. If you are thinking of asking him out, go ahead. </html>");
							else
								result.setText(
										"<html>No progress. You can only make eye contact. Need to wait for a good timing. </html>");
						}
						if (main == 5) {
							maincard.setText("Your main card is : Chariot");
							if (five.getIcon() == chariot && eight.getIcon() == star
									|| five.getIcon() == Fchariot && eight.getIcon() == Fstar)
								result.setText(
										"<html>Your love fortune is in disarray. You should not concern yourself with love during this period. </html>");
							else
								result.setText("<html>Your heart may be broken. Deal with it. </html>");
						}
						if (main == 6) {
							maincard.setText("Your main card is : Hermit");
							if (six.getIcon() == hermit && eight.getIcon() == star
									|| six.getIcon() == Fhermit && eight.getIcon() == Fstar)
								result.setText(
										"<html>Although there may be some complication, but your love will be fulfilled. </html>");
							else
								result.setText(
										"<html>Take heed of your friend suggestions. You should not be so serious with this love, or you can loose your friendship. </html>");
						}
						if (main == 7) {
							maincard.setText("Your main card is : Wheel Of Fortune");
							if (seven.getIcon() == wheel && eight.getIcon() == star
									|| seven.getIcon() == Fwheel && eight.getIcon() == Fstar)
								result.setText(
										"<html>The circumstance is not favorable. You have little chance to meet each other. </html>");
							else
								result.setText(
										"<html>The feeling of love is about to change and turn into friendship </html>");
						}
					}
					isClicked1 = true;
					isClicked2 = true;
					isClicked3 = true;
					isClicked4 = true;
					isClicked5 = true;
					isClicked6 = true;
					isClicked7 = true;
				}

			}
		});
		result.setForeground(Color.MAGENTA);
		result.setFont(new Font("Angsana New", 3, 30));
		maincard.setForeground(Color.MAGENTA);
		maincard.setFont(new Font("Angsana New", 3, 30));
		supportcard.setForeground(Color.MAGENTA);
		supportcard.setFont(new Font("Angsana New", 3, 30));
		rightpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightpanelresult.setLayout(new GridLayout(1, 0));
		rightpanel.add(maincard);
		rightpanel.add(supportcard);
		rightpanelresult.add(result);
		rightpanel.add(rightpanelresult);
		rightpanel.setPreferredSize(new Dimension(380, 300));
		rightpanelresult.setPreferredSize(new Dimension(350, 145));
		rightpanelresult.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
	}
}
