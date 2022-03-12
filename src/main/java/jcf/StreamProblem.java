package jcf;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list of the strings, omitting any string length 4 or more.
 * ["a", "bbb", "cccc", "dddddd"] → ["a", "bbb"]
 * */
public class StreamProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        System.out.println(noLongString(strings));
    }

    public static List<String> noLongString(List<String> strings) {
        return strings.stream().filter(a->a.length() < 4).collect(Collectors.toList());
    }
}
