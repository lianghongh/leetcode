class Solution {
    public void sortColors(int[] nums) {
        int red,blue,white;
        red=blue=white=0;
        for(int i=0;i<nums.length;i++)
        {
            if (nums[i]==0)
                red++;
            else if(nums[i]==1)
                white++;
            else
                blue++;
        }
        int k=0;
        while(k<red)
            nums[k++]=0;
        while (k<red+white)
            nums[k++]=1;
        while(k<red+white+blue)
            nums[k++]=2;
    }
}
