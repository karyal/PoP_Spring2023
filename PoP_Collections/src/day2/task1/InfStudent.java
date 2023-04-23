package day2.task1;

import java.util.ArrayList;

public interface InfStudent {
	public boolean save(Student student);
	public Student search(int  sid);
	public boolean edit(Student student);
	public boolean delete(Student student);
	public ArrayList allStudents();
}