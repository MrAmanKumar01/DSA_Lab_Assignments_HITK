package _8_Greedy_And_DP;

import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        double[][] ratio = new double[weight.length][2];
        for(int i=0; i<weight.length; i++) {
            ratio[i][0] = i;  //0th column -> index
            ratio[i][1] = value[i]/(double)weight[i];  //1st col -> ratio
        }

        //Ascending order sort
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));  //used lambda expression

        int capacity = W;
        int finalVal = 0;
        for(int i=ratio.length-1; i>=0; i--) {  //ratios in descending order
            int idx = (int)ratio[i][0];

            if(capacity - weight[idx] >= 0) { //pick whole
                finalVal += value[idx];
                capacity -= weight[idx];
            } else {
                //pick fractional
                finalVal += (int)(ratio[i][1] * capacity);
                break;
            }
        }

        System.out.println(finalVal);
    }
}

/*
OUTPUT:
240
*/