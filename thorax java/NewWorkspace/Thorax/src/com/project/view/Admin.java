package com.project.view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.project.bean.UserBean;
import com.project.dao.UserDao;
import com.project.validation.EmailAndMobile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
public class  Admin 
{
	private JFrame frame;
	private JPanel panel1, panel2;
	private JLabel userLabel,passwordLabel,loginLabel,headerLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton,clearButton, registerButton, backButton;
	Boolean resultStatus=Boolean.FALSE;
	public static String uemail;
	
	public  Admin() 
	 {
		frame=new JFrame("ADMIN LOGIN FORM");
	    frame.setSize(800,600);
	    //frame.setLocation(250,200);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(200,160,600,440);
		
		panel1=new JPanel();
		panel1.setBounds(20,50,750,120);
		
		panel2 = new JPanel();
		panel2.setBounds(250,150,300,400);
		
		
		panel2.setOpaque(false);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images/8.jpg")));
		
		
		panel2.setLayout(null);
		
		headerLabel=new JLabel("Thorax Detection System");
		headerLabel.setBounds(150, 0, 160, 25);
		//headerLabel.setSize(headerLabel.getPreferredSize());
		headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
		headerLabel.setForeground(Color.WHITE);
		panel1.add(headerLabel);
		
		loginLabel=new JLabel("Admin Login");
		loginLabel.setBounds(100, 10, 160, 25);
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setFont(new Font("Arial", Font.BOLD, 22));
		panel2.add(loginLabel);

		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 60, 80, 25);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel2.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 60, 160, 25);
		panel2.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 100, 80, 25);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel2.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 100, 160, 25);
		panel2.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(50, 150, 100, 25);
		panel2.add(loginButton);
		
		loginButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)	
		  {
			  String email=userText.getText();
		      boolean validEmail =EmailAndMobile.isValidEmailAddress(email);
		      
		      String pass= passwordText.getText();
			   
			    if(userText.getText().length()==0)
		         {
		            JOptionPane.showMessageDialog(frame,"Please Enter User Email");
		         }
			    else if(validEmail==false)
		         {       
		            JOptionPane.showMessageDialog(frame,"Please Enter Valid Email Id");  
		         }
		        else if(passwordText.getText().length()==0)
		         {
		            
		            JOptionPane.showMessageDialog(frame,"Please Enter Password");
		             
		         }
		        else
		         {   
		        	
				       
				       UserDao ud=new UserDao();
				   
				   
				      if(resultStatus=ud.AdminloginCheck(email, pass)) 
				       {
				    	 
				    	  
				    	  try {
								UIManager
										.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
							} catch (Exception e1) {
								e1.printStackTrace();
							}

						     JOptionPane.showMessageDialog(null,"Login Success!!!");
				    	 AdminHome home=new AdminHome();
					      frame.dispose();
				       } 
				     else
				       {

					     JOptionPane.showMessageDialog(null,"Wrong Password / Username");
					     userText.setText("");
					     passwordText.setText("");
					     userText.requestFocus();
				       }
		         }
		    }
		  
		   }
		   );
		
		
		
		
		backButton= new JButton("Back");
		backButton.setBounds(180, 150, 100, 25);
		panel2.add(backButton);
		
		backButton.addActionListener(new java.awt.event.ActionListener()
		   {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
    			    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    		        } catch (Exception e1)
    		         {
    			     e1.printStackTrace();
    	           	}
            	new Home();
            	frame.dispose();
            }
        });
		
		
		
	    panel1.setOpaque(false);
		panel2.setOpaque(false);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	 }
	
	
     
	
}
