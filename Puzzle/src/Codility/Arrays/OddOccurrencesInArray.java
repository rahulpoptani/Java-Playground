package Codility.Arrays;

import java.util.HashSet;

/**
 * The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * For example, in array A such that:
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 *
 *         the elements at indexes 0 and 2 have value 9,
 *         the elements at indexes 1 and 3 have value 3,
 *         the elements at indexes 4 and 6 have value 9,
 *         the element at index 5 has value 7 and is unpaired.
 */

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) set.remove(A[i]);
            else set.add(A[i]);
        }
        return (int) set.toArray()[0];
    }
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int result = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println("Element with Odd Occurrence in Array: " + result);
    }
}
