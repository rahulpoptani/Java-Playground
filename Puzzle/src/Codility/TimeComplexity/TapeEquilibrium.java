package Codility.TimeComplexity;

/**
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * For example, consider array A such that:
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 *
 * We can split this tape in four places:
 *
 *         P = 1, difference = |3 − 10| = 7
 *         P = 2, difference = |4 − 9| = 5
 *         P = 3, difference = |6 − 7| = 1
 *         P = 4, difference = |10 − 3| = 7
 *
 * the function should return 1
 */

public class TapeEquilibrium {
    public int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        for (int i= 0; i < A.length; i++) rightSum += A[i];
        for (int j= 0; j < A.length-1; j++) {
            leftSum += A[j];
            rightSum -= A[j];
            result = Math.min(result, Math.abs(leftSum - rightSum));
        }
        return result;
    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{1, 1}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{1, 2}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{-1, -2, 2}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{0, 0, 0, 0}));
        System.out.println("MinSum: " + tapeEquilibrium.solution(new int[]{1000, -1000}));
    }
}
