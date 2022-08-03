package Codility.CountingElements;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 */

public class MissingInteger {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= A.length+1; i++) set.add(i);
        for (int x : A) set.remove(x);
        return (int) set.toArray()[0];
    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int[] arr1 = new int[]{1, 3, 6, 4, 1, 2};
        System.out.println("Missing Integer in Array: " + Arrays.toString(arr1) + " is: " + missingInteger.solution(arr1));
        int[] arr2 = new int[]{1, 2, 3};
        System.out.println("Missing Integer in Array: " + Arrays.toString(arr2) + " is: " + missingInteger.solution(arr2));
        int[] arr3 = new int[]{-1, -3};
        System.out.println("Missing Integer in Array: " + Arrays.toString(arr3) + " is: " + missingInteger.solution(arr3));
    }
}
