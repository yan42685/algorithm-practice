package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/11/2019 22:29
 * @description:
 */
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // reverse each column
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
