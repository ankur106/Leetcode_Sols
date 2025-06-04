class Solution {

    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] memo = new int[n][m];

        int ans = 0;


        for(int i =0;i < n; ++i){
            Arrays.fill(memo[i] , -1);
        }

        for(int i =0;i < n; ++i){
            for(int j =0;j < m; ++j){
            
                ans = Math.max(ans, calPath(matrix, memo, i, j, n, m));

            }
        }
        
        return ans;

    }


    private int calPath(int[][] matrix, int[][] memo, int i, int j, int n, int m){
        
        if(memo[i][j] != -1) return memo[i][j];

        int max = 1;

        for(int k =0; k< 4; ++k){
            int new_i = i + dx[k];
            int new_j = j + dy[k];

            if(isValid(new_i, new_j, n, m) && matrix[new_i][new_j] > matrix[i][j]){
                max = Math.max(max, 1 + calPath(matrix, memo, new_i, new_j, n, m));
            }

        }

        return memo[i][j] = max;


    }

    private boolean isValid(int i, int j, int n, int m){

        return i >= 0 && i < n && j >= 0 && j < m;

    }
}