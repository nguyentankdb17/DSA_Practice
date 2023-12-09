package Sorting;

import java.util.Collections;

public class SelectionSort {
    public static void selectionSort(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,2,1,3,6,7,5,2,4};
        selectionSort(arr.length,arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
