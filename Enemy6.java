import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy6 extends Enemy
{

    int waypointPassed = 0;
    boolean waypoint = false;
    int currentWaypointX;
    int currentWaypointY;
    int waypointOneX = 356;
    int waypointOneY = 460;
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
    int waypointSevenX;
    int waypointSevenY;
    int waypointEightX;
    int waypointEightY;
    int enemyHealth = 6;
    int timer = 9;

    public void act() 
    {
        int currentX = getX();
        int currentY = getY();
        if (currentX == currentWaypointX && currentY == currentWaypointY)
        {
            waypoint = true;
        }
        if (waypoint == true) /* resets waypoint and sets a new waypoint once a waypoint has been hit */
        {
            waypointPassed++;
            waypoint = false;
            setNextWaypoint(); 
        }
        followPath();
        takeDamage();
        imageOne();
    }    

    public void followPath()
    {
        if (waypointPassed == 0) /* sets starting direction of mob */
        {
            initDirection();
        }
        turnTowards(currentWaypointX, currentWaypointY);
        move(2 ); /* MAKE SURE ALL WAYPOINTS ARE DIVISIBLE BY 4 OR WONT WORK*/
    }

    public void initDirection()
    {
        
        currentWaypointX = waypointOneX;
        currentWaypointY = waypointOneY;
    }

    public void setNextWaypoint()
    {
            waypointOneX = 356;
            waypointOneY = 460;
            waypointTwoX = 580;
            waypointTwoY = 460;
            waypointThreeX = 580;
            waypointThreeY = 672;
            waypointFourX = 696;
            waypointFourY = 672;
            
            if (waypointPassed == 1)
            {
                currentWaypointX = waypointTwoX;
                currentWaypointY = waypointTwoY;
                turnTowards(currentWaypointX, currentWaypointY);
            } else if (waypointPassed == 2)
            {
                currentWaypointX = waypointThreeX;
                currentWaypointY = waypointThreeY;
                turnTowards(currentWaypointX, currentWaypointY);
            } else if (waypointPassed == 3)
            {
                currentWaypointX = waypointFourX;
                currentWaypointY = waypointFourY;
                turnTowards(currentWaypointX, currentWaypointY);
            } else if (waypointPassed == 4)
            {
                currentWaypointX = waypointFiveX;
                currentWaypointY = waypointFiveY;
                turnTowards(currentWaypointX, currentWaypointY);
            } else if (waypointPassed == 5)
            {
                currentWaypointX = waypointSixX;
                currentWaypointY = waypointSixY;
                turnTowards(currentWaypointX, currentWaypointY);
            }
        }
    
    

    public void takeDamage()
    {
        Background world;
        world = (Background) getWorld();
        Actor foundBomb;
        Actor foundBarrel;
        Actor foundBullet;
        foundBarrel = getOneIntersectingObject(DamageBarrel.class);
        foundBomb = getOneIntersectingObject(Bomb.class);
        foundBullet = getOneIntersectingObject(Bullet.class);
        Explosion explosion = new Explosion();

        if(foundBullet != null )
        {
            world.removeObject(foundBullet);
            enemyHealth = enemyHealth -3;
        }
        if(foundBarrel != null )
        {
            world.removeObject(foundBarrel);
            enemyHealth = enemyHealth - 8;
            world.addObject(explosion, getX(), getY());
        }
        if (foundBomb != null)
        {
            
            world.removeObject(foundBomb);
            enemyHealth--;
            
        }
         if (enemyHealth <= 0)
            {
              
                world.removeObject(this);
                world.addScore(1);
            }
        }
    

    /**
     * Starts the timer
     */
    public void imageTimer()
    {
        timer = 9;
    }

    public void imageOne()
    {
        if (waypointPassed == 0 ){
            setImage("Zombie(2)1 correct.png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 1) {
            setImage("Zombie(2)7.png"); 
            imageTimerCount2();
        }
        if (waypointPassed == 2) {
            setImage("Zombie(2)1 correct.png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 3) {
            setImage("Zombie(2)7.png"); 
            imageTimerCount2();
        }
        if (waypointPassed == 4) {
            setImage("Zombie1(first).png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 5) {
            setImage("Zombie 7.png"); 
            imageTimerCount2();
        }

    }

    /**
     * This changes the zombie from waypoint 0 to waypoint 1
     */
    public void imageTimerCountInitial()
    {
        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Zombie(2)2 correct.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)3 correct.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)1 correct.png");
        }
        if (timer == 0) {
            imageTimer(); }
    }

    public void imageTimerCount2()
    {
        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Zombie(2)7.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)9.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)7.png");
        }
        if (timer == 0) {
            imageTimer(); } 
    }

    public void imageTimerCount3()
    {
        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Zombie1(first).png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie2(first).png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie3(first).png");
        }
        if (timer == 0) {
            imageTimer(); } 
    }

    public void imageTimerCount4()
    {
        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Zombie 4(flipped).png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie 5(flipped).png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie 6(flipped).png");
        }
        if (timer == 0) {
            imageTimer(); } 
    }
}
/*class still needs the following for the prototype:
 * Health Bar System - Create a red rectangle, with a green rectangle on top that shrinks
 *     according to the amount of health left per enemy.
 * Health System - Keeps track of the number of health points left on the current monster
 *     as related to the amount of damage taken. Related to the health bar system. Can
 *     use the same variables.
 * Constructor - Has initial health and move values, allowing those to be changed by the
 *     towers at later points.
 * Waves - Create waves of enemies that spawn with time between each.
 */
