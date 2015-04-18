package stable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;


public class GUISchool extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textGPA;
	private JTextField textDistance;
	private JComboBox textAward;
	private JFrame error;
	private SchoolList schoolList = new SchoolList();

	/**
	 * Create the frame.
	 */
	public GUISchool(final GUIMain guiMain) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnBack = new JButton("Back");
		contentPane.add(btnBack, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		contentPane.add(label);	//fill a space
						
		JLabel lblEnterSchoolInformation = new JLabel("Enter School Information:");
		lblEnterSchoolInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterSchoolInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEnterSchoolInformation);
			
		JLabel label2 = new JLabel("");
		contentPane.add(label2); //fill a space
		
		JLabel lblSchoolName = new JLabel("School Name:");
		contentPane.add(lblSchoolName);
		
		textName = new JTextField();
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblMinGPA = new JLabel("Minimum GPA Requirement (0-4):");
		contentPane.add(lblMinGPA);
		
		textGPA = new JTextField();
		contentPane.add(textGPA);
		textGPA.setColumns(10);
		
		JLabel lblMaxDistance = new JLabel("Maximum Distance in miles (0-100):");
		contentPane.add(lblMaxDistance);
		
		textDistance = new JTextField();
		contentPane.add(textDistance);
		textDistance.setColumns(10);
		
		JLabel lblAward = new JLabel("Select Your Preferred Award:");
		contentPane.add(lblAward);
		
		textAward = new JComboBox();
		textAward.addItem("None");
		textAward.addItem("Scholarship");
		textAward.addItem("Honors Award");
		textAward.addItem("Other");
		contentPane.add(textAward);
		
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
    		School school = new School();
    		school.setName(textName.getText());
    		school.setGPA(Double.parseDouble(textGPA.getText()));
    		school.setDistance(Integer.parseInt(textDistance.getText()));
    		school.setAwards(textAward.getItemAt(textAward.getSelectedIndex()).toString());
    		
    		schoolList.add(school);
    		
    		System.out.println(school.getName() + " added to school list");
    		
    		//new GUI for list of schools
    		//new GUISchoolList(schoolList, this).setVisible(true);
    		this.hide();
	    	
    	}
    	catch(IndexOutOfBoundsException i){
			JOptionPane.showMessageDialog(error,
    			    "One or more numbers are out of range",
    			    "Entry error",
    			    JOptionPane.ERROR_MESSAGE);
		}
		
		catch(RuntimeException r){
			JOptionPane.showMessageDialog(error,
    			    "One or more entries are blank",
    			    "Entry error",
    			    JOptionPane.ERROR_MESSAGE);
		}
    	
    	
    }
	
	private void backButtonActionPerformed(ActionEvent evt, GUIMain guiMain) {
		
		guiMain.show();
		this.hide();
		
	}
}
