import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeatLevel1 extends World
{
public GreenfootSound bkgMusic;
    /**
     * Constructor for objects of class WinMap1.
     * 
     */
    public BeatLevel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Background1.bkgMusic.stop();
    }
    public void act()
    {
    if( Greenfoot.mouseClicked(this))
        {
            Background2 go = new Background2();
            Greenfoot.setWorld(go);
        }
}
}
