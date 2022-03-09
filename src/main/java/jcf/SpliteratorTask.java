package jcf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

/**
 * On spliteratorWork( List<Double> lst ):
 * -using Spliterator add to List<Double> sqrts all square roots of items from lst ,if this item greater than 1
 * -use Math.sqrt(number) to find square root : Math.sqrt(4)-> 2.0
 * On print(List<Double> list):
 * -get spliterator() of given list
 * -divide spliterator into 2 parts ( use spliterator.trySplit())
 * -print all items which >=2 from first part (use.println())
 * -print empty string
 * -print all items which >=10 from second part (use.println())
 * */
public class SpliteratorTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> lst = new ArrayList<>();
        while (scanner.hasNext()){
            lst.add((double)scanner.nextInt());
        }
        List<Double> sqrts = spliteratorWork(lst);
        print(sqrts);
    }

    public static List<Double> spliteratorWork(List<Double> lst){
        List<Double> sqrs = new ArrayList<>();
        lst.stream().filter(i->i>1).forEach(i->sqrs.add(Math.sqrt(i)));
        return sqrs;
    }
    public static void print(List<Double> list){
        Spliterator<Double> spliterator = list.spliterator();
        Spliterator<Double> spliteratorNew = spliterator.trySplit();
        if (spliteratorNew != null){
            spliteratorNew.forEachRemaining(System.out::println);
        }
        System.out.println();
        spliterator.forEachRemaining(d->{
            if (d >= 10)
                System.out.println(d);
        });
    }
}
