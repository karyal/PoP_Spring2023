package views;

//Event Handle
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.UserManager;
import models.User;

public class LoginWindow extends JFrame implements ActionListener {
	JTextField txtUser, txtPass; //Declare
	JButton btnLogin, btnClose;
	
	public LoginWindow() {//Constructor
		this.setTitle("Login Window");
		this.setSize(250, 175);//width, height
		this.setResizable(false);
		
		txtUser = new JTextField(); //Initialize
		txtUser.setBounds(20, 10, 160, 25);
		
		txtPass = new JTextField();
		txtPass.setBounds(20, 40, 160, 25);
		
		btnLogin=new JButton();
		btnLogin.addActionListener(this);//Event
		btnLogin.setText("Login");
		btnLogin.setBounds(20, 70, 75, 25);
		
		btnClose=new JButton();
		btnClose.addActionListener(this);//Event
		btnClose.setText("Close");
		btnClose.setBounds(100, 70, 75, 25);
		
		this.setLayout(null);
		this.add(txtUser);
		this.add(txtPass);
		this.add(btnLogin);
		this.add(btnClose);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnClose) {
			this.dispose(); //Exit
		}
		else if(ae.getSource()==btnLogin) {
			//do login
			User user = new User();
			user.setUserName(txtUser.getText());
			user.setPassword(txtPass.getText());
			UserManager userManager=new UserManager();
			boolean result = userManager.login(user);
			if(result == true) {
				JOptionPane.showMessageDialog(this, "Welcome!");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error to Login!");
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginWindow();

	}
}
