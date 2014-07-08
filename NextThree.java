import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextThree extends Button
{
    /**
     * Act - do whatever the NextThree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( Greenfoot.mouseClicked(this))
        {
            Enemies dworld = new Enemies();
            Greenfoot.setWorld(dworld);
        }    
    }
}
