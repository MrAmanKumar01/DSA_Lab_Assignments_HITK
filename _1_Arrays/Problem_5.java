/*
5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal.
*/

package _1_Arrays;

class CheckTriangular{
    int[][] arr;
    CheckTriangular(int[][] arr){
        this.arr = arr;
    }
    boolean lowerTriangular() {
        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if(i<j) {
                    if(arr[i][j]!=0)
                        return false;
                }else {
                    if(arr[i][j]==0)
                        return false;
                }
            }
        }
        return true;
    }

    boolean upperTriangular() {
        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if(i>j) {
                    if(arr[i][j]!=0)
                        return false;
                }else {
                    if(arr[i][j]==0)
                        return false;
                }
            }
        }
        return true;
    }

    boolean diagonal() {
        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if(i==j) {
                    if(arr[i][j]==0)
                        return false;
                }else {
                    if(arr[i][j]!=0)
                        return false;
                }
            }
        }
        return true;
    }

    boolean identity() {
        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if(i==j) {
                    if(arr[i][j]!=1)
                        return false;
                }else {
                    if(arr[i][j]!=0) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    boolean tridiagonal() {
        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if((Math.abs(i-j)==1 || i-j==0)) {
                    if(arr[i][j]==0)
                        return false;
                }else {
                    if(arr[i][j]!=0)
                        return false;
                }
            }
        }
        return true;
    }
}

public class Problem_5 {
    public static void main(String[] args) {
        int[][] arr = {
                {3,0,0},
                {5,3,0},
                {4,3,3}
        };
        CheckTriangular ct = new CheckTriangular(arr);
        System.out.println("lower Triangular : "+ ct.lowerTriangular());
        int[][] arr1 = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        CheckTriangular ct1 = new CheckTriangular(arr1);
        System.out.println("identity  : "+ ct1.identity());
        int[][] arr2 = {
                {1,3,4},
                {0,1,9},
                {0,0,1}
        };
        CheckTriangular ct2 = new CheckTriangular(arr2);
        System.out.println("upper triangular  : "+ ct2.upperTriangular());
        int[][] arr3 = {
                {2,0,0},
                {0,1,0},
                {0,0,3}
        };
        CheckTriangular ct3 = new CheckTriangular(arr3);
        System.out.println("diagonal  : "+ ct3.diagonal());
        int[][] arr4 = {
                {2,8,0,0},
                {8,1,6,0},
                {0,9,3,5},
                {0,0,3,8}
        };
        CheckTriangular ct4 = new CheckTriangular(arr4);
        System.out.println("tri-diagonal  : "+ ct4.tridiagonal());
    }
}

/*
OUTPUT:
lower Triangular : true
identity  : true
upper triangular  : true
diagonal  : true
tri-diagonal  : true
*/
