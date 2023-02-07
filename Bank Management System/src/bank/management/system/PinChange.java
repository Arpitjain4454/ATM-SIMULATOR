package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	

	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;
	PinChange(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,  900,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(250, 280 , 500, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(170, 320 , 180, 25);
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setBounds(330, 320, 180, 25);
		pin.setFont(new Font("Ralewa", Font.BOLD, 25));
		image.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setBounds(170, 360 , 180, 25);
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setBounds(330, 360, 180, 25);
		repin.setFont(new Font("Ralewa", Font.BOLD, 25));
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		add(change);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			
			String npin = pin.getText();
			String rpin= repin.getText();
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter PIN");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
				return;
			}
			
			Conn conn = new Conn();
			String query = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			String query1 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			String query2 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
	
			 try {
				conn.s.executeUpdate(query);
				 conn.s.executeUpdate(query);
				 conn.s.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
			
		}
		else if(ae.getSource() == back) {
			
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("");
	}

}
