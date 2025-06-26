class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        int maxHeight = -1;
        
        for (int current = n - 1; current >= 0; --current) {
            if (maxHeight < heights[current]) {
                list.add(current);
                
                maxHeight = heights[current];
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }
        
        return answer;
    }
}