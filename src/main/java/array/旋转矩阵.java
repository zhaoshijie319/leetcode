package array;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * <p>Rotate the image by 90 degrees (clockwise).
 *
 * <p>Follow up: Could you do this in-place?
 */
public class 旋转矩阵 {
    public static void main(String[] args) throws Exception {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new 旋转矩阵().rotate(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.println(A[i][j]);
            }
        }
    }

    public void rotate(int[][] matrix) {

        int length = matrix.length;

        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int lc = 0, tr = 0, rc = matrix[0].length - 1, br = matrix.length - 1;
        while (tr < br) {
            for (int i = lc, j = tr, k = rc, l = br;
                 i < rc && j < br && k > lc && l > tr;
                 i++, j++, k--, l--) {
                int temp1 = matrix[j][rc];
                matrix[j][rc] = matrix[tr][i];
                int temp2 = matrix[br][k];
                matrix[br][k] = temp1;
                temp1 = matrix[l][lc];
                matrix[l][lc] = temp2;
                matrix[tr][i] = temp1;
            }
            lc++;
            tr++;
            rc--;
            br--;
        }
    }
}
