package Assignment3_DayColorFortune;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DayOfColorFrame extends JFrame {
	DayOfColorPanel Panel;
	JPanel top, bot;
	JLabel Date, Day;
	JCheckBox lucky, unlucky;
	JTextField field;
	WeekOfDay week;
	SimpleDateFormat Df;
	Calendar calen;
	String[] DMY;
	private int Dayofweek;
	Boolean DayIsreal;
	public DayOfColorFrame() {
		top = new JPanel();
		bot = new JPanel();
		Date = new JLabel("Date (e.g.21/09/2017)");
		Day = new JLabel("Unknown");
		field = new JTextField(20);
		lucky = new JCheckBox("lucky color");
		unlucky = new JCheckBox("unlucky color");
		Panel = new DayOfColorPanel();
		top.add(Date);
		top.add(field);
		bot.add(Day);
		bot.add(lucky);
		bot.add(unlucky);
		this.setTitle("Day Color Frame");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(Panel, BorderLayout.CENTER);
		this.add(top, BorderLayout.NORTH);
		this.add(bot, BorderLayout.SOUTH);
		this.pack();
		Df = new SimpleDateFormat("dd/MM/YYYY");
		calen = new GregorianCalendar();
		field.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					DayIsreal = false;
					try {
						DMY = field.getText().split("/");
						if (Integer.parseInt(DMY[2]) > 0 && Integer.parseInt(DMY[1]) > 0
								&& Integer.parseInt(DMY[1]) < 13 && Integer.parseInt(DMY[0]) > 0
								&& Integer.parseInt(DMY[0]) < 32) {
							calen.set(Calendar.YEAR, Integer.parseInt(DMY[2]));
							calen.set(Calendar.MONTH, Integer.parseInt(DMY[1]) - 1);
							if (Integer.parseInt(DMY[1]) == 2 && Integer.parseInt(DMY[0]) < 29	|| Integer.parseInt(DMY[1]) == 2 && Integer.parseInt(DMY[2]) % 4 == 0
											&& Integer.parseInt(DMY[0]) < 30) {
								calen.set(Calendar.DAY_OF_MONTH, Integer.parseInt(DMY[0]));
								DayIsreal = true;
							} else if (Integer.parseInt(DMY[1]) == 4 || Integer.parseInt(DMY[1]) == 6	|| Integer.parseInt(DMY[1]) == 9		|| Integer.parseInt(DMY[1]) == 11) {
								if(Integer.parseInt(DMY[0]) <= 30 ) {
								calen.set(Calendar.DAY_OF_MONTH, Integer.parseInt(DMY[0]));
								DayIsreal = true;
								}
							} else if (Integer.parseInt(DMY[1]) == 1 || Integer.parseInt(DMY[1]) == 3|| Integer.parseInt(DMY[1]) == 5 || Integer.parseInt(DMY[1]) == 7	|| Integer.parseInt(DMY[1]) == 8 || Integer.parseInt(DMY[1]) == 10
									|| Integer.parseInt(DMY[1]) == 12 ) {
								if(Integer.parseInt(DMY[0]) <= 31) {
								calen.set(Calendar.DAY_OF_MONTH, Integer.parseInt(DMY[0]));
								DayIsreal = true;
								}
							}
							if (DayIsreal == true) {
								Dayofweek = calen.get(Calendar.DAY_OF_WEEK);
							}
						} else
							Dayofweek = 0;
					} catch (Exception ee) {
						Dayofweek = 0;
						Panel.Left.setBackground(null);
						Panel.Right.setBackground(null);
					}

					switch (Dayofweek) {
					case 0:
						Day.setText("Unknown");
						break;
					case 1:
						Day.setText("SUNDAY");
						break;
					case 2:
						Day.setText("MONDAY");
						break;
					case 3:
						Day.setText("TUESDAY");
						break;
					case 4:
						Day.setText("WEDNESDAY");
						break;
					case 5:
						Day.setText("THURSDAY");
						break;
					case 6:
						Day.setText("FRIDAY");
						break;
					case 7:
						Day.setText("SATURDAY");
						break;
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (lucky.isSelected()) {
					if (Dayofweek == 1) {
						Panel.Left.setBackground(week.SUNDAY.getLucky());
					} else if (Dayofweek == 2) {
						Panel.Left.setBackground(week.MONDAY.getLucky());
					} else if (Dayofweek == 3) {
						Panel.Left.setBackground(week.TUESDAY.getLucky());
					} else if (Dayofweek == 4) {
						Panel.Left.setBackground(week.WEDNESDAY.getLucky());
					} else if (Dayofweek == 5) {
						Panel.Left.setBackground(week.THURSDAY.getLucky());
					} else if (Dayofweek == 6) {
						Panel.Left.setBackground(week.FRIDAY.getLucky());
					} else if (Dayofweek == 7) {
						Panel.Left.setBackground(week.SATURDAY.getLucky());
					}
				} else
					Panel.Left.setBackground(null);
				if (unlucky.isSelected()) {
					if (Dayofweek == 1) {
						Panel.Right.setBackground(week.SUNDAY.getUnlucky());
					} else if (Dayofweek == 2) {
						Panel.Right.setBackground(week.MONDAY.getUnlucky());
					} else if (Dayofweek == 3) {
						Panel.Right.setBackground(week.TUESDAY.getUnlucky());
					} else if (Dayofweek == 4) {
						Panel.Right.setBackground(week.WEDNESDAY.getUnlucky());
					} else if (Dayofweek == 5) {
						Panel.Right.setBackground(week.THURSDAY.getUnlucky());
					} else if (Dayofweek == 6) {
						Panel.Right.setBackground(week.FRIDAY.getUnlucky());
					} else if (Dayofweek == 7) {
						Panel.Right.setBackground(week.SATURDAY.getUnlucky());
					}
				} else
					Panel.Right.setBackground(null);
			}
		});
		lucky.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lucky.isSelected()) {
					if (Dayofweek == 1) {
						Panel.Left.setBackground(week.SUNDAY.getLucky());
					} else if (Dayofweek == 2) {
						Panel.Left.setBackground(week.MONDAY.getLucky());
					} else if (Dayofweek == 3) {
						Panel.Left.setBackground(week.TUESDAY.getLucky());
					} else if (Dayofweek == 4) {
						Panel.Left.setBackground(week.WEDNESDAY.getLucky());
					} else if (Dayofweek == 5) {
						Panel.Left.setBackground(week.THURSDAY.getLucky());
					} else if (Dayofweek == 6) {
						Panel.Left.setBackground(week.FRIDAY.getLucky());
					} else if (Dayofweek == 7) {
						Panel.Left.setBackground(week.SATURDAY.getLucky());
					}
				} else
					Panel.Left.setBackground(null);
			}
		});
		unlucky.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (unlucky.isSelected()) {
					if (Dayofweek == 1) {
						Panel.Right.setBackground(week.SUNDAY.getUnlucky());
					} else if (Dayofweek == 2) {
						Panel.Right.setBackground(week.MONDAY.getUnlucky());
					} else if (Dayofweek == 3) {
						Panel.Right.setBackground(week.TUESDAY.getUnlucky());
					} else if (Dayofweek == 4) {
						Panel.Right.setBackground(week.WEDNESDAY.getUnlucky());
					} else if (Dayofweek == 5) {
						Panel.Right.setBackground(week.THURSDAY.getUnlucky());
					} else if (Dayofweek == 6) {
						Panel.Right.setBackground(week.FRIDAY.getUnlucky());
					} else if (Dayofweek == 7) {
						Panel.Right.setBackground(week.SATURDAY.getUnlucky());
					}
				} else
					Panel.Right.setBackground(null);
			}
		});
	}

	public static void main(String[] args) {
		DayOfColorFrame f = new DayOfColorFrame();
	}
}
