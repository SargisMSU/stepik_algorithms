package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
*
* Стек с поддержкой максимума:
Реализовать стек с поддержкой операций push, pop и max.
Вход. Последовательность запросов push, pop и max .
Выход. Для каждого запроса max вывести максимальное
число, находящееся на стеке.
* */
public class StackWithMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> maxStack = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < count; i++) {
            String line = bufferedReader.readLine();
            if (line.equals("max")) {
                System.out.println(maxStack.peek());
            } else if (line.equals("pop")) {
                maxStack.poll();
            } else if (line.startsWith("push")) {
                int num = Integer.parseInt(line.substring(5));
                if (maxStack.size() > 0 && maxStack.peek() > num) {
                    maxStack.add(maxStack.peek());
                } else {
                    maxStack.add(num);
                }
            }
        }
        bufferedReader.close();
    }
}
