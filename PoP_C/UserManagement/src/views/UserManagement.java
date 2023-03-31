package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.UserController;
import models.User;

public class UserManagement extends JFrame implements ActionListener{
	
	JLabel lblID, lblName, lblPhone, lblEmail, lblUser, lblPass, lblRole;
	JTextField txtID, txtName,txtPhone, txtEmail, txtUser, txtPass, txtRole;
	JButton btnSave, btnClose;
	
	public UserManagement() {
		this.setTitle("User Management");
		this.setSize(350, 450);
		this.setResizable(false);
		this.setLayout(null);
		
		lblID=new JLabel("ID : ");
		lblID.setBounds(10, 10, 150, 25);
		lblName=new JLabel("Name : ");
		lblName.setBounds(10, 40, 150, 25);
		lblPhone=new JLabel("Pone:  ");
		lblPhone.setBounds(10, 70, 150, 25);
		lblEmail=new JLabel("Email: ");
		lblEmail.setBounds(10, 100, 150, 25);
		lblUser=new JLabel("User:  ");
		lblUser.setBounds(10, 130, 150, 25);
		lblPass=new JLabel("Pass: ");
		lblPass.setBounds(10, 160, 150, 25);
		lblRole=new JLabel("Role: ");
		lblRole.setBounds(10, 190, 150, 25);
		
		txtID = new JTextField();
		txtID.setBounds(160, 10, 150, 25);
		txtName = new JTextField();
		txtName.setBounds(160, 40, 150, 25);
		txtPhone = new JTextField();
		txtPhone.setBounds(160, 70, 150, 25);
		txtEmail = new JTextField();
		txtEmail.setBounds(160, 100, 150, 25);
		txtUser = new JTextField();
		txtUser.setBounds(160, 130, 150, 25);
		txtPass = new JTextField();
		txtPass.setBounds(160, 160, 150, 25);
		txtRole = new JTextField();
		txtRole.setBounds(160, 190, 150, 25);
		btnSave=new JButton("Save");
		btnSave.setBounds(10, 220, 100, 25);
		btnSave.addActionListener(this);
		btnClose=new JButton("Close");
		btnClose.setBounds(110, 220, 100, 25);
		btnClose.addActionListener(this);
		
		this.add(lblID);this.add(txtID);
		this.add(lblName); this.add(txtName);
		this.add(lblPhone); this.add(txtPhone);
		this.add(lblEmail); this.add(txtEmail);
		this.add(lblUser); this.add(txtUser);
		this.add(lblPass); this.add(txtPass);
		this.add(lblRole); this.add(txtRole);
		this.add(btnSave); this.add(btnClose);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserManagement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnClose) {
			this.dispose();
		}
		else if(e.getSource()==btnSave) {
			//Save
			User user = new User(0, txtName.getText(), txtPhone.getText(), txtEmail.getText(), txtUser.getText(), txtPass.getText(), txtRole.getText());
			boolean result = new UserController().save(user);
			if(result==true) {
				//Save message
				JOptionPane.showMessageDialog(this, "Save user successfully");
			}
			else {
				//error message
				JOptionPane.showMessageDialog(this, "Error to save record");
			}
		}
		
	}

}
