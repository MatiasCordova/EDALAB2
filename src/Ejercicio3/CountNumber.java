package Ejercicio3;

import java.util.*;

class CountNumber {

    static int count(int arr[], int n) {
        int c = 1;

        for (int i = 1; i < n; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }

            if (i == j) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            arr[i] = m;
        }
        System.out.println();
        System.out.println(count(arr, n));
    }
}
