package data_structures.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<Integer, String> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            int number = Integer.parseInt(split[1]);
            switch (split[0]) {
                case "add":
                    phoneBook.put(number, split[2]);
                    break;
                case "find":
                    System.out.println(phoneBook.getOrDefault(number, "not found"));
                    break;
                case "del":
                    phoneBook.remove(number);
                    break;
                default:
            }
        }
    }
}
