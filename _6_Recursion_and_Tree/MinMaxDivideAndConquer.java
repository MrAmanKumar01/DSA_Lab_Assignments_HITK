/*
2. Write a recursive function to find the maximum and minimum number in the given list
that solves this using divide and conquer.
*/
package _6_Recursion_and_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinMaxDivideAndConquer {

    public static class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static MinMax findMinMax(List<Integer> nums, int start, int end) {
        if (start == end) {
            return new MinMax(nums.get(start), nums.get(end));
        } else if (end - start == 1) {
            return new MinMax(Math.min(nums.get(start), nums.get(end)), Math.max(nums.get(start), nums.get(end)));
        } else {
            int mid = start + (end - start) / 2;

            MinMax leftMinMax = findMinMax(nums, start, mid);
            MinMax rightMinMax = findMinMax(nums, mid + 1, end);

            int min = Math.min(leftMinMax.min, rightMinMax.min);
            int max = Math.max(leftMinMax.max, rightMinMax.max);

            return new MinMax(min, max);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
//        nums.add(3);
//        nums.add(7);
//        nums.add(1);
//        nums.add(10);
//        nums.add(5);
//        nums.add(0);
        System.out.print("Enter no. of elements you want to compare: ");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for (int i=0; i<n; i++) {
            nums.add(sc.nextInt());
        }

        MinMax result = findMinMax(nums, 0, nums.size() - 1);

        System.out.println("Minimum number: " + result.min);
        System.out.println("Maximum number: " + result.max);
    }
}

/*
OUTPUT:
Enter no. of elements you want to compare: 6
Enter the elements: 3 7 1 10 5 0
Minimum number: 0
Maximum number: 10
-------------------------------------------------
Enter no. of elements you want to compare: 9
Enter the elements: 4 7 13 1 -1 0 5 8 9
Minimum number: -1
Maximum number: 13
 */