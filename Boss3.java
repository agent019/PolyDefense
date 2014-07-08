import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss3 extends Enemy
{
    private ScoreBoard scoreboard;
    boolean waypoint = false;
    int waypointOneX = 600;
    int waypointOneY = 612;
    int waypointTwoX = 108;
    int waypointTwoY = 612;
    int waypointThreeX = 108;
    int waypointThreeY = 84;
    int waypointFourX = 480;
    int waypointFourY = 84;
    int waypointFiveX = 480;
    int waypointFiveY = 480;
    int waypointSixX = 232;
    int waypointSixY = 480;
    int waypointSevenX = 232;
    int waypointSevenY = 240;
    int enemyHealth = 400;
    Background3 bkg;

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
        move(1);

    }

    public void imageOne()
    {
        if (waypointPassed == 0 ){
            setImage("finalboss1.png"); 
        }
        if (waypointPassed == 1) {
            setImage("finalboss2.png"); 

        }
        if (waypointPassed == 2) {
            setImage("finalboss4.png");

        }
        if (waypointPassed == 3) {
            setImage("finalboss3.png"); 

        }
        if (waypointPassed == 4) {
            setImage("finalboss1.png"); 

        }
        if (waypointPassed == 5) {
            setImage("finalboss2.png"); 

        }
        if( waypointPassed == 6){
            setImage("finalboss4.png");

        }

    }

    public void initDirection()
    {
        currentWaypointX = waypointOneX;
        currentWaypointY = waypointOneY;
    }

    public void setNextWaypoint()
    {
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
        } else if (waypointPassed == 6)
        {
            currentWaypointX = waypointSevenX;
            currentWaypointY = waypointSevenY;
            turnTowards(currentWaypointX, currentWaypointY);
        }
    }

    public void takeDamage()
    {
        Background world;
        world = (Background) getWorld();
        Background3 background = (Background3) getWorld();
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

            if (enemyHealth <= 0)
            {
                background.victory();
                bkg.bkgMusic.stop();

            }

        }
    }

    public int getHealth()
    {
        return enemyHealth;
    }
}