package Codility.Iterations;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N
 * Example:
 * Number 9 has binary representation 1001 and contains a binary gap of length 2
 * Number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3
 * Number 20 has binary representation 10100 and contains one binary gap of length 1
 * Number 15 has binary representation 1111 and has no binary gaps
 * Number 32 has binary representation 100000 and has no binary gaps
 *
 * Given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap
 * N is an integer within the range [1..2,147,483,647]
 */

public class BinaryGap {

    public int solution(int N) {
        String bString = Integer.toString(N, 2);
        boolean started = false;
        int currentCount = 0;
        int maxCount = 0;
        for (int i = 0; i < bString.length(); i++) {
            String value = bString.substring(i,i+1);
            if (value.equals("1")) {
                started = true;
            }
            if (started && value.equals("0")) {
                currentCount += 1;
            }
            else if (started && value.equals("1")) {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println("Number: " + 9 + " Maximum Zeros: " + binaryGap.solution(9));
        System.out.println("Number: " + 529 + " Maximum Zeros: " + binaryGap.solution(529));
        System.out.println("Number: " + 20 + " Maximum Zeros: " + binaryGap.solution(20));
        System.out.println("Number: " + 15 + " Maximum Zeros: " + binaryGap.solution(15));
        System.out.println("Number: " + 32 + " Maximum Zeros: " + binaryGap.solution(32));
    }

}
