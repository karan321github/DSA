package Matrix;

public class Matrix {
        public static void printMatrix(int[][] arr) {
                for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length; j++) {
                                System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                }
        }

        public static void transposeOfAMatrix(int[][] arr) {
                int m = arr.length;
                int n = arr[0].length;
                for (int i = 0; i < m; i++) {
                        for (int j = i + 1; j < n; j++) {
                                int temp = arr[i][j];
                                arr[i][j] = arr[j][i];
                                arr[j][i] = temp;
                        }
                }

        }

        public static void rotateImage(int[][] arr) {
                transposeOfAMatrix(arr);
                for (int i = 0; i < arr.length; i++) {
                        int l = 0;
                        int r = arr[0].length - 1;
                        while (l < r) {
                                int temp = arr[i][l];
                                arr[i][l] = arr[i][r];
                                arr[i][r] = temp;
                        }
                }

        }

        public static int sumOfMatrix(int[][] matrix, int i, int j) {
                if (i == matrix.length) {
                        return 0;
                }
                if (j == matrix[0].length) {
                        sumOfMatrix(matrix, i + 1, j);
                }
                int sum = matrix[i][j];
                return sum + sumOfMatrix(matrix, i, j + 1);
        }

        public static void main(String[] args) {
                int[][] matrix = {
                                { 1, 2, 3 },
                                { 4, 5, 6 },
                                { 7, 8, 9 },

                };
                // transposeOfAMatrix(matrix);
                // printMatrix(matrix);
                rotateImage(matrix);
                printMatrix(matrix);
                int sumOfMatrix = sumOfMatrix(matrix, 0, 0);
                System.out.print("sum of a matrix " + sumOfMatrix);
        }
}
