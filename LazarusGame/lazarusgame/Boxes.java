package lazarusgame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static javax.imageio.ImageIO.read;

public class Boxes {

    private int x;
    private int y;

    private BufferedImage img;
    private BufferedImage nextImg;
    private BufferedImage stoneBox;
    private BufferedImage woodBox;
    private BufferedImage cardboardBox;
    private BufferedImage metalBox;
    private boolean move;
    private lazarusgame.CollisionDetection cd;
    private int boxNumber;
    private int nextBoxNumber;
    private int speed;
    private boolean lzKill;

    Boxes(int x, lazarusgame.CollisionDetection cd)
    {
        this.x = x;
        this.cd = cd;
        this.move = false;
        this.y = 0;
        this.lzKill = false;

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

    }

    public boolean newBox()
    {
        return !this.move;
    }

    public void stopBox()
    {this.move = false;}

    public void update()
    {
        if(this.move)
        {
            if(!this.cd.boxBoxCollision(this.x,this.y+40,this.boxNumber+1) && !this.cd.boxLazarusCollision(this.x,this.y+40))
            this.y = y + this.speed;

            else  {
                this.move = false;
                  if(this.cd.boxLazarusCollision(this.x,this.y+40))
                    this.lzKill = true;

                else{

                    int i = cd.removeBox(this.boxNumber+1,this.x,this.y+40);
                    new Music().playWall();
                    if(i != 0)
                        this.cd.updateMap(this.boxNumber + 1, this.x, this.y+40*i);
                    else
                        this.cd.updateMap(this.boxNumber + 1, this.x, this.y);
                }
            }
        }
    }

    public boolean isLzKill()
    {
        return this.lzKill;
    }

    public int getNextBoxNumber() {
        return nextBoxNumber;
    }

    public void generateBox(boolean first, int nextBoxNumber,int speed)
    {
        this.speed = (int) Math.ceil((double) 1/2*speed);
        System.out.println(this.speed);

        Random rand = new Random();

        if(first)
        {
            this.nextBoxNumber = rand.nextInt(4);
        }
        else
            this.nextBoxNumber = nextBoxNumber;

         if(!this.move)
        {
            System.out.println("*****************New Box***************");
            this.boxNumber = this.nextBoxNumber;
            this.nextBoxNumber = rand.nextInt(4);
            this.move = true;
            updateBox();
            update();
        }
    }

    public void updateBox()
    {
        if(this.boxNumber == 0)
            this.img = cardboardBox;
        else if(this.boxNumber == 1)
            this.img = woodBox;
        else if(this.boxNumber == 2)
            this.img = metalBox;
        else if(this.boxNumber == 3)
            this.img = stoneBox;

        if(this.nextBoxNumber == 0)
            this.nextImg = cardboardBox;
        else if(this.nextBoxNumber == 1)
            this.nextImg = woodBox;
        else if(this.nextBoxNumber == 2)
            this.nextImg = metalBox;
        else if(this.nextBoxNumber == 3)
            this.nextImg = stoneBox;
    }

    void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if(this.move)
            g2d.drawImage(this.img,x,y, null);
        g2d.drawImage(this.nextImg,20,880, null);

    }
}
