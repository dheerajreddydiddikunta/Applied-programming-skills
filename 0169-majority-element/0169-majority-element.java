import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {

        int count=0;
        int majorElement= 0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                count=1;
                majorElement= nums[i];
                continue;
            }
            if(nums[i]==majorElement)count++;
            else count--;
        }

        return majorElement;
    }
}