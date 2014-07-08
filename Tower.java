import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.lang.Math;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    int towerAttackRadius;  //Distance that tower can attack
    int stockXLocation;  //X location for the stock tower used to create towers
    int stockYLocation;  //Y location for the stock tower used to create towers
    boolean isTowerClicked = false;
    boolean isTowerPlaced = false;
    int newBombCountdown;
    int newBulletCountdown;
    int towerCost;
    List<Enemy> objectsInRange;
    Enemy target;
    int targetX;
    int targetY;
    GreenfootImage towerRadius;
    GreenfootImage theTower;
    public ScoreBoard scoreboard;
    public Background bkg;

    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        sellTower();
    }

    public void sellTower()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(this) == true && mouse.getButton() == 3 && isTowerPlaced == true)
        {
            Background bkg = (Background) getWorld();
            bkg.addScore(towerCost/2);
            World world = getWorld();
            world.removeObject(this);
        }
    }

    public int getStockXLocation()
    {
        return stockXLocation;
    }

    public int getStockYLocation()
    {
        return stockYLocation;
    }

    public void getTarget()
    {
        objectsInRange = getObjectsInRange(towerAttackRadius, Enemy.class);
        if (objectsInRange.isEmpty())
        {
            target = null;
            return;
        }
        Enemy tempTarget = null;
        Enemy tempTarget2 = null;
        for (int i = 0; i < objectsInRange.size(); i++)
        {
            if (tempTarget == null)
            {
                tempTarget = objectsInRange.get(i);
            }
            else if (tempTarget != null)
            {
                tempTarget2 = objectsInRange.get(i);
                if (tempTarget2.getWaypointPassed() > tempTarget.getWaypointPassed())
                {    
                    tempTarget = tempTarget2;
                }
                if (tempTarget2.getWaypointPassed() == tempTarget.getWaypointPassed())
                {
                    if (tempTarget2.getX() == tempTarget.getX())
                    {
                        if (Math.abs(tempTarget2.getWaypointY() - tempTarget2.getY()) < Math.abs(tempTarget.getWaypointY() - tempTarget.getY()))
                        {
                            tempTarget = tempTarget2;
                        }
                    }
                    else if (tempTarget2.getY() == tempTarget.getY())
                    {
                        if (Math.abs(tempTarget2.getWaypointX() - tempTarget2.getX()) < Math.abs(tempTarget.getWaypointX() - tempTarget.getX()))
                        {
                            tempTarget = tempTarget2;
                        }
                    }
                }
            }
            if (i == objectsInRange.size() - 1)
            {    
                target = tempTarget;
            }
        }
        targetX = target.getX();
        targetY = target.getY();
    }

    public void followMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse !=null && isTowerClicked == true) 
        {
            setLocation(mouse.getX(), mouse.getY());
        }
    }

}
