class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        per(nums,0,l);
        return l;
    }
    
    public void per(int[] nums,int cur,List<List<Integer>> r) {
        if(cur==nums.length-1)
        {
            List<Integer> l=new ArrayList<>();
            for(int i:nums)
                l.add(i);
            r.add(l);
            return;
        }
        for(int i=cur;i<nums.length;i++) {
            int t=nums[cur];
            nums[cur]=nums[i];
            nums[i]=t;
            per(nums,cur+1,r);
            t=nums[cur];
            nums[cur]=nums[i];
            nums[i]=t;
        }
    }
}