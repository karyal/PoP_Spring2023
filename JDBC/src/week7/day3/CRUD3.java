package week7.day3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CRUD3 extends JFrame implements ActionListener{
	JLabel lblPID;
	JLabel lblName;
	JTextField txtPID;
	JTextField txtName;
	JButton btnSave, btnSearch, btnEdit, btnDelete, btnClose;
	
	public CRUD3() {
		setTitle("CRUD-3");
		setSize(350, 250);
		setResizable(false);
		
		//
		lblPID=new JLabel("PID : ");
		lblName=new JLabel("NAME : ");
		txtPID=new JTextField();
		txtName=new JTextField();
		btnSave=new JButton("SAVE");
		btnSave.addActionListener(this);
		
		btnSearch=new JButton("SEARCH");
		btnSearch.addActionListener(this);
		
		btnEdit=new JButton("EDIT");
		btnDelete=new JButton("DELETE");
		btnClose=new JButton("CLOSE");
		
		setLayout(new GridLayout(5, 2));
		add(lblPID);add(txtPID);
		add(lblName);add(txtName);
		add(btnSave);add(btnSearch);
		add(btnEdit); add(btnDelete);
		add(btnClose);add(new JLabel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CRUD3();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSave) {
			//read values
			int pid=Integer.parseInt(txtPID.getText());
			String name = txtName.getText();
			Person p1 = new Person(pid, name);
			CRUD2 crud2 = new CRUD2();
			boolean result = crud2.inserRecord(p1);
			if(result) {
				JOptionPane.showMessageDialog(this, "Save Record");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error to save");
			}
			//send to save
		}
		else if(e.getSource()==btnSearch) {
			//read pid
			int pid=Integer.parseInt(txtPID.getText());
			Person p1;
			CRUD2 crud2 = new CRUD2();
			p1= crud2.search(pid);
			if(p1.getPid()>0) {
				txtName.setText(p1.getName());
				JOptionPane.showMessageDialog(this, "Record found");
			}
			else {
				JOptionPane.showMessageDialog(this, "Record not found");
				txtName.setText("");
			}
			//search record based on pid
			//display result
		}
		
	}

}
