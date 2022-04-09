package data_structures.disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Формат входа. Первая строка содержит числа n и m — число таблиц
 * и число запросов, соответственно. Вторая строка содержит n целых чисел r1, . . . , rn — размеры таблиц.
 * Каждая из последующих m строк содержит два номера таблиц destination i и source i, которые необходимо объединить.
 * Формат выхода. Для каждого из m запросов выведите максимальный размер таблицы после соответствующего объединения.
 * */
class DSF {
    int[] parent; // ссылки
    int[] rnk; // ранги

    /* Конструктор */
    DSF(int sz) {
        parent = new int[sz];
        rnk = new int[sz];
        for (int i = 0; i < sz; i++)
            make_set(i); // изначально все ссылки зациклены
    }

    void setRnk(int i, int rank){
        rnk[i] = rank;
    }

    void make_set (int v) {
        parent[v] = v;
    }

    int find_set (int v) {
        if (v == parent[v])
            return v;
        return parent[v] = find_set (parent[v]);
    }

    int union_sets (int a, int b) {
        a = find_set (a);
        b = find_set (b);
        if (a != b) {
            parent[b] = a;
            rnk[b] = rnk[a] + rnk[b];
            rnk[a] = rnk[b];
        }
        return rnk[b];
    }

    @Override
    public String toString() {
        return "DSF{" +
                "parent=" + Arrays.toString(parent) +
                ", rnk=" + Arrays.toString(rnk) +
                '}';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        DSF dsf = new DSF(firstLine[0]);
        int joiningSize = firstLine[1];
        int[] tablesSize = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < firstLine[0]; i++) {
            dsf.setRnk(i, tablesSize[i]);
        }
        int max = Arrays.stream(dsf.rnk).max().orElse(0);
        for (int i = 0; i < joiningSize; i++) {
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int i1 = dsf.union_sets(s[0] - 1, s[1] - 1);
            max = Math.max(max, i1);
            System.out.println(max);
        }
    }
}