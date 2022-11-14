package November_2022;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2022_11_2 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int Max_X = Integer.MIN_VALUE;
        int Max_Y = Integer.MIN_VALUE;
        int[] MaxPoint = new int[2];
        double MaxStrength = 0;
        PriorityQueue<Integer> X = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> Y = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int[] tower : towers) {
            X.add(tower[0]);
            Y.add(tower[1]);
        }
        Max_X = X.poll();
        Max_Y = Y.poll();
        for (int i = 0;i <= Max_X;i++)
            for (int j = 0;j <= Max_Y;j++){
                double strength = 0;
                for (int[] tower : towers) {
                    double distance = Math.sqrt(Math.pow(tower[0]-i,2) + Math.pow(tower[1]-j,2));
                    if (distance < radius)
                        strength+=tower[2]/(1+distance);
                }
                if (strength > MaxStrength){
                    MaxPoint[0]= i;
                    MaxPoint[1]= j;
                    MaxStrength=strength;
                }


            }
        System.out.println(MaxStrength);
        return MaxPoint;
    }


    @Test
    void Test(){
        int[][] towers = {{1,2,5},{2,1,7},{3,1,9}};
        int radius = 2;
        System.out.println(bestCoordinate(towers, 2)[0]);
        System.out.println(bestCoordinate(towers, 2)[1]);


    }


}
