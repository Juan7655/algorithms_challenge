package com.endava.drodriguez.SupermarketDrama;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class SuperMarket {
    private Map<Integer, Integer> shoppingListSize;
    private int capacity;

    SuperMarket(Map<Integer, Integer> shoppingListSize, int capacity) {
        this.shoppingListSize = shoppingListSize;
        this.capacity = capacity;
    }

    /**
     * Creates a matrix where each row represents a combination of elements to try. The matrix is used to
     * make all the combinations of n elements of the list. That is, it tries all combinations of one element,
     * two elements, etc.
     *
     * @param listSize number of items in the shopping list
     * @return matrix with @param{listSize} columns and 2^@param{listSize} rows.
     */
    private static List<int[]> binaryNumberGenerator(int listSize) {
        int numberPositions = (int) Math.pow(2, listSize) - 1;
        List<int[]> matrix = new ArrayList<>();
        //int[][] matrix = new int[numberPositions][listSize];
        int[] list = new int[listSize];
        for (int i = 0; i < listSize; i++) list[i] = 0;
        for (int j = 0; j < numberPositions; j++) {

            list[listSize - 1] += 1;

            int i = 1;
            while (list[listSize - i] > 1) {
                list[listSize - i++] = 0;
                list[listSize - i] += 1;
                if (list[0] == 2) break;
            }
            matrix.add(list.clone());
        }

        return matrix;
    }

    /**
     * main method to solve the problem. Joins all the other functions in logical order to solve the SuperMarket
     * situation
     *
     * @return array of 0's and 1's representing de elements that should be taken as solution to the given problem.
     */
    int[] result() {
        return binaryNumberGenerator((this.shoppingListSize.size())).stream()
                .collect(Collectors.toMap(i -> i, this::getSumFromPositions))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() <= this.capacity)
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * given an array of 0's and 1's, sums the elements of the shopping list wich correspond with the 1's in the input
     *
     * @param positions array of 0's and 1's representing which elements of the shopping list to sum
     * @return total sum of the value of the elements selected from the parameter
     */
    private int getSumFromPositions(int[] positions) {
        int sum = 0;

        for (int i = 0; i < positions.length; i++)
            if (positions[i] == 1) sum += this.shoppingListSize.get(i + 1);

        return sum;
    }
}
