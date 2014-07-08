import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeatLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeatLevel2 extends World
{
public GreenfootSound bkgMusic;
    /**
     * Constructor for objects of class BeatLevel2.
     * 
     */
    public BeatLevel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Background2.bkgMusic.stop();
    }
    public void act()
    {
        if( Greenfoot.mouseClicked(this))
        {
            Background3 go = new Background3();
            Greenfoot.setWorld(go);
        }
    }
}
