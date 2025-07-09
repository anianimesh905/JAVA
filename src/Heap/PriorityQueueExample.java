package src.Heap;

import java.util.PriorityQueue;
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>();

        min.add(10);
        min.add(5);
        min.add(20);

        System.out.println(min.peek());

        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);

        max.add(10);
        max.add(5);
        max.add(20);

        System.out.println(max.peek());


    }
}
