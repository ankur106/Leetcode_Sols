class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] != color){
            dfs(image, sr, sc, color, image[sr][sc]);
        }

        return image;
    }


    private void dfs(int[][] image, int x, int y, int color, int original){
        image[x][y] =color;


        for(int i =0; i < 4; ++i ){
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if(new_x < 0 || new_y < 0 || new_x >= image.length || new_y >= image[0].length || image[new_x][new_y] != original) continue;
            dfs(image, new_x, new_y, color, original);

        }
    }
}