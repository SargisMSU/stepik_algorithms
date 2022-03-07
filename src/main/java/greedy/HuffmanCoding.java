package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * По данной непустой строке ss длины не более 10^4,
 * состоящей из строчных букв латинского алфавита,
 * постройте оптимальный беспрефиксный код.
 * В первой строке выведите количество различных букв k, встречающихся в строке,
 * и размер получившейся закодированной строки. В следующих k строках запишите коды
 * букв в формате "letter: code". В последней строке выведите закодированную строку.
 * */
public class HuffmanCoding {

    class Node implements Comparable<Node>{
        final int priority;
        String code;

        void buildCode(String code){
            this.code = code;
        }

        public Node(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(Node o) {
            return priority - o.priority;
        }
    }

    class InternalNode extends Node{
        Node prev, next;

        public InternalNode(Node prev, Node next) {
            super(prev.priority + next.priority);
            this.prev = prev;
            this.next = next;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            prev.buildCode(code + "0");
            next.buildCode(code + "1");
        }
    }

    class LeafNode extends Node{
        char symbol;

        public LeafNode(char symbol, int priority) {
            super(priority);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }

    void run(String input){
        Map<Character, Integer> countsOfChars = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (countsOfChars.containsKey(c)){
                countsOfChars.put(c, countsOfChars.get(c) + 1);
            }else {
                countsOfChars.put(c, 1);
            }
        }
        Map<Character, Node> charNode = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : countsOfChars.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNode.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }
        int sum = 0;
        while (priorityQueue.size() >= 2){
            InternalNode internalNode = new InternalNode(priorityQueue.poll(), priorityQueue.poll());
            priorityQueue.add(internalNode);
            sum += internalNode.priority;
        }
        if (countsOfChars.size() == 1){
            sum = input.length();
        }
        System.out.println(countsOfChars.size() + " " + sum);
        if (countsOfChars.size() == 1){
            priorityQueue.peek().buildCode("0");
        }else {
            priorityQueue.peek().buildCode("");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            builder.append(charNode.get(c).code);
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        new HuffmanCoding().run(input);

    }
}
