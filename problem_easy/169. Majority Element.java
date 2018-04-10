class Solution {
    public int majorityElement(int[] nums) {
        int count=0,c1=nums[0];          //投票选举算法
        for(int i=0;i<nums.length;i++)
        {
            if(c1==nums[i])
                count++;
            else if(count==0)
            {
                c1=nums[i];
                count=0;
            }
            else
                count--;
        }
        return c1;
    }
}