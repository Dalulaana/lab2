package com.company;
import java.util.*;

public class addAllTest {
    public static void main(String args[])
    {
        String arr[]= {"1", "3", "4", "8"};
        List<String> list = Arrays.asList(arr);
        DMyArrayList<String> myList = new DMyArrayList<String>();
        myList.addAll(list);
        System.out.println(myList);

        myList.addAll(3, Arrays.asList("2", "5", "9"));
        System.out.println(myList);
        System.out.println();

    }
}
