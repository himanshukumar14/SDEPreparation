package Graph;

import java.util.Arrays;
import java.util.Vector;

/**
 * 
 * Take two bool arrays vis1 and vis2 of size N (number of nodes of a graph) and keep false in all indexes.
Start at a random vertex v of the graph G, and run a DFS(G, v).
Make all visited vertices v as vis1[v] = true.
Now reverse the direction of all the edges.
Start DFS at the vertex which was chosen at step 2.
Make all visited vertices v as vis2[v] = true.
If any vertex v has vis1[v] = false and vis2[v] = false then the graph is not connected.s
 *
 */

public class CheckIfDirectedGraphConnected {


	static int N = 100000;
	 

    static Vector<Integer>[] gr1 = new Vector[N];

    static Vector<Integer>[] gr2 = new Vector[N];
 
    static boolean[] vis1 = new boolean[N];
    static boolean[] vis2 = new boolean[N];
 
    static {
        for (int i = 0; i < N; i++)
        {
            gr1[i] = new Vector<>();
            gr2[i] = new Vector<>();
        }
    }
 
    // Function to add edges
    static void Add_edge(int u, int v)
    {
        gr1[u].add(v);
        gr2[v].add(u);
    }
 
    // DFS function
    static void dfs1(int x)
    {
        vis1[x] = true;
        for (int i : gr1[x])
            if (!vis1[i])
                dfs1(i);
    }
 
    // DFS function
    static void dfs2(int x)
    {
        vis2[x] = true;
        for (int i : gr2[x])
            if (!vis2[i])
                dfs2(i);
    }
 
    static boolean Is_connected(int n)
    {
 
        // Call for correct direction
        Arrays.fill(vis1, false);
        dfs1(1);
 
        // Call for reverse direction
        Arrays.fill(vis2, false);
        dfs2(1);
 
        for (int i = 1; i <= n; i++)
        {
 
            // If any vertex it not visited in any direction
            // Then graph is not connected
            if (!vis1[i] && !vis2[i])
                return false;
        }
 
        // If graph is connected
        return true;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int n = 4;
 
        // Add edges
        Add_edge(1, 2);
        Add_edge(1, 3);
        Add_edge(2, 3);
        Add_edge(3, 4);
 
        // Function call
        if (Is_connected(n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
