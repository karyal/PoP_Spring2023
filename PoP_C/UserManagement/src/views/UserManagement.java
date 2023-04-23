package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.UserController;
import models.User;

public class UserManagement extends JFrame implements ActionListener{
	
	JLabel lblID, lblName, lblPhone, lblEmail, lblUser, lblPass, lblRole;
	JTextField txtID, txtName,txtPhone, txtEmail, txtUser, txtPass, txtRole;
	JButton btnSave, btnClose, btnSearch, btnEdit, btnDelete;
	
	//Table
	String[] columnNames = {"ID", "Name","Phone","Email","User","Password","Role"};
	JTable table1;
	DefaultTableModel tableModel;
	JScrollPane scroll;
	
	public UserManagement() {
		this.setTitle("User Management");
		this.setSize(720, 575);
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
		btnSearch=new JButton("Search");
		btnSearch.setBounds(10, 250, 100, 25);
		btnSearch.addActionListener(this);
		btnEdit=new JButton("Edit");
		btnEdit.setBounds(110, 250, 100, 25);
		btnEdit.addActionListener(this);
		btnDelete=new JButton("Delete");
		btnDelete.setBounds(10, 280, 100, 25);
		btnDelete.addActionListener(this);
		
		//Table settings
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		table1=new JTable();
		table1.setModel(tableModel); 
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table1.setFillsViewportHeight(true);
		scroll = new JScrollPane(table1);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 310, 500, 250);
		
		//Get all users
		ArrayList users = new UserController().all();
		//System.out.println(users.size());
		for(int i=0; i<users.size(); i++) {
			User tmpUser = (User) users.get(i);//get individual user
			//publish on table
			tableModel.addRow(new Object[]{tmpUser.getUid(), tmpUser.getFullname(), tmpUser.getPhone(), tmpUser.getEmail(), tmpUser.getLoginname(), tmpUser.getLoginpass(), tmpUser.getRole()});
		}
		this.add(lblID);this.add(txtID);
		this.add(lblName); this.add(txtName);
		this.add(lblPhone); this.add(txtPhone);
		this.add(lblEmail); this.add(txtEmail);
		this.add(lblUser); this.add(txtUser);
		this.add(lblPass); this.add(txtPass);
		this.add(lblRole); this.add(txtRole);
		this.add(btnSave); this.add(btnClose);
		this.add(btnSearch);this.add(btnEdit);
		this.add(btnDelete);
		this.add(scroll);
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
		else if(e.getSource()==btnSearch) {
			//search
			int tmpUid = Integer.parseInt(txtID.getText());
			User user = new UserController().search(tmpUid);
			if(user == null || user.getUid()==0) {
				//found
				JOptionPane.showMessageDialog(this, "User not find");
			}
			else {
				JOptionPane.showMessageDialog(this, "User find successfully");
				txtName.setText(user.getFullname());
				txtPhone.setText(user.getPhone());
				txtEmail.setText(user.getEmail());
				txtUser.setText(user.getLoginname());
				txtPass.setText(user.getLoginpass());
				txtRole.setText(user.getRole());
			}
		}
		else if(e.getSource()==btnEdit) {
			//Save
			User user = new User(Integer.parseInt(txtID.getText()), txtName.getText(), txtPhone.getText(), txtEmail.getText(), txtUser.getText(), txtPass.getText(), txtRole.getText());
			boolean result = new UserController().edit(user);
			if(result==true) {
				//edit messages
				JOptionPane.showMessageDialog(this, "Update user successfully");
			}
			else {
				//error message
				JOptionPane.showMessageDialog(this, "Error to update record");
			}
			
		}
		else if(e.getSource()==btnDelete) {
			//delete record
			int tmpUID = Integer.parseInt(txtID.getText());
			boolean result = new UserController().delete(tmpUID);
			if(result==true) {
				//edit messages
				JOptionPane.showMessageDialog(this, "Delete user successfully");
			}
			else {
				//error message
				JOptionPane.showMessageDialog(this, "Error to delete record");
			}
		}
		
	}

}
