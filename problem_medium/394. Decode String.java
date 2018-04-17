class Solution {
    public String decodeString(String s) {
        if(s==null||s.length()==0)
            return "";
        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int start=0,end=0;
        while (start<s.length()&&end<s.length())
        {
            if(s.charAt(start)>='0'&&s.charAt(start)<='9')
            {
                while (end<s.length()&&s.charAt(end)>='0'&&s.charAt(end)<='9')
                    end++;
                s2.push(Integer.parseInt(s.substring(start,end)));
                start=end;
            }
            else if(s.charAt(start)=='[')
            {
                start++;
                end=start;
                while (end<s.length()&&(s.charAt(end)>='a'&&s.charAt(end)<='z'||s.charAt(end)>='A'&&s.charAt(end)<='Z'))
                    end++;
                s1.push(s.substring(start,end));
                start=end;
            }
            else if(s.charAt(start)==']')
            {
                int count=s2.pop();
                String ss=s1.pop();
                StringBuilder t=new StringBuilder();
                if(!s1.isEmpty())
                    t.append(s1.pop());
                for(int i=0;i<count;i++)
                    t.append(ss);
                start++;
                end=start;
                s1.push(t.toString());
            }
            else
            {
                while (end<s.length()&&(s.charAt(end)>='a'&&s.charAt(end)<='z'||s.charAt(end)>='A'&&s.charAt(end)<='Z'))
                    end++;
                StringBuilder t=new StringBuilder();
                if(!s1.isEmpty())
                    t.append(s1.pop());
                t.append(s.substring(start,end));
                s1.push(t.toString());
                start=end;
            }
        }
        return s1.pop();
    }
}