package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * 1.Using ListIterator iterate over the elements of list from the beginning to the end and after each word "Hip" add "Hop"
 * 2.Using ListIterator print the all elements(using .println())
 * */
public class ListIteratorProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(reader.readLine().split("\\s")).collect(Collectors.toList());
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            String next = stringListIterator.next();
            if (next.equals("Hip")){
                stringListIterator.add("Hop");
            }
        }
        stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }
    }
}
