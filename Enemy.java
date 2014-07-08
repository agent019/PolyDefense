import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int waypointPassed = 0;
    int waypointOneX;
    int waypointOneY;
    int currentWaypointX = waypointOneX;
    int currentWaypointY = waypointOneY;
    int waypointTwoX;
    int waypointTwoY;
    int waypointThreeX;
    int waypointThreeY;
    int waypointFourX;
    int waypointFourY;
    int waypointFiveX;
    int waypointFiveY;
    int waypointSixX;
    int waypointSixY;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public int getWaypointPassed()
    {
        return waypointPassed;
    }

    public int getWaypointX()
    {
        return currentWaypointX;
    }

    public int getWaypointY()
    {
        return currentWaypointY;
    }
}
