import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackTwo extends Button
{
    /**
     * Act - do whatever the BackTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( Greenfoot.mouseClicked(this))
        {
            Objective bworld = new Objective();
            Greenfoot.setWorld(bworld);
        }
    }    
}
