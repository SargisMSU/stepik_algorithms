package dynamically;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10^2,
 * содержащих строчные буквы латинского алфавита.
 */
public class EditingDistance {

    static String first, second;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        first = scanner.nextLine();
        second = scanner.nextLine();

        cache = new int[first.length() + 1][second.length() + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }

        System.out.println(editingDistance(first.length(), second.length()));
    }

    static int editingDistance(int n, int m) {
        if (n == 0) return m;
        if (m == 0) return n;

        if (cache[n][m] != -1)
            return cache[n][m];

        int res1 = editingDistance(n - 1, m) + 1;
        int res2 = editingDistance(n, m - 1) + 1;
        int res3 = editingDistance(n - 1, m - 1) +
                (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
        int result = Math.min(Math.min(res1, res2), res3);
        cache[n][m] = result;
        return result;
    }
}
