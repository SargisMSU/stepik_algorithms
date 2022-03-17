package dynamically;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дано целое число 1<=n<=10^3 и массив A[1…n] натуральных чисел, не превосходящих 2*10^9.
 * Выведите максимальное 1≤k≤n, для которого найдётся подпоследовательность 1<=i_1<=i_2<=...<=i_k<=n длины k,
 * в которой каждый элемент делится на предыдущий.
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(longestSubsequenceButtomUp(array));
    }

    private static int longestSubsequenceButtomUp(int[] array) {
        int[] counts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[i] && array[j] != 0 && array[i] % array[j] == 0 && counts[j] + 1 > counts[i]) {
                    counts[i] = counts[j] + 1;
                }
            }
        }
        return Arrays.stream(counts).max().getAsInt();
    }
}
