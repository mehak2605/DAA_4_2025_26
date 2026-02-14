public class LeetCode70_climbingStairs {
    public int solve(int n)
    {
        if(n==1||n==2)
        return n;
        return solve(n-1)+solve(n-2);
    }
    public int climbStairs(int n) {
        return solve(n);
    }
    /*
    dp[1]=1;
    dp[2]=2;
    for(int i=3; i<=n; i++)
    {
        dp[i]=dp[i-1]+dp[i-2];
    } -- bottom up approach
    
    public int solve(int n, int dp[])
    {
        if(n==1||n==2)
        return n;
        if(dp[n]!=-1)
        return dp[n];
        dp[n]=solve(n-1, dp)+solve(n-2, dp);
        return dp[n];
    }
    */
}