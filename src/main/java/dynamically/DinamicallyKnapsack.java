package dynamically;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Первая строка входа содержит целые числа 1<=W<=10^4 и 1 <= n <= 300 — вместимость рюкзака и число золотых слитков.
 * Следующая строка содержит n целых чисел 0 <= w_1, ..., w_n <= 10^5 задающих веса слитков.
 * Найдите максимальный вес золота, который можно унести в рюкзаке.
 */
public class DinamicallyKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        Arrays.sort(weights);
        int[][] matrix = new int[weight + 1][n + 1];
        for (int i = 0; i < weight + 1; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int res = dinamicallyKnapsack(matrix, weight, weights, n);
        System.out.println("res = " + res);

    }

    private static int dinamicallyKnapsack(int[][] matrix, int weight, int[] weights, int n) {
        if (weight == 0 || n == 0) {
            matrix[weight][n] = 0;
            return 0;
        }
        if (weights[n - 1] > weight) {
            if (matrix[weight][n - 1] == -1) {
                matrix[weight][n - 1] = dinamicallyKnapsack(matrix, weight, weights, n - 1);
            }
            return matrix[weight][n - 1];
        } else {
            if (matrix[weight - weights[n - 1]][n - 1] == -1) {
                matrix[weight - weights[n - 1]][n - 1] =
                        dinamicallyKnapsack(matrix, weight - weights[n - 1], weights, n - 1);
            }
            if (matrix[weight][n - 1] == -1) {
                matrix[weight][n - 1] = dinamicallyKnapsack(matrix, weight, weights, n - 1);
            }
            matrix[weight][n] = Math.max(weights[n - 1] + matrix[weight - weights[n - 1]][n - 1],
                    matrix[weight][n - 1]);
            return matrix[weight][n];
        }
    }
}
