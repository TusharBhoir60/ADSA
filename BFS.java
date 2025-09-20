import java.util.*;

public class BFS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        // Initialize graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
         
              graph.add(new ArrayList<>());
        
        }
        

        // Input edges
        System.out.println("Enter edges (from to):");
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            // For undirected graphs, also add the reverse:
            // graph.get(to).add(from);
        }

        // Input starting node
        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        // Perform BFS
        bfs(graph, start);
    }

    static void bfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
