import java.util.*;

class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, 0, n - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid + 1, end);
        merge(nums, indexes, start, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int rightCount = 0;

        int[] newIndexes = new int[end - start + 1];
        int k = 0;

        while (left <= mid && right <= end) {
            if (nums[indexes[right]] < nums[indexes[left]]) {
                newIndexes[k++] = indexes[right++];
                rightCount++;
            } else {
                newIndexes[k++] = indexes[left];
                count[indexes[left]] += rightCount;
                left++;
            }
        }

        while (left <= mid) {
            newIndexes[k++] = indexes[left];
            count[indexes[left]] += rightCount;
            left++;
        }

        while (right <= end) {
            newIndexes[k++] = indexes[right++];
        }

        for (int i = 0; i < newIndexes.length; i++) {
            indexes[start + i] = newIndexes[i];
        }
    }
}