package edu.fgcu;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
		JLabel lblNewLabel = new JLabel("Student Name:");
		contentPane.add(lblNewLabel);
		
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
		
		/*
		JLabel lblChooseOne = new JLabel("Choose One:");
		lblChooseOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblChooseOne, BorderLayout.NORTH);
						
		rdbtnSchool = new JRadioButton("School");
		rdbtnSchool.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(rdbtnSchool, BorderLayout.WEST);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(rdbtnStudent, BorderLayout.EAST);
		
		accountButtons = new ButtonGroup();
		accountButtons.add(rdbtnSchool);
		accountButtons.add(rdbtnStudent);
		
		JButton btnEnter = new JButton("Enter");
		contentPane.add(btnEnter, BorderLayout.SOUTH);
		
		btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });
	}
	
	private void enterButtonActionPerformed(ActionEvent evt) {
    	if (rdbtnSchool.isSelected() == true && rdbtnStudent.isSelected() == true) {
    		JOptionPane.showMessageDialog(error,
    			    "Only one option must be selected.",
    			    "Selection error",
    			    JOptionPane.ERROR_MESSAGE);
    	}
    	else if (rdbtnStudent.isSelected() == true){
    		GUIStudent guiStudent = new GUIStudent(this);
    		guiStudent.setVisible(true);
    		this.hide();
    	}
    	else if (rdbtnSchool.isSelected() == true) {
    		GUISchool guiSchool = new GUISchool(this);
    		guiSchool.setVisible(true);
    		this.hide();
    	}
    	else {
    		JOptionPane.showMessageDialog(error,
    			    "One option must be selected.",
    			    "Selection error",
    			    JOptionPane.ERROR_MESSAGE);
    	}*/
    }
}
