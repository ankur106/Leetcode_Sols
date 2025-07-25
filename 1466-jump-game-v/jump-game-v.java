class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        
        int[][] heights = new int[n][2];
        
        for(int i = 0; i < n; i++){
            heights[i] = new int[]{i, arr[i]}; 
        }
        
        //sort height Increasing order
        Arrays.sort(heights, (a, b) -> (a[1] - b[1]));
        
        int[] jumps = new int[n];
        
        int maxJump = 1;
        
        for(int[] height : heights){
            
            int index = height[0];
            int curr  = height[1];
            
            jumps[index] = 1;

            for(int i = index - 1; i >= Math.max(0, index - d); i--){
                if(curr <= arr[i]) break;
                
                
                jumps[index] = Math.max(jumps[index], jumps[i] + 1);
            }
            
            for(int i = index + 1; i <= Math.min(n - 1, index + d); i++){
                if(curr <= arr[i]) break;
                
                jumps[index] = Math.max(jumps[index], jumps[i] + 1);
            }
            
            
            maxJump = Math.max(maxJump, jumps[index]);
        }
        
        return maxJump;
        
    }
}