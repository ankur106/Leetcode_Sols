class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> li = new ArrayList<>();

        for(int i = 1; i <= n; ++i){
            int mThree = i % 3;
            int mFive = i % 5;

            if(mThree == 0 && mFive == 0){
                li.add("FizzBuzz");
                continue;
            }

            if(mThree == 0){
                li.add("Fizz");
                continue;

            }

            if(mFive == 0){
                li.add("Buzz");
                continue;

            }

            li.add(String.valueOf(i));

        } 

        return li;      
        
    }
}