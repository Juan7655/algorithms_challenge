package com.endava.drodriguez.WhereAmI;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {

    @Test
    public void getPath() {
        Boolean[][] maze = new Boolean[3][3];

        maze[0] = new Boolean[]{false, true, false};
        maze[1] = new Boolean[]{false, true, false};
        maze[2] = new Boolean[]{false, false, false};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        Boolean[][] expected = new Boolean[3][3];

        expected[0] = new Boolean[]{true, false, true};
        expected[1] = new Boolean[]{true, false, true};
        expected[2] = new Boolean[]{true, true, true};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath2() {
        Boolean[][] maze = new Boolean[4][4];

        maze[0] = new Boolean[]{false, true, true, false};
        maze[1] = new Boolean[]{false, false, true, false};
        maze[2] = new Boolean[]{true, false, false, false};
        maze[3] = new Boolean[]{true, true, false, true};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        Boolean[][] expected = new Boolean[4][4];

        expected[0] = new Boolean[]{true, false, false, true};
        expected[1] = new Boolean[]{true, true, false, true};
        expected[2] = new Boolean[]{false, true, true, true};
        expected[3] = new Boolean[]{false, false, false, false};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath3() {
        Boolean[][] maze = new Boolean[4][4];

        maze[0] = new Boolean[]{false, true, true, false};
        maze[1] = new Boolean[]{false, false, false, false};
        maze[2] = new Boolean[]{true, false, true, true};
        maze[3] = new Boolean[]{true, true, false, true};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        Boolean[][] expected = new Boolean[4][4];

        expected[0] = new Boolean[]{true, false, false, true};
        expected[1] = new Boolean[]{true, true, true, true};
        expected[2] = new Boolean[]{false, false, false, false};
        expected[3] = new Boolean[]{false, false, false, false};

        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath4() {
        Boolean[][] maze = new Boolean[4][4];

        maze[0] = new Boolean[]{false, true, true, false};
        maze[1] = new Boolean[]{false, true, true, false};
        maze[2] = new Boolean[]{false, false, false, false};
        maze[3] = new Boolean[]{true, true, true, false};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        Boolean[][] expected = new Boolean[4][4];

        expected[0] = new Boolean[]{true, false, false, true};
        expected[1] = new Boolean[]{true, false, false, true};
        expected[2] = new Boolean[]{true, true, true, true};
        expected[3] = new Boolean[]{false, false, false, false};


        assertArrayEquals(expected, m.getPath());
    }
    @Test
    public void getPath5() {
        Boolean[][] maze = new Boolean[8][4];

        maze[0] = new Boolean[]{false, false, true, true};
        maze[1] = new Boolean[]{true, false, true, true};
        maze[2] = new Boolean[]{true, false, false, true};
        maze[3] = new Boolean[]{true, false, true, true};
        maze[4] = new Boolean[]{true, false, false, false};
        maze[5] = new Boolean[]{true, false, true, false};
        maze[6] = new Boolean[]{true, false, true, false};
        maze[7] = new Boolean[]{true, false, true, false};

        Maze m = new Maze(maze, new int[]{0, 0}, new int[]{0, 2});

        Boolean[][] expected = new Boolean[8][4];

        expected[0] = new Boolean[]{true, true, false, false};
        expected[1] = new Boolean[]{false, true, false, false};
        expected[2] = new Boolean[]{false, true, false, false};
        expected[3] = new Boolean[]{false, true, false, false};
        expected[4] = new Boolean[]{false, true, true, true};
        expected[5] = new Boolean[]{false, false, false, true};
        expected[6] = new Boolean[]{false, false, false, true};
        expected[7] = new Boolean[]{false, false, false, true};

        assertArrayEquals(expected, m.getPath());
    }
}