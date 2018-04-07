class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> r=new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;)
        {
            if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else
            {
                r.add(nums1[i]);
                ++i;
                ++j;
            }
        }
        int[] result=new int[r.size()];
        for(int i=0;i<result.length;i++)
            result[i]=r.get(i);
        return result;
    }
}