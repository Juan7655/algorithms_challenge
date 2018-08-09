package com.endava.drodriguez.WhereAmI;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {

    @Test
    public void getPath() {
        int[][] maze = new int[3][3];

        maze[0] = new int[]{0, 1, 0};
        maze[1] = new int[]{0, 1, 0};
        maze[2] = new int[]{0, 0, 0};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        int[][] expected = new int[3][3];

        expected[0] = new int[]{1, 0, 1};
        expected[1] = new int[]{1, 0, 1};
        expected[2] = new int[]{1, 1, 1};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath2() {
        int[][] maze = new int[4][4];

        maze[0] = new int[]{0, 1, 1, 0};
        maze[1] = new int[]{0, 0, 1, 0};
        maze[2] = new int[]{1, 0, 0, 0};
        maze[3] = new int[]{1, 1, 0, 1};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 3});

        int[][] expected = new int[4][4];

        expected[0] = new int[]{1, 0, 0, 1};
        expected[1] = new int[]{1, 1, 0, 1};
        expected[2] = new int[]{0, 1, 1, 1};
        expected[3] = new int[]{0, 0, 0, 0};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath3() {
        int[][] maze = new int[4][4];

        maze[0] = new int[]{0, 1, 1, 0};
        maze[1] = new int[]{0, 0, 0, 0};
        maze[2] = new int[]{1, 0, 1, 1};
        maze[3] = new int[]{1, 1, 0, 1};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 3});

        int[][] expected = new int[4][4];

        expected[0] = new int[]{1, 0, 0, 1};
        expected[1] = new int[]{1, 1, 1, 1};
        expected[2] = new int[]{0, 0, 0, 0};
        expected[3] = new int[]{0, 0, 0, 0};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath4() {
        int[][] maze = new int[4][4];

        maze[0] = new int[]{0, 1, 1, 0};
        maze[1] = new int[]{0, 1, 1, 0};
        maze[2] = new int[]{0, 0, 0, 0};
        maze[3] = new int[]{1, 1, 1, 0};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 3});

        int[][] expected = new int[4][4];

        expected[0] = new int[]{1, 0, 0, 1};
        expected[1] = new int[]{1, 0, 0, 1};
        expected[2] = new int[]{1, 1, 1, 1};
        expected[3] = new int[]{0, 0, 0, 0};


        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath5() {
        int[][] maze = new int[8][4];

        maze[0] = new int[]{0, 0, 1, 1};
        maze[1] = new int[]{1, 0, 1, 1};
        maze[2] = new int[]{1, 0, 0, 1};
        maze[3] = new int[]{1, 0, 1, 1};
        maze[4] = new int[]{1, 0, 0, 0};
        maze[5] = new int[]{1, 0, 1, 0};
        maze[6] = new int[]{1, 0, 1, 0};
        maze[7] = new int[]{1, 0, 1, 0};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{7, 3});

        int[][] expected = new int[8][4];

        expected[0] = new int[]{1, 1, 0, 0};
        expected[1] = new int[]{0, 1, 0, 0};
        expected[2] = new int[]{0, 1, 0, 0};
        expected[3] = new int[]{0, 1, 0, 0};
        expected[4] = new int[]{0, 1, 1, 1};
        expected[5] = new int[]{0, 0, 0, 1};
        expected[6] = new int[]{0, 0, 0, 1};
        expected[7] = new int[]{0, 0, 0, 1};

        assertArrayEquals(expected, m.getPath());
    }
}