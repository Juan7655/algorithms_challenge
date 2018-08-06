package com.endava.drodriguez.SupermarketDrama;

import java.util.Map;

class SuperMarket {
    private Map<Integer, Integer> shoppingListSize;
    private int capacity;

    SuperMarket(Map<Integer, Integer> shoppingListSize, int capacity) {
        this.shoppingListSize = shoppingListSize;
        this.capacity = capacity;
    }

    int[] result() {

        int sum = -1;
        int[] positions = null;

        for(int[] items:binaryNumberGenerator(this.shoppingListSize.size())){
            int tempSum = getSumFromPositions(items);
            if(tempSum < this.capacity && tempSum > sum){
                sum = tempSum;
                positions = items.clone();
            }else if(tempSum == this.capacity) return items.clone();
        }

        return positions;
    }

    private int getSumFromPositions(int[] positions){

        int sum = 0;
        for (int i = 0; i < positions.length; i++)
            if(positions[i] == 1) sum += this.shoppingListSize.get(i + 1);

        return sum;
    }

    private static int[][] binaryNumberGenerator(int listSize){
        int numberPositions = (int)Math.pow(2, listSize-1);
        int[][] matrix = new int[numberPositions][listSize];
        int[] list = new int[listSize];
        for (int i = 0; i < listSize; i++) list[i] = 0;
        for (int j = 0; j < numberPositions; j++) {

            list[listSize - 1] += 1;

            int i = 1;
            while(list[listSize - i] > 1){
                list[listSize - i++] = 0;
                list[listSize - i] += 1;
                if(list[0] == 2) break;
            }
            matrix[j] = list.clone();
        }

        return matrix;
    }
}
