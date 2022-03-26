package data_structures;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringJoiner;

public class PackagesProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int countOfPackages = scanner.nextInt();
        ArrayDeque<Integer> priorityQueue = new ArrayDeque<>(size);
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < countOfPackages; i++) {
            int arrival = scanner.nextInt();
            int duration = scanner.nextInt();
            while (priorityQueue.size() > 0 && priorityQueue.peekFirst() <= arrival) {
                priorityQueue.removeFirst();
            }
            if (priorityQueue.size() < size) {
                int startTime = priorityQueue.size() > 0 ? priorityQueue.peekLast() : 0;
                startTime = Math.max(startTime, arrival);
                priorityQueue.add(startTime + duration);
                joiner.add((startTime) + "");
            } else {
                joiner.add(-1 + "");
            }
        }
        System.out.println(joiner);
    }
}
