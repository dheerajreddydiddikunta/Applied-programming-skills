class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            int diff = map.lastEntry().getKey()-map.firstEntry().getKey();
            while (diff > limit) {
                if (map.containsKey(nums[j])) {
                    map.put(nums[j], map.get(nums[j]) - 1);
                }
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                diff = map.lastEntry().getKey()-map.firstEntry().getKey();
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}