package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Warmholes {

    static class Vertex {
        int x;
        int y;
        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int distance (Vertex source, Vertex destination) {
        return Math.abs(source.x - destination.x) + Math.abs(source.y - destination.y);
    }

    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();

        Integer numberOfHoles = Integer.parseInt(br.readLine().trim());
        String[] sourceDestinationCoordinates = br.readLine().trim().split(" ");

        Vertex sourceVertex = new Vertex(Integer.parseInt(sourceDestinationCoordinates[0]),Integer.parseInt(sourceDestinationCoordinates[1]));
        Vertex destinationVertex = new Vertex(Integer.parseInt(sourceDestinationCoordinates[2]),Integer.parseInt(sourceDestinationCoordinates[3]));

        vertexArrayList.add(sourceVertex);

        Integer graph[][] = new Integer[numberOfHoles*2+2][numberOfHoles*2+2];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = -1;
            }
        }

        int graphIndex = 1;
        for (int i = 0; i < numberOfHoles; i++) {
            String[] holesCoordinates = br.readLine().trim().split(" ");
            Vertex holeSource = new Vertex(Integer.parseInt(holesCoordinates[0]),Integer.parseInt(holesCoordinates[1]));
            Vertex holeDestination = new Vertex(Integer.parseInt(holesCoordinates[2]),Integer.parseInt(holesCoordinates[3]));
            Integer distance = Integer.parseInt(holesCoordinates[4]);

            vertexArrayList.add(holeSource);
            vertexArrayList.add(holeDestination);

            graph[graphIndex][graphIndex+1] = graph[graphIndex+1][graphIndex] = distance;
            graphIndex += 2;
        }

        vertexArrayList.add(destinationVertex);

        for (int i = 0; i < graph.length; i++) {
            graph[0][i] = distance(vertexArrayList.get(0), vertexArrayList.get(i));
            graph[graph.length - 1][i] = distance(vertexArrayList.get(graph.length - 1), vertexArrayList.get(i));
        }

        //this loop fills the adj mat for wormholes
        for (int i = 1; i < graph.length - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else if (graph[i][j] == -1) {
                    if (i % 2 == 1) {
                        graph[i][j] = graph[i][i + 1] + distance(vertexArrayList.get(i + 1), vertexArrayList.get(j));
                    } else
                        graph[i][j] = graph[i][i - 1] + distance(vertexArrayList.get(i - 1), vertexArrayList.get(j));
                }
            }
        }
        graph[0][graph.length - 1] = graph[graph.length - 1][0] = distance(vertexArrayList.get(0),
                vertexArrayList.get(vertexArrayList.size() - 1));

        boolean visited[] = new boolean[numberOfHoles * 2 + 2];

        getMinDistance(graph, 0, graph.length - 1, visited, 0);
        System.out.println("Minimum Distance :" + ans);

    }

    private static void getMinDistance(Integer[][] graph, int cur_vertex, int fin_vertex, boolean[] visited, int cur_dist) {
        if (cur_vertex == fin_vertex) {
            ans = Math.min(ans, cur_dist);
            return;
        }
        if (visited[cur_vertex])
            return;
        visited[cur_vertex] = true;

        for (int i = 0; i < graph.length; i++) {
            getMinDistance(graph, i, fin_vertex, visited, cur_dist + graph[cur_vertex][i]);
        }
        visited[cur_vertex] = false;
    }

}




















