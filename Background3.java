import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background3 extends Background
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    public static GreenfootSound bkgMusic;
    public ScoreBoard scoreboard;
    public CastleHealth chp;
    public int health = 20;

    public Background3()
    {    
        // Create a new world with 700x700 cells with a cell size of 1x1 pixels.
        //super(700, 700, 1); 
        bkgMusic = new GreenfootSound("Rose_At_Nightfall.mp3");
        bkgMusic.playLoop();
        prepare();

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Castle3 castle = new Castle3();
        addObject(castle, 220, 240);
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 525, 25);
        chp = new CastleHealth();
        addObject(chp, 600, 600);
        scoreboard.addScore(40);
    }

    int waveNumber = 1;
    int i = 0;
    int timer = -100;
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
        Boss1 e = new Boss1();
        Boss3 f = new Boss3();
        switch (waveNumber)
        {
            case 1: 
            {
                if (i < 10)
                {
                    addObject(a, 600, -30);
                    i++;
                    if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10)
                    {
                        addObject (b, 600, -30);

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
                    addObject(b, 600, -30);
                    i++;
                    if ( i < 20)
                    {
                        addObject(a, 600, -30);
                        addObject(c, 600, -30);
                        addObject(b, 600, -30);
                        i++;

                        break;
                    }
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
                    addObject(c, 600, -30);
                    addObject(a, 600, -30);
                    i++;
                    if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10 || i == 15 || i == 20 || i ==25)
                    {
                        addObject (b, 600, -30);
                        addObject (c, 600, -30);

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
            case 4:
            {
                if (i < 30)
                {
                    addObject(d, 600, -30);
                    i++;
                    if (i < 15)
                    {
                        addObject(c, 600, -30);
                        addObject(b, 600, -30);
                        i++;
                        break;
                    }

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
                    addObject(f, 600, -30);
                    i++;
                    break;

                }
                else
                {
                    waveNumber++;
                    i = 0;
                    break;
                }
            }
            default: break;
        }
    }

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

    public void victory()
    {
        YouWin win = new YouWin();
        win.addScore(scoreboard.getScore());
        Greenfoot.setWorld(win); 
    }
}