package proekt1;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstVersion2_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Lexicon");
		frame.setSize(350, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 2));
        frame.add(panel, BorderLayout.CENTER);
		JLabel question1 = new JLabel("Question 1");
		question1.setBounds(10, 20, 80, 25);
		panel.add(question1, BorderLayout.LINE_START);
		JTextField answer1 = new JTextField(20);
		answer1.setBounds(100, 20, 205, 25);
		panel.add(answer1, BorderLayout.LINE_END);
		JLabel question2 = new JLabel("Question 2");
		question2.setBounds(10, 50, 80, 25);
		panel.add(question2);
		JTextField answer2 = new JTextField(20);
		answer2.setBounds(100, 50, 205, 25);
		panel.add(answer2);
		JLabel question3 = new JLabel("Question 3");
		question3.setBounds(10, 80, 80, 25);
		panel.add(question3);
		JTextField answer3 = new JTextField(20);
		answer3.setBounds(100, 80, 205, 25);
		panel.add(answer3);
		JLabel question4 = new JLabel("Question 4");
		question4.setBounds(10, 110, 80, 25);
		panel.add(question4);
		JTextField answer4 = new JTextField(20);
		answer4.setBounds(100, 110, 205, 25);
		panel.add(answer4);
		JLabel question5 = new JLabel("Question 5");
		question5.setBounds(10, 140, 80, 25);
		panel.add(question5);
		JTextField answer5 = new JTextField(20);
		answer5.setBounds(100, 140, 205, 25);
		panel.add(answer5);
		JLabel question6 = new JLabel("Question 6");
		question6.setBounds(10, 170, 80, 25);
		panel.add(question6);
		JTextField answer6 = new JTextField(20);
		answer6.setBounds(100, 170, 205, 75);
		panel.add(answer6);
		JButton clearButton = new JButton("clear");
		clearButton.setBounds(10, 250, 80, 25);
		panel.add(clearButton);
		JButton submitButton = new JButton("submit");
		submitButton.setBounds(245, 250, 80, 25);
		panel.add(submitButton);
		
		frame.setVisible(true);
	}

}
