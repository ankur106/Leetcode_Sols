import java.util.Arrays;

class Solution {
    public boolean stoneGame(int[] piles) {
        int numberOfPiles = piles.length;
        int[][] memo = new int[numberOfPiles][numberOfPiles];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int totalStones = 0;
        for (int stones : piles) {
            totalStones += stones;
        }

        int alexScore = findMaximumScore(
                piles,
                0,
                numberOfPiles - 1,
                memo
        );

        int leeScore = totalStones - alexScore;
        return alexScore > leeScore;
    }

    // Maximum score the current player can obtain from piles[start...end].
    private int findMaximumScore(
            int[] piles,
            int start,
            int end,
            int[][] memo
    ) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return piles[start];
        }

        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        int chooseLeft = piles[start] + Math.min(
                findMaximumScore(piles, start + 2, end, memo),
                findMaximumScore(piles, start + 1, end - 1, memo)
        );

        int chooseRight = piles[end] + Math.min(
                findMaximumScore(piles, start + 1, end - 1, memo),
                findMaximumScore(piles, start, end - 2, memo)
        );

        memo[start][end] = Math.max(chooseLeft, chooseRight);
        return memo[start][end];
    }
}