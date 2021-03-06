package stable;

import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUISimilarity extends JFrame {
	
	List<School> schools;
	List<Student> students;
	
	private JPanel contentPane;
	private JFrame error;
	private JFrame info;
	
	private JTextField studentTextGPA;
	private JTextField studentTextDistance;
	private JComboBox studentAward;
	private JButton btnBack;
	private JButton btnFindStudents;
	private JButton btnFindSchools;
	
	public GUISimilarity(SchoolList schoolList, StudentList studentList, final GUIMain guiMain) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H); //alt + h
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic(KeyEvent.VK_A); //alt + a
		JMenuItem howToUse = new JMenuItem("How to Use");
		howToUse.setMnemonic(KeyEvent.VK_U); //alt + u
		
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
		
		howToUse.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		    	
		    	JOptionPane.showMessageDialog(info,
		    				"To see your student's competition and potential school matches:"
		    			+ "\n1. Enter your student's credentials or your student's target credentials"
		    			+ "\n2. View students with similar credentials with the 'Find Similar Students' button"
		    			+ "\n3. View schools looking for credentials like your student's with the 'Find Possible Schools' button"
		    			,"How to Use Similarity Search",
	    			    JOptionPane.PLAIN_MESSAGE);
				
		    }
		});
		
		help.add(about);
		help.add(howToUse);
		menuBar.add(help);
		setJMenuBar(menuBar);
				
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2));
		setContentPane(contentPane);
		
		this.schools = schoolList.getList();
		this.students = studentList.getList();
				
		btnBack = new JButton("Back to Main");
		contentPane.add(btnBack);
		
		JLabel label1 = new JLabel("");
		contentPane.add(label1); //fill a space
		
		JLabel lblEnterStudentInformation = new JLabel("Enter Student Information:");
		lblEnterStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterStudentInformation);
		
		JLabel label2 = new JLabel("");
		contentPane.add(label2); //fill a space
		
		studentTextGPA = new JTextField();
		studentTextDistance = new JTextField();
		studentAward = new JComboBox();
		
		JLabel lblStudentGPA = new JLabel("Student GPA (0-4):");
		contentPane.add(lblStudentGPA);
		
		studentTextGPA.setNextFocusableComponent(studentTextDistance);
		contentPane.add(studentTextGPA);
		studentTextGPA.setColumns(10);
		
		JLabel lblStudentAward = new JLabel("Select Your Award:");
		contentPane.add(lblStudentAward);
		
		studentAward.addItem("None");
		studentAward.addItem("Scholarship");
		studentAward.addItem("Honors Award");
		studentAward.addItem("Other");
		contentPane.add(studentAward);
		
		JLabel label3 = new JLabel("");
		contentPane.add(label3); //fill a space
		JLabel label4 = new JLabel("");
		contentPane.add(label4); //fill a space
		
		btnFindStudents = new JButton("Find Similar Students");
		btnFindSchools = new JButton("Find Possible Schools");
		contentPane.add(btnFindStudents);
		contentPane.add(btnFindSchools);
		
		
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt, guiMain);
            }
        });
		
		btnFindSchools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	try {
            		Student student = new Student();
            		student.setGPA(Double.parseDouble(studentTextGPA.getText()));
            		student.setAwards(studentAward.getItemAt(studentAward.getSelectedIndex()).toString());

            		findSchools(evt, student);
            	}
            	catch(IndexOutOfBoundsException i) {
            		if(Double.parseDouble(studentTextGPA.getText())>4 | Double.parseDouble(studentTextGPA.getText())<0){
    				JOptionPane.showMessageDialog(error,
    	    			    "One or more numbers are out of range",
    	    			    "Entry error",
    	    			    JOptionPane.ERROR_MESSAGE);
    				}
            	}
            	catch(RuntimeException r){ //checks for blank text boxes
    				if(studentTextGPA.getText().isEmpty()){
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
        });
		
		btnFindStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
            		Student student = new Student();
            		student.setGPA(Double.parseDouble(studentTextGPA.getText()));
            		student.setAwards(studentAward.getItemAt(studentAward.getSelectedIndex()).toString());

            		findStudents(evt, student);
            	}
            	catch(IndexOutOfBoundsException i) {
            		if(Double.parseDouble(studentTextGPA.getText())>4 | Double.parseDouble(studentTextGPA.getText())<0){
    				JOptionPane.showMessageDialog(error,
    	    			    "One or more numbers are out of range",
    	    			    "Entry error",
    	    			    JOptionPane.ERROR_MESSAGE);
    				}
            	}
            	catch(RuntimeException r){ //checks for blank text boxes
    				if(studentTextGPA.getText().isEmpty()){
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
        });
	}
	
	private void findStudents(ActionEvent evt, Student newStudent) {
		List<Student> studentDisplay = new ArrayList<Student>();
		for (Student student:students) {
			if (((newStudent.getGPA() >= (student.getGPA()-0.5)) && (newStudent.getGPA() <= (student.getGPA()+0.5))) ||
					(newStudent.getAwards() == student.getAwards())) {
				studentDisplay.add(student);
			}
		}
		
		new GUISimilarStudents(studentDisplay, this).setVisible(true);	
		this.hide();
	}
	
	private void findSchools(ActionEvent evt, Student student) {
		List<School> schoolDisplay = new ArrayList<School>();
		for (School school:schools) {
			if (((student.getGPA() >= (school.getGPA()-0.5)) && (student.getGPA() <= (school.getGPA()+0.5))) || 
					(student.getAwards() == school.getAwards())) {
				schoolDisplay.add(school);
			}
		}
		
		new GUISimilarSchools(schoolDisplay, this).setVisible(true);	
		this.hide();
	}
	
	private void backButtonActionPerformed(ActionEvent evt, GUIMain guiMain) {
		
		guiMain.show();
		this.hide();
	}
}