package stable;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUIMain extends JFrame {

	private JPanel contentPane;
	
	private ButtonGroup accountButtons;
	private JRadioButton rdbtnSchool;
	private JRadioButton rdbtnStudent;
	private JFrame error;
	private JFrame info;
	
	private JTextField schoolTextName;
	private JTextField schoolTextGPA;
	private JTextField schoolTextDistance;
	private JComboBox schoolAward;
	
	private JTextField studentTextName;
	private JTextField studentTextGPA;
	private JTextField studentTextDistance;
	private JComboBox studentAward;
	

	private StudentList studentList;
	private SchoolList schoolList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frame = new GUIMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUIMain() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 4));
		setContentPane(contentPane);
		
		
		//final StudentList studentList = readStudentFile();
		//final SchoolList schoolList = readSchoolFile();
		
		
		/*format of columns:
		 * column 1 & 2 is school information - label, text box
		 * column 3 & 4 is student information - label, text box
		 */
		
//row 1		
		//column 1
		JLabel lblEnterSchoolInformation = new JLabel("Enter School Information:");
		lblEnterSchoolInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterSchoolInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterSchoolInformation);
			
		schoolTextName = new JTextField();
		schoolTextGPA = new JTextField();
		schoolTextDistance = new JTextField();
		schoolAward = new JComboBox();
			
		//column 2
		JLabel label1 = new JLabel("");
		contentPane.add(label1); //fill a space
		
		//column 3
		JLabel lblEnterStudentInformation = new JLabel("Enter Student Information:");
		lblEnterStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterStudentInformation);

		studentTextName = new JTextField();
		studentTextGPA = new JTextField();
		studentTextDistance = new JTextField();
		studentAward = new JComboBox();
		
		//column 4
		JLabel label2 = new JLabel("");
		contentPane.add(label2); //fill a space
		
//row 2		
		//column 1
		JLabel lblSchoolName = new JLabel("School Name:");
		contentPane.add(lblSchoolName);
		
		//column 2
		schoolTextName.setNextFocusableComponent(schoolTextGPA);
		contentPane.add(schoolTextName);
		schoolTextName.setColumns(10);
		
		//column 3
		JLabel lblStudentLabel = new JLabel("Student Name:");
		contentPane.add(lblStudentLabel);
		
		//column 4
		studentTextName.setNextFocusableComponent(studentTextGPA);
		contentPane.add(studentTextName);
		studentTextName.setColumns(10);
		
//row 3		
		//column 1
		JLabel lblMinGPA = new JLabel("Minimum GPA Requirement (0-4):");
		contentPane.add(lblMinGPA);
		
		//column 2
		schoolTextGPA.setNextFocusableComponent(schoolTextDistance);
		contentPane.add(schoolTextGPA);
		schoolTextGPA.setColumns(10);
		
		//column 3
		JLabel lblStudentGPA = new JLabel("Student GPA (0-4):");
		contentPane.add(lblStudentGPA);
		
		//column 4
		studentTextGPA.setNextFocusableComponent(studentTextDistance);
		contentPane.add(studentTextGPA);
		studentTextGPA.setColumns(10);
		
//row 4		
		//column 1
		JLabel lblMaxDistance = new JLabel("Maximum Distance in miles (0-100):");
		contentPane.add(lblMaxDistance);
		
		//column 2
		schoolTextDistance.setNextFocusableComponent(schoolAward);
		contentPane.add(schoolTextDistance);
		schoolTextDistance.setColumns(10);
		
		//column 3
		JLabel lblLocation = new JLabel("Preferred Distance in miles (0-100):");
		contentPane.add(lblLocation);
		
		//column 4
		studentTextDistance.setNextFocusableComponent(studentAward);
		contentPane.add(studentTextDistance);
		studentTextDistance.setColumns(10);
		
