package data_structures.hashtable;

import java.io.*;

public class SubstringSearch {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String substring = reader.readLine();
        String text = reader.readLine();

        int substringHash = hash(substring);
        int tempHash = hash(text.substring(0, substring.length()));
        if (substringHash == tempHash && substring.equals(text.substring(0, substring.length())))
            System.out.println(0);

        char[] chars = text.toCharArray();
        for (int i = 1; i < text.length() - substring.length() + 1; i++) {
            tempHash = (int) ((tempHash - chars[i - 1]) + chars[i + substring.length() - 1]);
            if (tempHash == substringHash && text.startsWith(substring, i)){
                System.out.println(i);
            }
        }
    }

    private static int hash(String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            res += aChar;
        }
        return res;
    }
}
