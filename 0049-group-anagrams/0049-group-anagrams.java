class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars); // Sorted version as key

            // Group anagrams in the map
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        // Return all grouped anagram lists
        return new ArrayList<>(map.values());
    }
}