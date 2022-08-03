package Codility.CountingElements;

import java.util.HashSet;

/**
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves).
 *
 * For example, you are given integer X = 5 and array A such that:
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 *
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 */

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (set.remove(A[i])) {
                if (set.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        int[] arr1 = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println("Time Required to Reach " + 5 + " is: " + frogRiverOne.solution(5, arr1));
        int[] arr2 = new int[]{1, 3, 1, 4, 3, 5, 4, 2, 5};
        System.out.println("Time Required to Reach " + 5 + " is: " + frogRiverOne.solution(5, arr2));
        int[] arr3 = new int[]{1};
        System.out.println("Time Required to Reach " + 5 + " is: " + frogRiverOne.solution(5, arr3));
    }
}
