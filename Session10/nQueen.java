import java.util.*;
class nQueen {
    char [][]result;
    int n;
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
    boolean solve(int row, int n)
    {
        if(row==n)
        {
            return true;
        }
        for(int col=0; col<n; col++)
        {
            if(isSafe(row, col))
            {
                result[row][col]='Q';
                if(solve(row+1, n))
                return true;
                result[row][col]='.';
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of board: ");
        int n=sc.nextInt();
        nQueen obj=new nQueen();
        obj.result=new char[n][n];
        obj.n=n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(obj.result[i], '.');
        }
        if(obj.solve(0, n)){
            System.out.println("Board:");
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                System.out.print(obj.result[i][j]+"   ");
                System.out.println();
            }
        }
        else
        System.out.println("No solution");
    sc.close();
    }
}