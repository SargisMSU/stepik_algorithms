package data_structures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Обход двоичного дерева
 * Построить in-order, pre-order и post-order обходы данного двоичного дерева.
 * Вход. Двоичное дерево.
 * Выход. Все его вершины в трёх разных порядках: in-order, pre-order и post-order.
 */

/*
 * Печатать CORRECT, если вводимое дерево двоичное, INCORRECT - в обратном случае.
 * */
public class BinaryTree {
    static class Node {
        private int value; // ключ узла
        private int leftChild; // Левый узел потомок
        private int rightChild; // Правый узел потомок

        public int getValue() {
            return this.value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public int getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(final int leftChild) {
            this.leftChild = leftChild;
        }

        public int getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(final int rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    static class Tree {
        private final Node[] array;

        public Tree(int size) { // Пустое дерево
            array = new Node[size];
        }

        public void insertNode(int index, int value, int left, int right) { // метод вставки нового элемента
            Node newNode = new Node(); // создание нового узла
            newNode.setValue(value); // вставка данных
            newNode.setLeftChild(left);
            newNode.setRightChild(right);
            array[index] = newNode;
        }

        public boolean isBinary(int index, int min, int max) {
            int currentValue = array[index].getValue();
            int leftChild = array[index].getLeftChild();
            int rightChild = array[index].getRightChild();
            if (currentValue > min && currentValue < max) {
                boolean isLeftSubTreeBinary = leftChild == -1 || isBinary(leftChild, min, currentValue);
                boolean isRightSubTreeBinary = rightChild == -1 || isBinary(rightChild, currentValue, max);
                return isLeftSubTreeBinary && isRightSubTreeBinary;
            } else
                return false;
        }

        public void printTreeInOrder(int index) {
            if (array[index].getLeftChild() != -1)
                printTreeInOrder(array[index].getLeftChild());
            System.out.print(array[index].getValue() + " ");
            if (array[index].getRightChild() != -1)
                printTreeInOrder(array[index].getRightChild());
        }

        public void printTreePreOrder(int index) {
            System.out.print(array[index].getValue() + " ");
            if (array[index].getLeftChild() != -1) {
                printTreePreOrder(array[index].getLeftChild());
            }
            if (array[index].getRightChild() != -1)
                printTreePreOrder(array[index].getRightChild());
        }

        public void printTreePostOrder(int index) {
            if (array[index].getLeftChild() != -1) {
                printTreePostOrder(array[index].getLeftChild());
            }
            if (array[index].getRightChild() != -1) {
                printTreePostOrder(array[index].getRightChild());
            }
            System.out.print(array[index].getValue() + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Tree binaryTree = new Tree(n);
        for (int i = 0; i < n; i++) {
            int[] insertLine = Arrays.stream(reader.readLine().split(" ")).
                    mapToInt(Integer::parseInt)
                    .toArray();
            binaryTree.insertNode(i, insertLine[0], insertLine[1], insertLine[2]);
        }
        if (n == 0) {
            System.out.println("CORRECT");
            return;
        }
        binaryTree.printTreeInOrder(0);
        System.out.println();
        binaryTree.printTreePreOrder(0);
        System.out.println();
        binaryTree.printTreePostOrder(0);
        System.out.println();

        System.out.println(binaryTree.isBinary(0, Integer.MIN_VALUE, Integer.MAX_VALUE) ?
                "CORRECT" : "INCORRECT");
    }
}
