class Solution {
    public int maxProduct(int[] nums) {
        int maxP=nums[0];
        int minP=nums[0];
        int res=maxP;
        for(int i=1;i<nums.length;i++)
        {
            int max=maxP*nums[i];
            int min=minP*nums[i];
            maxP=Math.max(Math.max(max,min),nums[i]);
            minP = Math.min(Math.min(max, min), nums[i]);
            res = Math.max(res, maxP);
        }
        return res;
    }
}