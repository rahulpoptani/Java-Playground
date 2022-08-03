package Codility.CountingElements;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 *         increase(X) − counter X is increased by 1,
 *         max counter − all counters are set to the maximum value of any counter.
 *
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 *         if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 *         if A[K] = N + 1 then operation K is max counter.
 *
 * For example, given integer N = 5 and array A such that:
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 *
 * the values of the counters after each consecutive operation will be:
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 *
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * The goal is to calculate the value of every counter after all operations.
 */

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int maxCounter = 0;
        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            int indexForResult = A[i];
            if (indexForResult > N) {
                for (int j = 0; j < result.length; j++) result[j] = maxCounter;
            } else {
                result[indexForResult-1] = result[indexForResult-1] + 1;
                maxCounter = Math.max(maxCounter, result[indexForResult-1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int[] arr1 = new int[]{3, 4, 4, 6, 1, 4, 4};
        System.out.println("MaxCounter Array of: " + Arrays.toString(arr1) + " is: " + Arrays.toString(maxCounters.solution(5, arr1)));
    }
}
