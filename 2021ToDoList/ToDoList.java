package todo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoList {
	// правим всичко като клас, след което единствената работа на мейн метода ще е 
	//да извика обект от класа
	
	// въвеждаме тези два панела тук, защото ще ни трябват за няколко метода
	JPanel checkBoxPanel = new JPanel();
	JPanel listPanel = new JPanel();
	
	//при всяко отваряне се избира нов цвят
	Random r=new Random();
	Color randomColor=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
	
	//метод, който запазва текст и състояние на чекбокс във файл
	public void toFile(JCheckBox box) {
		//създава се файл
		File myObj = new File("ToDoList.txt");
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
		//проверяваме дали чекбоксът е чекнат
		boolean isChecked;
		if(box.isSelected()) {
			isChecked = true;
		}else {
			isChecked = false;
		}
		String checkText = box.getText();
		
		text = checkText + "\n" + isChecked + "\n";
		//записваме във файла 
		try {
			FileWriter myWriter = new FileWriter("ToDoList.txt",true);
			myWriter.write(text);
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	//метод, който взима текста от текстово поле и го "превръща" в чекбокс
	public void textToCheck(JTextField field) {
		String str = field.getText();
		//проверява писано ли е изобщо в текстовото поле
		boolean empty = str.isEmpty();
		if(!empty) {
		JCheckBox wish = new JCheckBox(str);
		wish.setBackground(randomColor);
		wish.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		checkBoxPanel.add(wish);
		}
	}
	//метод, който "чисти" информацията от listPanel-a и прави нов чист такъв
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
	// метод със зададен файл и панел. Чете информацията от файла и я превръща в чекбоксове,
	//които се добавят към панела
	public void createCheckBoxPanel(File file, JPanel panel) {
		String text="";
		String selected;
		boolean isItSelected = false;
		try {
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				text = myReader.nextLine();
				//прочитаме първо текста и после състоянието на чекбокса и ги взимаме като стойности
				if(myReader.hasNextLine()) {
					selected = myReader.nextLine();
					if(selected.equals("true")) {
						isItSelected = true;
					}else {
						isItSelected = false;
					}
				}
				//създаваме чекбокс с дадените стойности
				JCheckBox check = new JCheckBox(text, isItSelected);
				check.setBackground(randomColor);
				check.setAlignmentX(listPanel.CENTER_ALIGNMENT);
				panel.add(check);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
	public ToDoList() {		
		JFrame frame = new JFrame("2021 to do list");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		contentPanel.setBackground(randomColor);
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
		checkBoxPanel.setBackground(randomColor);
		
		//отново извикваме файла, за да можем да го ползваме в метода за създаване на ChekBoxPanel
		File myObj = new File("ToDoList.txt");
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
		createCheckBoxPanel(myObj, checkBoxPanel);
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.setBackground(randomColor);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		//създаваме отстояния от края на панела,
		//на тези разстояния от краищата ще се разполагат елементите
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		JLabel label = new JLabel("2021 To Do List");
		//задаваме размер и шрифт на текста в "заглавието"
		label.setFont(new Font("Calibri", Font.BOLD,20));
		label.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		
		contentPanel.add(label);
		contentPanel.add(checkBoxPanel);
		
		newListPanel(listPanel);
		
		contentPanel.add(listPanel, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Add to list");
		addButton.setAlignmentX(listPanel.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener(){

			@Override
			//създава ново текстово поле
			public void actionPerformed(ActionEvent arg0) {
				JTextField newOne = new JTextField();
				listPanel.add(newOne);
				frame.pack();
				frame.repaint();
			}
			
		});
		
		JButton newListButton = new JButton("Start new list");
		newListButton.addActionListener(new ActionListener() {
			//изчиства файла, затваря досегашния прозорец и отваря нов, празен
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					PrintWriter writer = new PrintWriter("ToDoList.txt");
					writer.print("");
					writer.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				frame.dispose();
				new ToDoList();
			}
			
		});
		buttonPanel.add(newListButton);
		buttonPanel.setBackground(randomColor);
		
		JButton submitButton = new JButton("Save changes");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//превръща попълнените полета в чекбоксове
				Component[] fields = listPanel.getComponents();
				int broi = fields.length;
				
				for(int i=0; i<broi;i++) {
					JTextField field = (JTextField)fields[i];
					textToCheck(field);
				}
				
				Component[] checkBoxes = checkBoxPanel.getComponents();
				int broi2 = checkBoxes.length;
				//трие досегашната информация от файла,за да запише новата и да няма повторения
				try {
					PrintWriter writer = new PrintWriter("ToDoList.txt");
					writer.print("");
					writer.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//записва стойностите на чекбоксовете във файла
				for(int i=0; i<broi2;i++) {
					JCheckBox check = (JCheckBox)checkBoxes[i];
					toFile(check);
				}
				
				checkBoxPanel.setBackground(randomColor);
				newListPanel(listPanel);
				frame.pack();
				frame.repaint();
				JOptionPane.showMessageDialog(frame, "Saved successfully");
			}
			
		});
		buttonPanel.add(submitButton);
		contentPanel.add(addButton);
		contentPanel.add(buttonPanel, BorderLayout.PAGE_END);

		frame.add(contentPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//при всяко стартиране приложението се отваря в състоянието, 
		//в което е било след последното натискане на бутона commit changes, 
		//изключае полетата, които при всяко стартиране са 3 празни и цвета
		new ToDoList();
	}
	

}