package proekt2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

//import project2.Picture;
//import project.MergeSort;
//import project.ParkingSpace;

public class MainWindow{
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
        showWindow();                                
	}
    
	public static void showWindow() {
		
		int count=0;
		String text = "";
		File file = new File("ranklist.txt");
		University[] uni = new University[10];
		for(int i=0;i<10;i++) {
			uni[i] = new University();
		}
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				for(int i=0;i<40;i++) {
				text = sc.nextLine();
				count++;
				if(count%4==2) {
					uni[i/4].setName(text);
				}else if(count%4==3) {
					uni[i/4].setCountry(text);
				}else if(count%4==0) {
					uni[i/4].setCost(Integer.parseInt(text));
				}else if(count%4==1) {
					uni[i/4].setRankingNum(Integer.parseInt(text));
				}
			}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		CostComparator costc = new CostComparator();
		CountryComparator countryc = new CountryComparator();
		RankNumComparator rnc = new RankNumComparator();
		
		
		JFrame frame = new JFrame("University Ranking");  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
	    frame.setSize(850,600);                        
	    frame.getContentPane().setLayout(null);       
	                                                   
	    frame.setLocationRelativeTo(null);             
	    
		JLabel name = new JLabel(uni[0].getName());
	    name.setBounds(360,120,300,20);
	    frame.getContentPane().add(name);
		    
	    JLabel rankNum = new JLabel(""+uni[0].getRankingNum());
	    rankNum.setBounds(420,170,150,20);
	    frame.getContentPane().add(rankNum);
		    
	    JLabel country = new JLabel(uni[0].getCountry());
	    country.setBounds(380,220,150,20);
	    frame.getContentPane().add(country);
		    
	    JLabel cost = new JLabel(""+uni[0].getCost());
	    cost.setBounds(360,270,150,20);
		frame.getContentPane().add(cost);
		

       

	    JLabel lbl = new JLabel("Name: ");
	    lbl.setBounds(320, 120, 150, 20);
	    frame.getContentPane().add(lbl);
	    

	    JLabel lbl2 = new JLabel("Ranking number: ");
	    lbl2.setBounds(320, 170, 150, 20);
	    frame.getContentPane().add(lbl2);
	    
	    JLabel label = new JLabel("Country: ");
	    label.setBounds(320, 220, 150, 20);
	    frame.getContentPane().add(label);
	    
	    JLabel label2 = new JLabel("Cost: ");
	    label2.setBounds(320, 270, 150, 20);
	    frame.getContentPane().add(label2);
	    
	    
	    JLabel label3 = new JLabel("Personal opinion: ");
	    label3.setBounds(320, 320, 150, 20);
	    frame.getContentPane().add(label3);
	    
	    JTextArea opinionTxt = new JTextArea();
	    opinionTxt.setBounds(310, 350, 230, 50);
	    opinionTxt.setLineWrap(true);
	    frame.getContentPane().add(opinionTxt);
	    
	    JLabel opinion = new JLabel();
	    opinion.setBounds(330, 270, 250, 20);
	    frame.getContentPane().add(opinion);
	    
	    
	    
	    
	    
	    JButton prevBtn = new JButton("Previous");  
	    prevBtn.setBounds(100, 50, 110, 40);
	    Color lightYellow = new Color(255,255,204);    
	    prevBtn.setBackground(lightYellow);      
	    Color colorBtn = new Color(255,102,102);
	    prevBtn.setForeground(colorBtn);        
	    frame.getContentPane().add(prevBtn);
	    prevBtn.addActionListener(new ActionListener(){        
	    	public void actionPerformed(ActionEvent e){  
	    		String currUni = rankNum.getText();
	    		for(int i=0;i<10;i++) {
	    			if(uni[i].getRankingNum()==Integer.parseInt(currUni)) {
	    				try {
	    				isTherePrevious(i);
	    				name.setText(uni[i-1].getName());
	    				rankNum.setText(""+uni[i-1].getRankingNum());
	    				country.setText(uni[i-1].getCountry());
	    				cost.setText(""+uni[i-1].getCost());
	    				}catch (NoPrevOrNextExc ex) {
	    					JOptionPane.showMessageDialog(frame, ex);
	    				}
	    			}
	    		}
	        }  
	    }); 
		
	    JButton nextBtn = new JButton("Next");
	    nextBtn.setBounds(600,50,110, 40);
	    nextBtn.setBackground(lightYellow);            
	    nextBtn.setForeground(colorBtn);
	    frame.getContentPane().add(nextBtn);
	    nextBtn.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		String currUni = rankNum.getText();
	    		for(int i=0;i<10;i++) {
	    			if(uni[i].getRankingNum()==Integer.parseInt(currUni)) {
	    				try {
	    				isThereNext(i);
	    				name.setText(uni[i+1].getName());
	    				rankNum.setText(""+uni[i+1].getRankingNum());
	    				country.setText(uni[i+1].getCountry());
	    				cost.setText(""+uni[i+1].getCost());
	    				}catch(NoPrevOrNextExc ex) {
	    					JOptionPane.showMessageDialog(frame, ex);
	    				}
	    			}
	    		}
	        }  
	    }); 
	    
	   
	    JButton saveBtn = new JButton("Save changes");
	    saveBtn.setBounds(260, 500, 120, 40);
	    Color colorBtn1 = new Color(255,70,70);
	    saveBtn.setBackground(colorBtn1);
	    saveBtn.setForeground(Color.PINK);            
	    frame.getContentPane().add(saveBtn);
	    saveBtn.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		
	        }  
	    }); 
		
	    JButton numSort = new JButton("Sort by ranking number");
	    numSort.setBounds(340, 430, 170, 40);
	  //  Color colorBtn1 = new Color(255,70,70);
	    numSort.setBackground(Color.pink);
	    numSort.setForeground(colorBtn1);             
	    frame.getContentPane().add(numSort);
	    numSort.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		MergeSort.mergeSort(uni, rnc);
	    		name.setText(uni[0].getName());
				rankNum.setText(""+uni[0].getRankingNum());
				country.setText(uni[0].getCountry());
				cost.setText(""+uni[0].getCost());
	    		}});
	    
	    JButton unSort = new JButton("Sort by country");  
	    unSort.setBounds(150, 430, 140, 40);  
	    unSort.setBackground(Color.pink);
	    unSort.setForeground(colorBtn1);
	    frame.getContentPane().add(unSort);
	    unSort.addActionListener(new ActionListener(){        
	    	public void actionPerformed(ActionEvent e){
	    		MergeSort.mergeSort(uni, countryc);
	    		name.setText(uni[0].getName());
				rankNum.setText(""+uni[0].getRankingNum());
				country.setText(uni[0].getCountry());
				cost.setText(""+uni[0].getCost());
	    	}
	    });
	    
	    JButton areaSort = new JButton("Sort by costs");  
	    areaSort.setBounds(570, 430, 140, 40);  
	    areaSort.setBackground(Color.pink);
	    areaSort.setForeground(colorBtn1);
	    frame.getContentPane().add(areaSort);
	    areaSort.addActionListener(new ActionListener(){        
	    	public void actionPerformed(ActionEvent e){
	    		MergeSort.mergeSort(uni, costc);
	    		name.setText(uni[0].getName());
				rankNum.setText(""+uni[0].getRankingNum());
				country.setText(uni[0].getCountry());
				cost.setText(""+uni[0].getCost());
	    	}
	    });
	    
	    JButton change = new JButton("Change");  
	    change.setBounds(450, 500, 120, 40); 
	    change.setBackground(colorBtn1);
	    change.setForeground(Color.PINK); 
	    frame.getContentPane().add(change);
	    change.addActionListener(new ActionListener(){        
	    	public void actionPerformed(ActionEvent e){
	    		
	    		
	    	}
	    });
	    
		
		
	    frame.setVisible(true);
		
	    
		
	}
	
	public static void isTherePrevious(int i) throws NoPrevOrNextExc {
		if(i<=0) {
			throw new NoPrevOrNextExc("\nThis is the first university");
		}
	}
	public static void isThereNext(int i) throws NoPrevOrNextExc {
		if(i>=9) {
			throw new NoPrevOrNextExc("\nThis is the last university");
		}
	}
	}
