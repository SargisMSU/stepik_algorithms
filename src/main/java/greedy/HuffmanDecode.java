package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Восстановите строку по её коду и беспрефиксному коду символов.
 * В первой строке входного файла заданы два целых числа k и l через пробел — количество различных букв,
 * встречающихся в строке, и размер получившейся закодированной строки, соответственно. В следующих k строках
 * записаны коды букв в формате "letter: code". Ни один код не является префиксом другого. Буквы могут быть
 * перечислены в любом порядке. В качестве букв могут встречаться лишь строчные буквы латинского алфавита;
 * каждая из этих букв встречается в строке хотя бы один раз. Наконец, в последней строке записана
 * закодированная строка. Исходная строка и коды всех букв непусты. Заданный код таков, что закодированная
 * строка имеет минимальный возможный размер.
 *
 *
 * В первой строке выходного файла выведите строку s. Она должна состоять из строчных букв латинского алфавита.
 * Гарантируется, что длина правильного ответа не превосходит 10^4
 * */

public class HuffmanDecode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lettersCount = scanner.nextInt();
        int codedStrLength = scanner.nextInt();
        Map<String, Character> charCode = new HashMap<>();
        for (int i = 0; i < lettersCount; i++) {
            char c = scanner.next().charAt(0);
            String code = scanner.next();
            charCode.put(code, c);
        }
        String codedStr = scanner.next();
        StringBuilder result = new StringBuilder();
        while (codedStr.length() > 0){
            for (Map.Entry<String, Character> entry: charCode.entrySet()) {
                if (codedStr.startsWith(entry.getKey())){
                    codedStr = codedStr.substring(entry.getKey().length());
                    result.append(entry.getValue());
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
