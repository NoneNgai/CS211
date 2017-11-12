
package Assignment3_CoinsExchange;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ExchangeFrame extends JFrame {
	JPanel TOP, CENTER, BOT;
	JLabel InputText;
	JComboBox<String> Box;
	JTextField Input;
	JTextArea Area;
	Coins coin;
	private int tencnt, fivecnt, twocnt, onecnt, tmp, cnt;
	public ExchangeFrame() {
		TOP = new JPanel();
		CENTER = new JPanel();
		BOT = new JPanel();
		InputText = new JLabel("Enter the amount to exchange");
		Box = new JComboBox<>();
		Input = new JTextField(10);
		Area = new JTextArea("---Your exchange---");
		Area.setEditable(false);
		Area.setFont(new Font(null, Font.PLAIN, 23));
		Box.addItem("No Preference");
		Box.addItem("Minimum Coins");
		Box.addItem("ONE");
		Box.addItem("TWO");
		Box.addItem("FIVE");
		Box.addItem("TEN");
		TOP.setLayout(new GridLayout());
		TOP.setBorder(new TitledBorder(new LineBorder(null), "Preference"));
		TOP.add(Box);
		CENTER.setPreferredSize(new Dimension(350, 170));
		CENTER.setLayout(new GridLayout());
		CENTER.add(Area);
		BOT.add(InputText);
		BOT.add(Input);
		this.setLayout(new BorderLayout());
		this.add(TOP, BorderLayout.NORTH);
		this.add(CENTER, BorderLayout.CENTER);
		this.add(BOT, BorderLayout.SOUTH);
		Input.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						int value = Integer.parseInt(Input.getText());
						if (Box.getSelectedItem().equals("No Preference")) {
							Random r = new Random();
							Area.setText("");
							tencnt = 0;
							fivecnt = 0;
							twocnt = 0;
							onecnt = 0;
							tmp = value;
							do{if(tmp>0) {
								if(tmp > coin.TEN.getValue()) {
									cnt = r.nextInt(4);
									switch (cnt) {
									case 0: tmp-=coin.TEN.getValue(); tencnt+=1; break;
									case 1: tmp-=coin.FIVE.getValue(); fivecnt+=1; break;
									case 2: tmp-=coin.TWO.getValue(); twocnt+=1; break;
									case 3: tmp-=coin.ONE.getValue(); onecnt+=1; break;
									}
								}
								else if(tmp > coin.FIVE.getValue()) {
									cnt = r.nextInt(3);
									switch (cnt) {
									case 0: tmp-=coin.FIVE.getValue(); fivecnt+=1; break;
									case 1: tmp-=coin.TWO.getValue(); twocnt+=1; break;
									case 2: tmp-=coin.ONE.getValue(); onecnt+=1; break;
									}
								}
								else if(tmp > coin.TWO.getValue()) {
									cnt = r.nextInt(2);
									switch (cnt) {
									case 0: tmp-=coin.TWO.getValue(); twocnt+=1; break;
									case 1: tmp-=coin.ONE.getValue(); onecnt+=1; break;
									}
								}
								else{
									tmp-=coin.ONE.getValue(); onecnt+=1;
									}
							}
								}while(tmp>0);
							if (tencnt > 0) {
								Area.setText(
										"TEN: #Coins: " + tencnt + " - [value=" + tencnt * coin.TEN.getValue() + "]\n");
							}
							if (fivecnt > 0) {
								Area.setText(Area.getText() + "FIVE: #Coins: " + fivecnt + " - [value="
										+ fivecnt * coin.FIVE.getValue() + "]\n");
							}
							if (twocnt > 0) {
								Area.setText(Area.getText() + "TWO: #Coins: " + twocnt + " - [value="
										+ twocnt * coin.TWO.getValue() + "]\n");
							}
							if (onecnt > 0) {
								Area.setText(Area.getText() + "ONE: #Coins: " + onecnt + " - [value="
										+ onecnt * coin.ONE.getValue() + "]\n");
							}
							if (tencnt > 0 || fivecnt > 0 || twocnt > 0 || onecnt > 0)
								Area.setText(Area.getText() + "Total #coins " + (tencnt + fivecnt + twocnt + onecnt));
							
						} else if (Box.getSelectedItem().equals("Minimum Coins")) {
							Area.setText("");
							tmp = 0;
							tencnt = 0;
							fivecnt = 0;
							twocnt = 0;
							onecnt = 0;
							tmp = value;
							if (tmp / coin.TEN.getValue() > 0) {
								tencnt = tmp / coin.TEN.getValue();
								tmp = Math.floorMod(tmp, coin.TEN.getValue());
							}
							if (tmp / coin.FIVE.getValue() > 0) {
								fivecnt = tmp / coin.FIVE.getValue();
								tmp = Math.floorMod(tmp, coin.FIVE.getValue());
							}
							if (tmp / coin.TWO.getValue() > 0) {
								twocnt = tmp / coin.TWO.getValue();
								tmp = Math.floorMod(tmp, coin.TWO.getValue());
							}
							if (tmp / coin.ONE.getValue() > 0) {
								onecnt = tmp / coin.ONE.getValue();
							}
							if (tencnt > 0) {
								Area.setText(
										"TEN: #Coins: " + tencnt + " - [value=" + tencnt * coin.TEN.getValue() + "]\n");
							}
							if (fivecnt > 0) {
								Area.setText(Area.getText() + "FIVE: #Coins: " + fivecnt + " - [value="
										+ fivecnt * coin.FIVE.getValue() + "]\n");
							}
							if (twocnt > 0) {
								Area.setText(Area.getText() + "TWO: #Coins: " + twocnt + " - [value="
										+ twocnt * coin.TWO.getValue() + "]\n");
							}
							if (onecnt > 0) {
								Area.setText(Area.getText() + "ONE: #Coins: " + onecnt + " - [value="
										+ onecnt * coin.ONE.getValue() + "]\n");
							}
							if (tencnt > 0 || fivecnt > 0 || twocnt > 0 || onecnt > 0)
								Area.setText(Area.getText() + "Total #coins " + (tencnt + fivecnt + twocnt + onecnt));
							else
								Area.setText("Not Applicable Exchange");
						} else if (Box.getSelectedItem().equals("ONE")) {
							Area.setText("ONE: #Coins: " + value / coin.ONE.getValue() + " - [value=" + value + "]");
						} else if (Box.getSelectedItem().equals("TWO")) {
							if (value % 2 == 0)
								Area.setText(
										"TWO: #Coins: " + value / coin.TWO.getValue() + " - [value=" + value + "]");
							else
								Area.setText("Not Applicable Exchange");
						} else if (Box.getSelectedItem().equals("FIVE")) {
							if (value % 5 == 0)
								Area.setText(
										"FIVE: #Coins: " + value / coin.FIVE.getValue() + " - [value=" + value + "]");
							else
								Area.setText("Not Applicable Exchange");
						} else if (Box.getSelectedItem().equals("TEN")) {
							if (value % 10 == 0)
								Area.setText(
										"TEN: #Coins: " + value / coin.TEN.getValue() + " - [value=" + value + "]");
							else
								Area.setText("Not Applicable Exchange");
						}
					} catch (Exception ee) {
						Area.setText("Invalid Amount. Enter a new value");
					}

				}
			}
		});
		Box.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int value = Integer.parseInt(Input.getText());
			if (Box.getSelectedItem().equals("No Preference")) {
				Random r = new Random();
				Area.setText("");
				tencnt = 0;
				fivecnt = 0;
				twocnt = 0;
				onecnt = 0;
				tmp = value;
				do{if(tmp>0) {
					if(tmp > coin.TEN.getValue()) {
						cnt = r.nextInt(4);
						switch (cnt) {
						case 0: tmp-=coin.TEN.getValue(); tencnt+=1; break;
						case 1: tmp-=coin.FIVE.getValue(); fivecnt+=1; break;
						case 2: tmp-=coin.TWO.getValue(); twocnt+=1; break;
						case 3: tmp-=coin.ONE.getValue(); onecnt+=1; break;
						}
					}
					else if(tmp > coin.FIVE.getValue()) {
						cnt = r.nextInt(3);
						switch (cnt) {
						case 0: tmp-=coin.FIVE.getValue(); fivecnt+=1; break;
						case 1: tmp-=coin.TWO.getValue(); twocnt+=1; break;
						case 2: tmp-=coin.ONE.getValue(); onecnt+=1; break;
						}
					}
					else if(tmp > coin.TWO.getValue()) {
						cnt = r.nextInt(2);
						switch (cnt) {
						case 0: tmp-=coin.TWO.getValue(); twocnt+=1; break;
						case 1: tmp-=coin.ONE.getValue(); onecnt+=1; break;
						}
					}
					else{
						tmp-=coin.ONE.getValue(); onecnt+=1;
						}
				}
					}while(tmp>0);
				if (tencnt > 0) {
					Area.setText(
							"TEN: #Coins: " + tencnt + " - [value=" + tencnt * coin.TEN.getValue() + "]\n");
				}
				if (fivecnt > 0) {
					Area.setText(Area.getText() + "FIVE: #Coins: " + fivecnt + " - [value="
							+ fivecnt * coin.FIVE.getValue() + "]\n");
				}
				if (twocnt > 0) {
					Area.setText(Area.getText() + "TWO: #Coins: " + twocnt + " - [value="
							+ twocnt * coin.TWO.getValue() + "]\n");
				}
				if (onecnt > 0) {
					Area.setText(Area.getText() + "ONE: #Coins: " + onecnt + " - [value="
							+ onecnt * coin.ONE.getValue() + "]\n");
				}
				if (tencnt > 0 || fivecnt > 0 || twocnt > 0 || onecnt > 0)
					Area.setText(Area.getText() + "Total #coins " + (tencnt + fivecnt + twocnt + onecnt));
				
			} else if (Box.getSelectedItem().equals("Minimum Coins")) {
				Area.setText("");
				tmp = 0;
				tencnt = 0;
				fivecnt = 0;
				twocnt = 0;
				onecnt = 0;
				tmp = value;
				if (tmp / coin.TEN.getValue() > 0) {
					tencnt = tmp / coin.TEN.getValue();
					tmp = Math.floorMod(tmp, coin.TEN.getValue());
				}
				if (tmp / coin.FIVE.getValue() > 0) {
					fivecnt = tmp / coin.FIVE.getValue();
					tmp = Math.floorMod(tmp, coin.FIVE.getValue());
				}
				if (tmp / coin.TWO.getValue() > 0) {
					twocnt = tmp / coin.TWO.getValue();
					tmp = Math.floorMod(tmp, coin.TWO.getValue());
				}
				if (tmp / coin.ONE.getValue() > 0) {
					onecnt = tmp / coin.ONE.getValue();
				}
				if (tencnt > 0) {
					Area.setText("TEN: #Coins: " + tencnt + " - [value=" + tencnt * coin.TEN.getValue() + "]\n");
				}
				if (fivecnt > 0) {
					Area.setText(Area.getText() + "FIVE: #Coins: " + fivecnt + " - [value="
							+ fivecnt * coin.FIVE.getValue() + "]\n");
				}
				if (twocnt > 0) {
					Area.setText(Area.getText() + "TWO: #Coins: " + twocnt + " - [value=" + twocnt * coin.TWO.getValue()
							+ "]\n");
				}
				if (onecnt > 0) {
					Area.setText(Area.getText() + "ONE: #Coins: " + onecnt + " - [value=" + onecnt * coin.ONE.getValue()
							+ "]\n");
				}
				if (tencnt > 0 || fivecnt > 0 || twocnt > 0 || onecnt > 0)
					Area.setText(Area.getText() + "Total #coins " + (tencnt + fivecnt + twocnt + onecnt));
				else
					Area.setText("Not Applicable Exchange");
			} else if (Box.getSelectedItem().equals("ONE")) {
				Area.setText("ONE: #Coins: " + value / coin.ONE.getValue() + " - [value=" + value + "]");
			} else if (Box.getSelectedItem().equals("TWO")) {
				if (value % 2 == 0)
					Area.setText("TWO: #Coins: " + value / coin.TWO.getValue() + " - [value=" + value + "]");
				else
					Area.setText("Not Applicable Exchange");
			} else if (Box.getSelectedItem().equals("FIVE")) {
				if (value % 5 == 0)
					Area.setText("FIVE: #Coins: " + value / coin.FIVE.getValue() + " - [value=" + value + "]");
				else
					Area.setText("Not Applicable Exchange");
			} else if (Box.getSelectedItem().equals("TEN")) {
				if (value % 10 == 0)
					Area.setText("TEN: #Coins: " + value / coin.TEN.getValue() + " - [value=" + value + "]");
				else
					Area.setText("Not Applicable Exchange");
			}
		} catch (Exception ee) {
			Area.setText("Invalid Amount. Enter a new value");
		}
	}

	});}

	public static void main(String[] args) {
		ExchangeFrame Frame = new ExchangeFrame();
		Frame.setVisible(true);
		Frame.setTitle("Exchange Coin Machine");
		Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Frame.pack();
	}
}
