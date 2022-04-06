package data_structures;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Формат входа. Первая строка содержит число n. Следующая строка
 * задаёт массив чисел A[0], . . . , A[n − 1].
 * Формат выхода. Первая строка выхода должна содержать число обменов m, которое должно удовлетворять
 * неравенству 0 ≤ m ≤ 4n. Каждая из последующих m строк должна задавать обмен элементов массива.
 */
public class BuildHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        int n = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(i, array, joiner);
        }
        String s = joiner.toString();
        System.out.println(s.length() == 0 ? 0 : s.split("\n").length);
        System.out.println(s);
    }

    private static void siftDown(int k, int[] array, StringJoiner joiner) {
        while (k <= array.length / 2) {
            int maxIndex = k;
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            if (left < array.length && array[left] < array[maxIndex]){
                maxIndex = left;
            }
            if (right < array.length && array[right] < array[maxIndex]){
                maxIndex = right;
            }
            if (maxIndex == k){
                break;
            }else {
                swap(array, maxIndex, k, joiner);
                k = maxIndex;
            }
        }
    }

    private static void swap(int[] array, int m, int n, StringJoiner joiner){
        joiner.add(n + " " + m);
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
