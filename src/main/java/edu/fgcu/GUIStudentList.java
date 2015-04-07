package edu.fgcu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ListView;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;


public class GUIStudentList extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JList<Student> list;
	private JFrame error;

	/**
	 * Create the frame.
	 */
	public GUIStudentList(StudentList studentList, final GUIStudent guiStudent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnBack = new JButton("Back to Add Student");
		contentPane.add(btnBack, BorderLayout.NORTH);
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt,guiStudent);
            }
        });
	}
	
	private void backButtonActionPerformed(ActionEvent evt, GUIStudent guiStudent) {
		
		guiStudent.show();
		this.hide();
		
	}
	
	//view a list of students added
	//System.out.println(studentList.getList().get(0).getName() + " on list");
}
