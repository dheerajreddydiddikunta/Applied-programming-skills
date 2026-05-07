class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));    // (a, b) -> Integer.compare(a[0], b[0])
        for (int i = 0; i < Math.min(nums1.length, k); i++)
        {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (result.size() < k && !pq.isEmpty())
        {
            int[] current = pq.poll();
            result.add(List.of(nums1[ current[1]], nums2[current[2]]));

            if (current[2] + 1 < nums2.length)
            {
                pq.offer(new int[]{nums1[ current[1]] + nums2[current[2] + 1],  current[1], current[2] + 1});
            }
        }
        return result;
    }
}