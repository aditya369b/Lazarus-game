package lazarusgame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class GameOver {

    private BufferedImage titleimg1;
    private BufferedImage titleimg2;

    GameOver()
    {

        try {
            titleimg1 = read(new File("Resources/Game Over.PNG"));
            titleimg2 = read(new File("Resources/Winner.PNG"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }



    void drawImage(Graphics g,boolean gameOver)
    {
        Graphics2D g2d = (Graphics2D) g;

        if(gameOver) {
        g2d.drawImage(this.titleimg1, 400, 500, null);
    }
    else
        g2d.drawImage(this.titleimg2, 0, 0,1280,960, null);
    }

}
