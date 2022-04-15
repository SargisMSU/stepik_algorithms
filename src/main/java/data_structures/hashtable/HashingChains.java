package data_structures.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Формат входа. Первая строка размер хеш-таблицы m. Следующая
 * строка содержит количество запросов n. Каждая из последующих n строк содержит запрос одного из перечисленных выше
 * четырёх типов.
 * Формат выхода. Для каждого из запросов типа find и check выведите результат в отдельной строке.
 */
public class HashingChains {

    static class Map {
        int size;
        LinkedList<String>[] array;

        public Map(int size) {
            this.size = size;
            array = new LinkedList[size];
        }

        public void put(String value) {
            int hash = hash(value);
            if (array[hash] == null) {
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.add(value);
                array[hash] = linkedList;
            } else if (!array[hash].contains(value)) {
                array[hash].addFirst(value);
            }
        }

        int hash(String key) {
            char[] chars = key.toCharArray();
            BigDecimal decimal = new BigDecimal(0);
            for (int i = 0; i < chars.length; i++) {
                decimal = decimal.add(
                        BigDecimal.valueOf(chars[i]).
                                multiply(BigDecimal.valueOf(263).pow(i)).
                                remainder(BigDecimal.valueOf(1000000007)));
                decimal = decimal.remainder(BigDecimal.valueOf(1000000007));
            }
            return decimal.intValue() % size;
        }

        LinkedList<String> getByIndex(int index) {
            return array[index];
        }

        boolean contains(String value) {
            LinkedList<String> stringNode = array[hash(value)];
            if (stringNode == null)
                return false;
            return stringNode.contains(value);
        }

        public void delete(String value) {
            LinkedList<String> stringNode = array[hash(value)];
            if (stringNode != null) {
                stringNode.remove(value);
            }
        }

        @Override
        public String toString() {
            return "Map{" +
                    "size=" + size +
                    ", array=" + Arrays.toString(array) +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int requestsCount = Integer.parseInt(reader.readLine());
        Map map = new Map(size);
        for (int i = 0; i < requestsCount; i++) {
            String[] split = reader.readLine().split(" ");
            switch (split[0]) {
                case "add":
                    map.put(split[1]);
                    break;
                case "check":
                    int index = Integer.parseInt(split[1]);
                    LinkedList<String> byIndex = map.getByIndex(index);
                    /*System.out.println("check " + index);
                    System.out.println("map = " + map);*/
                    System.out.println(byIndex == null || byIndex.size() == 0 ? "" :
                            byIndex.toString().substring(1, byIndex.toString().length() - 1).
                                    replaceAll(",", ""));
                    break;
                case "find":
                    boolean contains = map.contains(split[1]);
                    System.out.println(contains ? "yes" : "no");
                    break;
                case "del":
                    map.delete(split[1]);
                    break;
            }
        }
    }
}
