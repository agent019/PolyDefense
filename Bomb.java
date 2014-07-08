import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tower1 projectile
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Projectile
{
    int xDestination;
    int yDestination;
    int moveCounter = 0;
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveToEnemy();
        checkEnemyMissed();
    }    

    public void setDestination(int x, int y)
    {
        xDestination = x;
        yDestination = y;
    }

    public void moveToEnemy()
    {
        if (moveCounter == 0)
        {
            turnTowards(xDestination, yDestination);
        }
        move(50);
        moveCounter++;
    }

    public void checkEnemyMissed()
    {
        if (moveCounter == 5)
        {
            World world = getWorld();
            world.removeObject(this);
        }

    }
}
