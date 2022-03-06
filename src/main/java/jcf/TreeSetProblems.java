package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Additional code,Soldier!
 * Given one input string as "1 2 3 4 5;6 7 8 9 10;11 12 13 14 15"(it's 3 lists)
 * 1.String[] sets consists of these lists. Add all elements from each list to correct set(see the comments in the code) sets[0] = {"1 2 3 4 5"} - its string and so on
 * *use split(" ") to separate elements from string
 * 2.On unionTreeLargeNumber(Set<Integer> set1,Set<Integer> set2,Set<Integer> set3):
 *      1)In each Set find the maximum element
 *      2)create TreeSet, add the resulting elements to TreeSet
 *      3)return this TreeSet with elements sorted in descending order:
 * you can use special method from class TreeSet or rather NavigableSet interface to change the order of storage on the reverse
 * 3.Using System.out.println() print elements of resultTreeSet
 *
 * */
public class TreeSetProblems {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");

        Set<Integer> set1 = new HashSet<>();
        //your code(add elements to set1 from sets[0])
        String[] split0 = sets[0].split(" ");
        for (int i = 0; i < split0.length; i++) {
            set1.add(Integer.parseInt(split0[i]));
        }
        Set<Integer> set2 = new HashSet<>();
        //your code(add elements to set2 from sets[1])

        String[] split1 = sets[1].split(" ");
        for (int i = 0; i < split1.length; i++) {
            set2.add(Integer.parseInt(split1[i]));
        }
        Set<Integer> set3 = new HashSet<>();
        //your code(add elements to set3 from sets[2])
        String[] split2 = sets[2].split(" ");
        for (int i = 0; i < split2.length; i++) {
            set3.add(Integer.parseInt(split2[i]));
        }

        Set<Integer> resultTreeSet = unionTreeLargeNumber(set1,set2,set3);

        //print elements of resultTreeSet(using System.out.printLn()) below
        for (Integer i : resultTreeSet) {
            System.out.println(i);
        }
    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3){
        TreeSet<Integer> resultSet = new TreeSet<>((o1, o2)->o2-o1);
        resultSet.add(Collections.max(set1));
        resultSet.add(Collections.max(set2));
        resultSet.add(Collections.max(set3));
        return resultSet;
    }
}
