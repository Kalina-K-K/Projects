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
		panel.add(question1, BorderLayout.LINE_START);
		JTextField answer1 = new JTextField(20);
		panel.add(answer1, BorderLayout.LINE_END);
		JLabel question2 = new JLabel("Question 2");
		panel.add(question2);
		JTextField answer2 = new JTextField(20);
		panel.add(answer2);
		JLabel question3 = new JLabel("Question 3");
		panel.add(question3);
		JTextField answer3 = new JTextField(20);
		panel.add(answer3);
		JLabel question4 = new JLabel("Question 4");
		panel.add(question4);
		JTextField answer4 = new JTextField(20);
		panel.add(answer4);
		JLabel question5 = new JLabel("Question 5");
		panel.add(question5);
		JTextField answer5 = new JTextField(20);
		panel.add(answer5);
		JLabel question6 = new JLabel("Question 6");
		panel.add(question6);
		JTextField answer6 = new JTextField(20);
		panel.add(answer6);
		JButton clearButton = new JButton("clear");
		panel.add(clearButton);
		JButton submitButton = new JButton("submit");
		panel.add(submitButton);
		
		frame.setVisible(true);
	}

}
