// Created by Dominick Forlenza

import java.util.ArrayList;

public class roommate {

	/* Global variables - may need to
	 * find a different method for memory
	 * management (this is Java though...)
	 */
	protected ArrayList<roommate> roommate_list;
	protected String name;
	protected chore rand_chore;
	
	// Default constructor
	public roommate() {
		// Do nothing
	}
	
	/* Create new roommate
	 * A roommate has a name and
	 * a chore associated with them
	 * that is set at a later date.
	 */
	public roommate(String name) {
		this.name = name;
	}
	
	/* Create list that holds all roommates
	 * that will be used to display chore
	 * information at the end after random roll.
	 */
	public final void createList() {
		this.roommate_list = new ArrayList<roommate>();
	}
	
	// Add roommate
	public final void addRoommate(roommate r) {
		roommate_list.add(r);
	}
	
	// Set random chore for roommate
	public final void setChore(chore ch, roommate r) {
		r.rand_chore = ch;
	}
	
	// Print roommate with random choice
	public final void displayRoommateWithChore() {
		System.out.println("Name: " + name + " -> " + rand_chore.desc);
	}
}