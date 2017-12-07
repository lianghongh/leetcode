class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int[] tem = new int[nums.length];
        tem[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            tem[i] = Math.max(tem[i - 1] + nums[i], nums[i]);
            if(tem[i]>sum)
                sum = tem[i];
        }
        return sum;
    }
}