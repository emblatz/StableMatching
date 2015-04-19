package stable;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;

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
	
	private JTextField schoolTextName;
	private JTextField schoolTextGPA;
	private JTextField schoolTextDistance;
	private JComboBox schoolAward;
	
	private JTextField studentTextName;
	private JTextField studentTextGPA;
	private JTextField studentTextDistance;
	private JComboBox studentAward;

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
	 */
	public GUIMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 4));
		setContentPane(contentPane);
		
		
		final SchoolList schoolList = new SchoolList();
		final StudentList studentList = new StudentList();
		
		/*format of columns:
		 * column 1 & 2 is school information - label, text box
		 * column 3 & 4 is student information - label, text box
		 */
		
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
		
		
		
		//empty row
		JLabel label3 = new JLabel("");
		contentPane.add(label3); //fill a space
		JLabel label4 = new JLabel("");
		contentPane.add(label4); //fill a space
		JLabel label5 = new JLabel("");
		contentPane.add(label5); //fill a space
		JLabel label6 = new JLabel("");
		contentPane.add(label6); //fill a space
		
		
		//column 1
		JButton btnMatch = new JButton("Match");
		contentPane.add(btnMatch);
		
		btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchButtonActionPerformed(evt, schoolList, studentList);
            }
        });
				
		
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
			
			
			new GUIMatching(schoolList, studentList, this).setVisible(true);	
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
		

    
}
