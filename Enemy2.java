import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    int waypointSixY ;
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
        move(1);/* MAKE SURE ALL WAYPOINTS ARE DIVISIBLE BY 3 OR WONT WORK*/
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
            waypointOneX = 99;
            waypointOneY = 222;
            waypointTwoX = 351;
            waypointTwoY = 222;
            waypointThreeX = 351;
            waypointThreeY = 450;
            waypointFourX = 99;
            waypointFourY = 450;
            waypointFiveX = 99;
            waypointFiveY = 672;
            waypointSixX = 690;
            waypointSixY = 672;
        }

        if (world instanceof Background2)
        {
            waypointOneX = 99;
            waypointOneY = 222;
            waypointTwoX = 351;
            waypointTwoY = 222;
            waypointThreeX = 351;
            waypointThreeY = 450;
            waypointFourX = 579;
            waypointFourY = 450;
            waypointFiveX = 579;
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
            waypointSevenX = 232;
            waypointSevenY = 480;
            waypointEightX = 240;
            waypointEightY = 232;              
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
            world.addScore(2);
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
        if(world instanceof Background1){
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
                imageTimerCount3();
            }
            if (waypointPassed == 3) {
                setImage("Zombie(2)4 flipped.png"); 
                imageTimerCount4();
            }
            if (waypointPassed == 4) {
                setImage("Zombie(2)1 correct.png"); 
                imageTimerCountInitial();
            }
            if (waypointPassed == 5) {
                setImage("Zombie(2)7.png"); 
                imageTimerCount2();
            }
        }
        if(world instanceof Background2)
        {
            if( waypointPassed == 0)
            {
                setImage("Zombie(2)1 correct.png");
                imageTimerCountInitial();
            }
            if ( waypointPassed == 1)
            {
                setImage("Zombie(2)7.png");
                imageTimerCount2();
            }
            if( waypointPassed == 2)
            {
                setImage("Zombie(2)1 correct.png");
                imageTimerCountInitial();
            }
            if ( waypointPassed == 3)
            {
                setImage("Zombie(2)7.png");
                imageTimerCount2();
            }
            if( waypointPassed == 4)
            {
                setImage("Zombie(2)1 correct.png");
                imageTimerCountInitial();
            }
            if ( waypointPassed == 5)
            {
                setImage("Zombie(2)7.png");
                imageTimerCount2();
            }
        }
        if (world instanceof Background3) {
            if (waypointPassed == 0) {
                setImage("Zombie(2)1 correct.png");
                imageTimerCountInitial();
            }
            if (waypointPassed == 1) {
                setImage("Zombie(2)4 flipped.png");
                imageTimerCount4();
            }
            if (waypointPassed == 2) {
                setImage("Zombie(2)4 flipped.png");
                imageTimerCount4();
            }
            if (waypointPassed == 3) {
                setImage("Zombie(2)11.png");
                imageTimerCount5();
            }
            if (waypointPassed == 4) {
                setImage("Zombie(2)7.png");
                imageTimerCount2();
            }
            if (waypointPassed == 5) {
                setImage("Zombie(2)1 correct.png");
                imageTimerCountInitial();
            }
            if (waypointPassed == 6) {
                setImage("Zombie(2)4 flipped.png");
                imageTimerCount4();
            }
            if (waypointPassed == 7) {
                setImage("Zombie 11.png");
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
            setImage("Zombie(2)1 correct.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)2 correct.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)3 correct.png");
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
            setImage("Zombie(2)8.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)9.png");
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
            setImage("Zombie(2)1 correct.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)2 correct.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)3 correct.png");
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
            setImage("Zombie(2)4 flipped.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)5 flipped.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)6 flipped.png");
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
            setImage("Zombie(2)11.png"); 
        }
        if (timer == 5) 
        {
            setImage("Zombie(2)10.png"); 
        }
        if (timer == 3) 
        {
            setImage("Zombie(2)11.png");
        }
        if (timer == 0) {
            imageTimer(); } 
    }
}

