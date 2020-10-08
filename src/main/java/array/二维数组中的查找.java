package array;
/**
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入一个整数，判断二维数组数组中是否有该数。
 */
public class 二维数组中的查找 {

    public static void main(String[] args) {

        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 12}, {6, 8, 11, 15}};

        System.out.println(find(1, a));
    }

    static boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

}
