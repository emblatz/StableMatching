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
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;


public class SimilarSchools extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField schools;
	private JList jlist;
	private JFrame error;

	/**
	 * Create the frame.
	 */
	public SimilarSchools(List<School> schoolDisplay, final Similarity similarity) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2));
		setContentPane(contentPane);
		
		btnBack = new JButton("Back to Finder");
		contentPane.add(btnBack);
		
		String listData[] = new String[schoolDisplay.size()];
		
		int i=0;
		for(School school:schoolDisplay){
			listData[i] = school.getName()+": "+school.getGPA()+", "+school.getAwards();
			i++;
		}
		
		jlist = new JList(listData);
		jlist.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.add(jlist);
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt, similarity);
            }
        });
	}
	
	private void backButtonActionPerformed(ActionEvent evt, Similarity similarity) {
		
		similarity.show();
		this.hide();
		
	}
	
	
}
