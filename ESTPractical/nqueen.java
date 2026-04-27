class Solution {
    public boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
    public List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
    public void solve(int row, int n, char board[][], List<List<String>> result)
    {
        if(row==n)
        {
            result.add(construct(board));
            return;
        }
        for(int i=0; i<n; i++)
        {
            if (isSafe(board, row, i, n)) {
                board[row][i] = 'Q';
                solve(row + 1, n, board, result); 
                board[row][i] = '.'; 
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][]=new char[n][n];
        for(char row[]: board)
        {
            Arrays.fill(row, '.');
        }
        solve(0, n, board, result);
        return result;
    }
}