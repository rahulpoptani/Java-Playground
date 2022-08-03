package Codility.TimeComplexity;

/**
 * A small frog wants to get to the other side of the road.
 * The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
 * For example, given:
 *   X = 10
 *   Y = 85
 *   D = 30
 *
 * the function should return 3, because the frog will be positioned as follows:
 *
 *         after the first jump, at position 10 + 30 = 40
 *         after the second jump, at position 10 + 30 + 30 = 70
 *         after the third jump, at position 10 + 30 + 30 + 30 = 100
 */

public class FrogJump {
    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        return (int) Math.ceil(distance/(double) D);
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println("Number of Jumps: " + frogJump.solution(10, 85, 30));
        System.out.println("Number of Jumps: " + frogJump.solution(10, 10, 1));
    }
}
