package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class ques2 {
    int V;
    int[][] graph;
    boolean[] visited;
    int[] path;

    boolean isSafe(int v, int pos) {
        // Must be adjacent to previous vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Must not be already visited
        if (visited[v])
            return false;

        return true;
    }

    boolean solve(int pos) {
        if (pos == V) {
            // Check if last vertex connects to first
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;
                visited[v] = true;

                if (solve(pos + 1))
                    return true;

                // Backtrack
                visited[v] = false;
                path[pos] = -1;
            }
        }
        return false;
    }

    void findCycle() {
        path = new int[V];
        visited = new boolean[V];

        Arrays.fill(path, -1);

        path[0] = 0;
        visited[0] = true;

        if (!solve(1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return;
        }

        System.out.println("Hamiltonian Cycle:");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // complete cycle
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ques2 hc = new ques2();

        System.out.print("\nEnter number of vertices: ");
        hc.V = sc.nextInt();

        hc.graph = new int[hc.V][hc.V];

        System.out.println("Enter adjacency matrix (0 or 1):");
        for (int i = 0; i < hc.V; i++) {
            for (int j = 0; j < hc.V; j++) {
                hc.graph[i][j] = sc.nextInt();
            }
        }

        hc.findCycle();

        sc.close();
        //Time complexity: O(V!)
        //Space complexity: O(V²)
    }
}
