package Assign2_Matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class tester extends JFrame{
	private ArrayList<Integer> num1= new ArrayList<>();
	private ArrayList<Integer> num2 = new ArrayList<>();
	private ArrayList<Integer> all = new ArrayList<>();
	private int boom;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JButton b = new JButton("Calculate");
	JButton b1 = new JButton("Clear");
	JTextArea a1 = new JTextArea(10, 10);
	JTextArea a2 = new JTextArea(10, 10);
	JTextArea a3 = new JTextArea(10, 10);
	JComboBox<String> cb = new JComboBox<>();
	JLabel l = new JLabel("=");

	public tester() {
		cb.addItem("+");
		cb.addItem("-");
		cb.addItem("*");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a3.setText(null);
				StringTokenizer str = new StringTokenizer(a1.getText());
				StringTokenizer str1 = new StringTokenizer(a2.getText());
				boom = str.countTokens();
				for(int i = 0;i<boom;i++){
					num1.add(Integer.parseInt(str.nextToken()));
					num2.add(Integer.parseInt(str1.nextToken()));
				}
				if(cb.getSelectedIndex()==0){
					int m = 0;
					for(int i = 0;i<boom;i++){
						all.add(num1.get(i)+num2.get(i));
						if(m==Math.sqrt(boom)){
							a3.setText(a3.getText()+"\n"+all.get(i)+" ");
							m=1;
						}
						else{
							a3.setText(a3.getText()+all.get(i)+" ");
							m++;
						}
					}
					num1.clear();
					num2.clear();
					all.clear();
				}
				else if(cb.getSelectedIndex()==2){
					int set1=0,set2=0,max=0,m=0,start1=0,start2=0;
					for(int i = 0;i<boom;i++){
						for(int j=0;j<Math.sqrt(boom);j++){
							if(j==0){
								if(set2==boom){
									set1=0;
									set2=0;
									start2++;
								}
								if(start2==Math.sqrt(boom)){
									start2=0;
									start1+=Math.sqrt(boom);
								}
								max=num1.get(start1+set1)*num2.get(start2+set2);
								set1++;
								set2+=Math.sqrt(boom);
							}else{
							max+=num1.get(start1+set1)*num2.get(start2+set2);
							set2+=Math.sqrt(boom);
							set1++;
							}
						}
						all.add(max);
						if(m==Math.sqrt(boom)){
							a3.setText(a3.getText()+"\n"+all.get(i)+" ");
							m=1;
						}else{
							a3.setText(a3.getText()+all.get(i)+" ");
							m++;
						}
					}
					all.clear();
					num1.clear();
					num2.clear();
				}
			}
		});
		b1.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				a1.setText(null);
				a2.setText(null);
				a3.setText(null);
				
			}
		});
		this.setLayout(new BorderLayout());
		a1.setBorder(new TitledBorder(new LineBorder(Color.black),"Matrix1"));
		a2.setBorder(new TitledBorder(new LineBorder(Color.black),"Matrix2"));
		a3.setBorder(new TitledBorder(new LineBorder(Color.black),"Result"));
		a3.setEditable(false);
		p.add(b);
		p.add(b1);
		p1.add(a1);
		p1.add(cb);
		p1.add(a2);
		p1.add(l);
		p1.add(a3);
		this.setSize(500, 500);
		this.add(p1, BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		tester m = new tester();
	}
}
