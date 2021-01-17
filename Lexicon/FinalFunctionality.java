package proekt1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FinalFunctionality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Lexicon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 2, 3, 3));
        frame.add(panel, BorderLayout.CENTER);
		JLabel question1 = new JLabel("Име: ");
		panel.add(question1, BorderLayout.LINE_START);
		JTextField answer1 = new JTextField(20);
		panel.add(answer1, BorderLayout.LINE_END);
		JLabel question2 = new JLabel("Дата на раждане: ");
		panel.add(question2);
		JTextField answer2 = new JTextField(20);
		panel.add(answer2);
		JLabel question3 = new JLabel("Какъв/каква мечтаеше да станеш като беше по-малък/малка?");
		panel.add(question3);
		JTextField answer3 = new JTextField(20);
		panel.add(answer3);
		JLabel question4 = new JLabel("Ако книгата на живота ти е в ръцете ти, би ли прочел/а последната страница?");
		panel.add(question4);
		JTextField answer4 = new JTextField(20);
		panel.add(answer4);
		JLabel question5 = new JLabel("Нещо, което те кара да се усмихваш: ");
		panel.add(question5);
		JTextField answer5 = new JTextField(20);
		panel.add(answer5);
		JLabel question6 = new JLabel("Любим спомен: ");
		panel.add(question6);
		JTextField answer6 = new JTextField(20);
		panel.add(answer6);
		
		question1.setVerticalAlignment(SwingConstants.CENTER);
        question1.setHorizontalAlignment(SwingConstants.CENTER);
        question2.setVerticalAlignment(SwingConstants.CENTER);
        question2.setHorizontalAlignment(SwingConstants.CENTER);
        question3.setVerticalAlignment(SwingConstants.CENTER);
        question3.setHorizontalAlignment(SwingConstants.CENTER);
        question4.setVerticalAlignment(SwingConstants.CENTER);
        question4.setHorizontalAlignment(SwingConstants.CENTER);
        question5.setVerticalAlignment(SwingConstants.CENTER);
        question5.setHorizontalAlignment(SwingConstants.CENTER);
        question6.setVerticalAlignment(SwingConstants.CENTER);
        question6.setHorizontalAlignment(SwingConstants.CENTER);
        
		File myObj = new File("lexicon.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			answer1.setText("");
			answer2.setText("");	
			answer3.setText("");	
			answer4.setText("");	
			answer5.setText("");	
			answer6.setText("");	
			}
		});
		panel.add(clearButton);

		JButton submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ans1 = answer1.getText();
				String ans2 = answer2.getText();
				String ans3 = answer3.getText();
				String ans4 = answer4.getText();
				String ans5 = answer5.getText();
				String ans6 = answer6.getText();
				
				if (ans1.isEmpty() || ans2.isEmpty() || ans3.isEmpty() || 
						ans4.isEmpty() || ans5.isEmpty() || ans6.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please answer all the questions!");
				}else {
				String text = ans1 + "\n" + ans2 + "\n" + ans3 + "\n"
				+ ans4 + "\n" + ans5 + "\n" + ans6 + "\n" + "\n";
				try {
					FileWriter myWriter = new FileWriter("lexicon.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				
//				File myObj = new File("lexicon.txt");
//				text = "";
//				try {
//					Scanner myReader = new Scanner(myObj);
//					while (myReader.hasNextLine()) {
//						text += myReader.nextLine() + "\n";
//					}
//					myReader.close();
//				} catch (FileNotFoundException e) {
//					try {
//						myObj.createNewFile();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Тhank you for filling in my lexicon!");
				}
			}
		});
		panel.add(submitButton);
		frame.pack();
		frame.setVisible(true);
	}

}
