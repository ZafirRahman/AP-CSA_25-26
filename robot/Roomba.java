package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
    }

    private Robot roomba;

    public int cleanRoom(String worldName, int startX, int startY) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(1);

        this.roomba = new Robot(startX, startY, East, 0);
        // Variables
        int totalSquaresMoved = 0;
        int totalBeepers = 0;
        int biggestPile = 0;
        int biggestPileStreet = 0;
        int biggestPileAvenue = 0;
        int CurrentPile;
        int pileCount = 0;

        boolean moreToClean = true;
        while (moreToClean) {

            CurrentPile = 0;

            // pick all beepers on current spot
            while (roomba.nextToABeeper()) {
                roomba.pickBeeper();
                CurrentPile++;
                totalBeepers++;
                System.out.println("Picked 1 beeper at (" + roomba.street() + ", " + roomba.avenue() + ")");
            }

            // update pile stats once per spot
            if (CurrentPile > 0) {
                pileCount++;
                if (CurrentPile > biggestPile) {
                    biggestPile = CurrentPile;
                    biggestPileStreet = roomba.street();
                    biggestPileAvenue = roomba.avenue();
                }
            }

            // move across the row
            if (roomba.frontIsClear()) {
                roomba.move();
                totalSquaresMoved++;
            } else {
                //  U-turn for facing east
                if (roomba.facingEast()) {
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) {
                        moreToClean = false;
                    } else {
                        roomba.move();
                        totalSquaresMoved++;
                        roomba.turnLeft();
                    }
                } else { // U-turn for facing west or ending the loop
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) {
                        moreToClean = false;
                    } else {
                        roomba.move();
                        totalSquaresMoved++;
                        roomba.turnLeft();
                        roomba.turnLeft();
                        roomba.turnLeft();
                    }
                }
            }
        }
        int area = totalSquaresMoved + 1;
        // All print statements with the data collected
        System.out.println("The largest pile is " + biggestPile + " beepers at (" + biggestPileStreet + ", " + biggestPileAvenue + ").");
        System.out.println("The area of the room is " + area);
        System.out.println("The total number of beepers are " + totalBeepers);
        System.out.println("The number of piles is " + pileCount);
        if (pileCount > 0) {
            double averagePileSize = (double) totalBeepers / pileCount;
            System.out.println("The average pile size is " + String.format("%.2f", averagePileSize) + " beepers.");
        }
        double percentDirty = (double) pileCount / totalSquaresMoved * 100;
        System.out.println("The percent dirty is " + String.format("%.2f", percentDirty) + "%.");

        return totalBeepers; 
    }
}