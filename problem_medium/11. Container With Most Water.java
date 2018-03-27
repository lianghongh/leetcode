class Solution {
    public int maxArea(int[] height) {
        int max=0,i=0,j=height.length-1;
        while (i<j)
        {
            int volume = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
            if (volume>max)
                max=volume;
            if (height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}