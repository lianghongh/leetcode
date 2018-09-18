class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums,0,nums.length-1,k);
    }
    
    
    public int find(int[] nums,int l,int r,int k)
    {
        if(l==r)
            return nums[l];
        int m=partition(nums,l,r);
        if(k-1>m-l)
            return find(nums,m+1,r,k-(m-l)-1);
        else if(k-1<m-l)
            return find(nums,l,m-1,k);
        else
            return nums[m];
    }

    public int partition(int[] nums,int l,int r)
    {
        int i=l;
        for(int j=l;j<r;j++)
        {
            if(nums[j]>nums[r])
            {
                int t=nums[j];
                nums[j]=nums[i];
                nums[i++]=t;
            }
        }
        int t=nums[r];
        nums[r]=nums[i];
        nums[i]=t;
        return i;
    }
}