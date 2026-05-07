class Solution {

    public static int[][] dp;

    public static int helper(int[] arr,int tar,int idx){
        if(tar == 0)
        return 0;

        if (idx == arr.length) return Integer.MAX_VALUE;
        
        if(dp[idx][tar] != -1){
            return dp[idx][tar];
        }

        int notTake = 0 + helper(arr,tar,idx+1);
        int take = Integer.MAX_VALUE;

        if(arr[idx] <= tar){
            int res = helper(arr,tar-arr[idx],idx);

            if(res != Integer.MAX_VALUE)
            take = 1 + res;
        }

        return dp[idx][tar] = Math.min(notTake,take);

    }
    public int coinChange(int[] arr, int tar) {
        dp = new int[arr.length+1][tar+1];
        for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        int a = helper(arr,tar,0);
        if(a == Integer.MAX_VALUE)
        return -1; 
        return a;
    }
}