package jcf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value.
 * In all cases remove the key "c",leaving the rest of the map unchanged.
 * {"a":"abstraction","b":"boolean","c":"xyz"} -> {"a":"abstraction","b":"abstraction"}
 * */
public class MapProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Map<String, String> input = new HashMap<>();
        for (String s : next.split(",")) {
            String[] split = s.split(":");
            input.put(split[0], split[1]);
        }
        mapShare(input);
        System.out.println("input = " + input);
    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        String aValue = null;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("a")){
                aValue = map.get(next);
                break;
            }
        }
        iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("b") && aValue != null){
                map.put(next, aValue);
            }else if (next.equals("c")){
                iterator.remove();
            }
        }
        return map;
    }
}
