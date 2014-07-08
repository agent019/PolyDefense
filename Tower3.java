import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class Tower2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower3 extends Tower

{
    /**
     * Act - do whatever the Tower2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Tower3() //Constructor
    {
        towerCost = 40;
        stockXLocation = 650;  //X location for the stock tower used to create towers
        stockYLocation = 150;  //Y location for the stock tower used to create towers
        newBombCountdown = 1;
        towerAttackRadius = 200;  //Distance that tower can attack
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
        if (isTowerPlaced == true && isTowerClicked == false)
        {
            getTarget();
            createBomb();
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && isTowerPlaced == true)
        {
            if ((mouse.getX() > (getX() - 10)) && (mouse.getX() < (getX() + 10)) && (mouse.getY() > (getY() - 10)) && (mouse.getY() < (getY() + 10)))
            {
                showRadius();
            }
            else if (getImage() == towerRadius)
            {
                setImage("Soldier1.png");
            }
        }
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
            showRadius();
        }
    }
     public void getTarget()
    {
        objectsInRange = getObjectsInRange(towerAttackRadius, Enemy.class);
        if (objectsInRange.isEmpty())
        {
            target = null;
        }
        else
        {
            target = objectsInRange.get(objectsInRange.size() - 1);
            targetX = target.getX();
            targetY = target.getY();
        }
    }

    public void createBomb()
    {
        if (target != null)
        {
            if (newBombCountdown-- == 0)
            {
                Bomb bomb = new Bomb();
                World world = getWorld();
                world.addObject(bomb, getX(), getY());
                bomb.setDestination(targetX, targetY);
                newBombCountdown = 12;
            }
        }
    }


    public void placeTower()
    {
        Background bkg;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(null) == true && mouse.getButton() == 1 )
        {
            bkg = (Background) getWorld();
            isTowerPlaced = true;
            this.setLocation(mouse.getX(), mouse.getY());
            bkg.addScore(-towerCost);
            Tower3 tower = new Tower3();
            World world = getWorld();
            world.addObject(tower, stockXLocation, stockYLocation);
            isTowerClicked = false;
        }
    }

    public void showRadius()
    {
        towerRadius = new GreenfootImage(towerAttackRadius * 2, towerAttackRadius * 2);
        theTower = new GreenfootImage("Soldier1.png");
        towerRadius.setColor(Color.blue);
        towerRadius.fillOval(0, 0, towerAttackRadius * 2, towerAttackRadius *2);
        towerRadius.setTransparency(150);
        towerRadius.drawImage(theTower, towerAttackRadius - 25, towerAttackRadius - 25);
        setImage(towerRadius);
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
