import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
    private ScoreBoard scoreboard;
    int waypointPassed = 0;
    boolean waypoint = false;
    int currentWaypointX;
    int currentWaypointY;
    int waypointOneX = 100;
    int waypointOneY = 220;
    int waypointTwoX = 600;
    int waypointTwoY = 608;
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
    int enemyHealth = 10;
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
        move(2);/* MAKE SURE ALL WAYPOINTS ARE DIVISIBLE BY 2 OR WONT WORK*/
    }

    public void initDirection()
    {
        World world = getWorld();
        currentWaypointX = waypointOneX;
        currentWaypointY = waypointOneY;
        if (world instanceof Background3)
        {
            currentWaypointX = waypointTwoX;
            currentWaypointY = waypointTwoY;
        }
    }

    public void setNextWaypoint()
    {
        World world = getWorld();

        if (world instanceof Background1 )
        {
            waypointOneX = 100;
            waypointOneY = 222;
            waypointTwoX = 350;
            waypointTwoY = 222;
            waypointThreeX = 350;
            waypointThreeY = 474;
            waypointFourX = 100;
            waypointFourY = 474;
            waypointFiveX = 100;
            waypointFiveY = 680;
            waypointSixX = 690;
            waypointSixY = 681;
        }

        if (world instanceof Background2)
        {
            waypointOneX = 100;
            waypointOneY = 222;
            waypointTwoX = 350;
            waypointTwoY = 222;
            waypointThreeX = 350;
            waypointThreeY = 450;
            waypointFourX = 578;
            waypointFourY = 450;
            waypointFiveX = 578;
            waypointFiveY = 672;
            waypointSixX = 690;
            waypointSixY = 672;
        }
        if (world instanceof Background3)
        {
            waypointOneX = 200;
            waypointOneY = 600;
            waypointTwoX = 600;
            waypointTwoY = 608;
            waypointThreeX = 100;
            waypointThreeY = 608;
            waypointFourX = 100;
            waypointFourY = 80;
            waypointFiveX = 480;
            waypointFiveY = 80;
            waypointSixX = 480;
            waypointSixY = 480;
            waypointSevenX = 230;
            waypointSevenY = 480;
            waypointEightX = 240;
            waypointEightY = 230;              
        }
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
        }else if (waypointPassed == 6)
        {
            currentWaypointX = waypointSevenX;
            currentWaypointY = waypointSevenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }else if (waypointPassed == 7)
        {
            currentWaypointX = waypointEightX;
            currentWaypointY = waypointEightY;
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
            if (enemyHealth == 3)
            {
                //setImage("smiley2.png"); 
            }
            if (enemyHealth == 2)
            {
                // setImage("smiley3.png"); 
            }
            if (enemyHealth == 1)
            { 
                //setImage("skull.png");
            }
        }
        if (enemyHealth <= 0)
        {
            GreenfootSound splat = new GreenfootSound("Splat.mp3");
            splat.play(); 
            world.removeObject(this);
            world.addScore(3);
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
        World world = getWorld();
        if(world instanceof Background1)
        {

            if (waypointPassed == 0 ){
                setImage("Zombie(3)1.PNG");
                imageTimerCountInitial();
            }
            if (waypointPassed == 1) {
                setImage("Zombie(3)7.png"); 
                imageTimerCount2();
            }
            if (waypointPassed == 2) {
                setImage("Zombie(3)1.PNG");
                imageTimerCount3();
            }
            if (waypointPassed == 3) {
                setImage("Zombie(3)4.PNG");
                imageTimerCount4();
            }
            if (waypointPassed == 4) {
                setImage("Zombie(3)1.PNG"); 
                imageTimerCountInitial();
            }
            if (waypointPassed == 5) {
                setImage("Zombie(3)7.png"); 
                imageTimerCount2();
            }}
        if(world instanceof Background2)
        {
            if (waypointPassed == 0 ){
                setImage("Zombie(3)1.PNG");
                imageTimerCountInitial();
            }
            if (waypointPassed == 1) {
                setImage("Zombie(3)7.png"); 
                imageTimerCount2();
            }
            if (waypointPassed == 2) {
                setImage("Zombie(3)1.PNG");
                imageTimerCount3();
            }
            if (waypointPassed == 3) {
                setImage("Zombie(3)7.png"); 
                imageTimerCount2();
            }
            if (waypointPassed == 4) {
                setImage("Zombie(3)1.PNG");
                imageTimerCount3();
            }
            if (waypointPassed == 5) {
                setImage("Zombie(3)7.png"); 
                imageTimerCount2();
            }
        }

        if (world instanceof Background3) {
            if (waypointPassed == 0) {
                setImage("Zombie(3)1 walk.png");
                imageTimerCountInitial();
            }
            if (waypointPassed == 1) {
                setImage("Zombie(3)4.PNG");
                imageTimerCount4();
            }
            if (waypointPassed == 2) {
                setImage("Zombie(3)4.PNG");
                imageTimerCount4();
            }
            if (waypointPassed == 3) {
                setImage("Zombie(3)10.png");
                imageTimerCount5();
            }
            if (waypointPassed == 4) {
                setImage("Zombie(3)7.png");
                imageTimerCount2();
            }
            if (waypointPassed == 5) {
                setImage("Zombie(3)1 walk.png");
                imageTimerCountInitial();
            }
            if (waypointPassed == 6) {
                setImage("Zombie(3)4.PNG");
                imageTimerCount4();
            }
            if (waypointPassed == 7) {
                setImage("Zombie(3)10.png");
                imageTimerCount5();
            }
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
            setImage("Zombie(3)1.PNG"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(3)2.PNG"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(3)3.PNG");
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
            setImage("Zombie(3)7.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(3)8.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(3)9.png");
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
            setImage("Zombie(3)1.PNG"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(3)2.PNG"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(3)3.PNG");
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
            setImage("Zombie(3)4.PNG"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(3)5.PNG"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(3)6.PNG");
        }
        if (timer == 0) {
            imageTimer(); } 
    }

    public void imageTimerCount5()
    {
        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Zombie(3)10.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(3)11.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(3)12.png");
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
