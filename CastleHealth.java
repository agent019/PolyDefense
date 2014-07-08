import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class CastleHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CastleHealth extends Actor
{
    private GreenfootImage chboard;
    private GreenfootImage ch;
    private int health = 20;
    private String label = "Lives Left: ";
    
    
    public CastleHealth()
    {
        super();
        
        
        int boardWidth = 200;
        int boardHeight = 50;
        int boardTransparency = 150;
        
        chboard = new GreenfootImage(boardWidth, boardHeight);
        chboard.setColor(Color.gray);
        chboard.setTransparency(boardTransparency);
        chboard.fillRect(0, 0, boardWidth, boardHeight);
        this.setImage(chboard);
        
        update();
    }
        
    public void act() 
    {
        // Add your action code here.
    }    
    public int getHealth()
    {
        return health;
    }
    public void subtractHealth(int hp)
    {

        health -= hp;
        update();
    }
    private void update()
    {
        ch = new GreenfootImage(chboard);
        ch.drawImage(new GreenfootImage(label + health, 18, Color.WHITE, new Color(0,0,0,0)), 25,5);
        this.setImage(ch);
    }
}
