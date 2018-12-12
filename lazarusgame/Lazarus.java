package lazarusgame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Lazarus {


    private int x;
    private int y;
    private Boxes box;
    private CollisionDetection cd;

    private BufferedImage img;
    private boolean RightTyped;
    private boolean LeftTyped;
    private boolean levelFinish;
    private int level;
    private Lives life;

    Lazarus(int x, int y, BufferedImage img,CollisionDetection cd) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.cd =cd;
        this.levelFinish = false;
        this.life = new Lives(3);
        this.level = 1;

        this.box = new Boxes(this.x,this.cd);
        this.box.generateBox(true,0,this.level);
    }



    void toggleRightPressed() {
        this.RightTyped = true;
    }

    void toggleLeftPressed() {
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

    private void moveLeft() { this.x -= 40; if(checkBox()) this.x += 40; this.LeftTyped = false;}

    private void moveRight() {
        this.x += 40;
        if(checkBox())
            this.x -= 40;

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
           this.y -= 40;
           return false;
       }
       {
           System.out.println(value);
           this.y += 40*value;
           System.out.println(y);
           return false;
       }
    }

    public void newBox()
    {
        if(this.box.newBox())
        {   int nextBox = this.box.getNextBoxNumber();
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

        g2d.drawImage(lzImg,x,y, null);
    }

    void drawImageBox(Graphics g)
    {
        this.box.drawImage(g);
    }


}