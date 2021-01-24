package todo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThirdTry {
	
	JPanel checkBoxPanel = new JPanel();
	JPanel listPanel = new JPanel();

	public void textToCheck(JTextField field) {
		String str = field.getText();
		boolean empty = str.isEmpty();
		if(!empty) {
		JCheckBox wish = new JCheckBox(str);
		wish.setAlignmentX(Component.LEFT_ALIGNMENT);
		checkBoxPanel.add(wish);
		}
	}
	
	public void newListPanel(JPanel panel) {
		Component[] comp = panel.getComponents();
		int broi = comp.length;
		
		for(int i=0; i<broi;i++) {
			panel.remove(comp[i]);
		}
		JTextField wish1 = new JTextField();
		wish1.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		panel.add(wish1);
		JTextField wish2 = new JTextField();
		wish2.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		panel.add(wish2);
		JTextField wish3 = new JTextField();
		wish3.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		panel.add(wish3);
	}

	
	public ThirdTry() {
		JFrame frame = new JFrame("2021 to do list");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		
		JLabel label = new JLabel("2021 To Do List");
		label.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		
		contentPanel.add(label);
		contentPanel.add(checkBoxPanel);
		newListPanel(listPanel);
		contentPanel.add(listPanel, BorderLayout.CENTER);
		
		
		JButton newWish = new JButton("Add to list");
		newWish.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		newWish.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField newOne = new JTextField();
				listPanel.add(newOne);
				frame.pack();
				frame.repaint();
			}
			
		});
		
		
		JButton newListButton = new JButton("Start new list");
		newListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new ThirdTry();
			}
			
		});
		buttonPanel.add(newListButton);
		
		
		
		JButton submitButton = new JButton("Commit changes");
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Component[] fields = listPanel.getComponents();
				int broi = fields.length;
				
				for(int i=0; i<broi;i++) {
					JTextField field = (JTextField)fields[i];
					textToCheck(field);
				}
				newListPanel(listPanel);
				frame.pack();
				frame.repaint();
			}
			
		});
		buttonPanel.add(submitButton);
		contentPanel.add(newWish);
		contentPanel.add(buttonPanel, BorderLayout.PAGE_END);

		frame.add(contentPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThirdTry();
	}
	

}