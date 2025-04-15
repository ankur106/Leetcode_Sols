class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);

        int ans = -1;

        int m = passengers.length;
        int j = 0;
        for(int i=0;  i < buses.length; ++i){
            if( j >= m){
                ans = buses[buses.length -1 ];
                break;
            }
            int currCapacity = capacity;
            

            while(currCapacity != 0 && j < m){
                if(passengers[j] <= buses[i]){
                    currCapacity--;
                    j++;
                }else{
                    break;
                }
            }

            int possibleAns = 0;

            if(currCapacity !=0){
                possibleAns = buses[i];
                if(j==0 || possibleAns != passengers[j-1]){
                    ans = possibleAns;
                    continue;
                }
            }
            
            
            possibleAns = passengers[j-1];
            
            int k = j-1;
            while(possibleAns > ans && k>=0 && possibleAns == passengers[k] ){
                k--;
                possibleAns--;
            }

            ans = possibleAns;

        }

        return ans;
        
    }
}