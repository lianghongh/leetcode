class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> l= Arrays.asList(1);
        if(rowIndex==1)
            return l;
        if(rowIndex==0)
            return new ArrayList<Integer>();
        for(int i=1;i<rowIndex;i++)
        {
            List<Integer> m=new ArrayList<>();
            m.add(l.get(0));
            for(int j=1;j<l.size();j++)
                m.add(l.get(j)+l.get(j-1));
            m.add(l.get(l.size()-1));
            l=m;
        }
        return l;
    }
}