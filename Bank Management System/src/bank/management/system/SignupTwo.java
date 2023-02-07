package bank.management.system;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


public class SignupTwo extends JFrame implements ActionListener {
	
	JTextField panTextField, aadharTextField;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox val_religion, val_category, val_income, val_education, val_occupation ;

	String formno;
	
	SignupTwo(String formno){
		
		this.formno = formno;
		
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM _ PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String []valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Jain", "Ohter"};
		val_religion = new JComboBox(valReligion);
		val_religion.setBounds(300, 140, 400, 30);
		val_religion.setBackground(Color.WHITE);
		add(val_religion);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String []valCategory = {"General", "OBC", "Minority", "SC", "ST", "Ohter"};
		val_category = new JComboBox(valCategory);
		val_category.setBounds(300, 190, 400, 30);
		val_category.setBackground(Color.WHITE);
		add(val_category);
		
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String []valIncome = {"0", "< 1,50,000", "< 2,50,000", "< 5,00,000", "== 10,00,000", "> 10,00,000"};
		val_income = new JComboBox(valIncome);
		val_income.setBounds(300, 240, 400, 30);
		val_income.setBackground(Color.WHITE);
		add(val_income);
		
		
		JLabel educational = new JLabel("Educational");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 300, 200, 30);
		add(educational);
		
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 325, 200, 30);
		add(qualification);
		
		String []valEducation = {"10th Pass", "12th Pass", "Graduate", "Post-Graduate", "Doctrate", "Other"};
		val_education = new JComboBox(valEducation);
		val_education.setBounds(300, 315, 400, 30);
		val_education.setBackground(Color.WHITE);
		add(val_education);
	
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		String []valOccupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
		val_occupation = new JComboBox(valOccupation);
		val_occupation.setBounds(300, 390, 400, 30);
		val_occupation.setBackground(Color.WHITE);
		add(val_occupation);
	
		
		JLabel pan = new JLabel("PAN Number:");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);
		
		JLabel aadhar = new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD ,14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);
		
		JLabel seniorcitizen = new JLabel("Senior Citizen:");
		seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorcitizen.setBounds(100, 540, 200, 30);
		add(seniorcitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup senior_citizen = new ButtonGroup();
		senior_citizen.add(syes);
		senior_citizen.add(sno);
		
		JLabel existing = new JLabel("Existing Account: ");
		existing.setFont(new Font("Raleway", Font.BOLD, 20));
		existing.setBounds(100, 590, 200, 30);
		add(existing);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existing_account = new ButtonGroup();
		existing_account.add(eyes);
		existing_account.add(eno);
	
		
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
		String religion = (String)val_religion.getSelectedItem();
		String category = (String)val_category.getSelectedItem();
		String income = (String)val_income.getSelectedItem();	
		String education = (String)val_education.getSelectedItem();
		String occupation = (String)val_occupation.getSelectedItem();
		String seniorcitizen = null;
		if(syes.isSelected()) {
			seniorcitizen = "Yes";
		}
		else if(sno.isSelected()) {
			seniorcitizen = "No";
		}
		
		String existingaccount = null;
		if(eyes.isSelected()) {
			existingaccount = "Yes";
		}
		else if(eno.isSelected()) {
			existingaccount = "No";
		}
	
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
	
		try {
				// Establish connection
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
				c.s.executeUpdate(query);
				
				//signupThree
				setVisible(false);
				new SignupThree(formno).setVisible(true);
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");

	}

}
