class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean visited[]=new boolean[n];
        visited[0]=true;
        visit(rooms,visited,0);
        for(boolean key : visited)
        {
            if(!key)return false;
        }
        return true;
    }
    public void visit(List<List<Integer>> rooms , boolean []visited , int i)
    {
        for(int num:rooms.get(i))
        {
            if(!visited[num])
            {
                visited[num]=true;
                visit(rooms,visited,num);
            }
        }
    }
}