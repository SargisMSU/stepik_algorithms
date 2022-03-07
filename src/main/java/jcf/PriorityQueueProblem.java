package jcf;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Первая строка входа содержит число операций 1≤n≤10^5.
 * Каждая из последующих nn строк задают операцию одного из следующих двух типов:
 *
 * Insert x, где 0≤x≤10^9— целое число;
 * ExtractMax
 * Первая операция добавляет число x в очередь с приоритетами, вторая — извлекает максимальное число и выводит его.
 * */
public class PriorityQueueProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        StringJoiner out = new StringJoiner("\n");
        for (int i = 0; i < count; i++) {
            String next = scanner.next();
            if (next.startsWith("Insert")){
                int num = scanner.nextInt();
                priorityQueue.add(num);
            }else if (next.equals("ExtractMax")){
                out.add(priorityQueue.poll()+"");
            }
        }
        System.out.println(out);
    }
}
