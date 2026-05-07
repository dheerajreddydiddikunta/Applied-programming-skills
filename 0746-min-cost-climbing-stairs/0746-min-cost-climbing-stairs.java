class Solution {
    // brute
    private int min(int[] cost, int i) {
        if (i == 0) {
            return cost[0];
        }

        // i when n-1 will cost itself, as after that we are sure we will reach n or more than n
        if (i == 1) {
            return cost[1];
        }

        int firstCost = min(cost, i - 1);
        int secondCost = min(cost, i - 2);
        return cost[i] + Math.min(firstCost, secondCost);
    }

    // memoized
    private int solveMem(int[] cost, int i, int[] dp) {
        if (i == 0) {
            return cost[0];
        }

        // i when n-1 will cost itself, as after that we are sure we will reach n or more than n
        if (i == 1) {
            return cost[1];
        }

        if (dp[i] != -1)
            return dp[i];

        int firstCost = solveMem(cost, i - 1, dp);
        int secondCost = solveMem(cost, i - 2, dp);
        return dp[i] = cost[i] + Math.min(firstCost, secondCost);
    }

    // tabulation
    private int solveTab(int[] cost, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            int currCost = cost[i];

            currCost += Math.min(dp[i - 1], dp[i - 2]);
            dp[i] = currCost;
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // space optimized
    private int solveSpace(int[] cost, int n) {
        int prev = cost[0];
        int next = cost[1];

        for (int i = 2; i < n; i++) {
            int currCost = cost[i];

            currCost += Math.min(prev, next);
            prev = next;
            next = currCost;
        }

        return Math.min(prev, next);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // return Math.min(min(cost, n - 1), min(cost, n - 2));

        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return Math.min(solveMem(cost, n - 1, dp), solveMem(cost, n - 2, dp));

        // return solveTab(cost, n);
        return solveSpace(cost, n);
    }
}