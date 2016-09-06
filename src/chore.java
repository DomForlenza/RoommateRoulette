// Created by Dominick Forlenza

import java.util.ArrayList;
import java.util.Random;

public class chore {

	/* Global variables - Again, maybe another method
	 * is better for memory management.
	 */
	protected String desc;
	protected ArrayList<chore> chore_list;
	private chore c1;
	private chore c2;
	private chore c3;
	private chore c4;
	private chore c5;
	private chore c6;
	private chore c7;
	private chore c8;
	private chore c9;
	private chore c10;
	
	// Default constructor
	public chore() {
		// Do nothing
	}

	// Chore constructor - each chore has a description and value
	public chore(String desc) {
		this.desc = desc;
	}
	
	// Create default (non-user) chores
	public final void createDefaultChores() {
		c1 = new chore("Vacuum/Mop");
		c2 = new chore("Wash the dishes");
		c3 = new chore("Dust");
		c4 = new chore("Take the trash out");
		c5 = new chore("Mow the lawn");
		c6 = new chore("Clean the bathtub/shower");
		c7 = new chore("Clean the toilet");
		c8 = new chore("Get the mail");
		c9 = new chore("TBD");
		c10 = new chore("TBD");
	}
	
	// Create chore list
	public final void createList() {
		createDefaultChores();
		chore_list = new ArrayList<chore>();
		chore_list.add(c1);
		chore_list.add(c2);
		chore_list.add(c3);
		chore_list.add(c4);
		chore_list.add(c5);
		chore_list.add(c6);
		chore_list.add(c7);
		chore_list.add(c8);
		chore_list.add(c9);
		chore_list.add(c10);
	}
}
