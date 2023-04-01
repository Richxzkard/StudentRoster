package labs.lab9;
import java.util.ArrayList;

class StudentRoster{
	ArrayList<Student> Roster;
	
	public StudentRoster(){
		Roster = new ArrayList<Student>();
	}
	
	public void add(Student new_student) {
		Roster.add(new_student);
	}
	
	public void delete(int index) {
		Roster.remove(index);
	}
	
	
}