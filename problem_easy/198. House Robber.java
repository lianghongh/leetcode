/**
*动态规划，no_rob表示第i-1个房子没有被抢劫时前i-1个房子被抢劫的最大值
*rob表示第i-1个房子被抢劫时前i-1个房子被抢劫的最大值
*因此当第i个房子没有被抢劫时，前i个房子的最大值就是前i-1个房子的最大值；当第i个房子被抢劫时，前i个房子的最大值=第i-1个房子没有被抢劫的最大值+第i个房子的值
*/

class Solution {
    public int rob(int[] nums) {
        int rob=0,no_rob=0;
        for(int i=0;i<nums.length;i++)
        {
            int t=no_rob;
            no_rob=rob>no_rob?rob:no_rob;
            rob=nums[i]+t;
        }
        return rob>no_rob?rob:no_rob;
    }
}