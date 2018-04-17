class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> r=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        if(candidates==null||candidates.length==0)
            return r;
        Arrays.sort(candidates);
        backtrack(candidates,0,target,l,r);
        return r;
    }
    
     public void backtrack(int[] can,int start,int remain,List<Integer> l,List<List<Integer>> r)
    {
        if(remain<0)
            return;
        if (remain==0)
        {
            r.add(new ArrayList<>(l));
            return;
        }

        for(int i=start;i<can.length;i++)
        {
            if(i>start&&can[i]==can[i-1])               //跳过重复的元素
                continue;
            l.add(can[i]);
            backtrack(can,i+1,remain-can[i],l,r);
            l.remove(l.size() - 1);
        }
    }
}