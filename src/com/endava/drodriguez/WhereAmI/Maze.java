package com.endava.drodriguez.WhereAmI;

import static com.endava.drodriguez.WhereAmI.Maze.Direction.*;


class Maze {
    private int[][] maze;
    private int[] initPoint, finalPoint;

    Maze(int[][] maze, int[] initPoint, int[] finalPoint) {
        this.maze = maze;
        this.initPoint = initPoint;
        this.finalPoint = finalPoint;
    }

    int[][] getPath() {
        int[][] path = getPath(this.maze, this.initPoint);

        if (path == null) return null;

        for (int i = 0; i < path.length; i++)
            for (int j = 0; j < path[i].length; j++)
                path[i][j] = path[i][j] == -1 ? 1 : 0;

        return path;
    }

    private int[][] getPath(int[][] history, int[] actualPosition) {
        history[actualPosition[0]][actualPosition[1]] = -1;
        if (actualPosition[0] == this.finalPoint[0] && actualPosition[1] == this.finalPoint[1]) return history;

        int[] northPos = moveStep(actualPosition, NORTH),
                southPos = moveStep(actualPosition, SOUTH),
                eastPos = moveStep(actualPosition, EAST),
                westPos = moveStep(actualPosition, WEST);

        if (northPos != null && coordinateIsInMaze(northPos) && history[northPos[0]][northPos[1]] == 0) {
            int[][] path = getPath(history, northPos);
            if (path != null) return path; else history[northPos[0]][northPos[1]]=0;
        }
        if (southPos != null && coordinateIsInMaze(southPos) && history[southPos[0]][southPos[1]] == 0) {
            int[][] path = getPath(history, southPos);
            if (path != null) return path; else history[southPos[0]][southPos[1]]=0;
        }
        if (eastPos != null && coordinateIsInMaze(eastPos) && history[eastPos[0]][eastPos[1]] == 0) {
            int[][] path = getPath(history, eastPos);
            if (path != null) return path; else history[eastPos[0]][eastPos[1]]=0;
        }
        if (westPos != null && coordinateIsInMaze(westPos) && history[westPos[0]][westPos[1]] == 0) {
            int[][] path = getPath(history, westPos);
            if (path != null) return path; else history[westPos[0]][westPos[1]]=0;
        }
        return null;
    }

    private boolean coordinateIsInMaze(int[] coordinate) {
        return coordinate[0] > -1 && coordinate[0] < maze.length &&
                coordinate[1] > -1 && coordinate[1] < maze[0].length;
    }

    private int[] moveStep(int[] actualPosition, Direction direction) {
        switch (direction) {
            case NORTH:
                return new int[]{actualPosition[0] - 1, actualPosition[1]};
            case SOUTH:
                return new int[]{actualPosition[0] + 1, actualPosition[1]};
            case EAST:
                return new int[]{actualPosition[0], actualPosition[1] + 1};
            case WEST:
                return new int[]{actualPosition[0], actualPosition[1] - 1};
            default:
                return null;
        }
    }

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }
}
