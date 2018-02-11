package com.beini.test.javase.sort;


/**
 * Created by beini on 2018/2/9.
 */
public class Test {

    public static void main(String[] args) {
        int[] array = {22, 3, 4, 66, 8, 80};
        int[] result = bubbleSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 冒泡
     */
    public static int[] bubbleSort(int[] args) {//相邻两个元素进行比较，符合条件就进行换位。
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[i]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
        return args;
    }
}
