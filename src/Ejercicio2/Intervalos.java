package Ejercicio2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Intervalos {


    private static int max(int[][] intervalos, int n) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int var = Integer.MIN_VALUE;
        int prueba = 0;
        int max = 0;
        for (int[] it : intervalos) {
            minHeap.offer(new int[]{it[0], 1});
            minHeap.offer(new int[]{it[1], -1});
        }
        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            max += arr[1];
            if (max > prueba) {
                prueba = max;
                var = arr[0];
            }
        }
        return var;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] intervalo = {{1, 8}, {2, 3}, {4, 9}};
        System.out.println(max(intervalo, n));
    }

}
