package fibonacci;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println(fibonacci(k));
    }

    private static int fibonacci(int k) {
        int a1 = 0;
        int a2 = 1;
        for (int i = 0; i < k - 1; i++) {
            int newValue = a1 + a2;
            a1 = a2;
            a2 = newValue;
        }
        return a2;
    }
}
