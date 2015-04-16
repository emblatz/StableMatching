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
	private JList jlist;
	private JFrame error;

	/**
	 * Create the frame.
	 */
	public GUIStudentList(StudentList studentList, final GUIMain guiMain) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2));
		setContentPane(contentPane);
		
		btnBack = new JButton("Back to Main");
		contentPane.add(btnBack);
		
		
		//view a list of students added
		String listDataNames[] = new String[studentList.getList().size()];
		Student listData[] = new Student[studentList.getList().size()];
		
		for(int i=0; i<listData.length; i++){
			listDataNames[i] = studentList.getList().get(i).getName();
			listData[i] = studentList.getList().get(i);
		}
		
		jlist = new JList(listDataNames);
		jlist.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.add(jlist);
		
		
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt,guiMain);
            }
        });
	}
	
	private void backButtonActionPerformed(ActionEvent evt, GUIMain guiMain) {
		
		guiMain.show();
		this.hide();
		
	}
	
}
