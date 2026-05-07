class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer,Integer> >(map.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
        public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int[] ele = new int[temp.size()];
        int i=0;
        for(int n: temp.keySet()){
         ele[i++] = n;
        }
        int[] result = new int[k];
        for(int z=0;z<k;z++){
            result[z] = ele[z];
        }
        return result;
    }
}