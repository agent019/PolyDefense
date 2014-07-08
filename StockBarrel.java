import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class Tower1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockBarrel extends Tower
{


    /**
     * Act - do whatever the Tower1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public StockBarrel() //Constructor
    {
        towerCost = 5;
        towerAttackRadius = 200;  //Distance that tower can attack
        stockXLocation = 650;  //X location for the stock tower used to create towers
        stockYLocation = 200;  //Y location for the stock tower used to create towers
       
    }

    public void act() 
    {
        
         Actor foundTower;
        foundTower = getOneObjectAtOffset(0, 0, Tower.class);

        if (isTowerPlaced == false )
        {
            if ( isTowerClicked == true &&  foundTower == null )
            {
                placeTower();
            }
            else
            {
                createTower();
            }
        }
        followMouse();
        
        
        super.act();
        
    }
    
       public void createTower()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Background bkg = (Background) getWorld();
        if (bkg.getScore() >= towerCost)
        {

            if (Greenfoot.mouseClicked(this) == true && mouse.getButton() == 1 ) 
            {
                isTowerClicked = true;
            }
        }

        if (mouse !=null && isTowerClicked == true) 
        {
            setLocation(mouse.getX(), mouse.getY());
            //showRadius();
           
        }
    }

    public void placeTower()
    {
        Background bkg;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(null) == true && mouse.getButton() == 1 )
        {
            bkg = (Background) getWorld();
            World world = getWorld();
            isTowerPlaced = true;
            DamageBarrel dmgbarrel = new DamageBarrel();
            world.addObject(dmgbarrel, mouse.getX(), mouse.getY());
            world.removeObject(this);
            bkg.addScore(-5);
            StockBarrel barrel = new StockBarrel();
            
            world.addObject(barrel, stockXLocation, stockYLocation);
            isTowerClicked = false;
        }
    }
}

/*class still needs the following for the prototype:
 * Select closest object - Out of the objects returned with the getObjectsInRange()
 *     function, select the one that is closest to the end of the track (possibly
 *     check current position (in pixels) versus the next waypoint, and compare
 *     waypoints to see which is closer to the end?) to aim at.
 * Firing - Fire at an enemy and do damage to it, resulting in a monetary reward
 *     and a score reward as the enemy is killed and removed from the map.
 * Selection - Have a sidebar with towers on it and a way to select and place one
 *     on the map.
 * Tower cost - Make selecting a tower cost a certain amount of money and placing
 *     a tower subtracts that much money from the current bank amount.
 */
