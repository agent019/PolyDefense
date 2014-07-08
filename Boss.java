import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends World
{

    /**
     * Constructor for objects of class Boss.
     * 
     */
    public Boss()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }

    public void prepare()
    {
        MainMenu mm = new MainMenu();
        addObject(mm, 550, 300);
        BackFour b = new BackFour();
        addObject(b, 550, 165);
    }
}
