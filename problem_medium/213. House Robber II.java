/**
*动态规划，参考easy/198.House Robber
*由于加入了环路，第一个房子和最后一个房子是相连的，因此可以分为两种情况：
*1. 第一个房子没有被抢，最后一个房子可以抢或不抢
*2. 第一个房子被抢了，最后一个房子不被抢
*计算两种结果的值，选取较大的结果即可
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int rob=nums[0],no_rob=0;
        for(int i=1;i<nums.length-1;i++)
        {
            int t=no_rob;
            no_rob=rob>no_rob?rob:no_rob;
            rob=nums[i]+t;
        }
        int r1=rob>no_rob?rob:no_rob;
        rob=no_rob=0;
        for(int i=1;i<nums.length;i++)
        {
            int t=no_rob;
            no_rob=rob>no_rob?rob:no_rob;
            rob=nums[i]+t;
        }
        int r2=rob>no_rob?rob:no_rob;
        return r1>r2?r1:r2;
    }
}