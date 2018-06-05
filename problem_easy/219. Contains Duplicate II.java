//方法一：暴力枚举
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j]&&j-i<=k)
                    return true;
            }
        }
        return false;
    }
}

//方法二：哈希表
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(m.containsKey(nums[i])&&i-m.get(nums[i])<=k)
                return true;
            else
                m.put(nums[i],i);
        }
        return false;
    }
}