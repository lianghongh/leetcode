class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> r = new ArrayList<>();
        if(nums==null||nums.length==0||k>nums.length)
            return null;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums)
            m.put(i,m.getOrDefault(i,0)+1);
        Set<Integer> key=m.keySet();
        int p=0,f=k;
        for(int i:key)
            nums[p++]=i;
        for(int i=p/2;i>=0;i--)
            adjust(nums,m,i,p);
        while (f>0)
        {
            int t=nums[0];
            nums[0]=nums[p-1];
            nums[p-1]=t;
            adjust(nums,m,0,--p);
            --f;
        }
        int size=key.size();
        for(int i=0;i<k;i++)
            r.add(nums[size-1-i]);
        return r;
    }
    
   public void adjust(int[] nums,Map<Integer,Integer> m,int i,int size)
    {
        int s=i;
        if(2*i+1<size&&m.get(nums[s])<m.get(nums[2*i+1]))
            s=2*i+1;
        if(2*i+2<size&&m.get(nums[s])<m.get(nums[2*i+2]))
            s=2*i+2;
        if(s!=i)
        {
            int t=nums[i];
            nums[i]=nums[s];
            nums[s]=t;
            adjust(nums,m,s,size);
        }
    }
}