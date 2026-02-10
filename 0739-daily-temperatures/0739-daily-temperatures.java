

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Step 1: Initialize the necessary variables
        int n = temperatures.length; // Length of the temperatures array
        int[] answer = new int[n]; // Array to store the result, initialized to 0
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices
        
        // Step 2: Iterate through each day
        for (int i = 0; i < n; i++) {
            // Step 3: Check if we have found a warmer temperature for any previous days
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop(); // Get the index of the previous day
                answer[index] = i - index; // Calculate the number of days to wait and update the answer array
            }
            // Step 4: Push the current day index onto the stack
            stack.push(i);
        }
        
        // Step 5: Return the final answer array
        return answer;
    }
}