import java.util.*;
public class nQueen_2 {
    char [][]result;
    int n, count=0;
    boolean isSafe(int row, int col)
    {
        for(int i=row; i>=0; i--)
        {
            if(result[i][col]=='Q')
            return false;
        }
        for(int i=row-1, j=col-1; i>=0&&j>=0; i--,j--)
        {
            if(result[i][j]=='Q')
            return false;
        }
        for(int i=row-1, j=col+1; i>=0&&j<n; i--,j++)
        {
            if(result[i][j]=='Q')
            return false;
        }
        return true;
    }
    void solve(int row, int n)
    {
        if(row==n)
        {
            count++;
            return;
        }
        for(int col=0; col<n; col++)
        {
            if(isSafe(row, col))
            {
                result[row][col]='Q';
                solve(row+1, n);
                result[row][col]='.';
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of board: ");
        int n=sc.nextInt();
        nQueen_2 obj=new nQueen_2();
        obj.result=new char[n][n];
        obj.n=n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(obj.result[i], '.');
        }
        obj.solve(0, n);
        System.out.println("It has "+obj.count+" distinct solutions");
    sc.close();
    }
}
