import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle2 extends Castle
{
    /**
     * Act - do whatever the Castle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private ScoreBoard scoreboard;
    private int score = 0;
    public int castleHealth;
    public CastleHealth chp;  
    Background2 bkg;

    public Castle2()
    {
        castleHealth = 20;
    }

    public void act() 
    {
        takeDamage();
        checkDeath();
    }    

     public void takeDamage()
    {
        Background2 world;
        Actor enemy;
        Actor boss;
        enemy = getOneObjectAtOffset(0, 0, Enemy.class);
        boss = getOneObjectAtOffset(0, 0, Boss2.class);
        if (boss != null)
        {
            world = (Background2) getWorld();
            world.removeObject(boss);
            castleHealth = castleHealth - 20;
            world.subtractHealth(20);
            
        }
        if (enemy != null)
        {
            world = (Background2) getWorld();
            world.removeObject(enemy);
            castleHealth--;
            world.subtractHealth(1);
        }
        
            
    }

  public void checkDeath()
    {
        Background2 world;
        if (castleHealth <= 0)
        {
            world = (Background2) getWorld();
            world.gameOver();
            bkg.bkgMusic.stop();
        }
    }

    public int getScore()
    {
        return score;
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
