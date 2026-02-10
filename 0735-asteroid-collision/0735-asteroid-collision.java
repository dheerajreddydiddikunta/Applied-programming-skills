class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int a = asteroids[i];
            while (!st.isEmpty() && a > 0 && st.peek() < 0) {
                int sum = a + st.peek();

                if (sum > 0) {
                    st.pop();
                } else if (sum < 0) {
                    a = 0;
                } else {
                    st.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                st.push(a);
            }
        }

        int[] ans = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i] = st.pop();
            i++;

        }

        return ans;
    }
}