class Solution {
    public int solve(int arr[], int sum1, int totalSum, int i, int dp[][])
    {
        if(i==arr.length)
        {
            int sum2=totalSum-sum1;
            return Math.abs(sum1-sum2);
        }
        if(dp[i][sum1]!=-1)
        return dp[i][sum1];
        int pick=solve(arr, sum1+arr[i], totalSum, i+1, dp);
        int notpick=solve(arr, sum1, totalSum, i+1, dp);
        return dp[i][sum1]=(int)Math.min(pick, notpick);
    }
    public int minDifference(int arr[]) {
        // code here
        int sum=0;
        for(int a: arr)
        sum+=a;
        int dp[][]=new int[arr.length+1][sum+1];
        for(int i=0; i<=arr.length; i++)
        Arrays.fill(dp[i], -1);
        return solve(arr, 0, sum, 0, dp);
        //Time complexity: O(n*sum) where n is the length of input array, and sum is sum of all elements of the array
        //Space complexity: O(n*sum)
    }
}
