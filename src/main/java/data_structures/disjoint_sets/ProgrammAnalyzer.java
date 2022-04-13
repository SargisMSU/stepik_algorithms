package data_structures.disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * При автоматическом анализе программ возникает такая задача.
 * Система равенств и неравенств
 * Проверить, можно ли присвоить переменным целые значения, чтобы
 * выполнить заданные равенства вида xi = xj и неравенства вида xp != xq.
 * Вход. Число переменных n, а также список равенств вида
 * xi = xj и неравенства вида xp != xq.
 * Выход. Проверить, выполнима ли данная система.
 * */

public class ProgrammAnalyzer {

    static class DSF {
        int[] parent; // ссылки
        int[] rnk; // ранги

        /* Конструктор */
        DSF(int sz) {
            parent = new int[sz];
            rnk = new int[sz];
            for (int i = 0; i < sz; i++)
                make_set(i); // изначально все ссылки зациклены
        }

        void setRnk(int i, int rank) {
            rnk[i] = rank;
        }

        void make_set(int v) {
            parent[v] = v;
        }

        int find_set(int v) {
            if (v == parent[v])
                return v;
            return parent[v] = find_set(parent[v]);
        }

        int union_sets(int a, int b) {
            a = find_set(a);
            b = find_set(b);
            if (a != b) {
                parent[b] = a;
                rnk[b] = rnk[a] + rnk[b];
                rnk[a] = rnk[b];
            }
            return rnk[b];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = firstLine[0];
        int equalityCount = firstLine[1];
        int inequalityCount = firstLine[2];
        DSF dsf = new DSF(n);
        for (int i = 0; i < equalityCount; i++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dsf.union_sets(line[0] - 1, line[1] - 1);
        }
        boolean result = true;
        for (int i = 0; i < inequalityCount; i++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int set1 = dsf.find_set(line[0] - 1);
            int set2 = dsf.find_set(line[1] - 1);
            if (set1 == set2)
                result = false;
        }

        System.out.println(result ? 1 : 0);
    }
}
