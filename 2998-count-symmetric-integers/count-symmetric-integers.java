class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans =0;
        for(int i = low;  i <= high;  ++i){
            if(checkSymmetric(i)){ 
                System.out.println(i);
                ans++;
            }
        }

        return ans;
    }


    boolean checkSymmetric(int number){
        if( number  <= 10 ||( number  >= 100 && number  <= 1000 )) return false;
        else if (number >10 && number  < 100){
            return number%10 == number/10;
        }else {
            int n1 = number%10;
            number = number/10;
            n1 += number%10;
            number = number/10;

            int n2 = number%10;
            number = number/10;

            n2 += number;

            return n2==n1;
        }
        
    }
}