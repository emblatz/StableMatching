package edu.fgcu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;


public class GUIStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textGPA;
	private JTextField textDistance;
	private JTextField textAward;
	private JFrame error;
	private StudentList studentList = new StudentList();

	/**
	 * Create the frame.
	 */
	public GUIStudent(final GUIMain guiMain) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnBack = new JButton("Back");
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		contentPane.add(label);	//fill a space
		
		JLabel lblEnterStudentInformation = new JLabel("Enter Student Information:");
		lblEnterStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterStudentInformation);
		
		JLabel label2 = new JLabel("");
		contentPane.add(label2); //fill a space
				
		JLabel lblNewLabel = new JLabel("Student Name:");
		contentPane.add(lblNewLabel);
		
		textName = new JTextField();
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student GPA:");
		contentPane.add(lblNewLabel_1);
		
		textGPA = new JTextField();
		contentPane.add(textGPA);
		textGPA.setColumns(10);
		
		JLabel lblLocation = new JLabel("Preferred Distance:");
		contentPane.add(lblLocation);
		
		textDistance = new JTextField();
		contentPane.add(textDistance);
		textDistance.setColumns(10);
		
		JLabel lblAward = new JLabel("Award:");
		contentPane.add(lblAward);
		
		textAward = new JTextField();
		contentPane.add(textAward);
		textAward.setColumns(10);
		
		JButton btnEnter = new JButton("Enter Information");
		contentPane.add(btnEnter);
		
		btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });
				
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt, guiMain);
            }
        });
	}
	
	private void enterButtonActionPerformed(ActionEvent evt) {
		try {
    		Student student = new Student();
    		student.setName(textName.getText());
    		student.setGPA(Double.parseDouble(textGPA.getText()));
    		student.setDistance(Integer.parseInt(textDistance.getText()));
    		student.setAwards(textAward.getText());
    		
    		studentList.add(student);
    		System.out.println(student.getName() + " added to school list");
    	}
    	catch(NullPointerException e) {
    		JOptionPane.showMessageDialog(error,
    			    "One or more entries is empty",
    			    "Entry error",
    			    JOptionPane.ERROR_MESSAGE);
    	}
		
		//new GUI for list of students
		new GUIStudentList(studentList, this).setVisible(true);
		this.hide();
		
    }
	
	private void backButtonActionPerformed(ActionEvent evt, GUIMain guiMain) {
		
		guiMain.show();
		this.hide();
		
	}
}
