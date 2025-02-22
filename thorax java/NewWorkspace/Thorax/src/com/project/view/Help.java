package com.project.view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.UIManager;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help
{
	private JFrame frame;
	private JPanel panel1, panel2,panel3;
	private JLabel userLabel,user1Label,passwordLabel,loginLabel,headerLabel,password1Label;
	private JButton HomeButton;
	Boolean resultStatus=Boolean.FALSE;
	public static String uemail;
	
	public Help() 
	 {
		frame=new JFrame("Help");
	    frame.setSize(800,600);
	    //frame.setLocation(250,200);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(200,160,600,440);
		
		panel1=new JPanel();
		panel1.setBounds(20,50,750,120);
		
		panel2 = new JPanel();
		panel2.setBounds(250,150,300,400);
		
		panel3 = new JPanel();
		panel3.setBounds(120,200,500,120);
		
		panel2.setOpaque(false);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images/8.jpg")));
		
		
		panel2.setLayout(null);
		
		headerLabel=new JLabel("Thorax Detection System ");
		headerLabel.setBounds(150, 0, 160, 25);
		//headerLabel.setSize(headerLabel.getPreferredSize());
		headerLabel.setFont(new Font("Arial", Font.BOLD, 40));
		headerLabel.setForeground(Color.WHITE);
		panel1.add(headerLabel);
		
		loginLabel=new JLabel("Help");
		loginLabel.setBounds(100, 10, 160, 25);
		loginLabel.setFont(new Font("Arial", Font.BOLD, 35));
		loginLabel.setForeground(Color.WHITE);
		panel2.add(loginLabel);
 
		userLabel = new JLabel("contact us :");
		userLabel.setBounds(10, 150, 300, 200);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Arial", Font.BOLD, 25));
		panel3.add(userLabel);
        
		user1Label = new JLabel("8745267345");
		user1Label.setBounds(50, 350, 350, 200);
		user1Label.setForeground(Color.WHITE);
		user1Label.setFont(new Font("Arial", Font.BOLD, 25));
		panel3.add(user1Label);
		
		passwordLabel = new JLabel("thorax@gmail.com");
		passwordLabel.setBounds(10, 100, 80, 25);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 25));
		panel3.add(passwordLabel);

	
		password1Label = new JLabel(" ");
		password1Label.setBounds(10, 100, 80, 25);
		password1Label.setForeground(Color.WHITE);
		password1Label.setFont(new Font("Arial", Font.BOLD, 25));
		panel3.add(password1Label);
		
		
		
		HomeButton = new JButton("Home");
		HomeButton.setBounds(50, 200, 80, 25);
		panel2.add(HomeButton);
		
		
	
		
		
		HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	HomeButtonActionPerformed(evt);
            }
        });
		
	
		
		
	    panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.setVisible(true);
	 }
	
	
	 public void HomeButtonActionPerformed(ActionEvent e)	
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
