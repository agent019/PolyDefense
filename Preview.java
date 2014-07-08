import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Preview here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Preview extends World
{

    /**
     * Constructor for objects of class Preview.
     * 
     */
    public Preview()
    {    
        super(600, 400, 1);
        prepare();
    }
    
    private void prepare()
    {
        MainMenu mm = new MainMenu();
        addObject(mm, 550, 300);
        Next n = new Next();
        addObject(n, 550, 50);
    }
}
