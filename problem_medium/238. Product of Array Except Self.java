class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero=0,index=0;
        int[] result=new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++)
            result[0]*=nums[i];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                index=i;
                zero++;
            }
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=0)
                result[i]=result[i-1]/nums[i]*nums[i-1];
            else if(zero==0||zero>1)
                result[i]=0;
            else
            {
                result[i]=1;
                for(int j=0;j<nums.length;j++)
                {
                    if(j!=index)
                        result[i]*=nums[j];
                }
            }
        }
        return result;
    }
}