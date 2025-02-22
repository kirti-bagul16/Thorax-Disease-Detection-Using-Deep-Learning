package com.project.view;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.project.algo.PDF;
import com.project.dao.UserDao;

import java.awt.*;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserHome
{
	private JFrame frame;
	private JLabel headerLabel,userLabel,addressLabel,ageLabel;
	
	private JTextArea userText,addressText,ageText;
	
	
	
    private InputStream is;
    private JPanel panel1,panel2;
    Boolean resultStatus=Boolean.FALSE;
	
    
    String area=null;
	String stage=null;
	String name=null;
    
	 String patientname=null;

	public UserHome()
	 {
		
		
		frame = new JFrame("View Results");
		frame.setSize(800,650);
		//frame.setLocation(250,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1=new JPanel();
		panel1.setBounds(20,50,750,80);
		
		panel2 = new JPanel();
		panel2.setBounds(250,150,300,500);
		
		
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images\\8.jpg")));
		
		panel2.setLayout(null);
		
		
		headerLabel=new JLabel("Thorax Detection System ");
		headerLabel.setBounds(110, 0, 160, 25);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		headerLabel.setForeground(Color.WHITE);
		panel1.add(headerLabel);

		
		 patientname=JOptionPane.showInputDialog("Enter Patient Name");
		 
		 UserDao dao=new UserDao();
			
			ResultSet rs=dao.SelectUser( patientname);
			
			try {
				
				if(rs.next()){
					 area=rs.getString(2);
					 stage=rs.getString(3);
					 name=rs.getString(4);
					}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		userLabel = new JLabel("Patient Name");
		userLabel.setBounds(10, 30, 80, 25);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
		userLabel.setForeground(Color.WHITE);
		panel2.add(userLabel);

		userText = new JTextArea(20, 0);
		userText.setBounds(100, 30, 160, 25);
		panel2.add(userText);
		userText.append(name);

		addressLabel = new JLabel("Thorax Stage");
		addressLabel.setBounds(10, 70, 80, 25);
		addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
		addressLabel.setForeground(Color.WHITE);
		panel2.add(addressLabel);

		addressText = new JTextArea(20,0);
		addressText.setBounds(100, 70, 160, 25);
		panel2.add(addressText);
		addressText.append(stage);
		
		/******************************/
		ageLabel= new JLabel("Thorax Area");
		ageLabel.setForeground(Color.WHITE);
		ageLabel.setFont(new Font("Arial", Font.BOLD, 16));
		ageLabel.setBounds(10, 110, 80, 25);
		panel2.add(ageLabel);
		
		ageText = new JTextArea(20,0);
		ageText.setBounds(100, 110, 160, 25);
		panel2.add(ageText);
		ageText.append(area);
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	 }
	
		
}
