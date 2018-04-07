class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int bit=0,len=pow(2,nums.length);
        for(int i=0;i<len;i++,bit++)
        {
            int j=0,s=bit;
            List<Integer> l = new ArrayList<>();
            while (s>0)
            {
                if((s&1)==1)
                    l.add(nums[j]);
                s>>=1;
                j++;
            }
            Collections.sort(l);
            if(!lists.contains(l))
                lists.add(l);
        }
        return lists;
    }
    
    public int pow(int n,int m)
    {
        int s=1;
        for(int i=0;i<m;i++)
            s*=n;
        return s;
    }
}