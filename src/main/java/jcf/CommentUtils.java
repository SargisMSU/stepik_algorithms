package jcf;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class LongRange {
    private final long left;
    private final long right;

    public static void main(String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());
        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));
        numbers.forEach(System.out::println);
    }

    public static Comparator<LongRange> getComparator() {
        return getComparator1().thenComparingLong(LongRange::getLeft);
    }

    public static Comparator<LongRange> getComparator1() {
        return (o1, o2) -> (int) ((o1.getRight()-o1.getLeft()) - (o2.getRight()-o2.getLeft()));
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}