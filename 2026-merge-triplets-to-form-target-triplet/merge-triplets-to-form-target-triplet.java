class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean foundX = false, foundY = false, foundZ = false;

        for(int[] triplet : triplets){
            int x = triplet[0];
            int y = triplet[1];
            int z = triplet[2];
            
            if(x > target[0] || y > target[1] || z > target[2]) continue;

            if(x == target[0]) foundX = true;
            if(y == target[1]) foundY = true;
            if(z == target[2]) foundZ = true;

        }
        return foundX && foundY && foundZ;
    }
}