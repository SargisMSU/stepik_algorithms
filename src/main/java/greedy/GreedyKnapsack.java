package greedy;

import java.util.*;
/**
 * Первая строка содержит количество предметов 1≤n≤10^3
 * и вместимость рюкзака 0≤W≤2⋅10^6.
 * Каждая из следующих n строк задаёт стоимость 0≤c≤2⋅10^6
 * и объём 0<w≤2⋅10^6 предмета (n, W, c — целые числа).
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть,
 * стоимость и объём при этом пропорционально уменьшатся), помещающихся в данный рюкзак,
 * с точностью не менее трёх знаков после запятой.
 * */
public class GreedyKnapsack {

    class Item{
        int cost, weight;
        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    "}\n";
        }
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int W = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            int cost, weight;
            cost = scanner.nextInt();
            weight = scanner.nextInt();
            items[i] = new Item(cost, weight);
        }
        Arrays.sort(items, Comparator.comparingDouble(item->-(double) item.cost/item.weight));
        double result = 0;
        for (Item item : items) {
            if (item.weight <= W){
                result += item.cost;
                W -= item.weight;
            }else {
                result += (double) item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        GreedyKnapsack greedyKnapsack = new GreedyKnapsack();
        greedyKnapsack.run();
    }
}
