// 求一个序列的最长递增子序列
// 方法一：动态规划

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[] inc=new int[nums.length];       //inc[i]表示以inc[i]结尾的递增序列的最大长度
        Arrays.fill(inc,1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]&&inc[j]+1>inc[i])      //遍历i之前的inc[j]，j<i，计算inc[i]
                    inc[i]=inc[j]+1;
            }
        }
        int max=inc[0];
        for(int i=1;i<inc.length;i++)
        {
            if(inc[i]>max)
                max=inc[i];
        }
        return max;             //最大递增子序列长度是inc中的最大值
    }
}