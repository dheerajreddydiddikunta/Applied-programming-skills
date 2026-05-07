class Solution {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        return minHeap.peek(); // The top element is the kth largest
    }

// another appraoch quicksort
    public int findKthLargest2(int[] nums, int k) {
        // Convert kth largest to kth smallest problem
        int targetIndex = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // This line should not be reached
    }

    private int partition(int[] nums, int left, int right) {
        // Randomly choose a pivot element to avoid worst-case scenarios
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);

        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println(result1); // Output: 5

        // Example 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println(result2); // Output: 4
    }

}