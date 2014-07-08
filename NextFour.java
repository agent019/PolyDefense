import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextFour extends Button
{
    /**
     * Act - do whatever the NextFour wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( Greenfoot.mouseClicked(this))
        {
            Boss dworld = new Boss();
            Greenfoot.setWorld(dworld);
        }  
    }    
}
