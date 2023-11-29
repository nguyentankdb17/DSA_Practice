package Sorting;

import java.util.Scanner;

public class HeapSort {
    static void buildHeap(int[] arr, int n)
    {
        for (int i=n/2-1;i>=0;i--) {
            heapify(arr,n,i);
        }
    }

    static void heapify(int[] arr, int n, int i)
    {
        // Your code here
        int left = 2*i+1;
        int right = 2*i+2;

        int largest = i;

        if (left<n &&  arr[left]>arr[largest]) {
            largest = left;
        }
        if (right<n && arr[right]>arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr,n,largest);
        }
    }

    static void heapSort(int[] arr, int n)
    {
        buildHeap(arr,n);
        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        heapSort(arr,n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
