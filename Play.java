import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IntroScreen intro;
    public void act() 
    {
        if( Greenfoot.mouseClicked(this))
        {
            Background1 world = new Background1();
            Greenfoot.setWorld(world);
            intro.bkgMusic.stop();
        }
    }    
}
