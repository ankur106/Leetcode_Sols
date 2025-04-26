class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        dp = [0 for i in range(len(questions) + 1)]

        for i in range(len(questions) - 1, -1, -1):
            skip = dp[i + 1]

            choose = questions[i][0]
            if i + questions[i][1] + 1 < len(questions):
                choose += dp[i + questions[i][1] + 1]
            
            dp[i] = max(skip, choose)
        
        return dp[0]
        