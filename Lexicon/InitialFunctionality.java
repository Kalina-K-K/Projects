package proekt1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InitialFunctionality {

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
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Тhank you for filling in my lexicon!");
			}
		});
		panel.add(submitButton);
		frame.pack();
		frame.setVisible(true);
	}

}
