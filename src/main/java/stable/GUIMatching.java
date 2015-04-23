package stable;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	private JFrame info;

	/**
	 * Create the frame.
	 */
	public GUIMatching(SchoolList schoolList, StudentList studentList, final GUIMain guiMain) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H); //alt + h
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic(KeyEvent.VK_A); //alt + a
		
		about.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		    	
		    	JOptionPane.showMessageDialog(info,
		    			"Software Testing, Dr. Guo - Stable Matching Project - Spring 2015"
		    			+ "\nWritten by Emily Blatz and Nowele Rechka"
				    	+ "\n\nThis is a small program to "
		    			+ "compare and match schools and students "
		    			+ "using the Stable Matching algorithm."
		    			,"About Stable Matcher",
	    			    JOptionPane.PLAIN_MESSAGE);
				
		    }
		});
		
		help.add(about);
		menuBar.add(help);
		setJMenuBar(menuBar);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2));
		setContentPane(contentPane);

//row 1
		//column 1
		btnBack = new JButton("Back to Main");
		contentPane.add(btnBack);
		
		//column 2
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
