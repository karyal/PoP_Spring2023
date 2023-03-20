package day2.myjdbc;

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

public class CRUD2 extends JFrame implements ActionListener {
	JLabel lblID, lblName;
	JTextField txtID, txtName;
	JButton btnSave, btnSearch, btnSelect, btnEdit, btnDelete, btnClose;

	// Table
	String[] columnNames = { "PID", "NAME" };
	JTable table1;
	DefaultTableModel tableModel;
	JScrollPane scroll;

	public CRUD2() {
		this.setTitle("CRUD-DEMO");
		this.setSize(450, 415);
		this.setResizable(false);
		this.setLayout(null);

		lblID = new JLabel("ID : ");
		lblID.setBounds(10, 15, 75, 25);
		lblName = new JLabel("NAME : ");
		lblName.setBounds(10, 45, 75, 25);

		txtID = new JTextField();
		txtID.setBounds(90, 15, 175, 25);

		txtName = new JTextField();
		txtName.setBounds(90, 45, 175, 25);

		btnSave = new JButton("SAVE");
		btnSave.setBounds(90, 75, 80, 25);
		btnSave.addActionListener(this);

		btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(175, 75, 90, 25);
		btnSearch.addActionListener(this);

		btnSelect = new JButton("SELECT");
		btnSelect.setBounds(90, 105, 80, 25);
		btnSelect.addActionListener(this);

		btnEdit = new JButton("EDIT");
		btnEdit.setBounds(175, 105, 90, 25);
		btnEdit.addActionListener(this);

		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(90, 135, 80, 25);
		btnDelete.addActionListener(this);

		btnClose = new JButton("CLOSE");
		btnClose.setBounds(175, 135, 90, 25);
		btnClose.addActionListener(this);

		// Table
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		table1 = new JTable();
		table1.setModel(tableModel);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table1.setFillsViewportHeight(true);
		scroll = new JScrollPane(table1);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(90, 175, 250, 175);

		updateTable();

		this.add(lblID);
		this.add(txtID);
		this.add(lblName);
		this.add(txtName);
		this.add(btnSave);
		this.add(btnSelect);
		this.add(btnSearch);
		this.add(btnEdit);
		this.add(btnDelete);
		this.add(btnClose);
		this.add(scroll);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CRUD2();
	}

	public void updateTable() {
		tableModel.setRowCount(0);
		ArrayList persons = new JDBC().all();
		for (int i = 0; i < persons.size(); i++) {
			Person person = (Person) persons.get(i);
			tableModel.addRow(new Object[] { person.getPid(), person.getName() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			this.dispose();
		} else if (e.getSource() == btnSave) {
			// save
			int pid = Integer.parseInt(txtID.getText());
			String name = txtName.getText();
			Person p1 = new Person(pid, name);
			boolean result = new JDBC().insert(p1);
			if (result) {
				updateTable();
				JOptionPane.showMessageDialog(this, "Record Saved");
			} else {
				JOptionPane.showMessageDialog(this, "Error to save record");
			}
		} else if (e.getSource() == btnSearch) {
			// search
			int pid = Integer.parseInt(txtID.getText());
			Person person = new JDBC().search(pid);
			if (person.getPid() >= 1) {
				this.txtName.setText(person.getName());
				JOptionPane.showMessageDialog(this, "Record found and display!");
			} else {
				this.txtID.setText("");
				this.txtName.setText("");
				JOptionPane.showMessageDialog(this, "Record not found");
			}
		} else if (e.getSource() == btnEdit) {
			// edit
			int pid = Integer.parseInt(txtID.getText());
			String name = txtName.getText();
			Person person = new Person(pid, name);
			boolean result = new JDBC().update(person);
			if (result) {
				updateTable();
				JOptionPane.showMessageDialog(this, "Record updated!");
			} else {
				JOptionPane.showMessageDialog(this, "Error to update record");
			}
		} else if (e.getSource() == btnDelete) {
			// delete
			int pid = Integer.parseInt(txtID.getText());
			boolean result = new JDBC().delete(pid);
			if (result) {
				updateTable();
				txtID.setText("");
				txtName.setText("");
				JOptionPane.showMessageDialog(this, "Record Deleted!");
			} else {
				JOptionPane.showMessageDialog(this, "Error to delete record");
			}
		}
		else if (e.getSource() == btnSelect) {
			// Select
			int rowID = table1.getSelectedRow();
			txtID.setText(table1.getValueAt(rowID, 0).toString());
			txtName.setText(table1.getValueAt(rowID, 1).toString());			
		}
	}
}