import java.util.*;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[]=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        
        for(int i=0; i<=k; i++)
        {
            int temp[]=cost.clone(); 
            for(int curr[]:flights)
            {
                int u=curr[0];
                int v=curr[1];
                int w=curr[2];
                if(cost[u] != Integer.MAX_VALUE&&cost[u]+w<temp[v])
                {
                    temp[v]=cost[u]+w;
                }
            } 
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
        //Time Complexity: O(k*E) where k = number of stops, and E = number of edges
        //Space Complexity: O(n) where n = number of nodes
    }
}