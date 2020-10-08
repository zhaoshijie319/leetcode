package array;

public class 寻找数组中最大值和最小值 {

    public static void main(String[] args) {
        int[] a = {5, 6, 8, 3, 7, 9};
        method(a);
    }

    private static void method(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max <= a[i]) {
                max = a[i];
            }
            if (min >= a[i]) {
                min = a[i];
            }
        }
        System.out.println("max = " + max + ", min = " + min);
    }

}
