package lazarusgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import static javax.imageio.ImageIO.read;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LazarusGame extends JPanel  {


    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 960;
    private BufferedImage world;
    private Graphics2D buffer;
    private JFrame jf;
    private lazarusgame.Lazarus lazarusPlayer;
    private BufferedImage background;
    private BufferedImage wall;
    private BufferedImage lazarus;
    private BufferedImage box;
    private BufferedImage stoneBox;
    private BufferedImage woodBox;
    private BufferedImage cardboardBox;
    private BufferedImage metalBox;
    private BufferedImage stopButton;
    private BufferedImage nextBox;
    private int level;
    private boolean levelFinish = false;
    private boolean changeLevel = false;
    private boolean display = false;
    private lazarusgame.Title title;
    private lazarusgame.Map map;
    private CollisionDetection cd;




    public static void main(String[] args) {
        Thread x;
        int i=0;

        while(true) {
            LazarusGame game = new LazarusGame();
            i++;
            if(i<=1)
            game.init();

            try {

                while (true) {
                        if(game.isStart())
                        {
                        game.lazarusPlayer.update();

                    if (!game.isLevelFinish() && !game.isLevelRestart()) {

                        Thread.sleep(1000 / 144);
                        game.repaint();
                    }
                    else
                    {

                        Thread.sleep(3000);
                        System.out.println("*********************Delay successful**************************");
                    }

                }}
            } catch (InterruptedException ignored) {

            }
        }
    }


    public boolean isStart()
    {
        return this.title.isStart();
    }

    public void init() {

        this.jf = new JFrame("Lazarus Game");
        this.world = new BufferedImage(LazarusGame.SCREEN_WIDTH, LazarusGame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);

        try {
            lazarus = read(new File("Resources/lazarus_n1.png"));


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            background = read(new File("Resources/Background.bmp"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            wall = read(new File("Resources/Wall.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            stoneBox = read(new File("Resources/StoneBox.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            woodBox = read(new File("Resources/WoodBox.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            cardboardBox = read(new File("Resources/CardBox.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            metalBox = read(new File("Resources/MetalBox.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            stopButton = read(new File("Resources/Button.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            nextBox = read(new File("Resources/Next Box.png"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.level = 1;
        this.map = Map.getLevel(this.level);

        this.cd = new CollisionDetection(this.map.getMap());

        this.lazarusPlayer = new lazarusgame.Lazarus(640, 760, this.lazarus,cd);

        lazarusgame.LazarusControl lc = new lazarusgame.LazarusControl(lazarusPlayer, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);

        this.title = new lazarusgame.Title(KeyEvent.VK_ENTER);

        try {
             new Music();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);

        this.jf.addKeyListener(lc);
        this.jf.addKeyListener(title);

        this.jf.setIconImage(lazarus);

        this.jf.setSize(LazarusGame.SCREEN_WIDTH, LazarusGame.SCREEN_HEIGHT +30);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.jf.setVisible(true);


    }


    public void closeGame()
    {
        this.jf.dispatchEvent(new WindowEvent(this.jf,WindowEvent.WINDOW_CLOSING));
    }

    public boolean isLevelFinish(){boolean flag = this.changeLevel; this.changeLevel = false; return flag;}

    public boolean isLevelRestart(){return this.lazarusPlayer.isRestart();}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        buffer = world.createGraphics();
        super.paintComponent(g2);


        if(!this.title.isStart()) {
            this.title.drawImage(buffer);
            g2.drawImage(world, 0, 0, null);
        }
        else if(this.display)
        {
            this.title.drawImage(buffer);
            g2.drawImage(world, 0, 0, null);
            this.display = false;
        }

        else if(this.lazarusPlayer.isEnd())
        {
            this.closeGame();
        }
        else if(this.lazarusPlayer.isRestart())
        {
            System.out.println("********8Restarted**************");
            cd.restartLevel();
            lazarusPlayer.setNewPosition(this.map.getlzPositionX(),this.map.getlzPositionY());
            lazarusPlayer.start();
        }
        else if(this.levelFinish)
        {
            System.out.println("************************ Level Change*********************");

            if(!this.map.isLastLevel())
            {this.level++;}
            else
                this.closeGame();

            this.map = Map.getLevel(this.level);
            cd.changeLevel(this.map.getMap());
            lazarusPlayer.setNewPosition(this.map.getlzPositionX(),this.map.getlzPositionY());
            this.changeLevel =true;
            this.levelFinish = false;
        }

        else {
            this.drawImage(buffer);

            g2.drawImage(this.world,0,0, null);

            String string = "LIVES";

            Font displayFont = new Font("TimesNewRoman", Font.BOLD, 24);
            g2.setFont(displayFont);
            g2.setColor(Color.RED);

            g2.drawString(string,5,35);
            int n=50, lives = this.lazarusPlayer.getLives();

            for(int i=0; i<lives;i++) {
                n = n+30;
                g2.drawImage(this.lazarus,n,10,null);
            }

            if(this.lazarusPlayer.isLevelFinish())
                this.levelFinish = true;
        }
    }


    void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.background, 0,0,SCREEN_WIDTH,SCREEN_HEIGHT, null);

        int xValue=0,yValue=0,i=0,j=0;

        while(i<24) {
            int layer[][] = this.cd.getMap();

            if(layer[i][j]!=0) {
                getImage(layer[i][j]);
                g2d.drawImage(this.box, xValue, yValue, null);
            }

            j++;
            if(j>31) {
                i++;
                j = 0;
                xValue = 0;
                yValue = yValue + this.wall.getWidth();
            }
            else
                xValue= xValue + this.wall.getHeight();

        }
        g2d.setColor(Color.WHITE);
        g2d.fill3DRect(0, 850,80,80,true);

        Image img = nextBox.getScaledInstance(70,20,Image.SCALE_FAST);
        g2d.drawImage(img,5,855,null);
        this.lazarusPlayer.drawImageBox(buffer);
        this.lazarusPlayer.drawImage(buffer);
    }

    private void getImage(int n)
    {
        if(n==1)
            this.box = this.cardboardBox;
        else if(n==2)
            this.box = this.woodBox;
        else if(n==3)
            this.box = this.metalBox;
        else if(n==4)
            this.box = this.stoneBox;
        else if(n==8)
            this.box = this.stopButton;
        else
            this.box = this.wall;
    }

}

