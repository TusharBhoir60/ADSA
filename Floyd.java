// Floyd-Warshall Algorithm in Java
import java.util.*;

public class FloydWarshall {
    static final int INF = 999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int dist[][] = new int[V][V];

        System.out.println("Enter cost adjacency matrix (0 if no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = sc.nextInt();
                if (i != j && dist[i][j] == 0)
                    dist[i][j] = INF; // no edge = infinite
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print shortest distance matrix
        System.out.println("\nShortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
