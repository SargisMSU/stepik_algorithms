package greedy;

import java.util.*;

/**
 * По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из
 * отрезков содержит хотя бы одну из точек.
 *
 * В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк содержит по два числа 0≤l≤r≤10^9,
 * задающих начало и конец отрезка. Выведите оптимальное число m точек и сами m точек.
 * Если таких множеств точек несколько, выведите любое из них.
 * */
public class CoveringSegments {

    private static int[] getPoints(Segment[] segments) {
        Arrays.sort(segments, Comparator.comparingInt(segment -> segment.end));

        List<Integer> listOfPoints = new ArrayList<>();
        int i = 0, n = segments.length;
        while (i < n) {
            int right = segments[i].end;
            listOfPoints.add(right);
            while (i < n &&  segments[i].start <= right &&
                    right <= segments[i].end)
                i++;
        }

        int[] points = new int[listOfPoints.size()];
        for(int j = 0; j < listOfPoints.size(); j++)
            points[j] = listOfPoints.get(j);
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = getPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}