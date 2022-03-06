package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given string as "JButton Button JMenu..." to stdin of your programm
 * 1.Add all elements from this string to List<String>
 * 2.Next, using ListIterator remove all items not starting with J and items beginning with J replace with the same elements but without the J ,for example JFrame -> Frame
 * 3.next, print all the remaining elements in reverse order(using .println())
 * */
public class ListIteratorProblem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            String next = stringListIterator.next();
            stringListIterator.remove();
            if (next.startsWith("J")){
                stringListIterator.add(next.substring(1));
            }
        }
        ListIterator<String> li = list.listIterator(list.size());
        while(li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }
}
