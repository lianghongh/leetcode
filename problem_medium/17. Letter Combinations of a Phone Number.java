class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> r=new ArrayList<>();
        for(int i=0;i<digits.length();i++)
        {
            if (digits.charAt(i)-'0'-2>=0&&digits.charAt(i)-'0'-2<dict.length)
                r=generate(r,digits.charAt(i)-'0'-2,dict);
        }
        return r;
    }
    
    public List<String> generate(List<String> result,int a,String[] dict){
        List<String> r=new ArrayList<>();
        if (result.size()==0)
        {
            for(int i=0;i<dict[a].length();i++)
                r.add(dict[a].charAt(i)+"");
        }
        else
        {
            for(int i=0;i<result.size();i++) {
                for(int j=0;j<dict[a].length();j++)
                    r.add(result.get(i)+dict[a].charAt(j));
            }
        }
        return r;
    }
}
