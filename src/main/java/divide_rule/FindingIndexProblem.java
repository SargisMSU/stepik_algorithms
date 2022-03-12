package divide_rule;

import java.util.Scanner;

/**
 * В первой строке даны целое число 1≤n≤10^5
 *   и массив A[1...n] из n различных натуральных чисел, не превышающих 10^9
 *   в порядке возрастания, во второй — целое число 1 <= k <= 10^5
 *   и k натуральных чисел b_1, ... , b_k
 *  , не превышающих 10^9
 *  . Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для которого A[j]=b_i
 *  или -1, если такого j нет.
 * */
public class FindingIndexProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.print(findIndexInArray(a, b[i]) + " ");
        }
    }

    static int findIndexInArray(int[] array, int elem){
        int left = 0, m;
        int right = array.length - 1;
        while (left <= right) {
            m = left + (right - left) / 2;
            if (array[m] == elem) {
                return m + 1;
            } else if (array[m] > elem) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return -1;
    }
}
