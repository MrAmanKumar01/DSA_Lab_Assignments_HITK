/*
4. Write class SparseMatrix to give a compressed storage representation of a sparse matrix and
also find the transpose of the sparse matrix (from the compressed representation).
*/
package _1_Arrays;

import java.util.ArrayList;

class SparseMatrix {
    private final int rows;
    private final int cols;
    private final ArrayList<Triplet> elements;

    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new ArrayList<>();
    }

    public void set(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        if (value != 0) {
            elements.add(new Triplet(row, col, value));
        }
    }

    public SparseMatrix transpose() {
        SparseMatrix transposedMatrix = new SparseMatrix(cols, rows);
        for (Triplet triplet : elements) {
            transposedMatrix.set(triplet.col, triplet.row, triplet.value);
        }
        return transposedMatrix;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = 0;
                for (Triplet triplet : elements) {
                    if (triplet.row == i && triplet.col == j) {
                        value = triplet.value;
                        break;
                    }
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static class Triplet {
        int row;
        int col;
        int value;

        Triplet(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}

public class Problem_4 {
    public static void main(String[] args) {
        SparseMatrix matrix = new SparseMatrix(3, 3);
        matrix.set(0, 0, 1);
        matrix.set(0, 2, 2);
        matrix.set(1, 1, 3);
        matrix.set(2, 0, 4);
        matrix.set(2, 2, 5);

        System.out.println("Original Matrix:");
        matrix.display();

        SparseMatrix transposedMatrix = matrix.transpose();

        System.out.println("\nTranspose Matrix:");
        transposedMatrix.display();
    }
}


/*
OUTPUT:
Original Matrix:
1 0 2
0 3 0
4 0 5

Transpose Matrix:
1 0 4
0 3 0
2 0 5
*/
