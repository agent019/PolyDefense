import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends World
{

    /**
     * Constructor for objects of class Towers.
     * 
     */
    public Towers()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }

    private void prepare()
    {
        MainMenu mm = new MainMenu();
        addObject(mm, 550, 300);
        NextThree ntwo = new NextThree();
        addObject(ntwo, 550, 50);
        BackTwo b = new BackTwo();
        addObject(b, 550, 165);
    }
}
