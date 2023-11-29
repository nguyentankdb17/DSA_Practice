package Sorting;

import java.util.Scanner;

public class MergeSort {
    static void merge(int[] arr, int l, int m, int r)
    {
        int[] ans = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k =0;

        while (i<=m && j<=r) {
            if (arr[i]<arr[j]) {
                ans[k++] = arr[i++];
            }
            else {
                ans[k++] = arr[j++];
            }
        }
        while (i<=m) {
            ans[k++] = arr[i++];

        }
        while (j<=r) {
            ans[k++] = arr[j++];
        }
        int b =0;
        for (int a = l; a<=r;a++) {
            arr[a] = ans[b++];
        }
    }
    static void mergeSort(int[] arr, int l, int r)
    {
        if (l<r) {
            int m = l + (r-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
