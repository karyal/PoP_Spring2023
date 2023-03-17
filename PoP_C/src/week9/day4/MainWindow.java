package week9.day4;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	JComboBox cmbAges;
	
	public MainWindow() {
		this.setSize(250, 150);
		this.setResizable(false);
		
		cmbAges=new JComboBox();
		cmbAges.setBounds(10, 10, 200, 30);
		//get values from database
		ArrayList ages = new MyDatabase().getAges();
		System.out.println(ages);
		//add ages in combobox?
		this.setLayout(null);
		this.add(cmbAges);
		this.setVisible(true);
	}
	
	public static void main(String []args) {
		new MainWindow();
	}
}
