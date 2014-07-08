import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackThree extends Button
{
    /**
     * Act - do whatever the BackThree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( Greenfoot.mouseClicked(this))
        {
            Towers bworld = new Towers();
            Greenfoot.setWorld(bworld);
        }
    }    
}
