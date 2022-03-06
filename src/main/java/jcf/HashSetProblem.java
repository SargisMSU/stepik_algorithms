package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Additional code,son!
 * 1.Given a string as "1 2 3 4 5 6 ..." . String[] strings contains of element from given string ("1","2",..).
 * Add all elements from String[] strings to Set<Integer> set.
 * 2.Add all the elements from helpList to set .
 * 3.Using Iterator remove/filter(Stream API)/"method-of-all-collections" all elements greater than 10(>) from set and return modified set.
 * */
public class HashSetProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        List<Integer> helpList = List.of(1,2,3,4);//getList();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            set.add(Integer.parseInt(strings[i]));
        }
        set.addAll(helpList);
        set = removeAllNumbersMoreThan10(set);
        set.forEach(System.out::println);
    }

    public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set){
        return set.stream().filter(integer -> integer <= 10).collect(Collectors.toSet());
    }
}
