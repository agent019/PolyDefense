import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends Enemy
{
    Background2 bkg;
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
    int waypointNineX;
    int waypointNineY;
    int waypointTenX;
    int waypointTenY;
    int waypointElevenX;
    int waypointElevenY;
    int waypointTwelveX;
    int waypointTwelveY;
    int waypointThirteenX;
    int waypointThirteenY;
    int waypointFourteenX;
    int waypointFourteenY;
    int waypointFifteenX;
    int waypointFifteenY;
    int waypointSixteenX;
    int waypointSixteenY;
    int waypointSeventeenX;
    int waypointSeventeenY;
    int waypointEighteenX;
    int waypointEighteenY;
    int waypointNineteenX;
    int waypointNineteenY;
    int waypointTwentyX;
    int waypointTwentyY;
    int waypoint21X;
    int waypoint21Y;
    int waypoint22X;
    int waypoint22Y;
    int waypoint23X;
    int waypoint23Y;
    int waypoint24X;
    int waypoint24Y;
    int waypoint25X;
    int waypoint25Y;
    int waypoint26X;
    int waypoint26Y;
    int waypoint27X;
    int waypoint27Y;
    int waypoint28X;
    int waypoint28Y;
    int waypoint29X;
    int waypoint29Y;
    int waypoint30X;
    int waypoint30Y;
    int waypoint31X;
    int waypoint31Y;
    int waypoint32X;
    int waypoint32Y;
    int enemyHealth = 450;
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
        move(2);

        imageOne();
    }    

    public void followPath()
    {
        if (waypointPassed == 0) /* sets starting direction of mob */
        {
            initDirection();

        }
        turnTowards(currentWaypointX, currentWaypointY);
        /* MAKE SURE ALL WAYPOINTS ARE DIVISIBLE BY 4 OR WONT WORK*/
    }

    public void initDirection()
    {
        World world = getWorld();
        currentWaypointX = waypointOneX;
        currentWaypointY = waypointOneY;

    }

    public void setNextWaypoint()
    {
        World world = getWorld();

        waypointOneX = 96;
        waypointOneY = 672;
        waypointTwoX = 96;
        waypointTwoY = 672;
        waypointThreeX = 576;
        waypointThreeY = 672;
        waypointFourX = 576;
        waypointFourY = 456;
        waypointFiveX = 336;
        waypointFiveY = 456;
        waypointSixX = 336;
        waypointSixY = 216;
        waypointSevenX = 96;
        waypointSevenY = 216;
        waypointEightX = 96;
        waypointEightY = 672;
        waypointNineX = 576;
        waypointNineY = 672;
        waypointTenX = 576;
        waypointTenY = 456;
        waypointElevenX = 336;
        waypointElevenY = 456;
        waypointTwelveX = 336;
        waypointTwelveY = 216;
        waypointThirteenX = 96;
        waypointThirteenY = 216;
        waypointFourteenX = 96;
        waypointFourteenY = 672;
        waypointFifteenX = 576;
        waypointFifteenY = 672;
        waypointSixteenX = 576;
        waypointSixteenY = 456;
        waypointSeventeenX = 336;
        waypointSeventeenY = 456;
        waypointEighteenX = 336;
        waypointEighteenY = 216;
        waypointNineteenX = 96;
        waypointNineteenY = 216;
        waypointTwentyX = 96;
        waypointTwentyY = 672;

        waypoint21X = 576;
        waypoint21Y = 672;
        waypoint22X = 576;
        waypoint22Y = 456;
        waypoint23X = 336;
        waypoint23Y = 456;
        waypoint24X = 336;
        waypoint24Y = 216;
        waypoint25X = 96;
        waypoint25Y = 216;
        waypoint26X = 96;
        waypoint26Y = 672;
        waypoint27X = 576;
        waypoint27Y = 672;
        waypoint28X = 576;
        waypoint28Y = 456;
        waypoint29X = 336;
        waypoint29Y = 456;
        waypoint30X = 336;
        waypoint30Y = 216;
        waypoint31X = 96;
        waypoint31Y = 216;
        waypoint32X = 96;
        waypoint32Y = 672;

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
        else if (waypointPassed == 8 )
        {
            currentWaypointX = waypointNineX;
            currentWaypointY = waypointNineY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 9 )
        {
            currentWaypointX = waypointTenX;
            currentWaypointY = waypointTenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 9 )
        {
            currentWaypointX = waypointTenX;
            currentWaypointY = waypointTenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 10 )
        {
            currentWaypointX = waypointElevenX;
            currentWaypointY = waypointElevenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 11 )
        {
            currentWaypointX = waypointTwelveX;
            currentWaypointY = waypointTwelveY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 12 )
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 13 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 14 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 15 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 16 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 17 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 18 )
        {
            currentWaypointX = waypointNineteenX;
            currentWaypointY = waypointNineteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 19 )
        {
            currentWaypointX = waypointTwentyX;
            currentWaypointY = waypointTwentyY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 20 )
        {
            currentWaypointX = waypoint21X;
            currentWaypointY = waypoint21Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 21 )
        {
            currentWaypointX = waypoint22X;
            currentWaypointY = waypoint22Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 22 )
        {
            currentWaypointX = waypoint23X;
            currentWaypointY = waypoint23Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 23 )
        {
            currentWaypointX = waypoint24X;
            currentWaypointY = waypoint24Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 24 )
        {
            currentWaypointX = waypoint25X;
            currentWaypointY = waypoint25Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 25 )
        {
            currentWaypointX = waypoint26X;
            currentWaypointY = waypoint26Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 26 )
        {
            currentWaypointX = waypoint27X;
            currentWaypointY = waypoint27Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 27 )
        {
            currentWaypointX = waypoint28X;
            currentWaypointY = waypoint28Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 28 )
        {
            currentWaypointX = waypoint29X;
            currentWaypointY = waypoint29Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 29 )
        {
            currentWaypointX = waypoint30X;
            currentWaypointY = waypoint30Y;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 30 )
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 31 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 32 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 33 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 34 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 35 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 36)
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 37 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 38 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 39 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 40 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 41 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 42 )
        {
            currentWaypointX = waypointNineteenX;
            currentWaypointY = waypointNineteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 43 )
        {
            currentWaypointX = waypointTwentyX;
            currentWaypointY = waypointTwentyY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 44 )
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 45 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 46 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 47 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 48 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 49 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 50 )
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 51 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 52 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 53 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 54 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 55 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 56 )
        {
            currentWaypointX = waypointThirteenX;
            currentWaypointY = waypointThirteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 57 )
        {
            currentWaypointX = waypointFourteenX;
            currentWaypointY = waypointFourteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 58 )
        {
            currentWaypointX = waypointFifteenX;
            currentWaypointY = waypointFifteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 59 )
        {
            currentWaypointX = waypointSixteenX;
            currentWaypointY = waypointSixteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 60 )
        {
            currentWaypointX = waypointSeventeenX;
            currentWaypointY = waypointSeventeenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
        else if (waypointPassed == 61 )
        {
            currentWaypointX = waypointEighteenX;
            currentWaypointY = waypointEighteenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
    }

    public void changeSpeed()
    {
        if( enemyHealth >= 250)
        {
            move(2);
        }
        if( enemyHealth < 250 && enemyHealth >= 100)
        {
            move(4);
        }
        if( enemyHealth < 100 && enemyHealth >= 50)
        {
            move (6);
        }
        if( enemyHealth < 50)
        {
            move(8);
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

            BeatLevel2 win = new BeatLevel2();
            Greenfoot.setWorld(win);
            bkg.bkgMusic.stop();
        }
    }

    public int getHealth()
    {
        return enemyHealth;
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
        if (waypointPassed == 0 || waypointPassed == 7 || waypointPassed == 13 || 
        waypointPassed == 19 || waypointPassed == 25 || waypointPassed == 31 || waypointPassed == 37
        || waypointPassed == 43 || waypointPassed == 49 || waypointPassed == 55 ||
        waypointPassed == 61)
        {
            setImage("troll1.png"); 
            imageTimerCountInitial();
        }
        if (waypointPassed == 2 || waypointPassed == 8 || waypointPassed == 14 || waypointPassed == 20 ||
        waypointPassed == 26 || waypointPassed == 32 || waypointPassed == 38 || waypointPassed == 44 
        || waypointPassed == 50 || waypointPassed == 56 ) 
        {
            setImage("troll7.png"); 
            imageTimerCount2();
        }
        if (waypointPassed == 3 || waypointPassed == 9 || waypointPassed == 15 || waypointPassed == 21
        || waypointPassed == 27 || waypointPassed == 33 || waypointPassed == 39 || waypointPassed  == 45 
        || waypointPassed == 51 || waypointPassed == 57) 
        {
            setImage("troll10.png"); 
            imageTimerCount3();
        }
        if (waypointPassed == 4 || waypointPassed == 10 || waypointPassed == 16 || waypointPassed == 22 || 
        waypointPassed == 28 || waypointPassed == 34 || waypointPassed == 40 || waypointPassed == 46 || 
        waypointPassed == 52 || waypointPassed == 58) {
            setImage("troll4.png"); 
            imageTimerCount4();

        }
        if (waypointPassed == 5 || waypointPassed == 11 || waypointPassed == 17 || waypointPassed == 23 || 
        waypointPassed == 29 || waypointPassed == 35 || waypointPassed == 41 || waypointPassed == 47 || 
        waypointPassed == 53 || waypointPassed == 59) {
            setImage("troll10.png"); 
            imageTimerCount3();
        }
        if (waypointPassed == 6 || waypointPassed == 12 || waypointPassed == 18 || waypointPassed == 24 || 
        waypointPassed == 30 || waypointPassed == 36 || waypointPassed == 42 || waypointPassed == 48 || 
        waypointPassed == 54 || waypointPassed == 60) {
            setImage("troll4.png"); 
            imageTimerCount4();
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
            setImage("troll1.png"); 
        }
        if (timer == 5) 
        {
            setImage("troll2.png"); 
        }
        if (timer == 3) 
        {
            setImage("troll3.png");
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
            setImage("troll7.png"); 
        }
        if (timer == 5) 
        {
            setImage("troll8.png"); 
        }
        if (timer == 3) 
        {
            setImage("troll9.png");
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
            setImage("troll10.png"); 
        }
        if (timer == 5) 
        {
            setImage("troll11.png"); 
        }
        if (timer == 3) 
        {
            setImage("troll12.png");
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
            setImage("troll4.png"); 
        }
        if (timer == 5) 
        {
            setImage("troll5.png"); 
        }
        if (timer == 3) 
        {
            setImage("troll6.png");
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
