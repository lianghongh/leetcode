class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] t=new int[k];
        for(int i=nums.length-k;i<nums.length;i++)
            t[i-nums.length+k]=nums[i];
        for(int i=nums.length-k-1;i>=0;i--)
            nums[i+k]=nums[i];
        for(int i=0;i<k;i++)
            nums[i]=t[i];
    }
}
