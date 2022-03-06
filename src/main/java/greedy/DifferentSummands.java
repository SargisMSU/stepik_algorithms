package greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * По данному числу n 1≤n≤10^9
 *   найдите максимальное число k, для которого n можно представить как сумму
 *   k различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
 *
 * Sample Input 1:
 * */

public class DifferentSummands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> summands = new ArrayList<>();
        int temp = 0;
        while (n > 0){
            temp++;
            if (temp * 2 < n){
                n -= temp;
                summands.add(temp);
            }else {
                summands.add(n);
                break;
            }
        }
        System.out.println(summands.size());
        for (int i = 0; i < summands.size(); i++) {
            System.out.print(summands.get(i) + " ");
        }
    }
}
