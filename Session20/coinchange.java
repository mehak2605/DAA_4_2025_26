package Session20;
import java.util.*;
public class coinchange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0; i<n; i++)
            coins[i]=sc.nextInt();
        System.out.print("Enter amount: ");
        int amount=sc.nextInt();
        int dp[][]=new int[n+1][amount+1];
        for(int row[]:dp)
            Arrays.fill(row, 0);
        int INF=Integer.MAX_VALUE-1;
        for(int i=1; i<amount+1; i++)
            dp[0][i]=INF;
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<amount+1; j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j]=(int)Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[n][amount]==INF)
            System.out.println("Not possible");
        else
            System.out.println("Minimum number of coins required: "+dp[n][amount]);
        sc.close();
    }
}