//row 5		
		//column 1
		JLabel lblSchoolAward = new JLabel("Select Your Preferred Award:");
		contentPane.add(lblSchoolAward);
		
		//column 2
		schoolAward.setNextFocusableComponent(studentTextName);
		schoolAward.addItem("None");
		schoolAward.addItem("Scholarship");
		schoolAward.addItem("Honors Award");
		schoolAward.addItem("Other");
		contentPane.add(schoolAward);
		
		//column 3
		JLabel lblStudentAward = new JLabel("Select Your Award:");
		contentPane.add(lblStudentAward);
		
		//column 4
		studentAward.addItem("None");
		studentAward.addItem("Scholarship");
		studentAward.addItem("Honors Award");
		studentAward.addItem("Other");
		contentPane.add(studentAward);
		
//row 6		
		//column 1
		JButton btnViewSchools = new JButton("View Schools");
		contentPane.add(btnViewSchools);
		
		btnViewSchools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSchoolsButtonActionPerformed(evt, schoolList);
            }
        });
		
		//column 2
		JButton btnEnterSchool = new JButton("Enter School Information");
		contentPane.add(btnEnterSchool);
		
		
		btnEnterSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonSchoolActionPerformed(evt, schoolList);
            }
        });
		
		//column 3
		JButton btnViewStudents = new JButton("View Students");
		contentPane.add(btnViewStudents);
		
		btnViewStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentsButtonActionPerformed(evt, studentList);
            }
        });
		
		//column 4
		JButton btnEnterStudent = new JButton("Enter Student Information");
		contentPane.add(btnEnterStudent);
		
		btnEnterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonStudentActionPerformed(evt, studentList);
            }
        });
		
//row 7	(empty row)
		//column 1
		JLabel label3 = new JLabel("");
		contentPane.add(label3); //fill a space
		//column 2
		JLabel label4 = new JLabel("");
		contentPane.add(label4); //fill a space
		//column 3
		JLabel label5 = new JLabel("");
		contentPane.add(label5); //fill a space
		//column 4
		JLabel label6 = new JLabel("");
		contentPane.add(label6); //fill a space

		
		
