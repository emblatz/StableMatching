package edu.fgcu;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUIMain extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	
	private ButtonGroup accountButtons;
	private JRadioButton rdbtnSchool;
	private JRadioButton rdbtnStudent;
	private JFrame error;
	
	private SchoolList schoolList;
	private JList jlistSchools;
	private StudentList studentList;
	private JList jlistStudents;
	
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
		
		/*format of columns:
		 * column 1 & 2 is school information - label, text box
		 * column 3 & 4 is student information - label, text box
		 */
		
		//column 1
		JLabel lblEnterSchoolInformation = new JLabel("Enter School Information:");
		lblEnterSchoolInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterSchoolInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterSchoolInformation);
			
		//column 2
		JLabel label1 = new JLabel("");
		contentPane.add(label1); //fill a space
		
		//column 3
		JLabel lblEnterStudentInformation = new JLabel("Enter Student Information:");
		lblEnterStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterStudentInformation);
		
		//column 4
		JLabel label2 = new JLabel("");
		contentPane.add(label2); //fill a space
		
		
		//column 1
		JLabel lblSchoolName = new JLabel("School Name:");
		contentPane.add(lblSchoolName);
		
		//column 2
		schoolTextName = new JTextField();
		contentPane.add(schoolTextName);
		schoolTextName.setColumns(10);
		
		//column 3
		JLabel lblStudentLabel = new JLabel("Student Name:");
		contentPane.add(lblStudentLabel);
		
		//column 4
		studentTextName = new JTextField();
		contentPane.add(studentTextName);
		studentTextName.setColumns(10);
		
		//column 1
		JLabel lblMinGPA = new JLabel("Minimum GPA Requirement (0-4):");
		contentPane.add(lblMinGPA);
		
		//column 2
		schoolTextGPA = new JTextField();
		contentPane.add(schoolTextGPA);
		schoolTextGPA.setColumns(10);
		
		//column 3
		JLabel lblStudentGPA = new JLabel("Student GPA (0-4):");
		contentPane.add(lblStudentGPA);
		
		//column 4
		studentTextGPA = new JTextField();
		contentPane.add(studentTextGPA);
		studentTextGPA.setColumns(10);
		
		//column 1
		JLabel lblMaxDistance = new JLabel("Maximum Distance in miles (0-100):");
		contentPane.add(lblMaxDistance);
		
		//column 2
		schoolTextDistance = new JTextField();
		contentPane.add(schoolTextDistance);
		schoolTextDistance.setColumns(10);
		
		//column 3
		JLabel lblLocation = new JLabel("Preferred Distance in miles (0-100):");
		contentPane.add(lblLocation);
		
		//column 4
		studentTextDistance = new JTextField();
		contentPane.add(studentTextDistance);
		studentTextDistance.setColumns(10);
		
		//column 1
		JLabel lblSchoolAward = new JLabel("Select Your Preferred Award:");
		contentPane.add(lblSchoolAward);
		
		//column 2
		schoolAward = new JComboBox();
		schoolAward.addItem("None");
		schoolAward.addItem("Scholarship");
		schoolAward.addItem("Honors Award");
		schoolAward.addItem("Other");
		contentPane.add(schoolAward);
		
		//column 3
		JLabel lblStudentAward = new JLabel("Select Your Award:");
		contentPane.add(lblStudentAward);
		
		//column 4
		studentAward = new JComboBox();
		studentAward.addItem("None");
		studentAward.addItem("Scholarship");
		studentAward.addItem("Honors Award");
		studentAward.addItem("Other");
		contentPane.add(studentAward);
		
		//column 1
		JButton btnEnterSchool = new JButton("Enter School Information");
		contentPane.add(btnEnterSchool);
		
		
		btnEnterSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonSchoolActionPerformed(evt);
            }
        });
		
		//column 2
		JLabel label3 = new JLabel("");
		contentPane.add(label3); //fill a space
		
		//column 3
		JButton btnEnterStudent = new JButton("Enter Student Information");
		contentPane.add(btnEnterStudent);
		
		btnEnterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonStudentActionPerformed(evt);
            }
        });
		
		//column 4
		
	}
		
		
		
		
		
	//button actions
	
		private void enterButtonSchoolActionPerformed(ActionEvent evt) {
	    	try {
	    		
	    		School school = new School();
	    		school.setName(schoolTextName.getText());
	    		school.setGPA(Double.parseDouble(schoolTextGPA.getText()));
	    		school.setDistance(Integer.parseInt(schoolTextDistance.getText()));
	    		school.setAwards(schoolAward.getItemAt(schoolAward.getSelectedIndex()).toString());
	    		
	    		schoolList.add(school);
	    		
	    		System.out.println(school.getName() + " added to school list");
	    		
	    	}
	    	catch(IndexOutOfBoundsException i){
	    		if(Double.parseDouble(schoolTextGPA.getText())>4 | Double.parseDouble(schoolTextGPA.getText())<0|
	    			Integer.parseInt(schoolTextDistance.getText())>100 | Integer.parseInt(schoolTextDistance.getText())<0){
				JOptionPane.showMessageDialog(error,
	    			    "One or more numbers are out of range",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
	    		}
			}
			
			catch(RuntimeException r){
				if(schoolTextGPA.getText().isEmpty() | schoolTextDistance.getText().isEmpty() | schoolTextName.getText().isEmpty()){
				JOptionPane.showMessageDialog(error,
	    			    "One or more entries are blank",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				}
			}
	    	
	    	
	    }
		
		private void enterButtonStudentActionPerformed(ActionEvent evt) {
			try {
				
	    		Student student = new Student();
	    		student.setName(studentTextName.getText());
	    		student.setGPA(Double.parseDouble(studentTextGPA.getText()));
	    		student.setDistance(Integer.parseInt(studentTextDistance.getText()));
	    		student.setAwards(studentAward.getItemAt(studentAward.getSelectedIndex()).toString());
	    		    		
	    		studentList.add(student);
	    		
	    		System.out.println(student.getName() + " added to school list");

	    		
	    	}
			catch(IndexOutOfBoundsException i){
				if(Double.parseDouble(studentTextGPA.getText())>4 | Double.parseDouble(studentTextGPA.getText())<0|
		    			Integer.parseInt(studentTextDistance.getText())>100 | Integer.parseInt(studentTextDistance.getText())<0){
				JOptionPane.showMessageDialog(error,
	    			    "One or more numbers are out of range",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				}
			}
			
			catch(RuntimeException r){
				if(studentTextGPA.getText().isEmpty() | studentTextDistance.getText().isEmpty() | studentTextName.getText().isEmpty()){
				JOptionPane.showMessageDialog(error,
	    			    "One or more entries are blank",
	    			    "Entry error",
	    			    JOptionPane.ERROR_MESSAGE);
				}
			}
			
	    	
			
			
			
	    }
		

    
}
