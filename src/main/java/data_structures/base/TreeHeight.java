package data_structures.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Формат входа. Первая строка содержит натуральное число n. Вторая
 * строка содержит n целых чисел parent0, . . . , parentn−1.
 * Для каждого 0 ≤ i ≤ n−1, parenti — родитель вершины i; если parenti = −1,
 * то i является корнем. Гарантируется, что корень ровно один. Гарантируется,
 * что данная последовательность задаёт дерево.
 * Формат выхода. Высота дерева.
 */
public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] tree = new Integer[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }
        int height = getHeight(tree);
        System.out.println(height);
    }

    private static int getHeight(Integer[] tree) {
        Set<Integer> leafs = getLeafs(tree);
        int res = 0;
        for (Integer leaf : leafs) {
            int height = 1;
            while (tree[leaf] != -1) {
                leaf = tree[leaf];
                height++;
            }
            res = Math.max(res, height);
        }
        return res;
    }

    private static Set<Integer> getLeafs(Integer[] tree) {
        int n = tree.length;
        Set<Integer> leafs = new HashSet<>(n);
        Set<Integer> elems = new HashSet<>(Arrays.asList(tree));
        for (int i = 0; i < n; i++) {
            if (!elems.contains(i))
                leafs.add(i);
        }
        return leafs;
    }

    private static int getHeightRecursive(Integer[] tree, int rootIndex) {
        int res = 1;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == rootIndex) {
                res = Math.max(res, 1 + getHeightRecursive(tree, i));
            }
        }
        return res;
    }
}
