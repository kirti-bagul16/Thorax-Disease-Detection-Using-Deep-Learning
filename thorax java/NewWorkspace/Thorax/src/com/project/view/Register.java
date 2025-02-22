package com.project.view;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;

import com.project.bean.UserBean;
import com.project.dao.UserDao;
import com.project.service.EmailDemo;
import com.project.validation.EmailAndMobile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class Register
{
	private JFrame frame;
	private JLabel headerLabel,userLabel,addressLabel,ageLabel, emailLabel,mobnoLabel,RegisterLabel, doc_nameLabel;
	private JLabel passwordLabel;
	private JTextField userText,addressText,ageText, emailText,mobnoText, doc_nameText;
	
	private JPasswordField passwordText;
	private JButton registerButton,clearButton, loginButton,backButton;
	
    private InputStream is;
    private JPanel panel1,panel2;
    Boolean resultStatus=Boolean.FALSE;
	

	public Register()
	 {
		frame = new JFrame("REGISTRATION FORM");
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
		
		RegisterLabel=new JLabel("REGISTRATION");
		RegisterLabel.setFont(new Font("Arial", Font.BOLD, 22));
		RegisterLabel.setForeground(Color.WHITE);
		panel2.add(RegisterLabel);

		userLabel = new JLabel("Username");
		userLabel.setBounds(10, 30, 80, 25);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel2.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 30, 160, 25); 
		panel2.add(userText);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 70, 80, 25);
		addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
		addressLabel.setForeground(Color.WHITE);
		
		panel2.add(addressLabel);

		addressText = new JTextField(20);
		addressText.setBounds(100, 70, 160, 25);
		panel2.add(addressText);
		
		/******************************/
		ageLabel= new JLabel("Age");
		ageLabel.setBounds(10, 110, 80, 25);
		ageLabel.setForeground(Color.WHITE);
		ageLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel2.add(ageLabel);
		
		ageText = new JTextField(20);
		ageText.setBounds(100, 110, 160, 25);
		panel2.add(ageText);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 150, 80, 25);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
		emailLabel.setForeground(Color.WHITE);
		panel2.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(100, 150, 160, 25);
		panel2.add(emailText);
		
		mobnoLabel = new JLabel("Mobno");
		mobnoLabel.setBounds(10, 190, 80, 25);
		mobnoLabel.setForeground(Color.WHITE);
		mobnoLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel2.add(mobnoLabel);

		mobnoText = new JTextField(20);
		mobnoText.setBounds(100, 190, 160, 25);
		panel2.add(mobnoText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 230, 80, 25);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
		passwordLabel.setForeground(Color.WHITE);
		panel2.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 230, 160, 25);
		panel2.add(passwordText);
		
		doc_nameLabel= new JLabel("Dr_Name");
		doc_nameLabel.setBounds(10, 270, 80, 25);
		doc_nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		doc_nameLabel.setForeground(Color.WHITE);
		panel2.add(doc_nameLabel);
		
		doc_nameText = new JTextField(20);
		doc_nameText.setBounds(100, 270, 160, 25);
		panel2.add(doc_nameText);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(10, 310, 100, 25);
		registerButton.setForeground(Color.BLACK);
		panel2.add(registerButton);
		
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(180, 310, 80, 25);
		clearButton.setForeground(Color.BLACK);
		panel2.add(clearButton);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 350, 80, 25);
		loginButton.setForeground(Color.BLACK);
		panel2.add(loginButton);
		
		backButton= new JButton("Back");
		backButton.setBounds(180, 350, 80, 25);
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
		registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	registerButtonActionPerformed(evt);
            }
        });
		
		
		clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clearButtonActionPerformed(evt);
            }
        });
		
		loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	loginButtonActionPerformed(evt);
            }
        });
		
		passwordText.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	passwordTextActionPerformed(evt);
	            }
	        });
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	 }
		
	    
		private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) 
		{
	        String uname=userText.getText();
	        boolean validName =EmailAndMobile.isValidName(uname);
	        
	        String address=addressText.getText();
	        
	        String age=ageText.getText();
	        boolean validAge =EmailAndMobile.isValidAge(age);
	       
	        String email=emailText.getText();
	        boolean validEmail =EmailAndMobile.isValidEmailAddress(email);
	        
	        String mobNo=mobnoText.getText();
	        boolean validMobilNo =EmailAndMobile.isValidMobilNumber(mobNo);
	        
	        String password=passwordText.getText();
	        
	        String doc_name=doc_nameText.getText();
	        boolean validDoc_Name =EmailAndMobile.isValidDocName(doc_name);
	        
	        if(userText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter User Name");
	        }
	        else if(validName==false)
	        {
	           
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Name"); 
	              
	        }
	       
	        else if(addressText.getText().length()==0)
	        {
	            
	            JOptionPane.showMessageDialog(frame,"Please Enter Address"); 
	        
	        }
	        
	        else if(ageText.getText().length()==0)
	        {
	        	
	            JOptionPane.showMessageDialog(frame,"Please Enter User Age");
	            
	        }
	        else if(validAge==false)
	        {
	            
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Age"); 
	             
	        }
	       
	        else if(emailText.getText().length()==0)
	        {
	        	
	            JOptionPane.showMessageDialog(frame,"Please Enter Email");
	            
	        }
	        else if(validEmail==false)
	        {
	           
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Email Id"); 
	                
	        }
	        else if(mobnoText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter Mobile");
	            
	        }
	        else if(validMobilNo==false)
	        {
	                    
	            
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Mobile Number"); 
	                          
	            
	        }
	        else if(passwordText.getText().length()==0)
	        {
	           
	            JOptionPane.showMessageDialog(frame,"Please Enter Password");
	            
	        }
	        
	        else if(doc_nameText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter Doc Name");
	        }
	        else if(validDoc_Name==false)
	        {
	           
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Doc Name"); 
	              
	        }
	                        
	        else
	        {
	        
	         UserBean bean=new UserBean();
	         bean.setUname(uname);
	         bean.setAddress(address);
	         bean.setAge(age);
	         bean.setEmail(email);
	         bean.setMobNo(mobNo);
	         bean.setPassword(password);
	         bean.setDoc_name(doc_name);
	        
	         UserDao ud=new UserDao();
	         
	 		 
	         if(ud.userRegistration(bean))
		        {
		        	 
		        	 
		             JOptionPane.showMessageDialog(frame,"User Register Successfully !!!");
		         
		         try {
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
		          Admin login=new Admin();
		          
		          frame.dispose();
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(frame,"Already Exist or Registration Failed !!!");
		        }
	        }
		}
		
		private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) 
		 {
			//GEN-FIRST:event_jPasswordField1ActionPerformed
		        // TODO add your handling code here:
		 }
	       
		private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) 
		{
	        
			userText.setText("");
	        passwordText.setText("");
	        addressText.setText("");
	        emailText.setText("");
	        mobnoText.setText("");
	      
	     }
		
		 private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) 
		   {
			 try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		        Admin login=new Admin();
		        //login.setVisible(true);
		        frame.dispose();
		        
		   }
		
		/* public static void main(String[] args)
			{
				
				new Register();
			}

	*/
}
