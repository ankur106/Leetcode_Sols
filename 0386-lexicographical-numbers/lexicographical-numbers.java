class Solution {

    List<Integer> li; 
    public List<Integer> lexicalOrder(int n) {

        li  =  new ArrayList<>();


        for(int i = 1 ; i <= 9; ++i){
            if(i <= n) li.add(i);
            addNumber(i * 10, n);
        }

        return li;
        
    }


    private void addNumber(int curr, int n){
        
        if(curr > n ) return;
        for(int i = 0; i <= 9; ++i){
            if(curr + i <=n){
                li.add(curr + i );
                addNumber((curr + i)* 10, n);
            }else break;
        }

    }
}