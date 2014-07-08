import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Enemy
{

    int enemyHealth = 2;
    int timer = 6;

    public void act() 
    {

        moveToCastle();
        takeDamage();
        changeImage();

    }    

    public void moveToCastle()
    {
        World world = getWorld();
        if(world instanceof Background1)
        {
            turnTowards(675, 675);
            move(3);
        }
        if(world instanceof Background3)
        {
            turnTowards(220, 240);
            move(3);
        }
    }

    public void takeDamage()
    {
        Background world;
        world = (Background) getWorld();
        Actor foundBomb;
        Actor foundBullet;
        foundBomb = getOneIntersectingObject(Bomb.class);
        foundBullet = getOneIntersectingObject(Bullet.class);
        if(foundBullet != null)
        {

            world.removeObject(foundBullet);
            enemyHealth = enemyHealth - 3;

        }
        if (foundBomb != null)
        {

            world.removeObject(foundBomb);
            enemyHealth--;

            if (enemyHealth <= 0)

            {

                world.removeObject(this);
                world.addScore(1);
            }
        }
    }

    public void imageTimer()
    {
        timer = 6;
    }

    public void changeImage()
    {
        if ( timer > 0 ){
            timer--;}
        if (timer == 3)
        {
            setImage("bat2.png");
        }
        if (timer == 0) 
        {
            imageTimer();
            setImage("bat1.png");
        }
    }

}