public class LeetCode70_climbingStairs {
    //recursive approach
    /*public int solve(int n)
    {
        if(n==1||n==2)
        return n;
        return solve(n-1)+solve(n-2);
    }*/
    public int climbStairs(int n) {
        //iterative approach
        int ft=1;
        int st=2;
        int tt=0;
        for(int i=3; i<=n; i++)
        {
            tt=ft+st;
            ft=st;
            st=tt;
        }
        if(n==1||n==2)
        return n;
        else
        return tt;
    }
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
    }   --top down approach with memoisation
    */