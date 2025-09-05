package robot;
import kareltherobot.*;


public class Diamond implements Directions{

    public static void main(String[] args) {

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(20,20);
        World.setDelay(30);

        // The line below creates a Robot that we will refer to as rob
        // Find out what the numbers and direction do!
        // Put rob in a better location for your initials.
        Robot rob = new Robot(10,2,North,100);

        // Want a second robot?  No prob.  They are cheap :)
        //Robot dude = new Robot(7,5,West,9);
        // examples of commands you can invoke on a Robot
        rob.move();// move one step in the direction it is facing
        

        // starting the letter R
        for (int a = 1; a<=4; a++) {
            for (int i = 1; i <= 4; i++) {
                rob.putBeeper();
                rob.move();
                printNumber(rob);
                rob.move();
                rob.turnLeft();   
                }
                printNumber(rob);
            }
            rob.move();

        printNumber(rob);
        // done with the line, now on the curve
        // rob.turnLeft();
    }

    public static void printNumber(final Robot robot){
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
    }
}
