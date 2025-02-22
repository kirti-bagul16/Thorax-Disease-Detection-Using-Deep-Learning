package com.project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class Home 
{
	JFrame frame;
	
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6; 
	private JLabel label1;
	private JButton homeButton,loginButton,RegisterButton,AdminLogin,HelpButton;
	
	
   public Home()
   {
 	    frame = new JFrame("HomePage");
	    frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		panel1=new JPanel();
		panel1.setBounds(20,50,750,100);
		
		panel2=new JPanel();
		panel2.setBounds(10, 170, 1275, 60);
		panel2.setLayout(null);
		
		label1=new JLabel("Thorax Detection System");
		label1.setBounds(150, 0, 160, 25);
		label1.setFont(new Font("Arial", Font.BOLD,35));
		label1.setForeground(Color.WHITE);
		panel1.add(label1);
		panel1.setOpaque(false);
			
		homeButton = new JButton("Home");
		homeButton.setBounds(35,10,110,50);
		homeButton.setForeground(Color.BLACK);
		panel2.add(homeButton);
		panel2.setOpaque(false);
		
		panel3=new JPanel();
		panel3.setBounds(10, 230, 1275, 60);
		panel3.setLayout(null);
		
		
		loginButton = new JButton("User Login");
		loginButton.setBounds(35,10,110, 50);
		loginButton.setForeground(Color.BLACK);
		panel3.add(loginButton);
		panel3.setOpaque(false);
		
		panel4=new JPanel();
		panel4.setBounds(10, 290, 1275, 60);
		panel4.setLayout(null);
		
		
			
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(35,10,110, 50);
		RegisterButton.setForeground(Color.BLACK);
		panel4.add(RegisterButton);
		panel4.setOpaque(false);
		
		panel5=new JPanel();
		panel5.setBounds(10,350, 1275, 60);
		panel5.setLayout(null);
		
		
		AdminLogin = new JButton("Admin Login");
		AdminLogin.setBounds(35,10,110,50); 
		AdminLogin.setForeground(Color.BLACK);
		panel5.add(AdminLogin);
		panel5.setOpaque(false);
		
		panel6=new JPanel();
		panel6.setBounds(10,412, 1275, 60);
		panel6.setLayout(null);
		
		
		HelpButton = new JButton("Help");
		HelpButton.setBounds(35,10,110,50); 
		HelpButton.setForeground(Color.BLACK);
		panel6.add(HelpButton);
		panel6.setOpaque(false);
		
		
		homeButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)	
		  {
			  try {
					UIManager
							.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 Home home=new Home();
			 //login.setVisible(true);
			 frame.dispose();
		  }
		  
		}
		);
		 
	
		
		loginButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)	
			  {
				  try {
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				LoginView l=new LoginView();
				frame.dispose();
			  }
			  
			}
			);
		
         RegisterButton.addActionListener(new ActionListener()
	       {
	         public void actionPerformed(ActionEvent e)	
	          {
	        	 try {
						UIManager
								.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
		        Register r =new Register();
		        frame.dispose();
	          }
	  
	       }
		);
         
         
         HelpButton.addActionListener(new ActionListener()
 		{
 		  public void actionPerformed(ActionEvent e)	
 		  {
 			  try {
 					UIManager
 							.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
 				} catch (Exception e1) {
 					e1.printStackTrace();
 				}
 			 Help help=new Help();
 			 //login.setVisible(true);
 			 frame.dispose();
 		  }
 		  
 		}
 		);
 		 
         
         AdminLogin.addActionListener(new ActionListener()
	       {
	         public void actionPerformed(ActionEvent e)	
	          {
	        	 try {
						UIManager
								.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
		        Admin r =new Admin();
		        frame.dispose();
	          }
	  
	       }
		);
            
	        frame.setContentPane(new JLabel(new ImageIcon("Images/8.jpg")));
	 	    frame.add(panel1);
	 	    frame.add(panel2);
	 	    frame.add(panel3);
	 	    frame.add(panel4);
	 	    frame.add(panel5);
	 	    frame.add(panel6);
	 	    frame.setLocationRelativeTo(null);
	 	    frame.setResizable(false);
	 		frame.setVisible(true);
     }
  
       public static void main(String args[])
        {
    	   try 
    	   {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
           } 
    	   catch (Exception e1) {
	            e1.printStackTrace();
}
	       new Home();
        }
}
