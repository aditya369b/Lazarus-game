package lazarusgame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Animation {

    private BufferedImage[] lz_right;
    private BufferedImage[] lz_rightJump;
    private BufferedImage[] lz_left;
    private BufferedImage[] lz_leftJump;


    Animation()
    {
        this.lz_right = new BufferedImage[7];

        for(int i=0;i<7;i++) {
            int j=i+1;
            try {
                lz_right[i] = read(new File("Resources/lz_right/lz_right"+j+".gif"));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        this.lz_rightJump = new BufferedImage[7];

        for(int i=0;i<7;i++) {
            int j=i+1;
            try {
                lz_rightJump[i] = read(new File("Resources/lz_right_jump/lz_right_jump"+j+".gif"));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        this.lz_left = new BufferedImage[7];

        for(int i=0;i<7;i++) {
            int j=i+1;
            try {
                lz_left[i] = read(new File("Resources/lz_left/lz_left"+j+".gif"));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        this.lz_leftJump = new BufferedImage[7];

        for(int i=0;i<7;i++) {
            int j=i+1;
            try {
                lz_leftJump[i] = read(new File("Resources/lz_left_jump/lz_left_jump"+j+".gif"));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void displayRight(Graphics g, int frame,int x, int y)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.lz_right[frame],x,y,null);

    }

    public void displayLeft(Graphics g, int frame,int x, int y)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.lz_left[frame],x,y,null);
    }
    public void displayRightJump(Graphics g, int frame,int x, int y)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.lz_rightJump[frame],x,y,null);
    }

    public void displayLeftJump(Graphics g, int frame,int x, int y)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.lz_leftJump[frame],x,y,null);
    }

}