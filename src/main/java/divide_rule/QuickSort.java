package divide_rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на прямой, соответственно.
 * Следующие nn строк содержат по два целых числа a  и b — координаты концов отрезков.
 * Последняя строка содержит m целых чисел — координаты точек. Все координаты не превышают 10^8 по модулю.
 * Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
 * Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 * */
public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        String[] lengths = bufferedReader.readLine().split(" ");
        int segmentsCount = Integer.parseInt(lengths[0]);
        int pointsCount = Integer.parseInt(lengths[1]);
        int[][] segments = new int[2][segmentsCount];
        for (int i = 0; i < segmentsCount; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            segments[0][i] = Integer.parseInt(s[0]);
            segments[1][i] = Integer.parseInt(s[1]);
        }
        int[] points = new int[pointsCount];
        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < pointsCount; i++) {
            points[i] = Integer.parseInt(s[i]);
        }
        quickSort(segments[0], 0, segmentsCount - 1);
        quickSort(segments[1], 0, segmentsCount - 1);
        for (int i = 0; i < pointsCount; i++) {
            int point = points[i];
            int m = getLECounts(segments[0], point);
            int n = getLCounts(segments[1], point);
            System.out.print((m - n) + " ");
        }
    }

    private static int getLCounts(int[] segment, int point) {
        int count = 0;
        int i = 0;
        while (i < segment.length && segment[i] < point){
            count++;
            i++;
        }
        return count;
    }
    private static int getLECounts(int[] segment, int point) {
        int count = 0;
        int i = 0;
        while (i < segment.length && segment[i] <= point){
            count++;
            i++;
        }
        return count;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

}
