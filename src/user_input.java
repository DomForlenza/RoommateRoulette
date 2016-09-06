// Created by Dominick Forlenza

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class user_input {

	// Private global variables
	private ArrayList<String> name_list = new ArrayList<String>(); // Create name list
	private ArrayList<chore> c_list = new ArrayList<chore>(); // Create chore list
	private ArrayList<chore> reroll_list = new ArrayList<chore>(); // Reroll chore list
	private Scanner scan = new Scanner(System.in); // Create scanner
	private roommate r = new roommate();

	// Begin session at user start
	protected final void sessionBegin(RR_GUI rrg) {
        readUsers(); // Begin by reading # of users and their names
	}
	
	// Read # of users and their names
	private final void readUsers() {
		// Get number of roommates
		System.out.println("How many of you are there?");
		try {
			int num_roommates = scan.nextInt();
		
			// Enter names only num_roommates amount of names allowed
			System.out.println("Please enter your names.");
			for (int i = 0; i < num_roommates; i++) {
				String name = scan.next();
				name_list.add(name);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number as an integer.");
			System.exit(-1);
		}
		
		// Create default roommate list
		r.createList();

		// Add roommates entered to roommate list
		for (String name : name_list) { 
			r.addRoommate(new roommate(name));
		}
		
		readChoreInput(); // Read chore selection
	}
	
	// Allow user to enter chore (only one right now)
	private final void userChoreInput() {
		boolean cont = true;
		System.out.println("Do you have a chore to add that is not on this list? Type 'yes' or 'no'.");
		String user_chore = scan.next();
		
		if (user_chore.equalsIgnoreCase("yes")) {
			System.out.println("Ok, what chore do you need done?");
			scan.nextLine(); // Move onto next line for input
			String user_chore_on_yes = scan.nextLine();
			chore new_chore = new chore(user_chore_on_yes);
			c_list.add(new_chore);
			
			// Add another chore
			while (cont == true) {
				System.out.println("Another? Type 'yes' or 'no'."); 
				String user_another = scan.next();
				
				if (user_another.equalsIgnoreCase("yes")) {
					System.out.println("Ok, what chore do you need done?");
					scan.nextLine(); // Move onto next line for input
					String user_another_on_yes = scan.nextLine();
					chore new_chore_another = new chore(user_another_on_yes);
					c_list.add(new_chore_another);
				}
				else if (user_another.equalsIgnoreCase("no")) {
					cont = false;
					System.out.println("Continuing...");
					randomChoiceAssignment(); // Move on to random selection
				}
			}
		}
		else if (user_chore.equalsIgnoreCase("no")) {
			System.out.println("Continuing...");
			randomChoiceAssignment(); // Move on to random selection
		}
		else {
			System.out.println("Input not recognized. Please enter 'yes' or 'no'.");
			userChoreInput();
		}
	}
	
	private final void readChoreInput() {
		// Create chore list with default values
		chore ch = new chore();
		ch.createList();
		// Display chore choices from default chore list
		System.out.println("Please choose the chores by number that you need done from the list below and type the number one at a time on the same line followed by a space.");
		System.out.println("Type any character followed by the enter key once you are finished to terminate the input.");
		System.out.println();
		
		int chore_count = 0;
		for (chore chr : ch.chore_list) {
			System.out.println((++chore_count) + " " + chr.desc);
		}

		// Allow user to select chores by int value associated
		ArrayList<Integer> chore_choice_list = new ArrayList<Integer>();
		while (scan.hasNextInt()) {
			try {
				chore_choice_list.add(scan.nextInt());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number as an integer.");
				continue;
			}
		}

		// Add appropriate default value chosen by user to chore list
		for (int chr : chore_choice_list) {
			if (chr == 1) {
				chore c = new chore("Vaccuum/Mop");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 2) {
				chore c = new chore("Wash the dishes");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 3) {
				chore c = new chore("Dust");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 4) {
				chore c = new chore("Take the trash out");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 5) {
				chore c = new chore("Mow the lawn");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 6) {
				chore c = new chore("Clean the bathtub/shower");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 7) {
				chore c = new chore("Clean the toilet");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 8) {
				chore c = new chore("Get the mail");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 9) {
				chore c = new chore("TBD");
				c_list.add(c);
				reroll_list.add(c);
			} else if (chr == 10) {
				chore c = new chore("TBD");
				c_list.add(c);
				reroll_list.add(c);
			}
		}
			
		scan.next(); // Skip end character from chore input
		userChoreInput(); // Take user chore input
	}
	
	// Random chore roll (allows rerolls)
	private final void randomChoiceAssignment() {
		boolean roll = true; // At this point we want roll to be true to begin initial roll
		ArrayList<chore> redo_list = new ArrayList<chore>();
		while (roll == true) {
			// Get roommate list and assign random chore to each roommate
			
			for (roommate rmm : r.roommate_list) {
				int rand = new Random().nextInt(c_list.size());
				chore rand_chore = c_list.get(rand);
				redo_list.add(rand_chore);
				roommate rm = rmm;
				rm.setChore(rand_chore, rm);
				rm.displayRoommateWithChore();
				c_list.remove(rand);
			}
			
     		// Add removed (to avoid duplicates) chores back into c_list in case user wants to redo roll
			for (chore chr : redo_list) {
				c_list.add(chr);
			}
			
			// Allow user reroll
			System.out.println("Reset? Type 'yes' or 'no'.");
			String reroll = scan.next();
			if (reroll.equalsIgnoreCase("yes")) {
				roll = true;
				redo_list.clear();
			} else if (reroll.equalsIgnoreCase("no")) {
				roll = false;
				System.out.println("Exiting!");
				System.exit(-1);
			}
		}
	}
}
