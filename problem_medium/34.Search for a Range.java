class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int i=-1;
        while (l<=r)
        {
            int m=(l+r)/2;
            if (target<nums[m])
                r=m-1;
            else if(target>nums[m])
                l=m+1;
            else
            {
                i=m;
                break;
            }
        }
        if (i==-1)
            return new int[]{-1,-1};
        else
        {
            int left=i,right=i;
            while (left>=l&&nums[left]==target)
                left--;
            while (right<=r&&nums[right]==target)
                right++;
            return new int[]{left+1, right-1};
        }
    }
}