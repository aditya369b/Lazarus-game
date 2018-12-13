package lazarusgame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Lazarus {


    private int x;
    private int y;
    private Boxes box;
    private CollisionDetection cd;
    private BufferedImage[] lzMove = new BufferedImage[7];
    private BufferedImage img;
    private boolean RightTyped;
    private boolean LeftTyped;
    private boolean levelFinish;
    private boolean move = false;
    private boolean moveRight = false;
    private boolean moveLeft = false;
    private boolean jump = false;
    private boolean fall = false;
    private int nextBox;
    private int display =0;
    private int level;
    private Lives life;
    private Animation animation;

    Lazarus(int x, int y, BufferedImage img,CollisionDetection cd) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.cd =cd;
        this.levelFinish = false;
        this.life = new Lives(3);
        this.level = 1;
        this.animation = new Animation();

        this.box = new Boxes(this.x,this.cd);
        this.box.generateBox(true,0,this.level);
    }



    void toggleRightPressed() {
        if(!this.moveRight && !this.moveLeft) this.RightTyped = true;
    }

    void toggleLeftPressed() {
        if(!this.moveRight && !this.moveLeft)
            this.LeftTyped = true;
    }


    public void update() {

        if (this.LeftTyped) {
            this.moveLeft();
        }
        if (this.RightTyped) {
            this.moveRight();
        }

        this.cd.updatelzPosition(this.x,this.y);

        if(!this.levelFinish) {
            newBox();
        }
    }

    private void moveLeft() {
        this.x -= 40;

    if(checkBox())
        this.x += 40;
    else {
        this.move = true;
        this.moveLeft = true;
    }
    this.LeftTyped = false;
    }

    private void moveRight() {
        this.x += 40;

        if(checkBox())
            this.x -= 40;
        else {
            this.move = true;
            this.moveRight = true;
        }

        this.RightTyped = false;

    }



    private boolean checkBox() {

       int value = this.cd.checkBox(this.x, this.y);

       if(value == -1)
       { return true;}
       else if(value == 0)
       {return false;}
       else if(value == -3)
       {this.levelFinish = true; return false;}
       else if(value == -2)
       {
           this.jump = true;
           this.y -= 40;
           return false;
       }
       {
            this.fall = true;
           System.out.println(value);
           this.y += 40*value;
           System.out.println(y);
           return false;
       }
    }

    public void newBox()
    {
        if(this.box.newBox())
        {    nextBox = this.box.getNextBoxNumber();
        System.out.println("************Lazarus New Box " + x);
            this.box = new Boxes(this.x,this.cd);
        this.box.generateBox(false,nextBox,this.level);

        }
        else {
            this.box.update();
             if(this.box.isLzKill())
             {
                this.life.reduceLife();
             }
        }

    }

    public int getLives()
    {
        return this.life.getLives();
    }

    public boolean isRestart()
    {
        if(this.life.isRestart())
            this.box.stopBox();

        return this.life.isRestart();
    }

    public void start()
    {
        this.life.start();
        this.box = new Boxes(this.x,this.cd);
        this.box.generateBox(false,nextBox,this.level);
       // this.box.stopBox();
       // this.box.generateBox(true,0,this.level);
    }

    public boolean isEnd()
    {
        return this.life.isEnd();
    }

    public boolean isLevelFinish() {
        boolean flag
;        if(this.cd.checkStop(x,y)) {
            flag = true;
                this.levelFinish =true;
            }
        else
            flag = this.levelFinish;

        if(flag)
        {
            System.out.println("***************Box Stopped*****************");
            this.box.stopBox();
            this.level++;
        }
        return flag;
    }

    public void setNewPosition(int x, int y)
    {
        this.x =x;
        this.y =y;
        this.levelFinish = false;
    }

    void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
       Image lzImg = this.img.getScaledInstance(40,40,Image.SCALE_FAST);

if(this.fall)
{
    g2d.drawImage(lzImg, x, y, null);

    this.moveRight = this.moveLeft = this.jump = this.fall = false;

}
else{
        if((move || this.display!=0)) {
            if(this.display < 7)
            drawAnimation(g);
            else
                this.display = 0;

            new Music().playMove();
            this.move = false;
        }
        else {

            g2d.drawImage(lzImg, x, y, null);

            this.moveRight = this.moveLeft = this.jump = this.fall = false;
        }
    }}

    void drawAnimation(Graphics g)
    {
        //Graphics2D g2d = (Graphics2D) g;

            if(this.moveRight && !this.jump)
            this.animation.displayRight(g,this.display,x-40,y-40);

            if(this.moveLeft && !this.jump)
                this.animation.displayLeft(g,this.display,x,y-40);

        if(this.moveRight && this.jump)
            this.animation.displayRightJump(g,this.display,x-40,y);

        if(this.moveLeft && this.jump) {
            System.out.println("***************Jumping*************");
            this.animation.displayLeftJump(g, this.display, x, y);
        }
            this.display++;
    }

    void drawImageBox(Graphics g)
    {
        this.box.drawImage(g);
    }


}