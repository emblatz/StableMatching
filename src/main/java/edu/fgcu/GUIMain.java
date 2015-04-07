package edu.fgcu;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class GUIMain extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnSchool;
	private JRadioButton rdbtnStudent;
	private JFrame error;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblChooseOne = new JLabel("Choose One:");
		contentPane.add(lblChooseOne, BorderLayout.NORTH);
		
		rdbtnSchool = new JRadioButton("School");
		contentPane.add(rdbtnSchool, BorderLayout.CENTER);
		
		rdbtnStudent = new JRadioButton("Student");
		contentPane.add(rdbtnStudent, BorderLayout.WEST);
		
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
    		new GUIStudent().setVisible(true);
    		this.dispose();
    	}
    	else if (rdbtnSchool.isSelected() == true) {
    		new GUISchool().setVisible(true);
    		this.dispose();
    	}
    	else {
    		JOptionPane.showMessageDialog(error,
    			    "One option must be selected.",
    			    "Selection error",
    			    JOptionPane.ERROR_MESSAGE);
    	}
    }
}
