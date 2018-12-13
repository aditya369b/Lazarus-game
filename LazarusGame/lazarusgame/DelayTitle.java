package lazarusgame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class DelayTitle{

    private boolean start = false;
    private BufferedImage titleimg;
    //private BufferedImage bgImg;

    DelayTitle()
    {

        try {
            titleimg = read(new File("Resources/Title.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }



    boolean isStart()
    {
        return this.start;
    }

    void drawImage(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

//        g2d.drawImage(this.bgImg, 0,0,1280,960, null);
        g2d.drawImage(this.titleimg, 0,0,1280,960, null);

        String string = "LOADING!!! ";
        System.out.println(string);


        Font displayFont = new Font("TimesNewRoman", Font.BOLD, 48);
        g2d.setFont(displayFont);
        g2d.setColor(Color.WHITE);
        g2d.fill3DRect(200,40,900,80,true);
        g2d.setColor(Color.BLACK);
        g2d.drawString(string, 500, 100);


    }


}
