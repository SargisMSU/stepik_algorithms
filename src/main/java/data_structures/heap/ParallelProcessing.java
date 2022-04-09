package data_structures.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class ParallelProcessing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] firstLine = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] tasks = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long processorsCount = firstLine[0];
        long tasksCount = firstLine[1];
        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int timeDiff = (int) (o1.getTime() - o2.getTime());
            if (timeDiff != 0)
                return timeDiff;
            else return (int) (o1.getProcessor() - o2.getProcessor());
        });

        for (int i = 0; i < processorsCount; i++) {
            priorityQueue.add(new Entry(i, 0));
        }

        for (long task : tasks) {
            Entry entry = priorityQueue.poll();
            System.out.println(entry.getProcessor() + " " + entry.getTime());
            entry.setTime(entry.getTime() + task);
            priorityQueue.add(entry);
        }
    }
}


class Entry {
    private long processor, time;

    public Entry(long processor, long time) {
        this.processor = processor;
        this.time = time;
    }

    public long getProcessor() {
        return processor;
    }

    public void setProcessor(long processor) {
        this.processor = processor;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
