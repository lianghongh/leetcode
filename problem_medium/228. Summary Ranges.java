class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>();
        for(int i=0;i<nums.length;)
        {
            StringBuilder b = new StringBuilder();
            b.append(nums[i]);
            int j,t;
            for(j=i+1,t=nums[i];j<nums.length&&nums[j]-t==1;j++)
                t=nums[j];
            if(j-1!=i)
                b.append("->" + nums[j - 1]);
            i=j;
            l.add(b.toString());
        }
        return l;
    }
}