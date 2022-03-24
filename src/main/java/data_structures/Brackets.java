package data_structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> deque = new ArrayDeque<>();
        ArrayDeque<Integer> indexesDeque = new ArrayDeque<>();
        boolean right = true;
        while (scanner.hasNext()) {
            char[] chars = scanner.next().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                    deque.add(chars[i]);
                    indexesDeque.add(i + 1);
                } else if (chars[i] == ')') {
                    if (deque.size() > 0 && '(' == deque.getLast()) {
                        deque.removeLast();
                        indexesDeque.removeLast();
                    } else {
                        System.out.println(i + 1);
                        right = false;
                        break;
                    }
                } else if (chars[i] == '}') {
                    if (deque.size() > 0 && '{' == deque.getLast()) {
                        deque.removeLast();
                        indexesDeque.removeLast();
                    } else {
                        System.out.println(i + 1);
                        right = false;
                        break;
                    }
                } else if (chars[i] == ']') {
                    if (deque.size() > 0 && '[' == deque.getLast()) {
                        deque.removeLast();
                        indexesDeque.removeLast();
                    } else {
                        System.out.println(i + 1);
                        right = false;
                        break;
                    }
                }
            }
            if (right && deque.size() == 0) {
                System.out.println("Success");
            } else if (right) {
                System.out.println(indexesDeque.getFirst());
            }
            deque.clear();
            indexesDeque.clear();
        }
    }
}
