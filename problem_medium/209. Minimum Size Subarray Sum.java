class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[] length = new int[nums.length];
        if(nums[0]<s)
            length[0]=Integer.MAX_VALUE;
        else
            length[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>=s)
                length[i]=1;
            else
            {
                int sum=nums[i];
                int j;
                for(j=i-1;j>=0;j--)
                {
                    sum+=nums[j];
                    if(sum>=s&&i-j+1<length[i-1])
                    {
                        length[i]=i-j+1;
                        break;
                    }
                }
                if(j==-1)
                    length[i] = length[i - 1];
            }
        }
        if(length[nums.length-1]==Integer.MAX_VALUE)
            return 0;
        return length[nums.length-1];
    }
}