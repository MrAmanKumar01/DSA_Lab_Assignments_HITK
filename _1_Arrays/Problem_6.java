/*
 6. Write a program to find whether a matrix is orthogonal or not.
Also find the 1-norm of the matrix.
 */

package _1_Arrays;

class Matrix{
    int arr[][];
    Matrix(int[][]arr){
        this.arr=arr;
    }
//	private int[][] transpose(){
//		int[][]t = new int[this.arr.length][this.arr[0].length];
//		for(int i = 0; i<arr.length;i++) {
//			for(int j =0; j<arr[i].length; j++) {
//				t[j][i] = this.arr[i][j];
//			}
//		}
//		return t;
//	}

    private int[][] multiplication(){
        int[][]m = new int[this.arr.length][arr[0].length];
        for(int i =0;i<arr.length;i++) {
            for(int j =0; j<arr[i].length;j++) {
                int sum =0;
                for(int k =0;k<arr.length;k++) {
                    sum += arr[i][k] * arr[k][j];
                }
                m[i][j]=sum;
            }
        }
        return m;
    }

    private boolean identity(int m[][]) {
        for(int i =0; i<m.length; i++) {
            for(int j =0; j<m[i].length; j++) {
                if(i==j) {
                    if(m[i][j]!=1)
                        return false;
                }else {
                    if(m[i][j]!=0) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    boolean orthogonal() {
        return identity(multiplication());
    }

    int firstNorm() {
        int max =Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            int sum =0;
            for(int j =0; j<arr.length; j++) {
                sum+=Math.abs(arr[j][i]);
            }
            if(max<sum)
                max = sum;
        }
        return max;
    }
}

public class Problem_6 {
    public static void main(String[] args) {
        int [][]a = {{1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};
        Matrix m = new Matrix(a);
        System.out.println(m.orthogonal());
        int [][]b = {
                {1, 9, 0},
                {0, 1, 15},
                {-23, 0, 1}
        };
        Matrix m1 = new Matrix(b);
        System.out.println(m1.firstNorm());
    }
}
