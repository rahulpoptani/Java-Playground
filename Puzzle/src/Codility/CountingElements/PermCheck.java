package Codility.CountingElements;

import java.util.Arrays;
import java.util.HashSet;

/**
 * A non-empty array A consisting of N integers is given.
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * For example, array A such that:
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, the function should return 1.
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing. The function should return 0.
 */

public class PermCheck {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= A.length; i++) set.add(i);
        for (int i = 0; i < A.length; i++) set.remove(A[i]);
        if (set.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int[] arr1 = new int[]{4, 1, 3, 2};
        System.out.println("Array: " + Arrays.toString(arr1) + " is permutation: " + permCheck.solution(arr1));
        int[] arr2 = new int[]{4, 1, 3};
        System.out.println("Array: " + Arrays.toString(arr2) + " is permutation: " + permCheck.solution(arr2));
    }
}
