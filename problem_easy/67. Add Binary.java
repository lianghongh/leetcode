class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder=new StringBuilder();
        a=new StringBuilder(a).reverse().toString();
        b=new StringBuilder(b).reverse().toString();
        int i=0,add=0;
        for(;i<Math.min(a.length(),b.length());i++)
        {
            int s=a.charAt(i)-'0'+b.charAt(i)-'0'+add;
            builder.append(s%2);
            add=s/2;
        }
        while (i<a.length())
        {
            int s=a.charAt(i++)-'0'+add;
            builder.append(s%2);
            add=s/2;
        }
        while (i<b.length())
        {
            int s=b.charAt(i++)-'0'+add;
            builder.append(s % 2);
            add=s/2;
        }
        if (add!=0)
            builder.append(add);
        String r=builder.reverse().toString();
        for(i=0;i<r.length()&&r.charAt(i)=='0';i++);
        if (i==r.length())
            return "0";
        return r.substring(i);
    }
}