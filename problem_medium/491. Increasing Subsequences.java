
// DFS求一个序列的所有递增序列
// 使用HashSet对序列进行去重，每有一个元素被添加就把当前递增序列添加到集合中
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> s=new HashSet<>();
        List<Integer> l=new ArrayList<>();
        if(nums==null||nums.length==0)
            return new ArrayList<List<Integer>>();
        dfs(nums,0,l,s);
        return new ArrayList<List<Integer>>(s);
    }
    
    public void dfs(int[] nums,int cur,List<Integer> l,Set<List<Integer>> r)
    {
        if(cur==nums.length)
            return;
        
        boolean flag=false;             //是否应该移出l的最后一个元素
        if(l.size()==0||l.get(l.size()-1)<=nums[cur])       //当且仅当l为空或新搜索的元素大于等于l的最后一个元素
        {
            l.add(nums[cur]);
            flag=true;
            if(l.size()>1)
            {
                if(!r.contains(l))               //每有一个元素被添加到当前序列，就把该序列加到集合中
                    r.add(new ArrayList<>(l));
            }
        }
        dfs(nums,cur+1,l,r);
        if(flag)
            l.remove(l.size()-1);
        dfs(nums,cur+1,l,r);
    }
}