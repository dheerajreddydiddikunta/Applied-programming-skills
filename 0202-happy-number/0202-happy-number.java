class Solution {

    public HashMap<Integer, Boolean> happyNumbers = new HashMap();

    public Solution() {
        happyNumbers.put(1, true);
        happyNumbers.put(2, false);
    }

    public int happyFunction(int n) {
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            ans += digit * digit;
            n = n / 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        int num = n;
        boolean answer;
        List<Integer> l = new ArrayList<Integer>();
        while (!happyNumbers.containsKey(num)) {
            l.add(num);
            num = happyFunction(num);
            if (l.contains(num)) {
                answer = false;
                happyNumbers.put(num, false);
            }
        }
        answer = happyNumbers.get(num);
        for (int i : l) {
            happyNumbers.put(i, answer);
        }
        return answer;
    }
}