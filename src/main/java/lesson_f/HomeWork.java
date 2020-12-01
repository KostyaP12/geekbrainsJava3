package lesson_f;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 9, -4, 3, 15};
        int[] arrTwo = {1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4};
        HomeWork homeWork = new HomeWork();
        System.out.println(Arrays.toString(homeWork.taskTwo(arr)));
        System.out.println(homeWork.taskTree(arrTwo));
    }

    public int[] taskTwo(int[] arr) {
        int[] arrNew;
        boolean flag = false;
        int buff = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                flag = true;
                buff = i + 1;
            }
        }
        if (flag) {
            arrNew = Arrays.copyOfRange(arr, buff, arr.length);
            return arrNew;
        } else {
            throw new RuntimeException("В массиве нет числа 4");
        }
    }

    public boolean taskTree(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0 || i == 0){
                flag = (arr[i] == 1);
            }
            if(i % 2 != 0 ){
                flag = (arr[i] == 4);
            }
            if(!flag){
                return flag;
            }
        }
        return flag;
    }
}

