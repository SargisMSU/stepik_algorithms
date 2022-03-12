package jcf;

import java.util.*;

/**
 * Given an array of strings,
 *
 * On wordCount() : return a
 * SortedMap<String, Integer> with a key for each different string, with the value the number of
 * times that string appears in the array.
 *
 * On printMap(): Using System.out.println() print all items of the Map ("key : value")
 * */
public class SortedMapProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        SortedMap<String, Integer> map = wordCount(arr);
        printMap(map);
    }

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])){
                map.put(strings[i], map.get(strings[i]) + 1 );
            }else {
                map.put(strings[i], 1);
            }
        }
        return map;
    }
    public static void printMap(Map<String, Integer> map){
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue());
        }
    }
}
