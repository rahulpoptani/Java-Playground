package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Endoscope {

    static class Node {
        int X;
        int Y;
        int L;
        Node(int X, int Y, int L) {
            this.X = X;
            this.Y = Y;
            this.L = L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer numberOfTests = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < numberOfTests; i++) {
            String[] layout = br.readLine().split(" ");
            int rows = Integer.parseInt(layout[0]);
            int cols = Integer.parseInt(layout[1]);
            int eX = Integer.parseInt(layout[2]);
            int eY = Integer.parseInt(layout[3]);
            int eL = Integer.parseInt(layout[4]);
            Integer[][] matrix = new Integer[rows][cols];
            Integer[][] visited = new Integer[rows][cols];
            ArrayList<Node> queue = new ArrayList();
            for (int y = 0; y < rows; y++) {
                String[] rowValue = br.readLine().split(" ");
                for (int z = 0; z < cols; z++) {
                    matrix[y][z] = Integer.parseInt(rowValue[z]);
                    visited[y][z] = 0;
                }
            }
            queue.add(0,new Node(eX,eY,eL));
            Integer scope = 0;
            while (!queue.isEmpty()) {
                Node current = (Node) queue.remove(queue.size()-1);
                visited[current.X][current.Y] = 1;
                if (current.L == 0) continue;
                if (matrix[current.X][current.Y] != 0) {
                    scope += 1;
                }

                if (isValid(current.X, current.Y-1, rows, cols, visited) && left(current.X, current.Y, matrix) && right(current.X, current.Y-1, matrix)) {
                    queue.add(0, new Node(current.X, current.Y-1, current.L-1));
                    visited[current.X][current.Y-1] = 1;
                }
                if (isValid(current.X, current.Y+1, rows, cols, visited) && right(current.X, current.Y, matrix) && left(current.X, current.Y+1, matrix)) {
                    queue.add(0, new Node(current.X, current.Y+1, current.L-1));
                    visited[current.X][current.Y+1] = 1;
                }
                if (isValid(current.X-1, current.Y, rows, cols, visited) && up(current.X, current.Y, matrix) && down(current.X-1, current.Y, matrix)) {
                    queue.add(0, new Node(current.X-1, current.Y, current.L-1));
                    visited[current.X-1][current.Y] = 1;
                }
                if (isValid(current.X+1, current.Y, rows, cols, visited) && down(current.X, current.Y, matrix) && up(current.X+1, current.Y, matrix)) {
                    queue.add(0, new Node(current.X+1, current.Y, current.L-1));
                    visited[current.X+1][current.Y] = 1;
                }
            }
            System.out.println(scope);
        }
    }

    public static Boolean isValid(Integer x, Integer y, Integer rows, Integer cols, Integer[][] visited) {
        return x >= 0 && y >= 0 && x < rows && y < cols && visited[x][y] != 1;
    }
    public static Boolean left(Integer x, Integer y, Integer[][] matrix) {
        return Arrays.asList(1,3,6,7).contains(matrix[x][y]);
    }
    public static Boolean right(Integer x, Integer y, Integer[][] matrix) {
        return Arrays.asList(1,3,4,5).contains(matrix[x][y]);
    }
    public static Boolean up(Integer x, Integer y, Integer[][] matrix) {
        return Arrays.asList(1,2,4,7).contains(matrix[x][y]);
    }
    public static Boolean down(Integer x, Integer y, Integer[][] matrix) {
        return Arrays.asList(1,2,6,5).contains(matrix[x][y]);
    }

    public static void printMatrix(Integer[][] matrix, Integer rows, Integer cols) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 2
 * 5 6 2 1 3
 * 0 0 5 3 6 0
 * 0 0 2 0 2 0
 * 3 3 1 3 7 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 5 6 2 2 6
 * 3 0 0 0 0 3
 * 2 0 0 0 0 6
 * 1 3 1 1 3 1
 * 2 0 2 0 0 2
 * 0 0 4 3 1 1
 */
