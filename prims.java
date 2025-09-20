import java.util.*;

public class prims{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        // Initialize graph adjacency matrix
        int[][] graph = new int[V][V];

        // Input edges and their weights
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges in format: from to weight");
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from][to] = weight;
            graph[to][from] = weight;  // Since undirected graph
        }

        // Run Prim's algorithm
        primMST(graph, V);
    }

    static void primMST(int[][] graph, int V) {
        int[] key = new int[V]; // values used to pick minimum weight edge
        boolean[] mstSet = new boolean[V]; // MST vertices included

        // Initialize all keys as infinite
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Start from first vertex
        int[] parent = new int[V]; // Store MST edges
        parent[0] = -1; // First node is root of MST

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            // Update the keys of adjacent vertices
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print MST edges and weights
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
