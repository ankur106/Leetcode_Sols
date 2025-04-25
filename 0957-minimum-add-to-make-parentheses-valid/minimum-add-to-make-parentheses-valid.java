class Solution {
    public int minAddToMakeValid(String s) {
        
        Deque<Character> stk = new ArrayDeque<>();
        int count = 0;

        for(char c : s.toCharArray()){
            
            if(c == ')' && stk.size() >0 && stk.peek() == '('){
                stk.pop();
                continue;
            }

            stk.push(c);
        }

        return stk.size();
        
    }
}