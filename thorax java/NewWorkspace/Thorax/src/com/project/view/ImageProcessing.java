package com.project.view;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import com.project.algo.Detection;
import com.project.algo.GrayDemo;
import com.project.algo.Identification;
import com.project.algo.KMeansMain;
import com.project.algo.Kmeans;
import com.project.algo.MedianFilter;
import com.project.algo.PDF;
import com.project.algo.PixelCount;
import com.project.algo.Thresholding;

import com.project.bean.UserBean;
import com.project.dao.UserDao;
import com.project.db.DBConnect;

public class ImageProcessing extends javax.swing.JFrame 
{
  Connection connection=null;
  PreparedStatement ps=null;
  ResultSet rs=null;
  String filePath=null;
  String filePath1=null;
  public static String FileName=null;
  String tmp="";
  String appPath1=null;
  String outImg1=null;
  String outImg2=null;
  String fileName=null;
  String fileName1=null;
  String TumorArea="";
  String stageofTumor="";
  String identification="";
  String patientname=null;
  File source, dest;
  public static float tumorarea;
  
  String Path="C:/Users/HP/Desktop/NewWorkspace/Thorax/";
	
  String appPath=Path+"src/com/project/images";
  
  public ImageProcessing() 
  {

   initComponents();
   setSize(1500,970);
   //setLocation(80,100);
   setLocationRelativeTo(null);
   setVisible(true);
   
  }

//1048576 Size limit allowed for Image storage in MySQL.
  public void showImage()
  {
	  jScrollPane2.setText("");
	  
	  try
	  {
		//display image
		  	JFileChooser chooser=new JFileChooser(new File("C:\\Users\\HP\\Desktop\\dataset"));

		  	chooser.setMultiSelectionEnabled(false);
		  	chooser.setVisible(true);

		  	chooser.showOpenDialog(this);

		  	File file=chooser.getSelectedFile();
		  	FileName=file.getName();
		  	if(file!=null)
		  	{
		  		filePath=file.getPath();
			  	
		  		JOptionPane.showMessageDialog(this, "Image Uploaded Successfully!!!");
			  	
			  	path.setText("File path:-"+" "+filePath);
			  	showimage.setIcon(new ImageIcon(filePath));
			  	filename.setText(file.getName());
			  	
			  	file=chooser.getSelectedFile();
			  	BufferedImage patientImage = ImageIO.read(file);
			  	source=new File(appPath+"/ct_Img.png");
		        ImageIO.write(patientImage, "png", source);
			  	
			  	dest = new File(appPath);
			  	
		        if (!dest.exists()) {
		            if (dest.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		        }
	          

				fileName=filename.getText();
			   
			 	fileName=fileName.substring(0,fileName.indexOf("."));
			 	
			 	 patientname=JOptionPane.showInputDialog("Enter Patient Name");
			 	 
			 	 System.out.print("Patient Name:"+patientname);
			 }
		  	else
		  	{
		  		JOptionPane.showMessageDialog(this,"Please select image");
		  	}
	  }
   catch(Exception e)
   {
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
   }
}
public void showOriginalImage()
{
	try
	  {
		 
		  	//File file=new File(appPath+"/"+filename.getText());
		  	if(source!=null)
		  	{
		  		filePath=source.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
}

public void showGrayImage()
{
	try
	  {    
		   //File file=new File(appPath+"/"+filename.getText());
		   BufferedImage grayImg=GrayDemo.toGray(source);
		   
		   File file=new File(appPath+"/GrayImg.png");
		   
		   ImageIO.write(grayImg, "png", file);
		   
		   JOptionPane.showMessageDialog(this, "Gray Successfully!!!");
		  	if(file!=null)
		  	{
		  		filePath=file.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
}

public void showFilterImage()
{
	try
	  {     
		   File file=new File(appPath+"/GrayImg.png");
		   
		   BufferedImage filterImg=MedianFilter.medianFilter(file);
		   
		   file=new File(appPath+"/FilteredImg.png");
		   
		   ImageIO.write(filterImg, "png", file);
		   
		   JOptionPane.showMessageDialog(this, "Filtered Successfully!!!");
		  	if(file!=null)
		  	{
		  		filePath=file.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  		System.out.println("filePath1==="+filePath);
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
}

public void showClusters()
{
	try
	  {   
		   File file=new File(appPath+"/FilteredImg.png");
		   BufferedImage filterImg=ImageIO.read(file);
		    
		   String[] dstpath={appPath+"/cluster1.png",appPath+"/cluster2.png",appPath+"/cluster3.png",appPath+"/cluster4.png"};
		   for(int i=0; i<dstpath.length;i++)
		   {
		    System.out.println("path= "+dstpath[i]);
		   }
		    
		   Kmeans kmeans=new Kmeans();
		   int k=4;
		   Kmeans.imagecluster(k,filterImg,dstpath);
		    
		   File file1=new File(appPath+"/cluster1.png");
		   File file2=new File(appPath+"/cluster2.png");
		   File file3=new File(appPath+"/cluster3.png");
		   File file4=new File(appPath+"/cluster4.png");
		   
		   String filepath1=null;
		   String filepath2=null;
		   String filepath3=null;
		   String filepath4=null;
		   
		   JOptionPane.showMessageDialog(this, "Segmentation Successfully!!!");
		   
		  	if(file1!=null && file2!=null && file3!=null && file4!=null)
		  	{
		  		filepath1=file1.getPath();
		  		filepath2=file2.getPath();
		  		filepath3=file3.getPath();
		  		filepath4=file4.getPath();
		  	}
		  	if(filepath1!=null && filepath2!=null && filepath3!=null && filepath4!=null)
		  	{
		  		//path.setText("File path:-"+" "+filePath);
		  		clustlbl1.setIcon(new ImageIcon(filepath1));
		  		clustlbl2.setIcon(new ImageIcon(filepath2));
		  		clustlbl3.setIcon(new ImageIcon(filepath3));
		  		clustlbl4.setIcon(new ImageIcon(filepath4));
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
}

public void showFuzzyClusters()
{
	try
	{
		 
		   File file=new File(appPath+"/cluster4.png");
		   BufferedImage koutImg=ImageIO.read(file);
		    
		   String dstpath=appPath+"/fuzzyoutput.png";
		   
		   KMeansMain main=new KMeansMain();
			int c=9;
			main.fcluster(c,koutImg,dstpath);
			
			file=new File(appPath+"/fuzzyoutput.png");
			
			JOptionPane.showMessageDialog(this, "Found infected area Successfully!!!");
			if(file!=null)
		  	{
		  		filePath=file.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  		System.out.println("filePath2==="+filePath);
		  	} 
				
			
	}
		catch(Exception e)
			{
			   JOptionPane.showMessageDialog(this, e.getMessage());
			   e.printStackTrace();
			}
	
}
public void showThresholdImage()
{
	try
	  {     
		   File file=new File(appPath+"/fuzzyoutput.png");
		   BufferedImage img=ImageIO.read(file);
		   
		   Thresholding th=new Thresholding();
 		  
		   BufferedImage Threshold=th.Threshold(img, 175);
		   
		   file=new File(appPath+"/ThresholdImg.png");
		   
		   ImageIO.write(Threshold, "png", file);
		   JOptionPane.showMessageDialog(this, "Thresholding Successfully!!!");
		  	if(file!=null)
		  	{
		  		filePath=file.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  		System.out.println("filePath1==="+filePath);
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
}
public void showTumorDetection()
{
	try
	  {     
		   String inputpath=appPath+"/ThresholdImg.png";
		   String outputpath=appPath+"/detectedtumor.png";
		   
		   Detection td=new Detection();
		  
		   td.detect(inputpath, outputpath);
		  	
		   File file=new File(appPath+"/detectedarea.png");
		   JOptionPane.showMessageDialog(this, "Thorax Detection Successfully!!!");
		  	if(file!=null)
		  	{
		  		filePath=file.getPath();
		  	}
		  	if(filePath!=null)
		  	{
		  		path.setText("File path:-"+" "+filePath);
		  		showimage.setIcon(new ImageIcon(filePath));
		  		System.out.println("filePath1==="+filePath);
		  	} 
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}

}

public void areaOfTumor()
{
	
	 File file=new File(appPath+"/ThresholdImg.png"); 
	 PixelCount pixel=new PixelCount();
     int whitepixels=pixel.Pixel(file);
    
     double count1=(double)whitepixels;
    
     double doublearea=(Math.sqrt(count1))*0.264;
     tumorarea=(float)doublearea;
     
     TumorArea=String.valueOf(tumorarea);
     
     TextArea.setText("");
     TextArea.append("\n");
     TextArea.append("Area of Thorax=");
     TextArea.append("\n\n");
     TextArea.append(TumorArea+" mm");
     JOptionPane.showMessageDialog(this, "Thorax area= "+TumorArea);
     TextArea.setFont(new Font("Arial", Font.BOLD, 22));
     TextArea.append("\n");
     
}
public void stageOfTumor()
{
	
	Identification s=new Identification();
	stageofTumor=s.test1(tumorarea);
	TextArea.setText("");
    TextArea.append("\n");
    TextArea.append("Stage of Thorax=");
    TextArea.append("\n\n");
    TextArea.append(stageofTumor);
    JOptionPane.showMessageDialog(this, stageofTumor);
    TextArea.setFont(new Font("Arial", Font.BOLD, 22));
    TextArea.append("\n");
}

public void identification()
{
	
	  if(tumorarea>60)
	    {
	    	
		    identification="Thorax Is High Risk ";
	        JOptionPane.showMessageDialog(this, identification);
	        TextArea.setText("");
	        TextArea.append("\n");
	        TextArea.append("Identification=");
	        TextArea.append("\n\n");
	        TextArea.append(identification);
	        TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	        TextArea.append("\n");
	    }
	    else if(0.0 <tumorarea && tumorarea <60)
	    {
	    	identification="Thorax Is Medium";
	    	JOptionPane.showMessageDialog(this, identification);
	    	TextArea.setText("");
	        TextArea.append("\n");
	        TextArea.append("Identification=");
	        TextArea.append("\n\n");
	        TextArea.append(identification);
	        TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	        TextArea.append("\n");
	    }
	  
	    else 
	    {
	    	identification="Thorax Image Is Healthy";
	    	JOptionPane.showMessageDialog(this, identification);
	    	TextArea.setText("");
	        TextArea.append("\n");
	        TextArea.append("Identification=");
	        TextArea.append("\n\n");
	        TextArea.append(identification);
	        TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	        TextArea.append("\n");
	    }
	  
}

public void getPrediction()
{
	
	String stage=Identification.stage;
	
	if(stage.equalsIgnoreCase("Initial"))
	{
		TextArea.setText("");
	    TextArea.append("\n");
	    JOptionPane.showMessageDialog(this, "Disease Risk Level is Low ");
	    TextArea.append("Disease Risk Level is Low ");
	    TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	    TextArea.append("\n");
	}
	else if(stage.equalsIgnoreCase("Critical"))
	{
		TextArea.setText("");
	    TextArea.append("\n");
	    TextArea.append("Disease Risk Level is High and Thorax Positive");
	    JOptionPane.showMessageDialog(this, "Disease Risk Level is High and Thorax Positive ");
	    TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	    TextArea.append("\n");
	}
	else
	{
		TextArea.setText("");
	    TextArea.append("\n");
	    TextArea.append("No Any Disease Risk and Thorax Negative");
	    JOptionPane.showMessageDialog(this, "No Any Disease Risk and Thorax Negative");
	    TextArea.setFont(new Font("Arial", Font.BOLD, 22));
	    TextArea.append("\n");
		
	}
}

public void report()
{
	try
	  {
		
		String uemail=LoginView.uemail;
		
		String report=appPath+"/report.pdf";
		
		UserDao ud=new UserDao();
		
		ArrayList<UserBean> details = new ArrayList<UserBean>();
		
		details=ud.userDetails(uemail);
		
		PDF p=new PDF();
		
		PDF.generateReport(TumorArea, stageofTumor, patientname, report,identification);
		
		String sql="insert into tbl_results(area,stage,name) values(?,?,?)";
		
		Connection con=DBConnect.getConnection();
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, TumorArea);
		ps.setString(2, stageofTumor);
		ps.setString(3, patientname);
		
		int index = ps.executeUpdate();

		
		
		JOptionPane.showMessageDialog(this, "Report Generated Successfully!!!");
		Desktop desktop = Desktop.getDesktop();
		File file = new File(report);
		desktop.open(file);
	  }
	catch(Exception e)
	{
	   JOptionPane.showMessageDialog(this, e.getMessage());
	   e.printStackTrace();
	}
	  
}


private void initComponents() 
   {

     jLabel1 = new javax.swing.JLabel();
     path = new javax.swing.JLabel();
     filename = new javax.swing.JLabel();
     showimage = new javax.swing.JLabel();
     
     clustlbl1= new javax.swing.JLabel();
     clustlbl2= new javax.swing.JLabel();
     clustlbl3= new javax.swing.JLabel();
     clustlbl4= new javax.swing.JLabel();
     
     browse_btn = new javax.swing.JButton();
     original_btn = new javax.swing.JButton();
     gray_btn = new javax.swing.JButton(); 
     filter_btn = new javax.swing.JButton();
     kmeans_btn = new javax.swing.JButton();
     fuzzy_btn= new javax.swing.JButton();
     thresh_btn= new javax.swing.JButton();
     detect_btn= new javax.swing.JButton();
     area_btn= new javax.swing.JButton();
     stage_btn= new javax.swing.JButton();
     identification_btn= new javax.swing.JButton();
     prediction_btn= new javax.swing.JButton();
     report_btn= new javax.swing.JButton();
     back_btn= new javax.swing.JButton();
     exit_btn= new javax.swing.JButton();
     
     mainPanel= new javax.swing.JPanel();
     TextArea = new javax.swing.JTextArea();
     
     jScrollPane1 = new javax.swing.JScrollPane();
     jScrollPane2 = new javax.swing.JTextArea();	

     setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
     getContentPane().setLayout(null);
     
     setContentPane(new JLabel(new ImageIcon("images\\3D2.jpg")));

     
     jLabel1.setText("Thorax Detection System Using Machine Learning");
     jLabel1.setFont(new Font("Arial", Font.BOLD, 20));
     jLabel1.setForeground(Color.BLACK);
     getContentPane().add(jLabel1);
     jLabel1.setBounds(330, 30, 600, 16);

     /*jScrollPane1.setViewportView(showimage);
     getContentPane().add(jScrollPane1);
     jScrollPane1.setBounds(330, 70, 400, 375);*/
     
     mainPanel.revalidate();
     mainPanel.add(showimage);
     getContentPane().add(mainPanel);
     mainPanel.setBounds(330, 90, 600, 650);
     
     browse_btn.setText("Select Image");
     //browse_btn.setForeground(new java.awt.Color(51, 51, 255));
     browse_btn.setForeground(Color.BLACK);
     getContentPane().add(browse_btn);
     browse_btn.setBounds(150, 70, 150, 30);
     browse_btn.addActionListener(new ActionListener() 
     {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			browse_btnActionPerformed(e);	
			
		}
	});
    
     original_btn.setText("Original Image");
     original_btn.setForeground(Color.BLACK);
     getContentPane().add(original_btn);
     original_btn.setBounds(150, 110, 150, 30);
     original_btn.addActionListener(new ActionListener() 
     {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			original_btnActionPerformed(e);	
			
		}
	});
     
    gray_btn.setText("Gray Image");
    gray_btn.setForeground(Color.BLACK);
    getContentPane().add(gray_btn);
    gray_btn.setBounds(150, 150, 150, 30);
    gray_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			gray_btnActionPerformed(e);	
			
		}
	});
     
    filter_btn.setText("Filter Image");
    filter_btn.setForeground(Color.BLACK);
    getContentPane().add(filter_btn);
    filter_btn.setBounds(150, 190, 150, 30);
    filter_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			filter_btnActionPerformed(e);	
			
		}
	});
    
    kmeans_btn.setText("Segmentation");
    kmeans_btn.setForeground(Color.BLACK);
    getContentPane().add(kmeans_btn);
    kmeans_btn.setBounds(150, 230, 150, 30);
    kmeans_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			kmeans_btnActionPerformed(e);	
			mainPanel.removeAll();
			mainPanel.add(clustlbl1);
			mainPanel.revalidate();
			mainPanel.add(clustlbl2);
			mainPanel.revalidate();
			mainPanel.add(clustlbl3);
			mainPanel.revalidate();
			mainPanel.add(clustlbl4);
			mainPanel.revalidate();
			
			/*jScrollPane1.repaint();
			jScrollPane1.setViewportView(clustlbl1);
			jScrollPane1.setViewportView(clustlbl2);
			jScrollPane1.setViewportView(clustlbl3);
			jScrollPane1.setViewportView(clustlbl4);*/
		}
	});
    
    
    fuzzy_btn.setText("Feature Extraction");
    fuzzy_btn.setForeground(Color.BLACK);
    getContentPane().add(fuzzy_btn);
    fuzzy_btn.setBounds(150,270, 150, 30);
    fuzzy_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			fuzzy_btnActionPerformed(e);	
			mainPanel.removeAll();
			mainPanel.updateUI();
			mainPanel.add(showimage);
			mainPanel.revalidate();
			getContentPane().add(mainPanel);
		}
	});
    
    
    thresh_btn.setText("Classification");
    thresh_btn.setForeground(Color.BLACK);
    getContentPane().add(thresh_btn);
    thresh_btn.setBounds(150, 310, 150, 30);
    thresh_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			thresh_btnActionPerformed(e);	
			
		}
	});
    
    
    detect_btn.setText("Detect Area");
    detect_btn.setForeground(Color.BLACK);
    getContentPane().add(detect_btn);
    detect_btn.setBounds(150, 350, 150, 30);
    detect_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			detect_btnActionPerformed(e);	
			
		}
	});
    
    area_btn.setText("Area of Thorax");
    area_btn.setForeground(Color.BLACK);
    getContentPane().add(area_btn);
    area_btn.setBounds(150, 390, 150, 30);
    area_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			area_btnActionPerformed(e);	
			getContentPane().add(TextArea);
			TextArea.setBounds(950, 70, 300, 275);
			TextArea.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
			TextArea.setEditable(false);
		}
	});
    
    stage_btn.setText("Stage of Thorax");
    stage_btn.setForeground(Color.BLACK);
    getContentPane().add(stage_btn);
    stage_btn.setBounds(150, 430, 150, 30);
    stage_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			stage_btnActionPerformed(e);
			getContentPane().add(TextArea);
			TextArea.setBounds(950, 70, 300, 275);
			TextArea.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
			TextArea.setEditable(false);	
			
		}
	});
  
    
    prediction_btn.setText("Prediction");
    prediction_btn.setForeground(Color.BLACK);
    getContentPane().add(prediction_btn);
    prediction_btn.setBounds(150, 470, 150, 30);
    prediction_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			prediction_btnActionPerformed(e);
			getContentPane().add(TextArea);
			TextArea.setBounds(950, 70, 300, 275);
			TextArea.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
			
		}
	});
    
    report_btn.setText("Report");
    report_btn.setForeground(Color.BLACK);
    getContentPane().add(report_btn);
    report_btn.setBounds(150, 510, 150, 30);
    report_btn.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			report_btnActionPerformed(e);	
			
		}
	});
   
   back_btn.setText("Back");
   back_btn.setForeground(Color.BLACK);
   getContentPane().add(back_btn);
   back_btn.setBounds(150, 550, 150, 30);
   back_btn.addActionListener(new ActionListener() 
   {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			UserHome ip=new UserHome();
			dispose();
		}
	});
    
   exit_btn.setText("Exit");
   exit_btn.setForeground(Color.BLACK);
   getContentPane().add(exit_btn);
   exit_btn.setBounds(150, 590, 150, 30);
   exit_btn.addActionListener(new ActionListener() 
   {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			//threshold_btnActionPerformed(e);
			File[] flist=dest.listFiles();
	     	   if(flist.length>0)
	     	   {
	     		   for(File f:flist)
	     		   {
	     			  f.delete(); 
	     		   }
	     	   }
			dispose();
		}
	});
   
   path.setFont(new Font("Arial", Font.BOLD, 16));
   path.setForeground(Color.BLACK);
   getContentPane().add(path);
   path.setBounds(20, 680, 1000, 30);
            
     pack();
     
  }  

  private void browse_btnActionPerformed(java.awt.event.ActionEvent evt) 
   { 
	   showImage();  
   } 
  private void original_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  showOriginalImage();  
  } 
  private void gray_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  showGrayImage();
  } 
  private void filter_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  showFilterImage();
  }
  
  private void kmeans_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  showClusters();
  }
  private void fuzzy_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	 showFuzzyClusters();
  }
  
  private void thresh_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	 showThresholdImage();
  }
  private void detect_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  showTumorDetection();
  }
  private void area_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	 areaOfTumor();
  }
  private void stage_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	 stageOfTumor();
  }
 
  private void prediction_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  getPrediction();
  }
  private void report_btnActionPerformed(java.awt.event.ActionEvent evt) 
  { 
	  report();
  }
 
  
   // Variables declaration - do not modify 
   private javax.swing.JButton browse_btn,original_btn,gray_btn,filter_btn, kmeans_btn, fuzzy_btn,thresh_btn,detect_btn,area_btn, stage_btn,identification_btn,prediction_btn,report_btn,back_btn, exit_btn;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel showimage,clustlbl1,clustlbl2,clustlbl3,clustlbl4;
   private javax.swing.JLabel path,filename;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JPanel mainPanel;
   private javax.swing.JTextArea jScrollPane2,TextArea;

   // End of variables declaration 

    private boolean check() 
    {
      if(filePath!=null) 
      {
       if(filePath.endsWith(".jpeg")||filePath.endsWith(".gif")||filePath.endsWith(".jpg")||filePath.endsWith(".JPEG")||filePath.endsWith(".GIF")||filePath.endsWith(".JPG")||filePath.endsWith(".png"))
        {
         return true;
        }
        return false;
       }
       return false;
    }
}