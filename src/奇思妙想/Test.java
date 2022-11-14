package 奇思妙想;

import javax.lang.model.element.Element;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        integers.add(8);
        integers.add(11);
        integers.add(64);
        integers.add(3);
        integers.add(0);
        System.out.println(integers.peek());

        while (!integers.isEmpty()){
            System.out.println(integers.poll());
        }
        Stack<Integer> objects = new Stack<>();
        Queue<Integer> queue = new LinkedList<Integer>();


        //双端队列
        ArrayDeque<Integer> de = new ArrayDeque<>();
        de.addFirst(1);
        de.addFirst(2);
        de.addFirst(3);
        de.addLast(4);

    }
    public static class com implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            return (Integer) o2 - (Integer) o1;
        }
    }
}
