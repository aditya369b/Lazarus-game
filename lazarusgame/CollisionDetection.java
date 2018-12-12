package lazarusgame;

public class CollisionDetection {

    private int[][] map;
    private int lzPosition[] = new int[2];
    private int boxPriority;

    CollisionDetection( int[][] map)
    {
        this.map = map;

    }


    public void updateMap(int boxNumber, int x, int y)
    {
        int i = x/40, j = y/40;

        this.map[j][i] = boxNumber;
    }

    public int[][] getMap()
    {
        return this.map;
    }

    public void changeLevel(int[][] newMap)
    {
        this.map = newMap;
        System.out.println(newMap[19][16]);
    }

    public void restartLevel()
    {
        int i=0;

        while(i<24) {
            int j=0;
            while (j<32){
                System.out.println(this.map[i][j]);
            if (this.map[i][j] != 0 && this.map[i][j] != 8 && this.map[i][j] != 9)
            {this.map[i][j] = 0; System.out.println(this.map[i][j]);}

            j++;
        }
            i++;
        }
    }

    public void updatelzPosition(int x, int y)
    {
        this.lzPosition[0] =x;
        this.lzPosition[1] =y;
    }

    public boolean boxLazarusCollision(int x, int y)
    {
        if(lzPosition[0] == x && lzPosition[1] < y)
            return true;
            else
                return false;
    }

    public boolean boxBoxCollision(int x, int y,int boxNumber)
    {

        int i = x/40, j = y/40;
        boolean flag = false;

            if(map[j][i]>=boxNumber)
            {
                this.boxPriority = this.map[j][i]; flag = true;
            }
            else if(map[j][i]!=0)
            {
                map[j][i]=0;
            }


        return flag;
    }

    public int removeBox(int boxNumber,int x,int y)
    {
        if(this.boxPriority < boxNumber)
        {
            int i=y/40, totalBoxes =1;

            map[i][x/40] = 0;
            i++;
            while(i<24)
            {
              if(map[i][x/40] < boxNumber)
              {totalBoxes++; map[i][x/40] = 0; i++;}
              else
                  break;
            }
            return totalBoxes;
        }
        else
            return 0;
    }

    public boolean checkStop(int x, int y)
    {
        int i = x/40, j = y/40;

        if(map[j][i] == 8)
            return true;
        else
            return false;
    }

    public int checkBox(int x, int y)
    {
        int i = x/40, j = y/40, flag = 0;

        if(i<0 || i>31 || j<0)
            return -1;

        System.out.println(x +"  "+y+"  "+i+"  "+j+"  "+map[j][i]);

        if(map[j][i] == 8)
            return -3;

        if(map[j][i] != 0 && map[j][i] != 8) {
            if (j - 1 >= 0 && map[j - 1][i] != 0 && map[j - 1][i] != 8)
                flag = -1;
            else
                flag = -2;

        }

             if(map[j+1][i] == 0 || map[j+1][i] == 8)
            {
                int k=j-1;
                if(k==-1)
                {k=0; flag++;}
                while(k<31)
                {
                    System.out.println("*****************    test    *********" + map[k][i]);
                    if(map[k][i] ==0 || map[k][i] ==8)
                    {flag++; k++; System.out.println("*****************    test    *********");}
                    else
                    { flag = flag-2; break;}
                }
            }


            return flag;
    }

}
