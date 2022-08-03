package Codility.TimeComplexity;

import java.util.HashSet;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * For example, given array A such that:
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 *
 * the function should return 4, as it is the missing element.
 */

public class PermMissingElem {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer element : A) {
            set.add(element);
        }
        for (int i = 1; i <= A.length+1; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        System.out.println("Missing Element: " + permMissingElem.solution(new int[]{2, 3, 1, 5}));
        System.out.println("Missing Element: " + permMissingElem.solution(new int[]{1, 2, 3, 4}));
        System.out.println("Missing Element: " + permMissingElem.solution(new int[]{}));
    }
}
