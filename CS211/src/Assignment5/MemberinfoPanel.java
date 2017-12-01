package Assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MemberinfoPanel extends JPanel{
	JLabel membercode,name,phone,amount;
	JTextField memberfield,namefield,phonefield,amountfield;
	JButton add;
	JTextArea areainfo,areatop3;
	JPanel top,top1,top2,top3,top4,top5,bot;
	HashMap<String, Member> memberinfo = new HashMap<>();
	ArrayList<Member> mem = new ArrayList<>();
	PriorityQueue<Member> queue = new PriorityQueue<>();
	Member m;
	public MemberinfoPanel() {
		top = new JPanel();
		top1 = new JPanel();
		top2 = new JPanel();
		top3 = new JPanel();
		top4 = new JPanel();
		top5 = new JPanel();
		bot = new JPanel();
		membercode = new JLabel("Member Code :");
		name = new JLabel("Name Lastname :");
		phone = new JLabel("Phone No :");
		amount = new JLabel("Amount Paid :");
		memberfield = new JTextField(8);
		namefield = new JTextField(40);
		phonefield = new JTextField(12);
		amountfield = new JTextField(8);
		add = new JButton("Add");
		areainfo = new JTextArea();
		areatop3 = new JTextArea();
		areatop3.setPreferredSize(new Dimension(220, 120));
		areatop3.setBorder(new LineBorder(Color.BLACK, 2));
		areatop3.setText("Top 3 Spender\n");
		top.setLayout(new GridLayout(5, 1));
		top1.setLayout(new FlowLayout(FlowLayout.LEFT));
		top2.setLayout(new FlowLayout(FlowLayout.LEFT));
		top3.setLayout(new FlowLayout(FlowLayout.LEFT));
		top4.setLayout(new FlowLayout(FlowLayout.LEFT));
		top5.setLayout(new FlowLayout(FlowLayout.CENTER));
		top1.add(membercode);
		top1.add(memberfield);
		top2.add(name);
		top2.add(namefield);
		top3.add(phone);
		top3.add(phonefield);
		top4.add(amount);
		top4.add(amountfield);
		top5.add(add);
		top.add(top1);
		top.add(top2);
		top.add(top3);
		top.add(top4);
		top.add(top5);
		bot.setLayout(new BorderLayout());
		bot.add(areainfo, BorderLayout.CENTER);
		bot.add(areatop3, BorderLayout.EAST);
		this.setLayout(new GridLayout(2, 1));
		this.add(top);
		this.add(bot);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cnt=0;int temp = 0;
				areainfo.setText("");
				areatop3.setText("Top 3 Spender\n");
				String memcode = "^[A-Z]{3}-[0-9]{4}$";
				String namepat = "^[A-Z][a-z]{1,10}\\s[A-Z][a-z]{1,20}";
				String phonepat = "0[8-9]{1}-?[0-9]{4}-?[0-9]{4}";
				if(memberfield.getText().matches(memcode)==false) {
					JOptionPane.showMessageDialog(null, "Member Code is invalid");
				}
				if(namefield.getText().matches(namepat)==false) {
					JOptionPane.showMessageDialog(null, "Invalid Name");
				}
				if(phonefield.getText().matches(phonepat)==false) {
					JOptionPane.showMessageDialog(null, "Invalid Phone Format");
				}
				try {
				if(memberfield.getText().matches(memcode)&&namefield.getText().matches(namepat)&&phonefield.getText().matches(phonepat)&&Integer.parseInt(amountfield.getText())>=0) {
					mem.add(new Member(memberfield.getText(), namefield.getText(),phonefield.getText(),Integer.parseInt(amountfield.getText())));
					m = memberinfo.get(new String(memberfield.getText()));      	/////////// ข้อ5
					if(m!=null) {												/////////// ข้อ5
						m.setAmount(Integer.parseInt(amountfield.getText()));		/////////// ข้อ5
						m.setName(namefield.getText());							/////////// ข้อ5
						m.setPhoneno(phonefield.getText());						/////////// ข้อ5
						memberinfo.put(memberfield.getText(), m);				/////////// ข้อ5 
					}
					else {
						memberinfo.put(memberfield.getText(), new Member(memberfield.getText(), namefield.getText(),phonefield.getText(),Integer.parseInt(amountfield.getText())));
					}
					queue.clear();
					//// ข้อ 4 queue.add(new Member(memberfield.getText(), namefield.getText(),phonefield.getText(),Integer.parseInt(amountfield.getText())));
					for(Entry<String,Member> map : memberinfo.entrySet()) { /////////// ข้อ5 
						queue.add(map.getValue());							/////////// ข้อ5 
						areainfo.setText(areainfo.getText()+map.getKey()+"     "+map.getValue().getName()+"     "+map.getValue().getPhoneno()+"     "+map.getValue().getAmount()+"\n");
					}														/////////// ข้อ5 
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Enter Information Again.");
				}
				}catch(NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Invalid Amount. Please Enter Number(not alphabet).");
				}
				while(queue.peek()!=null&&cnt<3) {
					areatop3.setText(areatop3.getText()+queue.poll().toString()+"\n");
					cnt++;
				}		
			}
		});
		
	}

}
