package lazarusgame;

public class Lives {
    private int lives;
    private boolean restart;
    private boolean end;

    Lives(int lives)
    {
        this.lives = lives;
        this.restart = false;
        this.end = false;
    }

    void reduceLife()
    {
        if(this.lives>0) {
            this.lives -= 1;
            this.restart = true;
        }
        else
            this.end = true;
    }

    int getLives()
    {
        return this.lives;
    }

    boolean isRestart()
    {
        return this.restart;
    }

    void start()
    {
        this.restart = false;
    }

    boolean isEnd()
    {
        return this.end;
    }


}
