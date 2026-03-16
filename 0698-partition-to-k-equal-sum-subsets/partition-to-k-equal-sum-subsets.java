class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k, 
                              int targetSum, Integer mask, HashMap<Integer, Boolean> memo) {
                                  
        int n = arr.length;
      
        if (count == k - 1) { 
            return true;
        }
        
        if (currSum > targetSum) { 
            return false;
        }
        
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
      
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, 0, count + 1, 0, k, targetSum, mask, memo);
            memo.put(mask, ans);
            return ans;
        }
        
        for (int j = index; j < n; ++j) {
            if (((mask >> j) & 1) == 0) {
                mask = (mask | (1 << j));
                
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, mask, memo)) {
                    return true;
                }
                
                mask = (mask ^ (1 << j));
            }
        } 
        memo.put(mask, false);
        return false;
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
  
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }
      
        if (totalArraySum % k != 0) { 
            return false;
        }
      
        Arrays.sort(arr);
        reverse(arr);
        
        int targetSum = totalArraySum / k;
        Integer mask = 0;
        
        HashMap<Integer, Boolean> memo = new HashMap<>();
      
        return backtrack(arr, 0, 0, 0, k, targetSum, mask, memo);
    }
}