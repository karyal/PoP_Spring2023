package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.StudentController;
import models.Student;

public class ManageStudent extends JFrame implements ActionListener{
	
	JLabel lblSid, lblName, lblCourse;
	JTextField txtSid, txtName, txtCourse;
	JButton btnSave, btnClose;
	
	public ManageStudent() {
		setTitle("Manage Student");
		setSize(275, 175);
		setResizable(false);
		
		lblSid=new JLabel("SID : ");
		lblName=new JLabel("NAME : ");
		lblCourse=new JLabel("COURSE : ");
		
		txtSid = new JTextField();
		txtName = new JTextField();
		txtCourse = new JTextField();
		
		btnSave=new JButton("SAVE");
		btnSave.addActionListener(this);
		btnClose=new JButton("CLOSE");
		
		setLayout(new GridLayout(4, 2));
		add(lblSid);add(txtSid);
		add(lblName);add(txtName);
		add(lblCourse);add(txtCourse);
		add(btnSave);add(btnClose);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ManageStudent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSave) {
			//save
			//read values from textbox
			int sid=Integer.parseInt(txtSid.getText());
			String name = txtName.getText();
			String course = txtCourse.getText();
			Student s1 = new Student(sid, name, course);
			StudentController sc = new StudentController(); 
			boolean result = sc.save(s1);
			if(result==true) {
				JOptionPane.showMessageDialog(this, "Save record");
				txtSid.setText("");
				txtName.setText("");
				txtCourse.setText("");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error to save record");
			}
		}
		
	}

}
