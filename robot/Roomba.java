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
    this.roomba = new Robot(startX, startY, East, 0);

    // Initialize a variable to count the beepers
    int totalSquaresMoved = 1;
    int totalBeepers = 0;
    int biggestPile = 0;
    int CurrentPile = 0;
    int pileCount = 0;
    // Use the instance variable 'roomba' for all calls
    boolean moreToClean = true;
    while (moreToClean) {
        CurrentPile = 1;
        while (roomba.frontIsClear())
        {
                roomba.move();
                totalSquaresMoved++;
            }
        while (roomba.nextToABeeper()){
            roomba.pickBeeper();
            CurrentPile++;
            totalBeepers++;
        }
        if (CurrentPile > biggestPile){
            biggestPile = CurrentPile;
        }

        if (roomba.facingEast()){
            roomba.turnLeft();
            if (!roomba.frontIsClear()){
                roomba.turnOff();
                break;
            }
            roomba.move();
            totalSquaresMoved++;
            roomba.turnLeft();
        }
        else{
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.move();
            totalSquaresMoved++;
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
        }
    }
    
    // ... cleaning logic to pick up beepers and increment `totalBeepers` ...
    // Add the return statement here to return the final count
    System.out.println("The largest pile is " + biggestPile + " beepers.");
    System.out.println("The area of the room is " + totalSquaresMoved);
    System.out.println("The total number of beepers are " + totalBeepers);
    System.out.println(pileCount);
    return biggestPile;
}
}