package HashTable;

import java.util.HashSet;

public class ZeroSumSubarray {
    static boolean findSum(int[] arr, int n)
    {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum == 0 || set.contains(prefixSum)) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }
}