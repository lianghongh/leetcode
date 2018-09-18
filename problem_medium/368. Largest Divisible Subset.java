// 1.首先对数组进行排序（从小到大）
// 2.dp[i]存储以nums[i]结尾的，存在整除关系的数组最大长度，转移关系为dp[i]=max(dp[j]+1,dp[i]) 0<=j<i
// 3.求出dp[i]的最大值，即整个集合中满足任意nums[i]%nums[j]==0的最大长度
// 4.回溯求出整除链的所有元素，放到集合中


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)
            return result;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);                  //将dp数组初始化为1，即每个元素没有可以整除的数时，长度应该为1
        Arrays.sort(nums);           
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                    dp[i]=dp[j]+1>dp[i]?dp[j]+1:dp[i];       //计算dp[i]的值
            }
        }
        int max=dp[0],index=0;
        for(int i=1;i<dp.length;i++)
        {
            if(dp[i]>max)                  //求dp数组的最大值
            {
                max=dp[i];
                index=i;
            }
        }
        for(int i=index;i>=0;i--)
        {
            if(nums[index]%nums[i]==0&&dp[i]==max)         //找到最长整除链的尾部，向前回溯
            {
                result.add(nums[i]);
                index=i;                    //index表示当前整除链的尾部
                max--;                     //max表示剩余需要寻找的整除链元素的个数，找到一个就max--
            }
        }
        return result;
    }
}