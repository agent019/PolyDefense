import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroScreen extends World
{
    public static GreenfootSound bkgMusic = null;
    /**
     * Constructor for objects of class IntroScreen.
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 700, 1);
        if( bkgMusic == null )
        {
            bkgMusic = new GreenfootSound("Remember.mp3");
            bkgMusic.playLoop();
        }
        prepare();
    }

    private void prepare()
    {
        Instructions ins = new Instructions();
        addObject(ins, 200, 650);
        Play p = new Play();
        addObject(p, 520, 650);
    }
}
