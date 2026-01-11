class Solution {

public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            // Update the histogram heights
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            // Use your largestRectangleArea function to calculate the max area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;

        
    }


    public int[] nsei(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        //Since we have to find next smaller element index, so we need to have idea of next element, that's why we are traversing from backside
        for(int i=n-1;i>=0;i--){
            //since we want smaller element, and if we get greater element at stack's top we will pop out
            while(st.isEmpty()==false && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()==true) res[i]=n; //If stack is empty means we didn't get nsei, so store our n 
            else res[i]=st.peek(); //else stack's top will hold index of nse
            st.push(i); //push the index of current element into stack
        }
        return res;
    }
     //This method will find the Previous Smaller Element Index for every height
    public int[] psei(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
             //since we want smaller element, and if we get greater element at stack's top we will pop out
            while(st.isEmpty()==false && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()==true) res[i]=-1;//If stack is empty means we didn't get psei, so store our -1 
            else res[i]=st.peek();//else stack's top will hold index of pse
            st.push(i);//push the index of current element into stack
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int[] nseI = nsei(heights); // we will find the index of Next smaller element for every height
        int[] pseI = psei(heights); // we will find the index of Previous smaller element for every height
        for(int i=0;i<heights.length;i++){
            //for every height we will find out the width by nseI - pseI -1
            int width = nseI[i]-pseI[i]-1;
            maxArea = Math.max(maxArea, heights[i]*width); //Calculate the max Area 
        }
        return maxArea;
    }
        

}