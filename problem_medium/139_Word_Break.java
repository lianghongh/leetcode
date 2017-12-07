class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.equals(""))
            return false;
        boolean[] r = new boolean[s.length() + 1];
        Set<String> words=new HashSet<>(wordDict);
        r[0]=true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(r[j]&&words.contains(s.substring(j,i)))
                {
                    r[i]=true;
                    break;
                }
            }
        }
        return r[s.length()];
    }
}