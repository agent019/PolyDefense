import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    /**
     * Constructor for objects of class Background.
     * 
     */

    public ScoreBoard scoreboard;
    public CastleHealth chp;
    public int health = 20;

    public Background()
    {    
        // Create a new world with 700x700 cells with a cell size of 1x1 pixels.
        super(700, 700, 1); 

        //prepare();
        addNewTower();

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 525, 25);
    }

    public void addNewTower()
    {
        Tower1 t = new Tower1();
        Tower2 s = new Tower2();
        Tower3 q = new Tower3();
        StockBarrel r = new StockBarrel();
        addObject(t, t.getStockXLocation(), t.getStockYLocation());
        addObject(s, s.getStockXLocation(), s.getStockYLocation());
        addObject(q, q.getStockXLocation(), q.getStockYLocation());
        addObject(r, r.getStockXLocation(), r.getStockYLocation());
    }

    public void addScore(int x)
    {
        scoreboard.addScore(x);
    }

    public int getScore()
    {
        return scoreboard.getScore();
    }

    public void gameOver()
    {
        GameOverScreen go = new GameOverScreen();
        Greenfoot.setWorld(go);
        go.addScore(getScore());
    }
}

   