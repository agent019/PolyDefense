import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends World
{
    private ScoreBoard scoreboard;
    private int score = 0;

    /**
     * Constructor for objects of class YouWin.
     * 
     */
    public YouWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 100, 60);
        scoreboard.setLocation(370, 300);
        scoreboard.addScore(score);
    }

    public void act()
    {
        if( Greenfoot.mouseClicked(this))
        {
            IntroScreen go = new IntroScreen();
            Greenfoot.setWorld(go);
        }
    }

    public int getScore()
    {
        return scoreboard.getScore();
    }

    public void addScore(int x)
    {
        scoreboard.addScore(x);
    }

    public void setScore(int x)
    {
        score = x;
    }
}