//row 8
		//column 1
		JLabel label7 = new JLabel("Load Your School File:");
		contentPane.add(label7);
		
		//column 2
		JTextField loadYourSchoolFile = new JTextField();
		contentPane.add(loadYourSchoolFile); //fill a space
		
		//column 3
		JLabel label8 = new JLabel("Load Your Student File:");
		contentPane.add(label8);
		
		//column 4
		JTextField loadYourStudentFile = new JTextField();
		contentPane.add(loadYourStudentFile); 
		
		//column 1
		JButton btnLoadSchoolFile = new JButton("Load Preset Schools");
		contentPane.add(btnLoadSchoolFile);
		
		btnLoadSchoolFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					loadSchoolFileActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }			
        });
		
		//column 2
		JButton btnLoadYourSchoolFile = new JButton("Load Your Schools");
		contentPane.add(btnLoadYourSchoolFile);
		
		btnLoadYourSchoolFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
					loadYourSchoolFileActionPerformed(evt);
				
            }

				
        });
		
		//column 3
		JButton btnLoadStudentFile = new JButton("Load Preset Students");
		contentPane.add(btnLoadStudentFile);
		
		btnLoadStudentFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					loadStudentFileActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		//column 4
		JButton btnLoadYourStudentFile = new JButton("Load Your Students");
		contentPane.add(btnLoadYourStudentFile);
		
		btnLoadYourStudentFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
					loadYourStudentFileActionPerformed(evt);
				
            }
        });
		
		//empty row
		JLabel label9 = new JLabel("");
		contentPane.add(label9); //fill a space
		JLabel label10 = new JLabel("");
		contentPane.add(label10); //fill a space
		JLabel label11 = new JLabel("");
		contentPane.add(label11); //fill a space
		JLabel label12 = new JLabel("");
		contentPane.add(label12); //fill a space
		
		//column 1
		JLabel label13 = new JLabel("");
		contentPane.add(label13); //fill a space
		
		JButton btnMatch = new JButton("Match");
		contentPane.add(btnMatch);
		
		btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchButtonActionPerformed(evt, schoolList, studentList);
            }
        });
		
		JButton btnSimilar = new JButton("Find Students and Schools");
		contentPane.add(btnSimilar);
				
		btnSimilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                similarButtonActionPerformed(evt, schoolList, studentList);
            }
        });
	}
		
		
	//load files
	public SchoolList readSchoolFile() throws IOException {
		SchoolList schools = new SchoolList();
		BufferedReader sch = new BufferedReader(new FileReader("Schools.txt"));
	    try {
	        String line = sch.readLine();
	        int lineCount = 1;
	        String name = null;
	        double gpa = 0.0;
	        int distance = 0;
	        String award = null;

	        while (line != null) {
	            if ((lineCount%10 == 1) || (lineCount%10 == 6)) {
	            	name = line;
	            }
	            else if ((lineCount%10 == 2) || (lineCount%10 == 7)) {
	            	gpa = Double.parseDouble(line);
	            }
	            else if ((lineCount%10 == 3) || (lineCount%10 == 8)) {
	            	distance = Integer.parseInt(line);
	            }
	            else if ((lineCount%10 == 4) || (lineCount%10 == 9)) {
	            	award = line;
	            }
	            else {
	            	School school = new School();
	            	school.setName(name);
	            	school.setGPA(gpa);
	            	school.setDistance(distance);
	            	school.setAwards(award);
	            	schools.add(school);
	            }
	            line = sch.readLine();
	            lineCount++;
	        }
	        
	    } finally {
	        sch.close();
	    }
	    return schools;
	}
	
	public StudentList readStudentFile() throws IOException {
		StudentList students = new StudentList();
		BufferedReader st = new BufferedReader(new FileReader("Students.txt"));
	    try {
	        String line = st.readLine();
	        int lineCount = 1;
	        String name = null;
	        double gpa = 0.0;
	        int distance = 0;
	        String award = null;

	        while (line != null) {
	            if ((lineCount%10 == 1) || (lineCount%10 == 6)) {
	            	name = line;
	            }
	            else if ((lineCount%10 == 2) || (lineCount%10 == 7)) {
	            	gpa = Double.parseDouble(line);
	            }
	            else if ((lineCount%10 == 3) || (lineCount%10 == 8)) {
	            	distance = Integer.parseInt(line);
	            }
	            else if ((lineCount%10 == 4) || (lineCount%10 == 9)) {
	            	award = line;
	            }
	            else {
	            	Student student = new Student();
	            	student.setName(name);
	            	student.setGPA(gpa);
	            	student.setDistance(distance);
	            	student.setAwards(award);
	            	students.add(student);
	            }
	            line = st.readLine();
	            lineCount++;
	        }
	        
	    } finally {
	        st.close();
	    }
	    
	    return students;
	}
		
		
	//button actions
	
		private void enterButtonSchoolActionPerformed(ActionEvent evt, SchoolList schoolList) {
	    	try {
	    		
	    		School school = new School();
	    		school.setName(schoolTextName.getText());
	    		school.setGPA(Double.parseDouble(schoolTextGPA.getText()));
	    		school.setDistance(Integer.parseInt(schoolTextDistance.getText()));
	    		school.setAwards(schoolAward.getItemAt(schoolAward.getSelectedIndex()).toString());

	    		schoolList.add(school);
	    		
	    		schoolTextName.setText(null);
	    		schoolTextGPA.setText(null);
	    		schoolTextDistance.setText(null);
	    		
		    	
	    		
	    	}
	    	catch(IndexOutOfBoundsException i){ //checks for invalid numbers
	    		if(Double.parseDouble(schoolTextGPA.getText())>4 | Double.parseDouble(schoolTextGPA.getText())<0|
	    			Integer.parseInt(schoolTextDistance.getText())>100 | Integer.parseInt(schoolTextDistance.getText())<0){
				JOptionPane.showMessageDialog(error,
	    			    "One or more numbers are out of range",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
	    		}
			}
			
			catch(RuntimeException r){ //checks for blank text boxes
				if(schoolTextGPA.getText().isEmpty() | schoolTextDistance.getText().isEmpty() | schoolTextName.getText().isEmpty()){
				JOptionPane.showMessageDialog(error,
	    			    "One or more entries are blank",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				
				}
				else{
					JOptionPane.showMessageDialog(error,
		    			    "Not a number",
		    			    "Entry error",
		    			    JOptionPane.ERROR_MESSAGE);
					
				}
			}
	    	
	    	
	    }
		
		private void enterButtonStudentActionPerformed(ActionEvent evt, StudentList studentList) {
			try {
				
	    		Student student = new Student();
	    		student.setName(studentTextName.getText());
	    		student.setGPA(Double.parseDouble(studentTextGPA.getText()));
	    		student.setDistance(Integer.parseInt(studentTextDistance.getText()));
	    		student.setAwards(studentAward.getItemAt(studentAward.getSelectedIndex()).toString());
	    		    		
	    		studentList.add(student);

	    		studentTextName.setText(null);
	    		studentTextGPA.setText(null);
	    		studentTextDistance.setText(null);
	    		
	    	}
			catch(IndexOutOfBoundsException i){ //checks for invalid numbers
				if(Double.parseDouble(studentTextGPA.getText())>4 | Double.parseDouble(studentTextGPA.getText())<0|
		    			Integer.parseInt(studentTextDistance.getText())>100 | Integer.parseInt(studentTextDistance.getText())<0){
				JOptionPane.showMessageDialog(error,
	    			    "One or more numbers are out of range",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				}
			}
			
			catch(RuntimeException r){ //checks for blank text boxes
				if(studentTextGPA.getText().isEmpty() | studentTextDistance.getText().isEmpty() | studentTextName.getText().isEmpty()){
				JOptionPane.showMessageDialog(error,
	    			    "One or more entries are blank",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(error,
		    			    "Not a number",
		    			    "Entry error",
		    			    JOptionPane.ERROR_MESSAGE);
					
				}
			}
	    }
		
		
		
		private void matchButtonActionPerformed(ActionEvent evt, SchoolList schoolList, StudentList studentList){
						
			//new GUI to see matches
			new GUIMatching(schoolList, studentList, this).setVisible(true);	
			this.hide();
		}
		
		private void similarButtonActionPerformed(ActionEvent evt, SchoolList schoolList, StudentList studentList) {
			
			//new GUI for similarity search
			new GUISimilarity(schoolList, studentList, this).setVisible(true);
			this.hide();
		}
		
		private void viewSchoolsButtonActionPerformed(ActionEvent evt, SchoolList schoolList){
			
			//new GUI for list of schools
    		new GUISchoolList(schoolList, this).setVisible(true);
    		this.hide();
					
		}
		
		private void viewStudentsButtonActionPerformed(ActionEvent evt, StudentList studentList){
			
    		//new GUI for list of students
    		new GUIStudentList(studentList, this).setVisible(true);
    		this.hide();
					
		}
		
		private void loadSchoolFileActionPerformed(ActionEvent evt) throws IOException {

			schoolList = readSchoolFile();
			JOptionPane.showMessageDialog(info, "Preset schools loaded!", "Schools", JOptionPane.INFORMATION_MESSAGE);
		}
		
		private void loadStudentFileActionPerformed(ActionEvent evt) throws IOException {

			studentList = readStudentFile();
			JOptionPane.showMessageDialog(info, "Preset students loaded!", "Students", JOptionPane.INFORMATION_MESSAGE);
		}
		
		private void loadYourSchoolFileActionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			
		}		
		
		private void loadYourStudentFileActionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			
		}		
		
		
    
}
