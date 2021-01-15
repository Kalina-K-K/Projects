package todo;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("2021 to do list");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JLabel label = new JLabel("2021 To Do List");
		label.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		listPanel.add(label);
		JTextField wish1 = new JTextField();
		wish1.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		listPanel.add(wish1);
		JTextField wish2 = new JTextField();
		wish2.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		listPanel.add(wish2);
		JTextField wish3 = new JTextField();
		wish3.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		listPanel.add(wish3);
		JButton newWish = new JButton("Add to list");
		newWish.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		JButton newListButton = new JButton("Start new list");
		buttonPanel.add(newListButton);
		JButton submitButton = new JButton("Commit changes");
		buttonPanel.add(submitButton);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		contentPanel.add(listPanel, BorderLayout.CENTER);
		contentPanel.add(newWish);
		contentPanel.add(buttonPanel, BorderLayout.PAGE_END);
		frame.add(contentPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
