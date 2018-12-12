package lazarusgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LazarusControl implements KeyListener{

        private lazarusgame.Lazarus lazarus;
        private final int right;
        private final int left;


        LazarusControl(lazarusgame.Lazarus lz, int left, int right) {
            this.lazarus = lz;
            this.right = right;
            this.left = left;
        }

        @Override
        public void keyTyped(KeyEvent ke) {}

        @Override
        public void keyPressed(KeyEvent ke) {

            int keyPressed = ke.getKeyCode();

            if (keyPressed == left) {
                this.lazarus.toggleLeftPressed();
            }

            if (keyPressed == right) {
                this.lazarus.toggleRightPressed();
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {}
    }







