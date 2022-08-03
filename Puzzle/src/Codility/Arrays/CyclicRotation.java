package Codility.Arrays;

import java.util.Arrays;

/**
 * Rotate an array to the right by a given number of steps.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * For example, given
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 *
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *
 * For another example, given
 *     A = [0, 0, 0]
 *     K = 1
 *
 * the function should return [0, 0, 0]
 *
 * Given
 *     A = [1, 2, 3, 4]
 *     K = 4
 *
 * the function should return [1, 2, 3, 4]
 */

public class CyclicRotation {

    public int[] reverseArray(int[] A, int start, int end) {
        while (start < end) {
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start += 1;
            end -= 1;
        }
        return A;
    }
    public int[] solution(int[] A, int K) {
        if (K == 0 || A.length == 0 || K == A.length) return A;
        int len = A.length;
        K = K % A.length;
        reverseArray(A, 0, len-1);
        reverseArray(A, 0, K-1);
        reverseArray(A, K, len-1);
        return A;
    }
    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] sol1 = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println("Solution: " + Arrays.toString(sol1));

        int[] sol2 = cyclicRotation.solution(new int[]{0, 0, 0}, 1);
        System.out.println("Solution: " + Arrays.toString(sol2));

        int[] sol3 = cyclicRotation.solution(new int[]{1, 2, 3, 4}, 4);
        System.out.println("Solution: " + Arrays.toString(sol3));

        int[] sol4 = cyclicRotation.solution(new int[]{}, 4);
        System.out.println("Solution: " + Arrays.toString(sol4));
    }
}
