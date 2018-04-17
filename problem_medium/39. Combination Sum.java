class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        if(candidates==null||candidates.length==0)
            return r;
        Arrays.sort(candidates);
        backtrack(candidates,l,target,0,r);
        return r;
    }
    
    public void backtrack(int[] can,List<Integer> result,int remain,int start,List<List<Integer>> r)
    {
        if(remain<0)
            return;
        if(remain==0)
        {
            r.add(new ArrayList<>(result));
            return;
        }
        for(int i=start;i<can.length;i++)
        {
            result.add(can[i]);
            backtrack(can,result,remain-can[i],i,r);
            result.remove(result.size()-1);
        }
    }
}