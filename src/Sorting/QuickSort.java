package Sorting;

import java.util.Scanner;

public class QuickSort {
    static void quickSort(int[] arr, int low, int high)
    {
        if (low <high) {
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;

        for (int j=low;j<high;j++) {
            if (arr[j] <pivot) {
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr,i+1,high);
        return i+1;
    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
