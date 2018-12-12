package lazarusgame;

import java.util.HashMap;

public abstract class Map {


    Map() {}

    private static HashMap<Integer,Map> level = new HashMap<>();

    static{
        level.put(1,new Level1());
        level.put(2,new Level2());
        level.put(3,new Level3());
    }

    public static Map getLevel(int n)
    {
        return level.get(n);
    }

    public abstract int[][] getMap();
    public abstract int getlzPositionX();
    public abstract int getlzPositionY();
    public abstract boolean isLastLevel();

}
