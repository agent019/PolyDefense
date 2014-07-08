import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background2 extends Background
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    public static GreenfootSound bkgMusic;
    public ScoreBoard scoreboard;
    public CastleHealth chp;
    public int health = 20;

    public Background2()
    {    
        // Create a new world with 700x700 cells with a cell size of 1x1 pixels.
        //super(700, 700, 1); 
        bkgMusic = new GreenfootSound("Rose_at_Midnight.mp3");
        bkgMusic.playLoop();
        prepare();
        //addNewTower();

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Castle2 castle = new Castle2();
        addObject(castle, 660, 670);
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 525, 25);
        chp = new CastleHealth();
        addObject(chp, 400, 600);
        scoreboard.addScore(30);

    }

    int waveNumber = 1;
    int i = 0;
    int timer = -200;
    int secondaryTimer = 0;

    public void addScore(int x)
    {
        scoreboard.addScore(x);
    }

    public int getScore()
    {
        return scoreboard.getScore();
    }

    public void subtractHealth(int hp)
    {
        chp.subtractHealth(hp);
    }

    public void spawnEnemies()
    {
        Enemy1 a = new Enemy1();
        Enemy2 b = new Enemy2();
        Enemy3 c = new Enemy3();
        Enemy4 d = new Enemy4();
        Enemy5 e = new Enemy5();
        Boss2 f = new Boss2();
        Enemy6 g = new Enemy6();

        switch (waveNumber)
        {
            case 1: 
            { 
                if (  i < 10)
                {
                    addObject(a, 100, -30);
                    i++;

                    if( i == 1 )
                    {
                        addObject(e, 350, -30);
                        i++;
                    }
                    break;

                }
                else
                {
                    waveNumber++;
                    i = 0;
                    break;
                }
            }
            case 2:
            {
                if ( i < 20)
                {
                    addObject(b, 100, -30);
                    i++;
                    if (  i == 10 )
                    {
                        addObject(a, 100, -30);
                        i++;

                    }
                    if( i == 2 || i == 8 || i == 18)
                    {
                        addObject(e, 350, -30);
                        i++;
                    }
                    break;

                }
                else
                {
                    waveNumber++;
                    i = 0;
                    break;
                }
            }
            case 3:
            {
                if (i < 25)
                {
                    addObject(c, 100, -30);

                    i++;
                    if ( i == 8 || i == 16 || i == 24 )
                    {
                        addObject(b, 100, -30);
                        i++;
                    }
                    if ( i == 6 || i == 18 )
                    {
                        addObject(a, 100, -30);
                        i++;

                    }
                    if( i == 4 || i == 10 || i == 22)
                    {
                        addObject(e, 350, -30);

                    }
                    break;
                }
                else
                {
                    waveNumber++;
                    i = 0;
                    break;
                }
            }
            case 4:
            {
                if (i < 30)
                {
                    addObject(d, 100, -30);

                    i++;
                    if( i == 5 || i == 15 || i == 25)
                    {
                        addObject(e, 350, -30);
                        i++;
                    }
                    if( i == 8 || i == 16 || i == 24)
                    {
                        addObject(a, 100, -30);
                        i++;
                    }
                    if ( i == 6 || i == 12 || i == 18 || i ==24)
                    {
                        addObject(g, 350, -30);
                        i++;
                    }
                    if ( i == 10 || i == 20 )
                    {
                        addObject(c, 100, -30);
                        i++;
                    }
                    if( i == 4 || i == 14 || i == 25)
                    {
                        addObject(b, 100, -30);
                        i++;
                    }
                    break;
                }
                else
                {
                    waveNumber++;
                    i = 0;
                    break;
                }
            }
            case 5: 
            {
                if (i < 1)
                {
                    addObject(f, 100, -30);
                    i++;

                }
                addObject(a, 100, -30);
                addObject(b, 100, -30);
                addObject(e, 350, -30);
                addObject(g, 350, -30);
                i++;

                if( i > 13)
                {
                    addObject(c, 100, -30);
                    addObject(d, 100, -30);
                }
            }}}

    public void act()
    {
        if (timer == 100)
        {
            spawnEnemies();
            timer = 0;
        }
        else
        {
            timer++;
        }

    }

    public void gameOver()
    {
        GameOverScreen go = new GameOverScreen();
        Greenfoot.setWorld(go);
        go.addScore(scoreboard.getScore());
    }
}

    