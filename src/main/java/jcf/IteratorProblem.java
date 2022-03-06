package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Using BufferedReader read one string with numbers written across the space ("1 2 3 4 5 ...").
 *
 * Put this numbers to any Collection of Integers.Sort this collection!
 *
 * Using Iterator remove all even annoying numbers(death for elem%2=0 !) from your Collection
 *
 * Print all remaining elements to console (use System.out.println() method)
 * */
public class IteratorProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (String s1 : s.split(" ")) {
            treeSet.add(Integer.parseInt(s1));
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next % 2 == 0){
                iterator.remove();
            }
        }
        treeSet.forEach(System.out::println);
    }
}
