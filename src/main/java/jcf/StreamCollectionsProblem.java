package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given string as "JButton Button JMenu..." to stdin of your programm
 *
 * Add all elements from this string to List<String>
 * Next, using Stream API remove all items not starting with J and items beginning with J replace with the
 * same elements but without the J ,for example JFrame -> Frame
 * next, print all the remaining elements in reverse order(using .println())
 * */
public class StreamCollectionsProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        LinkedList<String> j = list.stream().filter(s -> s.startsWith("J")).map(s ->
                s.substring(1)).collect(Collectors.toCollection(LinkedList::new));

        j.descendingIterator().forEachRemaining(System.out::println);
    }
}
