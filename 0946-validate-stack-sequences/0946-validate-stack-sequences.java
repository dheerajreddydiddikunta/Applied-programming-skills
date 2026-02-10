class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i=0;
        int j=0;
         while(i<pushed.length){
        s.push(pushed[i]);
             while(!s.isEmpty() && j< popped.length && s.peek() == popped[j]){
                 s.pop();
                 j++;
             }
             i++;
            
         }
        return s.isEmpty();
    }
}