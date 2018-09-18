class Solution {
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        for(int i=0;i<k-1;i++)
            getNext(nums);
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<nums.length;i++)
            builder.append(nums[i]);
        return builder.toString();
    }
    
    
    public void getNext(int[] nums)            //按照字典序生成nums的下一个排列
    {
        int i;
        for(i=nums.length-2;i>=0&&nums[i]>=nums[i+1];i--);
        if(i==-1)
        {
            for(int j=0;j<=nums.length/2;j++)
            {
                int t=nums[j];
                nums[j]=nums[nums.length-1-j];
                nums[nums.length-1-j]=t;
            }
            return;
        }
        int j;
        for(j=nums.length-1;j>i&&nums[j]<=nums[i];j--);
        int t=nums[j];
        nums[j]=nums[i];
        nums[i]=t;
        for(int k=i+1;k<=(nums.length+i)/2;k++)
        {
            t=nums[k];
            nums[k]=nums[nums.length+i-k];
            nums[nums.length+i-k]=t;
        }
    }
}