class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean[] is=new boolean[nums.length];
        for(int i=1;i<nums.length;i++)
        {
            if(is[i-1])
                return true;
            else
            {
                int sum=nums[i];
                for(int j=i-1;j>=0;j--)
                {
                    sum+=nums[j];
                    if(k!=0&&sum%k==0)
                        return true;
                    else if(k==0&&sum==0)
                        return true;
                }
                is[i]=false;
            }
        }
        return is[nums.length-1];
    }
}