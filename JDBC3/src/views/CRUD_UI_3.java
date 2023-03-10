package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.JDBC3;
import models.NewPerson;

public class CRUD_UI_3 extends JFrame implements ActionListener {
	JLabel lblPID, lblName, lblAddress, lblEmail;
	JTextField txtPID, txtName, txtAddress, txtEmail;
	JButton btnSave, btnEdit, btnDelete, btnSearch, btnSelect, btnClose;
	
	String[] columnNames = {"PID", "NAME", "ADDRESS", "EMAIL"};
	JTable tblPerson;
	DefaultTableModel tableModel;
	JScrollPane scroll;
	
	public CRUD_UI_3() {
		setTitle("CRUD-3 Application");
		setSize(550, 450);
		setLayout(null);
		
		lblPID=new JLabel("PID : ");
		lblPID.setBounds(20,  10, 100, 25);
		
		lblName=new JLabel("NAME : ");
		lblName.setBounds(20,  40, 100, 25);
		
		lblAddress=new JLabel("ADDRESS : ");
		lblAddress.setBounds(20,  70, 100, 25);
		
		lblEmail=new JLabel("EMAL : ");
		lblEmail.setBounds(20,  100, 100, 25);
		
		txtPID=new JTextField();
		txtPID.setBounds(130,  10, 175, 25);
		
		txtName=new JTextField();
		txtName.setBounds(130,  40, 175, 25);
		
		txtAddress=new JTextField();
		txtAddress.setBounds(130,  70, 175, 25);
		
		txtEmail=new JTextField();
		txtEmail.setBounds(130,  100, 175, 25);
		
		btnSave=new JButton("SAVE");
		btnSave.addActionListener(this);
		btnSave.setBounds(130,  130, 75, 25);	
		
		btnSearch=new JButton("SEARCH");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(210,  130, 85, 25);
				
		btnEdit=new JButton("EDIT");
		btnEdit.addActionListener(this);
		btnEdit.setBounds(130,  160, 75, 25);
		
		btnDelete=new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(210,  160, 85, 25);
		
		btnSelect=new JButton("SELECT");
		btnSelect.addActionListener(this);
		btnSelect.setBounds(130,  350, 85, 25);
		
		btnClose=new JButton("CLOSE");
		btnClose.addActionListener(this);
		btnClose.setBounds(225,  350, 85, 25);
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		tblPerson=new JTable();
		tblPerson.setModel(tableModel); 
		tblPerson.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblPerson.setFillsViewportHeight(true);
		scroll = new JScrollPane(tblPerson);
		scroll.setBounds(20, 190, 500, 150);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		refreshTable();
		
		add(lblPID);add(txtPID);
		add(lblName);add(txtName);
		add(lblAddress);add(txtAddress);
		add(lblEmail);add(txtEmail);
		add(btnSave);add(btnSearch);
		add(btnEdit);add(btnDelete);
		add(scroll);
		add(btnSelect); add(btnClose);
		setVisible(true);
	}		
	
	public void refreshTable() {
		List persons = new JDBC3().allPersons();
		tableModel.setNumRows(0);
		for(int i=0; i<persons.size(); i++) {
			//System.out.println(persons.get(i));
			NewPerson tmpPerson = (NewPerson) persons.get(i);
			tableModel.addRow(new Object[]{tmpPerson.getPid(), tmpPerson.getName(),tmpPerson.getAddress(),tmpPerson.getEmail()});
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnClose) {
			this.dispose();
		}
		else if(ae.getSource()==btnSelect) { //Row Selection
			int selectedRow = tblPerson.getSelectedRow();			
			String pid, name, address, email;
			pid=tblPerson.getValueAt(0, 0).toString();
			name=tblPerson.getValueAt(selectedRow, 1).toString();
			address=tblPerson.getValueAt(selectedRow, 2).toString();
			email=tblPerson.getValueAt(selectedRow, 3).toString();
			
			txtPID.setText(pid);
			txtName.setText(name);
			txtAddress.setText(address);
			txtEmail.setText(email);
		}
		else if(ae.getSource()==btnSearch) { //Search based on ID
			int pid;
			String name, address, email;
			pid=Integer.parseInt(txtPID.getText());						
			NewPerson person= new JDBC3().search(pid);
			if(person.getPid()>0) {				
				txtName.setText(person.getName());
				txtAddress.setText(person.getAddress());
				txtEmail.setText(person.getEmail());
				JOptionPane.showMessageDialog(this,"Record found and display successfully");								
			}
			else{
				JOptionPane.showMessageDialog(this,"Error to search record");  
			}
		}
		else if(ae.getSource()==btnEdit) { //Edit or Update
			int pid;
			String name, address, email;
			pid=Integer.parseInt(txtPID.getText());
			name=txtName.getText();
			address=txtAddress.getText();
			email=txtEmail.getText();
			boolean result = new JDBC3().update(pid, name, address, email);
			if(result) {
				refreshTable();
				JOptionPane.showMessageDialog(this,"Record update successfully");
				txtPID.setText("");
				txtName.setText("");
				txtAddress.setText("");
				txtEmail.setText("");				
			}
			else{
				JOptionPane.showMessageDialog(this,"Error to update record");  
			}
		}
		else if(ae.getSource()==btnDelete) { //Delete
			int pid;			
			pid=Integer.parseInt(txtPID.getText());			
			boolean result = new JDBC3().delete(pid);
			if(result) {
				refreshTable();
				JOptionPane.showMessageDialog(this,"Record delete successfully");
				txtPID.setText("");
				txtName.setText("");
				txtAddress.setText("");
				txtEmail.setText("");				
			}
			else{
				JOptionPane.showMessageDialog(this,"Error to delete record");  
			}
		}
		else if(ae.getSource()==btnSave) { //Save
			int pid;
			String name, address, email;
			pid=Integer.parseInt(txtPID.getText());
			name=txtName.getText();
			address=txtAddress.getText();
			email=txtEmail.getText();
			boolean result = new JDBC3().insert(pid, name, address, email);
			if(result) {
				refreshTable();
				JOptionPane.showMessageDialog(this,"Record insert successfully");
				txtPID.setText("");
				txtName.setText("");
				txtAddress.setText("");
				txtEmail.setText("");
			}
			else{
				JOptionPane.showMessageDialog(this,"Error to insert record");  
			}
		}
	}
	
	public static void main(String[] args) {
		new CRUD_UI_3();
	}
}