package todo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SecondTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("2021 to do list");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel listPanel = new JPanel();
		SpringLayout layout = new SpringLayout();
		listPanel.setLayout(layout);
		JLabel label = new JLabel("2021 To Do List");
//		label.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,
				0,
                SpringLayout.HORIZONTAL_CENTER, listPanel);
        layout.putConstraint(SpringLayout.NORTH, label,
                5,
                SpringLayout.NORTH, listPanel);
		listPanel.add(label);
		JTextField wish1 = new JTextField();
//		wish1.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		layout.putConstraint(SpringLayout.WIDTH, wish1,
				0,
                SpringLayout.WIDTH, listPanel);
        layout.putConstraint(SpringLayout.NORTH, wish1,
                5,
                SpringLayout.SOUTH, label);
		listPanel.add(wish1);
		JTextField wish2 = new JTextField();
//		wish2.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		layout.putConstraint(SpringLayout.WIDTH, wish2,
				0,
                SpringLayout.WIDTH, listPanel);
        layout.putConstraint(SpringLayout.NORTH, wish2,
                5,
                SpringLayout.SOUTH, wish1);
		listPanel.add(wish2);
		JTextField wish3 = new JTextField();
//		wish3.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		layout.putConstraint(SpringLayout.WIDTH, wish3,
				0,
                SpringLayout.WIDTH, listPanel);
        layout.putConstraint(SpringLayout.NORTH, wish3,
                5,
                SpringLayout.SOUTH, wish2);
		listPanel.add(wish3);
		JButton newWish = new JButton("Add to list");
//		newWish.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		layout.putConstraint(SpringLayout.WIDTH, newWish,
				0,
                SpringLayout.WIDTH, listPanel);
        layout.putConstraint(SpringLayout.NORTH, newWish,
                5,
                SpringLayout.SOUTH, wish3);
		newWish.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField newOne = new JTextField();
				layout.putConstraint(SpringLayout.WIDTH, newOne,
						0,
		                SpringLayout.WIDTH, listPanel);
		        layout.putConstraint(SpringLayout.NORTH, newOne,
		                5,
		                SpringLayout.SOUTH, wish3);
		        layout.putConstraint(SpringLayout.WIDTH, newWish,
						0,
		                SpringLayout.WIDTH, listPanel);
		        layout.putConstraint(SpringLayout.NORTH, newWish,
		                5,
		                SpringLayout.SOUTH, newOne);
				listPanel.add(newOne);
				frame.pack();
				frame.repaint();
			}
			
		});
		listPanel.add(newWish);
//		layout.putConstraint(SpringLayout.WIDTH, listPanel,
//                5,
//                SpringLayout.WIDTH, newWish);
        layout.putConstraint(SpringLayout.SOUTH, listPanel,
                5,
                SpringLayout.SOUTH, newWish);
		
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
		contentPanel.add(buttonPanel, BorderLayout.PAGE_END);
		frame.add(contentPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
