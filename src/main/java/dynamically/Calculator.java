package dynamically;

import java.util.Arrays;
import java.util.Scanner;

/**
 * У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x: заменить x на 2x,
 * 3x или x+1. По данному целому числу 1<=n<=10^5
 * определите минимальное число операций k, необходимое, чтобы получить n из 1.
 * Выведите k и последовательность промежуточных чисел.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] minOperations = new int[n];
        Arrays.fill(minOperations, -1);
        minOperations[0] = 0;
        for (int i = 2; i < n + 1; i++) {
            int res1 = minOperations[i - 2] + 1;
            if (i % 2 == 0) {
                res1 = Math.min(res1, minOperations[(i - 1) / 2] + 1);
            }
            if (i % 3 == 0) {
                res1 = Math.min(res1, minOperations[(i - 1) / 3] + 1);
            }
            minOperations[i - 1] = res1;
        }
        int operationsCount = minOperations[n - 1];
        int num = n;
        int[] steps = new int[operationsCount + 1];
        steps[operationsCount] = num;
        for (int i = n - 1; i > 0; i--) {
            if (minOperations[i - 1] == operationsCount - 1 && ((num % 3 == 0 && num / 3 == i) ||
                    (num % 2 == 0 && num / 2 == i) || num - 1 == i)) {
                operationsCount = minOperations[i - 1];
                steps[operationsCount] = i;
                num = i;
            }
        }
        System.out.println(minOperations[n - 1]);
        String s = Arrays.toString(steps);
        s = s.substring(1, s.length() - 1).replaceAll(",", "");
        System.out.println(s);
    }
}
