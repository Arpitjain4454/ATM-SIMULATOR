package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
	
	JButton  w100, w500, w1000, w5000, w10000, w2000, back;
	String pinnumber;
	FastCash(String pinnumber){
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,  900,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Select Withdrawal Amount");
		text.setBounds(220, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		w100 = new JButton("Rs 100");
		w100.setBounds(170, 415, 150, 30);
		w100.addActionListener(this);
		image.add(w100);
		
		w500 = new JButton("Rs 500");
		w500.setBounds(355, 415, 150, 30);
		w500.addActionListener(this);
		image.add(w500);
		
		w1000 = new JButton("Rs 1000");
		w1000.setBounds(170, 450, 150, 30);
		w1000.addActionListener(this);
		image.add(w1000);
		
		w2000 = new JButton("Rs 2000");
		w2000.setBounds(355, 450, 150, 30);
		w2000.addActionListener(this);
		image.add(w2000);
		
		w5000 = new JButton("Rs 5000");
		w5000.setBounds(170, 485, 150, 30);
		w5000.addActionListener(this);
		image.add(w5000);
		
		w10000 = new JButton("Rs 10000");
		w10000.setBounds(355, 485, 150, 30);
		w10000.addActionListener(this);
		image.add(w10000);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(911, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select 8 from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		
		new FastCash("");
	}

}