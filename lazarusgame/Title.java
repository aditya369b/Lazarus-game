package lazarusgame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Title implements KeyListener{

    private boolean start = false;
    private int key;
    private BufferedImage titleimg;
    private BufferedImage bgImg;

    Title(int key)
    {
        this.key=key;

        try {
            titleimg = read(new File("Resources/Title.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            bgImg = read(new File("Resources/Background.bmp"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void keyTyped(KeyEvent ke) {
        int keyTyped = ke.getKeyChar();
        if (keyTyped == key) {
            this.start =true;
        }
    }

    public void keyPressed(KeyEvent ke) {}
    public void keyReleased(KeyEvent ke) {}


    boolean isStart()
    {
        return this.start;
    }

    void drawImage(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.bgImg, 0,0,1280,960, null);
            g2d.drawImage(this.titleimg, 0,0,1280,960, null);

        String string = "PRESS 'Enter' TO START THE GAME!!! ";

        Font displayFont = new Font("TimesNewRoman", Font.BOLD, 48);
        g2d.setFont(displayFont);
        g2d.setColor(Color.WHITE);
        g2d.fill3DRect(200,40,900,80,true);
        g2d.setColor(Color.BLACK);
        g2d.drawString(string, 200, 100);


    }


}
