class Solution {

    private int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,S);
        return count;
    }
    
    void dfs(int[] nums,int cur,int remain)
    {
        if(cur==nums.length)
        {
            if(remain==0)
                count++;
            return;
        }
        
        dfs(nums,cur+1,remain-nums[cur]);
        dfs(nums,cur+1,remain+nums[cur]);
    }
}