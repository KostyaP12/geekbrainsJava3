import lesson_f.HomeWork;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestTaskTwo{
    HomeWork homeWork;

    @Before
    public void init(){
        homeWork = new HomeWork();
    }
    @Test
    public void singleValue () {
        int[] arr = {1, 15, 20, 30, 4, 17, 6, 7, 4, 3, 5, 8, 7, 98};
        int key = 0;
        for(int i = 0; i < arr.length; i++){if(arr[i] == 4) key = i + 1;}
        int[] newArr = Arrays.copyOfRange(arr, key, arr.length);
        Assert.assertArrayEquals(homeWork.taskTwo(arr), newArr);
    }

    @Test
    public void multiValues (){
        int [] arr = {123, 4, 456489, 897, 4, 4564, 87, 123};
        int key = 0;
        for(int i = 0; i < arr.length; i++){if(arr[i] == 4) key = i + 1;}
        int[] newArr = Arrays.copyOfRange(arr, key, arr.length);
        Assert.assertArrayEquals(homeWork.taskTwo(arr), newArr);
    }

    @Test(expected = RuntimeException.class)
    public void presenceOfValue(){
        int [] arr = {0, 1};
        Assert.assertArrayEquals(homeWork.taskTwo(arr), arr);
    }

    @Test
    public void lastInt (){
        int [] arr = {1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 1};
        Assert.assertFalse(homeWork.taskTree(arr));
    }

    @Test
    public void firstInt (){
        int [] arr = {4, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4};
        Assert.assertFalse(homeWork.taskTree(arr));
    }

    @Test
    public void middleInt (){
        int [] arr = {4, 4, 1, 4, 1, 4, 4, 4, 1, 4, 1, 4};
        Assert.assertFalse(homeWork.taskTree(arr));
    }
}
