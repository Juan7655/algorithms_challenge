package com.endava.drodriguez;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void test() {
        int expected = 5;
        Main m = new Main();
        int actual = m.test();

        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        int expected = 7;
        Main m = new Main();
        int actual = m.test();

        assertEquals(expected, actual);

    }
}