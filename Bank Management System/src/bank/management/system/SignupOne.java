package bank.management.system;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	Random ran = new Random();
	long random = Math.abs((ran.nextLong()%9000L)+1000L);
	
	JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, other, otherstatus, married, single;
	JDateChooser dateChooser;
	
	
	SignupOne(){
		
		setLayout(null);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 100, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(600, 290, 140, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel status = new JLabel("Marital Status:");
		status.setFont(new Font("Raleway", Font.BOLD, 20));
		status.setBounds(100, 390, 200, 30);
		add(status);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		single = new JRadioButton("Unmarried");
		single.setBounds(450, 390, 120, 30);
		single.setBackground(Color.WHITE);
		add(single);
		
		otherstatus = new JRadioButton("Other");
		otherstatus.setBounds(600, 390, 140, 30);
		otherstatus.setBackground(Color.WHITE);
		add(otherstatus);
		
		ButtonGroup statusgroup = new ButtonGroup();
		statusgroup.add(married);
		statusgroup.add(single);
		statusgroup.add(otherstatus);
		
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pin Code: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor()
.getUiComponent()).getText();	
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		else{
			gender = "Other";
		}
		
		String email = emailTextField.getText();
		String status = null;
		if(single.isSelected()) {
			status = "Single";
		}
		else if(married.isSelected()) {
			status = "Married";
		}
		else {
			status = "OtherStatus";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,  "Name is Required");
			}else {
				// Establish connection
				Conn c = new Conn();
				String query = "insert into SignUp values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+status+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();

	}

}
