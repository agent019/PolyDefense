import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objective here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objective extends World
{

    /**
     * Constructor for objects of class Objective.
     * 
     */
    public Objective()
    {    
        super(600, 400, 1);
        prepare();
    }
    
    private void prepare()
    {
        MainMenu mm = new MainMenu();
        addObject(mm, 550, 300);
        NextTwo ntwo = new NextTwo();
        addObject(ntwo, 550, 50);
        Back b = new Back();
        addObject(b, 550, 165);
    }
}
