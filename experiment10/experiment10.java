class Solution {
    public long solve(StringBuilder s, StringBuilder t, long dp[][], int i, int j)
    {
        if(j>=t.length())
        return 1;
        if(i>=s.length())
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        long count=0;
        if(s.charAt(i)==t.charAt(j))
        {
            count+=solve(s, t, dp, i+1, j+1);
        }
        count+=solve(s, t, dp, i+1, j);
        return dp[i][j]=count;
    }
    public int numDistinct(String s, String t) {
        long dp[][]=new long[s.length()+1][t.length()+1];
        for(int i=0; i<s.length()+1; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return (int)solve(new StringBuilder(s), new StringBuilder(t), dp, 0, 0);
        //Time complexity: O(n*m) where n and m are the lengths of the strings s and t respectively
        //Space complexity: O(n*m)
    }
}