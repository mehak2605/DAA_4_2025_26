package Session18;
import java.util.*;
public class lcs
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String text1=sc.next();
        String text2=sc.next();
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=(int)Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println("LCS length: "+dp[n][m]);
        sc.close();
    }
}