// Created by Dominick Forlenza

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/* Roommate Roulette GUI
 * STILL VERY EARLY IN DEVELOPMENT!
 * No documentation available yet
*/
public class RR_GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel gameTitle; // Title at top (north)
	
	private JButton start; // Start button
	
	private JTextField name1, name2, name3, name4; // Roommate names
	
	protected ArrayList<roommate> rm_list; // Dynamic roommate list
	
	private JFrame start_screen, choose_chores; // Screens
	
	
	// Constructor
	public RR_GUI() {
		
		super("Roommate Roulette v1.0");
		
		rm_list = new ArrayList<roommate>();
				
		// Frame init
		start_screen = new JFrame();
		start_screen.setVisible(true);
		choose_chores = new JFrame();
		choose_chores.setVisible(false);

		start_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// North panel
		JPanel north = new JPanel(new GridLayout(3, 1));
		
		// Info label
		gameTitle = new JLabel("Click on the start button to begin!", SwingConstants.CENTER);
		north.add(gameTitle);
		start_screen.getContentPane().add(north);
		
		// Add north panel to GUI
		add(north, BorderLayout.NORTH);
		
		// Start button
		start = new JButton("Start");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		start.addActionListener(this);
		start.setEnabled(true);
		
		// Center panel
		JPanel center = new JPanel();
		
		/*
         * Group layout experiement
		GroupLayout layout = new GroupLayout(center);
		center.setLayout(layout);
		
		// Turn on automatically creating gaps between components
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		// Create sequential group for horizontal axis
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		*/
		
		// Roommate text fields
		name1 = new JTextField("Roommate name 1");
		name2 = new JTextField("Roommate name 2");
		name3 = new JTextField("Roommate name 3");
		name4 = new JTextField("Roommate name 4");
		
		name1.setHorizontalAlignment(SwingConstants.RIGHT);
		name2.setHorizontalAlignment(SwingConstants.RIGHT);
		name3.setHorizontalAlignment(SwingConstants.RIGHT);
		name4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		name1.setPreferredSize(new Dimension(300, 24));
		name2.setPreferredSize(new Dimension(300, 24));
		name3.setPreferredSize(new Dimension(300, 24));
		name4.setPreferredSize(new Dimension(300, 24));
		
		// Name labels
		JLabel name_label1 = new JLabel("Roommate name 1:", SwingConstants.CENTER);
		JLabel name_label2 = new JLabel("Roommate name 2:", SwingConstants.CENTER);
		JLabel name_label3 = new JLabel("Roommate name 3:", SwingConstants.CENTER);
		JLabel name_label4 = new JLabel("Roommate name 4:", SwingConstants.CENTER);

		name_label1.setLabelFor(name1);
		name_label2.setLabelFor(name2);
		name_label3.setLabelFor(name3);
		name_label4.setLabelFor(name4);
		
		center.add(name1);
		center.add(name2);
		center.add(name3);
		center.add(name4);
		
		start_screen.getContentPane().add(center);
		
		add(center, BorderLayout.CENTER);
		
		// South panel
		JPanel south = new JPanel();
		south.add(start);
		
		start_screen.getContentPane().add(south);
		
		// Add south panel to GUI
		add(south, BorderLayout.SOUTH);
				
		// Close by user
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == start) {
			String name_one = name1.getText().trim();
				// Empty name - ignore
				if (name_one.length() == 0) {
					return;
				}
				else {
					rm_list.add(new roommate(name_one));
				}
			String name_two = name2.getText().trim();
				// Empty name - ignore
				if (name_two.length() == 0) {
					return;
				}
				else {
					rm_list.add(new roommate(name_two));
				}
			String name_three = name3.getText().trim();
				// Empty name - ignore
				if (name_three.length() == 0) {
					return;
				}
				else {
					rm_list.add(new roommate(name_three));
				}
			String name_four = name4.getText().trim();
				// Empty name - ignore
				if (name_four.length() == 0) {
					return;
				}
				else {
					rm_list.add(new roommate(name_four));
				}
				
		
			//user_input u1 = new user_input();
			//u1.sessionBegin(null); // Null if non GUI otherwise provide sessionBegin with GUI
			
			// Second screen to choose chores
			choose_chores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			start_screen.setVisible(false);
			choose_chores.setVisible(true);
			
			
			JPanel north = new JPanel(new GridLayout(3, 1));
			
			JLabel choose_info = new JLabel("Choose your chores below.", SwingConstants.CENTER);
			north.add(choose_info);
			choose_chores.getContentPane().add(north);
			add(north, BorderLayout.NORTH);
		}
		
	}
	
	// Start the GUI
	public static void main(String[] args) {
		new RR_GUI();
	}
}
