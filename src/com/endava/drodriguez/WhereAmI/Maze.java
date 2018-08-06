package com.endava.drodriguez.WhereAmI;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Boolean[][] maze;
    private int[] initPoint, finalPoint;

    public Maze(Boolean[][] maze, int[] initPoint, int[] finalPoint) {
        this.maze = maze;
        this.initPoint = initPoint;
        this.finalPoint = finalPoint;
    }

    public Boolean[][] getPath(){
        return new Boolean[3][3];
    }
}
