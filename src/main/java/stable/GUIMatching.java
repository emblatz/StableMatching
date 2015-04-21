package stable;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;


public class GUIMatching extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JList jlist;
	private JFrame error;

	/**
	 * Create the frame.
	 */
	public GUIMatching(SchoolList schoolList, StudentList studentList, final GUIMain guiMain) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2));
		setContentPane(contentPane);
		
		btnBack = new JButton("Back to Main");
		contentPane.add(btnBack);
		
		Matching match = new Matching();
		ArrayList<String> matches = match.runMatch(schoolList.getList(), studentList.getList());
		
		
		JList list = new JList(matches.toArray());
		contentPane.add(list);
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt, guiMain);
            }
        });
	}
	
	private void backButtonActionPerformed(ActionEvent evt, GUIMain guiMain) {
		
		guiMain.show();
		this.hide();
		
	}
	
	
}
