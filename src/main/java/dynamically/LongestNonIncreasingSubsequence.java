package dynamically;

import java.util.Scanner;

/**
 * Дано целое число 1<=n<=10^5 и массив A[1…n] содержащий неотрицательные целые числа, не превосходящие 10^9.
 * Найдите наибольшую невозрастающую подпослед.овательность в A. В первой строке выведите её длину k,
 * во второй — её индексы 1 <= i_1 <= i_2 ... <= i_k <=  n(таким образом, A[i_1] >= A[i_2] >=...>= A[i_n]).
 */
public class LongestNonIncreasingSubsequence {

    public static int[] lis(int[] a) {
        int n = a.length;
        /**
         * tail[i]- индекс последнего элемента подпоследовательности длины i+1
         * */
        int[] tail = new int[n];
        int[] prev = new int[n];

        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = lower_bound(a, tail, len, a[i]);
            if (pos == len) {
                ++len;
            }
            prev[i] = pos > 0 ? tail[pos - 1] : -1;
            tail[pos] = i;
        }

        int[] res = new int[len];
        for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
            res[--len] = i + 1;
        }
        return res;
    }

    static int lower_bound(int[] a, int[] tail, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tail[mid]] >= key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int[] lis = lis(a);

        System.out.println(lis.length);
        for (int i = 0; i < lis.length; i++)
            System.out.print(lis[i] + " ");
    }
}
