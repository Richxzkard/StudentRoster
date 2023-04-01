package labs.lab9;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

class StudentRosterDriver{
	private boolean adding = false;
	private StudentRoster roster;
	private Student current_student;
	private JFrame frame;
	private JPanel main_panel;
	private JPanel name_panel;
	private JPanel breed_panel;
	private JPanel phone_panel;
	private JPanel student_status;
	private JPanel course_panel;
	private JPanel tuition_panel;
	private JPanel notes_panel;
	private JPanel action_panel;
	private JPanel navigate_panel;
	
	private JLabel label_name;
	private JLabel label_breed;
	private JLabel label_phone;
	private JLabel label_course;
	private JLabel label_tuition;
	private JLabel label_notes;
	private JTextField field_name;
	private JTextField field_phone;
	private JComboBox breed_selections;
	private JRadioButton new_student;
	private JRadioButton returning_student;
	private JCheckBox agility_training;
	private JCheckBox obedience_1;
	private JCheckBox obedience_2;
	private JCheckBox puppy_etiquette;
	private JCheckBox tricks;
	private JButton new_stu;
	private JButton save_stu;
	private JButton delete_stu;
	private JButton previous;
	private JButton next;
	private ButtonGroup group;
	private JScrollPane notes;
	private JTextArea notes_area;
	private ActionListener new_listener;
	private ActionListener save_listener;
	private ActionListener previous_listener;
	private ActionListener next_listener;
	private ActionListener delete_listener;
	
