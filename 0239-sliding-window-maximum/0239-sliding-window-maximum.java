class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];   
        }
        
        List<Integer> result = new ArrayList<>(); // List to store the max of each window
        Deque<Integer> deque  = new LinkedList<>(); // Queue to store elements in the current window

           int i=0;
           int j = 0;

           while(j<nums.length){
            //calcualtion

            // Remove indices that are not in the range of the sliding window
            while(!deque.isEmpty() && deque.peek() < i){
                deque.poll();
            }

           // Maintain elements in deque in descending order by removing elements from the back if they are less than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }

            // Add current element index to deque
            deque.addLast(j);

            if(j-i + 1 < k ){
                j++;
            }

            else if(j-i+1 == k){
                // answer 
                // The element at the front of the deque is the maximum of the window
                result.add(nums[deque.peek()]);
                

                // slide the window


                if(deque.peek() == i ){
                    deque.poll(); // Only remove the front if it is going out of the window
               
                }
                i++;
                j++;
            }

           }

        // Convert the List<Integer> to int[]
        int[] res = new int[result.size()];
        for (int x = 0; x < result.size(); x++) {
            res[x] = result.get(x);
        }

        return res;
 

        
    }
}