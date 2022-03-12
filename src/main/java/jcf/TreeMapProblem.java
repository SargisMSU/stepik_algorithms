package jcf;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Modify and return the given map as follows:
 * if the first key % 2 != 0 return sub map from First Key inclusive to FirstKey+4 inclusive in descending order
 * else return sub map from LastKey-4 inclusive to the Last Key inclusive in descending order
 * */
public class TreeMapProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        NavigableMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            String[] splits = inputArr[i].split(":");
            map.put(Integer.parseInt(splits[0]), splits[1]);
        }
        map = getSubMap(map);
        System.out.println("map = " + map);
    }

    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        if (map.firstKey() % 2 != 0) {
            return map.subMap(map.firstKey(), true, map.firstKey() + 4, true).descendingMap();
        }else {
            return map.subMap(map.lastKey() - 4, true, map.lastKey(), true).descendingMap();
        }
    }
}
