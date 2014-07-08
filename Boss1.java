import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends Enemy
{
    private ScoreBoard scoreboard;
    int waypointPassed = 0;
    boolean waypoint = false;
    int currentWaypointX;
    int currentWaypointY;
    int waypointOneX = 100;
    int waypointOneY = 220;
    int waypointTwoX = 350;
    int waypointTwoY = 220;
    int waypointThreeX = 350;
    int waypointThreeY = 475;
    int waypointFourX = 100;
    int waypointFourY = 475;
    int waypointFiveX = 100;
    int waypointFiveY = 680;
    int waypointSixX = 690;
    int waypointSixY = 680;
    int enemyHealth = 200;
    int timer = 9;
    int timer2 = 50;
    Background1 bkg;

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
        spawnEnemy();
    }    

    public void followPath()
    {
        if (waypointPassed == 0) /* sets starting direction of mob */
        {
            initDirection();
        }
        turnTowards(currentWaypointX, currentWaypointY);
        move(1);
    }

    public void initDirection()
    {
        currentWaypointX = waypointOneX;
        currentWaypointY = waypointOneY;
    }

    public void setNextWaypoint()
    {
        World world = getWorld();
        if(world instanceof Background1)
        {
            int waypointOneX = 100;
    int waypointOneY = 220;
    int waypointTwoX = 350;
    int waypointTwoY = 220;
    int waypointThreeX = 350;
    int waypointThreeY = 475;
    int waypointFourX = 100;
    int waypointFourY = 475;
    int waypointFiveX = 100;
    int waypointFiveY = 680;
    int waypointSixX = 690;
    int waypointSixY = 680;
}
if(world instanceof Background3){
    int waypointOneX = 600;
    int waypointOneY = 608;
    int waypointTwoX = 100;
    int waypointTwoY = 608;
    int waypointThreeX = 100;
    int waypointThreeY = 80;
    int waypointFourX = 480;
    int waypointFourY = 80;
    int waypointFiveX = 480;
    int waypointFiveY = 480;
    int waypointSixX = 190;
    int waypointSixY = 480;
    int waypointSevenX = 220;
    int waypointSevenY = 240;
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
        }
    }

    public void takeDamage()
    {
        Background world;
        world = (Background) getWorld();
        Actor foundBomb;
        Actor foundBullet;
        Actor foundBarrel;
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
        if (foundBomb !=null)
        {

            world.removeObject(foundBomb);
            enemyHealth--;
            if (enemyHealth == 50)
            {
                // setImage("smiley2.png"); 
            }
            if (enemyHealth == 30)
            {
                //setImage("smiley3.png"); 
            }
            if (enemyHealth == 15)
            { 
                //setImage("skull.png");
            }
        }
        if (enemyHealth <= 0)
        {
            BeatLevel1 win = new BeatLevel1();
            Greenfoot.setWorld(win);
            bkg.bkgMusic.stop();
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
            setImage("Flying Boss 4.png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 1) {
            setImage("Flying Boss 2.png"); 
            imageTimerCount2();
        }
        if (waypointPassed == 2) {
            setImage("Flying Boss 4.png");
            imageTimerCount3();
        }
        if (waypointPassed == 3) {
            setImage("Flying Boss 3.png"); 
            imageTimerCount4();
        }
        if (waypointPassed == 4) {
            setImage("Flying Boss 4.png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 5) {
            setImage("Flying Boss 2.png"); 
            imageTimerCount2();
        }

    }

    /**
     * This changes the zombie from waypoint 0 to waypoint 1
     */
    public void resettimer2()
    {
        timer2 = 50;
    }
    public void spawnEnemy()
    {
        Bat a = new Bat();
        Background world;
        world = (Background) getWorld();
        if (timer2 > 0)
        {
            timer2 --;
        }
        if (timer2 == 0)
        {
            world.addObject(a, getX(), getY());
            resettimer2();
        }
        
    }

    public void imageTimerCountInitial()
    {

        if ( timer > 0 ) {
            timer --; }
        if (timer == 7) 
        {
            setImage("Flying Boss 4.png"); 
        }
        if (timer == 5) 
        {
            setImage("Flying Boss 8.png"); 
        }
        if (timer == 3) 
        {
            setImage("Flying Boss 12.png");
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
            setImage("Flying Boss 2.png"); 
        }
        if (timer == 5) 
        {
            setImage("Flying Boss 6.png"); 
        }
        if (timer == 3) 
        {
            setImage("Flying Boss 10.png");
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
            setImage("Flying Boss 4.png"); 
        }
        if (timer == 5) 
        {
            setImage("Flying Boss 8.png"); 
        }
        if (timer == 3) 
        {
            setImage("Flying Boss 12.png");
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
            setImage("Flying Boss 3.png"); 
        }
        if (timer == 5) 
        {
            setImage("Flying Boss 7.png"); 
        }
        if (timer == 3) 
        {
            setImage("Flying Boss 11.png");
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
