package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given string as this "1 2 3 4 5....". reader read this string.
 * 1.Separate elements with a space from str;
 * 2.add all this numbers to head of Linkedlist;
 * 3.remove 3 times the element at index 0;
 * 4.sort the resulting list in ascending order and print all of its elements each on a new line;
 * */
public class LinkedListProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] numsSplit = str.split(" ");
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < numsSplit.length; i++) {
            ll.add(Integer.parseInt(numsSplit[i]));
        }
        for (int i = 0; i < 3; i++) {
            ll.removeLast();
        }
        ll.sort(Comparator.comparingInt(o -> o));
        for (Integer i : ll) {
            System.out.println(i);
        }
    }
}
