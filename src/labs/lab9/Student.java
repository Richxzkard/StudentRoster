package labs.lab9;
import java.util.ArrayList;

class Student{
	boolean is_valid = true;
	String name;
	String phone;
	String breed;
	String student_status;
	ArrayList<String> courses;
	double tuition;
	String notes;
	
	
	public Student() {
		this.name = "";
		this.phone = "";
		this.breed = "";
		this.student_status = "";
		this.courses = new ArrayList<String>();
		this.tuition = 0.00;
		this.notes = "";
	}
	
	public void set_name(String name) {
		this.name = name;
		if (name.equals("")) is_valid = false;
	}
	
	public void set_phone(String phone) {
		this.phone = phone;
		String pattern = "[0-9]*$";
		if (phone.equals("")) is_valid = false;
		if (!phone.matches(pattern)) is_valid = false;
	}
	
	public void set_breed(String breed) {
		this.breed = breed;
	}
	
	public void set_status(String status) {
		this.student_status = status;
		if (status.equals("")) is_valid = false;
	}
	
	public void add_course(String course) {
		this.courses.add(course);
	}
	
	public void set_notes(String notes) {
		this.notes = notes;
	}
	
	public void addtuition() {
		this.tuition += 100;
	}
	
	public void droptuition() {
		this.tuition -= 100;
	}
}