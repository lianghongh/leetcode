class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r=new ArrayList<>();
        if(numRows==0)
            return r;
        r.add(new ArrayList(Arrays.asList(1)));
        for(int i=1;i<numRows;i++)
        {
            List<Integer> l=new ArrayList<>();
            l.add(r.get(i-1).get(0));
            for(int j=0;j<r.get(i-1).size()-1;j++)
                l.add(r.get(i-1).get(j)+r.get(i-1).get(j+1));
            l.add(r.get(i-1).get(r.get(i-1).size()-1));
            r.add(l);
        }
        return r;
    }
}