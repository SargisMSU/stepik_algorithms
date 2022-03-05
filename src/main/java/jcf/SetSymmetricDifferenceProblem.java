package jcf;

import java.util.HashSet;
import java.util.Set;

/**
 *  Find Symmetrical difference of sets on symDifference(Set<T> set1, Set<T> set2) and return it.
 *  For example sets:{1 2 3 4} {3 4 5 6} --> Symmetrical difference = {1 2 5 6}
 * */

public class SetSymmetricDifferenceProblem {

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1,2,3,4);
        Set<Integer> set2 = Set.of(3,4,5,6);
        Set<Integer> symDifference = symDifference(set1, set2);
        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("symDifference = " + symDifference);
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> symDiff = new HashSet<>(set1);
        symDiff.addAll(set2);
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        symDiff.removeAll(common);
        return symDiff;
    }
}