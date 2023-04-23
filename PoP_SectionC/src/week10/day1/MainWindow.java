package week10.day1;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class MainWindow extends JFrame implements ActionListener{
	
	JComboBox cmbAges;
	JButton btnRefresh;
	
	public MainWindow() { 
		this.setSize(450, 150);
		this.setResizable(false);
		
		cmbAges=new JComboBox();
		cmbAges.setBounds(10, 10, 200, 30);
		//get values from database
		ArrayList ages = new MyDatabase().getAges();
		//add ages in combobox?
		for(int i=0; i<ages.size(); i++) {
			System.out.println(ages.get(i));
			cmbAges.addItem(ages.get(i));
		}
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(215, 10, 200, 30);
		btnRefresh.addActionListener(this);
		
		this.setLayout(null);
		this.add(cmbAges);
		this.add(btnRefresh);
		this.setVisible(true);
	}
	
	public static void main(String []args) {
		new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRefresh) {
			//get values from database
			ArrayList ages = new MyDatabase().getAges();
			//add ages in combobox?
			cmbAges.removeAll();//?
			for(int i=0; i<ages.size(); i++) {
				cmbAges.addItem(ages.get(i));
			}
		}
		
	}
}
