class Solution {
    int count =0;
    public int totalNQueens(int n) {

        boolean[][] queens = new boolean[n][n];

        check(0, n, queens);
        return count;
    }


    private void check(int r, int n, boolean[][] queens){
        if(r == n){ count++; return;} 

        for(int clm = 0; clm < n; ++clm){
            
            if(isValid(r, clm, queens)){
                queens[r][clm] = true;

                check(r + 1, n, queens);
                queens[r][clm] = false;

            }
        }

    }

    private boolean isValid(int r, int c, boolean[][] queens){
        
        for(int row = 0 ; row < r; ++row){
            if(queens[row][c]) return false;
        }


        for(int row = r, col = c; row >=0 &&  col >= 0; row--, col-- ){
               if(queens[row][col]) return false;  
        } 


        for(int row = r,col = c; row >=0 && col < queens.length; row--, col++){
               if(queens[row][col]) return false;  
        }    
        return true;


    }
}