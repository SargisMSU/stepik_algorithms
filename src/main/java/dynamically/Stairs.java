package dynamically;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Даны число 1 \le n \le 10^21≤n≤10
 * 2
 * ступенек лестницы и целые числа -10^4 <= a_1,..., a_n <= 10^4,
 * которыми помечены ступеньки. Найдите максимальную сумму,
 * которую можно получить, идя по лестнице снизу вверх (от нулевой до nn-й ступеньки),
 * каждый раз поднимаясь на одну или две ступеньки.
 */
public class Stairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }
        int[] d = new int[n];
        Arrays.fill(d, -1);
        for (int i = 0; i < n; i++) {
            if (i == 0) d[i] = points[i];
            else if (i == 1) d[i] = Math.max(points[i], d[0] + points[i]);
            else d[i] = points[i] + Math.max(d[i - 1], d[i - 2]);
        }
        System.out.println(d[n - 1]);
    }
}
