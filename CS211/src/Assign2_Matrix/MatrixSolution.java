package Assign2_Matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MatrixSolution extends JFrame {
	JPanel topPanel = new JPanel();
	JPanel botPanel = new JPanel();
	JButton cal = new JButton("Calculate");
	JButton clear = new JButton("Clear");
	JTextArea Mat1 = new JTextArea(7, 9);
	JTextArea Mat2 = new JTextArea(7, 9);
	JTextArea MatResult = new JTextArea(7, 9);
	JComboBox<String> operation = new JComboBox<>();
	JLabel sum = new JLabel("=");
	private ArrayList<Integer> matrix1, matrix2, matrixresult;
	private int digicnt, linecnt,set1,set2,max,cnt,start1,start2;;

	public MatrixSolution() {
		matrix1 = new ArrayList<>();
		matrix2 = new ArrayList<>();
		matrixresult = new ArrayList<>();
		this.setLayout(new BorderLayout());
		operation.addItem("+");
		operation.addItem("*");
		Mat1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Matrix 1"));
		Mat2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Matrix 2"));
		MatResult.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Result"));
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mat1.setText(null);
				Mat2.setText(null);
				MatResult.setText(null);
			}
		});
		cal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringTokenizer x = new StringTokenizer(Mat1.getText());
				StringTokenizer y = new StringTokenizer(Mat2.getText());
				digicnt = x.countTokens();
				linecnt = (int) Math.sqrt(digicnt);
				try {
					for (int i = 0; i < digicnt; i++) {
						matrix1.add(Integer.parseInt(x.nextToken()));
						matrix2.add(Integer.parseInt(y.nextToken()));
					}
					if ((String) operation.getSelectedItem() == "+") {
						MatResult.setText("");
						for (int i = 0; i < digicnt; i++) {
							matrixresult.add(matrix1.get(i) + matrix2.get(i));
						}
						for (int i = 0; i < digicnt; i++) {
							MatResult.setText(MatResult.getText() + matrixresult.get(i) + " ");
							if ((i + 1) % linecnt == 0)
								MatResult.setText(MatResult.getText() + "\n");
						}
						matrix1.clear();
						matrix2.clear();
						matrixresult.clear();
					}
					if ((String) operation.getSelectedItem() == "*") {
						MatResult.setText("");
						set1=0;set2=0;max=0;cnt=0;start1=0;start2=0;
						for(int i = 0;i<digicnt;i++){
							for(int j=0;j<linecnt;j++){
								if(j==0){
									if(set2==digicnt){
										set1=0;
										set2=0;
										start2++;
									}
									if(start2==linecnt){
										start2=0;
										start1+=linecnt;
									}
									max=matrix1.get(start1+set1)*matrix2.get(start2+set2);
									set1++;
									set2+=linecnt;
								}else{
								max+=matrix1.get(start1+set1)*matrix2.get(start2+set2);
								set2+=linecnt;
								set1++;
								}
							}
							matrixresult.add(max);
							if(cnt==linecnt){
								MatResult.setText(MatResult.getText()+"\n"+matrixresult.get(i)+" ");
								cnt=1;
							}else{
								MatResult.setText(MatResult.getText()+matrixresult.get(i)+" ");
								cnt++;
							}
						}
						matrix1.clear();
						matrix2.clear();
						matrixresult.clear();

					}
				} catch (NumberFormatException g) {
					JOptionPane.showMessageDialog(null, "Matrix can calculate only numbers.(Not Alphabet)");
					Mat1.setText("");
					Mat2.setText("");
					MatResult.setText("");
				}
			}
		});

		Mat1.setPreferredSize(new Dimension());
		Mat2.setPreferredSize(new Dimension());
		MatResult.setPreferredSize(new Dimension());
		botPanel.add(cal);
		botPanel.add(clear);
		topPanel.add(Mat1);
		topPanel.add(operation);
		topPanel.add(Mat2);
		topPanel.add(sum);
		topPanel.add(MatResult);
		this.setSize(500, 230);
		this.setResizable(false);
		this.add(topPanel, BorderLayout.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MatrixSolution m = new MatrixSolution();
	}
}
