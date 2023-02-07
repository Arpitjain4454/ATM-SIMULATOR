package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{
	
	String pinnumber;
	
	MiniStatement(String pinnumber){	
		this.pinnumber = pinnumber;
		setTitle("Mini Statement");
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds (150, 20, 100, 20);
		add (bank);
		
		JLabel balance = new JLabel();
		balance.setBounds (20, 400, 300, 20);
		add(balance);
		
		JLabel card = new JLabel();
		card.setBounds (20, 80, 300, 20);
		add (card);
		
		Conn c = new Conn();
		ResultSet rs;
		try {
			rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs1 = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			while(rs1.next()) {
				mini.setText(mini.getText() +"<html>" + rs1.getString("date") +" | "+ "&nsp;&nsp;&nsp;&nsp;&nsp;" + rs1.getString("type") + "&nsp;&nsp;&nsp;&nsp;&nbsp;" + rs1.getString("amount") + "<br><br><html>");
				if(rs1.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs1.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs1.getString("amount"));
				}
			}
			balance.setText("Your current balance is RS " + bal);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		setSize(400,600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("");
	}

}
