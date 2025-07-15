class TicTacToe {
    int[][] board;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        
        return check(row, col, player) == true ? player : 0;
    }

    private boolean check(int row, int col, int player){
        for(int i=0; i<n; ++i){
            if(board[row][i] != player) break;
            if(i == n-1) return true;
        }

        for(int i=0;i <n; ++i){
            if(board[i][col] != player) break;
            if(i == n-1) return true;
        }

        if(row == col){
            for(int i=0;i <n; ++i){
                if(board[i][i] != player) break;
                if(i == n-1) return true;
            }
        }

        if(row + col == n-1){
            for(int i=0;i <n; ++i){
                if(board[n - i - 1][i] != player) break;
                if(i == n-1) return true;
            }
        }

        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */