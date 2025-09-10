package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// Declared here so it is visible in all the methods!
	private Robot roomba;
	// You will need to add many variables!!

	public int cleanRoom(String worldName, int startX, int startY) {
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(20);

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba
		this.roomba = new Robot(startX, startY, North, 100);

		// Use the instance variable 'roomba' for all calls
		for (int i = 0; i < 4; i++) {
			while (roomba.frontIsClear()) {
				roomba.move();
			} // This was the missing brace for the while loop

			// Turn right
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.move();
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
}
		}

		int totalBeepers = 0; // Initialize a variable to hold the final count
		// ... cleaning logic to pick up beepers and increment `totalBeepers` ...
		
		return totalBeepers; // Add the return statement
	}
}
