// 数组长度为n+1，元素为1-n的整数，其中有且仅有一个重复的元素
// 可以按照循环置换将不重复的元素放到数组的前n个位置，那么最后一个位置必然是重复的元素

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            while(nums[i]!=i+1)             //循环置换，第i个位置应该放i+1
            {
                if(nums[i]==nums[nums[i]-1])       //当第i个元素和第nums[i]-1个元素相等时找到了重复的元素，直接返回
                    return nums[i];
                int t=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=t;
            }
        }
        return nums[nums.length-1];        //最后一个元素必然是重复的元素
    }
}