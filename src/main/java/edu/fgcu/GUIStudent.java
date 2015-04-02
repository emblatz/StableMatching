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
	public GUIStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEnterStudentInformation = new JLabel("Enter Student Information:");
		lblEnterStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterStudentInformation);
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);
		
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
	}
	
	private void enterButtonActionPerformed(ActionEvent evt) {
		try {
    		Student student = new Student();
    		student.setName(textName.getText());
    		student.setGPA(Double.parseDouble(textGPA.getText()));
    		student.setDistance(Integer.parseInt(textDistance.getText()));
    		student.setAwards(textAward.getText());
    		
    		studentList.add(student);
    	}
    	catch(NullPointerException e) {
    		JOptionPane.showMessageDialog(error,
    			    "One or more entries is empty",
    			    "Entry error",
    			    JOptionPane.ERROR_MESSAGE);
    	}
    }
}
