package com.endava.drodriguez.WhereAmI;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.endava.drodriguez.WhereAmI.Maze.Direction.*;


class Maze {
    private int[][] maze;
    private int[] initPoint, finalPoint;

    Maze(int[][] maze, int[] initPoint, int[] finalPoint) {
        this.maze = maze;
        this.initPoint = initPoint;
        this.finalPoint = finalPoint;
    }

    /**
     * initial setting for the maze solution finder. Finds the path that will solve the maze problem
     * and re-formats its values, assigning 1's to the path positions of the solution, and 0's otherwise
     * (walls and unvisited positions).
     *
     * @return matrix with the solution for the given maze
     */
    int[][] getPath() {
        int[][] path = getPath(this.maze, this.initPoint);

        if (path == null) return null;

        for (int i = 0; i < path.length; i++)
            for (int j = 0; j < path[i].length; j++)
                path[i][j] = path[i][j] == -1 ? 1 : 0;

        return path;
    }

    /**
     * Recursive method to find the path from an actual point to the objective point
     *
     * @param history        matrix that contains the maze (walls) and the previously visited cells. It is used to
     *                       determine where is it reasonable to move, i.e. cells that are not walls and that have
     *                       not been visited before
     * @param actualPosition array with [x, y] coordinates representing the actual position in the maze
     * @return matrix containing the maze and the path taken to solve the maze problem. The matrix contains
     * 1's for walls, 0's for unvisited positions, and -1's representing the solution path of the maze
     */
    @Nullable
    private int[][] getPath(@NotNull int[][] history, int[] actualPosition) {

        if (actualPosition == null || !coordinateIsInMaze(actualPosition) || history[actualPosition[0]][actualPosition[1]] != 0)
            return null;


        history[actualPosition[0]][actualPosition[1]] = -1;
        if (actualPosition[0] == this.finalPoint[0] && actualPosition[1] == this.finalPoint[1]) return history;

        //the four cardinal coordinates moving one step from the actual position
        int[] northPos = moveStep(actualPosition, NORTH),
                southPos = moveStep(actualPosition, SOUTH),
                eastPos = moveStep(actualPosition, EAST),
                westPos = moveStep(actualPosition, WEST);

        //can I get a solution moving to the given direction?
        int[][] path = getPath(history, northPos);
        path = path == null ? getPath(history, southPos) : path;
        path = path == null ? getPath(history, eastPos) : path;
        path = path == null ? getPath(history, westPos) : path;

        //after moving in all four cardinal points, if no solution path is obtained,
        // remove position from history
        if(path==null) history[actualPosition[0]][actualPosition[1]] = 0;

        return path;
    }

    /**
     * determine if a given [x, y] point falls within the range of the maze
     *
     * @param coordinate array of [x, y] coordinates of the point to evaluate
     * @return true if the point falls within the range of the maze, false otherwise
     */
    @Contract(pure = true)
    private boolean coordinateIsInMaze(@NotNull int[] coordinate) {
        return coordinate[0] > -1
                && coordinate[0] < maze.length
                && coordinate[1] > -1
                && coordinate[1] < maze[0].length;
    }

    /**
     * from the actual position, return the new position, when moving in a determined direction
     *
     * @param actualPosition array with [x, y] coordinates before moving
     * @param direction      cardinal direction to move from the actual position
     * @return array with [x, y] coordinates of position after moving in the given direction
     */
    @NotNull
    @Contract(pure = true)
    private int[] moveStep(int[] actualPosition, @NotNull Direction direction) {
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