	public StudentRosterDriver(){
		//creating panels
		roster = new StudentRoster();
		adding = true;
		current_student = new Student();
		
		frame = new JFrame();
		main_panel = new JPanel();
		name_panel = new JPanel();
		breed_panel = new JPanel();
		phone_panel = new JPanel();
		student_status = new JPanel();
		course_panel = new JPanel();
		tuition_panel = new JPanel();
		notes_panel = new JPanel();
		action_panel = new JPanel();
		navigate_panel = new JPanel();
		notes_panel.setLayout(new BorderLayout());
		main_panel.setLayout(new GridLayout(9,1));
		
		//creating modules
		label_name = new JLabel("Name:");
		field_name = new JTextField(22);
		
		label_breed = new JLabel("Breed:");
		breed_selections = new JComboBox();
		breed_selections.addItem("Bulldog");
		breed_selections.addItem("Chihuahua");
		breed_selections.addItem("French Bulldog");
		breed_selections.addItem("German Shepherd");
		breed_selections.addItem("Golden Retriever");
		breed_selections.addItem("Labrador Retriever");
		breed_selections.addItem("Pomeranian");
		breed_selections.addItem("Poodle");
		breed_selections.addItem("Pug");
		breed_selections.addItem("Siberian Husky");
		breed_selections.addItem("Other");
		
		label_phone = new JLabel("Phone:");
		field_phone = new JTextField(22);
		
		group = new ButtonGroup();
		new_student = new JRadioButton("New Student");
		returning_student = new JRadioButton("Returning Student");
		group.add(new_student);
		group.add(returning_student);
		
		label_course = new JLabel("Courses:");
		agility_training = new JCheckBox("Agility Training");
		obedience_1 = new JCheckBox("Obedience 1");
		obedience_2 = new JCheckBox("Obedience 2");
		puppy_etiquette = new JCheckBox("Puppy Etiquette");
		tricks = new JCheckBox("Tricks");
		
		label_tuition = new JLabel("Tuition: $0.00");
		
		label_notes = new JLabel("                   Notes:");
		notes_area = new JTextArea();
		notes = new JScrollPane(notes_area);
		
		new_stu = new JButton("New");
		save_stu = new JButton("Save");
		delete_stu = new JButton("Delete");
		
		previous =  new JButton("<<Previous");
		next = new JButton("Next>>");
		previous.setEnabled(false);
		next.setEnabled(false);
		
		//packing
		name_panel.add(label_name);
		name_panel.add(field_name);
		
		breed_panel.add(label_breed);
		breed_panel.add(breed_selections);
		
		phone_panel.add(label_phone);
		phone_panel.add(field_phone);
		
		student_status.add(new_student);
		student_status.add(returning_student);
		
		course_panel.add(label_course);
		course_panel.add(agility_training);
		course_panel.add(obedience_1);
		course_panel.add(obedience_2);
		course_panel.add(puppy_etiquette);
		course_panel.add(tricks);
		
		tuition_panel.add(label_tuition);
		
		notes_panel.add(label_notes, BorderLayout.WEST);
		notes_panel.add(notes, BorderLayout.CENTER);
		
		action_panel.add(new_stu);
		action_panel.add(save_stu);
		action_panel.add(delete_stu);
		
		navigate_panel.add(previous);
		navigate_panel.add(next);
		
		main_panel.add(name_panel);
		main_panel.add(breed_panel);
		main_panel.add(phone_panel);
		main_panel.add(student_status);
		main_panel.add(course_panel);
		main_panel.add(tuition_panel);
		main_panel.add(notes_panel);
		main_panel.add(action_panel);
		main_panel.add(navigate_panel);
		
		frame.add(main_panel);
		frame.setSize(400,550);
		frame.setTitle("Zikang Xiong - 41815789");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		class NewListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				field_name.setText("");
				field_phone.setText("");
				breed_selections.setSelectedIndex(0);
				group.clearSelection();
				agility_training.setSelected(false);
				obedience_1.setSelected(false);
				obedience_2.setSelected(false);
				puppy_etiquette.setSelected(false);
				tricks.setSelected(false);
				label_tuition.setText("Tuition: $0.00");
				notes_area.setText("");
				current_student = new Student();
				adding = true;
			}
		}
		new_listener = new NewListener();
		new_stu.addActionListener(new_listener);
		
		
		class SaveListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempname = field_name.getText();
				if (!adding) {
					if (current_student.name!=tempname) {
						for (Student s:roster.Roster) {
							if (s.name.equals(tempname)) current_student.is_valid = false;
						}
					}
					else current_student.is_valid = true;
				}
				if (adding) {
					for (Student s:roster.Roster) {
						if (s.name.equals(tempname)) current_student.is_valid = false;
					}
				}
				String tempbreed = (String) breed_selections.getSelectedItem();
				String tempphone = field_phone.getText();
				String tempstatus = "";
				if (new_student.isSelected()) tempstatus = "New Student";
				if (returning_student.isSelected()) tempstatus = "Returning Student";
				if (agility_training.isSelected()) current_student.add_course("Agility Training");
				if (obedience_1.isSelected()) current_student.add_course("Obedience 1");
				if (obedience_2.isSelected()) current_student.add_course("Obedience 2");
				if (puppy_etiquette.isSelected()) current_student.add_course("Puppy Etiquette");
				if (tricks.isSelected()) current_student.add_course("Tricks");
				for (String s:current_student.courses) current_student.addtuition();
				String tempnotes = notes_area.getText();
				
				current_student.set_name(tempname);
				current_student.set_breed(tempbreed);
				current_student.set_phone(tempphone);
				current_student.set_status(tempstatus);
				current_student.set_notes(tempnotes);
				
				if (!current_student.is_valid) {
					JFrame tempframe = new JFrame();
					JPanel temppanel = new JPanel();
					JLabel templabel = new JLabel("Invalid input!");
					
					temppanel.add(templabel);
					tempframe.add(temppanel);
					tempframe.setSize(100,100);
					tempframe.setTitle("Error");
					tempframe.setVisible(true);
					
					if (adding) {
						adding = true;
						current_student = new Student();
					}
				}
				else{
					if (adding) {
						JFrame tempframe = new JFrame();
						JPanel temppanel = new JPanel();
						JLabel templabel = new JLabel("Student Added!");
						String temp_tui = Double.toString(100*current_student.courses.size());
						label_tuition.setText("Tuition: $"+temp_tui);
						
						temppanel.add(templabel);
						tempframe.add(temppanel);
						tempframe.setSize(100,100);
						tempframe.setTitle("Success");
						tempframe.setVisible(true);
						roster.add(current_student);
						adding = false;
					}
					else {
						JFrame tempframe = new JFrame();
						JPanel temppanel = new JPanel();
						JLabel templabel = new JLabel("Changes saved!");
						String temp_tui = Double.toString(100*current_student.courses.size());
						label_tuition.setText("Tuition: $"+temp_tui);
						
						temppanel.add(templabel);
						tempframe.add(temppanel);
						tempframe.setSize(100,100);
						tempframe.setTitle("Success");
						tempframe.setVisible(true);
					}	
				}
				if (roster.Roster.size()==0||roster.Roster.size()==1) {
					previous.setEnabled(false);
					next.setEnabled(false);
				}
				else {
					if (roster.Roster.indexOf(current_student)==0) {
						previous.setEnabled(false);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)>0&&roster.Roster.indexOf(current_student)<roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)==roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(false);
					}
				}
			}
		}
		save_listener = new SaveListener();
		save_stu.addActionListener(save_listener);
		
		
		class PreviousListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				current_student = roster.Roster.get(roster.Roster.indexOf(current_student)-1);
				field_name.setText(current_student.name);
				field_phone.setText(current_student.phone);
				breed_selections.setSelectedItem(current_student.breed);;
				if (current_student.student_status.equals("New Student")) new_student.setSelected(true);
				else returning_student.setSelected(true);
				
				
				agility_training.setSelected(false);
				obedience_1.setSelected(false);
				obedience_2.setSelected(false);
				puppy_etiquette.setSelected(false);
				tricks.setSelected(false);
				if (current_student.courses.contains("Agility Training")) agility_training.setSelected(true);
				if (current_student.courses.contains("Obedience 1")) obedience_1.setSelected(true);
				if (current_student.courses.contains("Obedience 2")) obedience_2.setSelected(true);
				if (current_student.courses.contains("Puppy Etiquette")) puppy_etiquette.setSelected(true);
				if (current_student.courses.contains("Tricks")) tricks.setSelected(true);
				String temp_tui = Double.toString(100*current_student.courses.size());
				label_tuition.setText("Tuition: $"+temp_tui);
				notes_area.setText(current_student.notes);
				if (roster.Roster.size()==0||roster.Roster.size()==1) {
					previous.setEnabled(false);
					next.setEnabled(false);
				}
				else {
					if (roster.Roster.indexOf(current_student)==0) {
						previous.setEnabled(false);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)>0&&roster.Roster.indexOf(current_student)<roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)==roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(false);
					}
				}
			}
		}
		previous_listener = new PreviousListener();
		previous.addActionListener(previous_listener);
		
		
		class NextListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				current_student = roster.Roster.get(roster.Roster.indexOf(current_student)+1);
				field_name.setText(current_student.name);
				field_phone.setText(current_student.phone);
				breed_selections.setSelectedItem(current_student.breed);;
				if (current_student.student_status.equals("New Student")) new_student.setSelected(true);
				else returning_student.setSelected(true);
				
				agility_training.setSelected(false);
				obedience_1.setSelected(false);
				obedience_2.setSelected(false);
				puppy_etiquette.setSelected(false);
				tricks.setSelected(false);
				if (current_student.courses.contains("Agility Training")) agility_training.setSelected(true);
				if (current_student.courses.contains("Obedience 1")) obedience_1.setSelected(true);
				if (current_student.courses.contains("Obedience 2")) obedience_2.setSelected(true);
				if (current_student.courses.contains("Puppy Etiquette")) puppy_etiquette.setSelected(true);
				if (current_student.courses.contains("Tricks")) tricks.setSelected(true);
				String temp_tui = Double.toString(100*current_student.courses.size());
				label_tuition.setText("Tuition: $"+temp_tui);
				notes_area.setText(current_student.notes);
				if (roster.Roster.size()==0||roster.Roster.size()==1) {
					previous.setEnabled(false);
					next.setEnabled(false);
				}
				else {
					if (roster.Roster.indexOf(current_student)==0) {
						previous.setEnabled(false);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)>0&&roster.Roster.indexOf(current_student)<roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(true);
					}
					else if (roster.Roster.indexOf(current_student)==roster.Roster.size()-1) {
						previous.setEnabled(true);
						next.setEnabled(false);
					}
				}
			}
		}
		next_listener = new NextListener();
		next.addActionListener(next_listener);
		
		
		class DeleteListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if (roster.Roster.size()!=0) {
					roster.Roster.remove(current_student);
					JFrame tempframe = new JFrame();
					JPanel temppanel = new JPanel();
					JLabel templabel = new JLabel("Student Deleted!");
					
					temppanel.add(templabel);
					tempframe.add(temppanel);
					tempframe.setSize(100,100);
					tempframe.setTitle("Success");
					tempframe.setVisible(true);
					if (roster.Roster.size()==0) {
						current_student = new Student();
						field_name.setText("");
						field_phone.setText("");
						breed_selections.setSelectedIndex(0);
						group.clearSelection();
						agility_training.setSelected(false);
						obedience_1.setSelected(false);
						obedience_2.setSelected(false);
						puppy_etiquette.setSelected(false);
						tricks.setSelected(false);
						label_tuition.setText("Tuition: $0.00");
						notes_area.setText("");
						current_student = new Student();
						adding = true;
						previous.setEnabled(false);
						next.setEnabled(false);
					}
					else {
						current_student = roster.Roster.get(0);
						field_name.setText(current_student.name);
						field_phone.setText(current_student.phone);
						breed_selections.setSelectedItem(current_student.breed);
						if (current_student.student_status.equals("New Student")) new_student.setSelected(true);
						else returning_student.setSelected(true);
						
						agility_training.setSelected(false);
						obedience_1.setSelected(false);
						obedience_2.setSelected(false);
						puppy_etiquette.setSelected(false);
						tricks.setSelected(false);
						if (current_student.courses.contains("Agility Training")) agility_training.setSelected(true);
						if (current_student.courses.contains("Obedience 1")) obedience_1.setSelected(true);
						if (current_student.courses.contains("Obedience 2")) obedience_2.setSelected(true);
						if (current_student.courses.contains("Puppy Etiquette")) puppy_etiquette.setSelected(true);
						if (current_student.courses.contains("Tricks")) tricks.setSelected(true);
						String temp_tui = Double.toString(100*current_student.courses.size());
						label_tuition.setText("Tuition: $"+temp_tui);
						notes_area.setText(current_student.notes);
						if (roster.Roster.size()==1||roster.Roster.size()==0) {
							previous.setEnabled(false);
							next.setEnabled(false);
						}
						else {
							if (roster.Roster.indexOf(current_student)==0) {
								previous.setEnabled(false);
								next.setEnabled(true);
							}
							else if (roster.Roster.indexOf(current_student)>0&&roster.Roster.indexOf(current_student)<roster.Roster.size()-1) {
								previous.setEnabled(true);
								next.setEnabled(true);
							}
							else if (roster.Roster.indexOf(current_student)==roster.Roster.size()-1) {
								previous.setEnabled(true);
								next.setEnabled(false);
							}
						}
					}
				}
				}
			
		}
		delete_listener = new DeleteListener();
		delete_stu.addActionListener(delete_listener);
	}
}