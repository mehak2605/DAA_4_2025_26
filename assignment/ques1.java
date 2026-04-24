package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class ques1 {
    int n;
    char[][] board;
    int count = 0;

    boolean[] col;
    boolean[] diag1; // row - col + n - 1
    boolean[] diag2; // row + col

    void solve(int row) {
        if (row == n) {
            count++;
            printBoard();
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !diag1[row - c + n - 1] && !diag2[row + c]) {

                board[row][c] = 'Q';
                col[c] = diag1[row - c + n - 1] = diag2[row + c] = true;

                solve(row + 1);

                board[row][c] = '.';
                col[c] = diag1[row - c + n - 1] = diag2[row + c] = false;
            }
        }
    }

    void printBoard() {
        System.out.println("Solution " + count + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter size of board: ");
        int n = sc.nextInt();

        ques1 obj = new ques1();
        obj.n = n;

        obj.board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(obj.board[i], '.');
        }

        obj.col = new boolean[n];
        obj.diag1 = new boolean[2 * n - 1];
        obj.diag2 = new boolean[2 * n - 1];

        obj.solve(0);

        System.out.println("Total solutions: " + obj.count);

        
        sc.close();

        //Time Complexity: O(N!)
        //Space Complexity: O(N²)
    }
    
}
