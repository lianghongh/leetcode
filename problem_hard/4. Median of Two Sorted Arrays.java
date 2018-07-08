//暴力合并，时间复杂度为O(m+n),空间复杂度为O(m+n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        merge(nums1,nums2,nums);
        if(nums.length%2==1)
            return nums[nums.length/2];
        else
            return (nums[nums.length/2-1]+nums[nums.length/2])/2.0;
    }
    
    void merge(int[] nums1,int[] nums2,int[] nums)
    {
        int k=0;
        int i,j;
        for(i=0,j=0;i<nums1.length&&j<nums2.length;)
        {
            if(nums1[i]<nums2[j])
                nums[k++]=nums1[i++];
            else
                nums[k++]=nums2[j++];
        }
        while(i<nums1.length)
            nums[k++]=nums1[i++];
        while(j<nums2.length)
            nums[k++]=nums2[j++];
    }
}