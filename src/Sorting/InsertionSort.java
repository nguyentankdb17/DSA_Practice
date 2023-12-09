package Sorting;

public class InsertionSort {
    public static void insertionSort(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,2,1,3,6,7,5,2,4};
        insertionSort(arr.length,arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
