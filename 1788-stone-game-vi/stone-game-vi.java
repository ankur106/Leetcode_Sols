import java.util.Arrays;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;
        
        // 1. Create an Integer object array to store indices (0 to len-1)
        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) {
            indices[i] = i;
        }

        // 2. Sort the indices in DESCENDING order based on (aliceValues + bobValues)
        // This works because indices is an Object array (Integer[])!
        Arrays.sort(indices, (a, b) -> {
            int sumA = aliceValues[a] + bobValues[a];
            int sumB = aliceValues[b] + bobValues[b];
            return Integer.compare(sumB, sumA); // Descending order
        });

        int aliceTotal = 0;
        int bobTotal = 0;
        
        // 3. Simulate the greedy game using the sorted indices
        for (int i = 0; i < len; ++i) {
            int originalIdx = indices[i]; // Get the original index of the best stone
            
            if (i % 2 == 0) {
                // Alice's turn: she gets her own value for this stone
                aliceTotal += aliceValues[originalIdx]; 
            } else {
                // Bob's turn: he gets his own value for this stone
                bobTotal += bobValues[originalIdx]; 
            }
        }
        
        // 4. Return the result based on who scored more
        if (aliceTotal > bobTotal) return 1;
        if (aliceTotal < bobTotal) return -1;
        return 0;
    }
}
