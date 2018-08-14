package com.endava.drodriguez.SupermarketDrama;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class SuperMarketTest {

    @Test
    public void result() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 7);
        input.put(2, 3);
        input.put(3, 5);

        SuperMarket s = new SuperMarket(input, 8);

        assertArrayEquals(new int[]{0, 1, 1}, s.result());
    }
    @Test
    public void result2() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 2);
        input.put(2, 6);
        input.put(3, 8);
        input.put(4, 5);

        SuperMarket s = new SuperMarket(input, 12);

        assertArrayEquals(new int[]{0, 1, 0, 1}, s.result());
    }
    @Test
    public void result3() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 3);
        input.put(2, 5);
        input.put(3, 11);
        input.put(4, 8);
        input.put(5, 1);
        input.put(6, 2);

        SuperMarket s = new SuperMarket(input, 20);

        //assertArrayEquals(new int[]{0,0,1,1,1,0}, s.result());
        assertArrayEquals(new int[]{1,1,1,0,1,0}, s.result());

    }
    @Test
    public void result4() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 9);
        input.put(2, 2);
        input.put(3, 5);
        input.put(4, 8);
        input.put(5, 3);

        SuperMarket s = new SuperMarket(input, 1);

        assertArrayEquals(null, s.result());
    }
    @Test
    public void result5() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 5);
        input.put(2, 10);
        input.put(3, 7);
        input.put(4, 3);

        SuperMarket s = new SuperMarket(input, 80);

        assertArrayEquals(new int[]{1, 1, 1, 1}, s.result());
    }
    @Test
    public void result6() {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 5);
        input.put(2, 10);
        input.put(3, 8);
        input.put(4, 3);

        SuperMarket s = new SuperMarket(input, 8);

        assertArrayEquals(new int[]{1, 0, 0, 1}, s.result());
    }
}