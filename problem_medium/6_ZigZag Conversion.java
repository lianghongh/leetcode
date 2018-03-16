class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        StringBuilder builder=new StringBuilder();
        int length=s.length();
        for(int i=0;i<length;)
        {
            builder.append(s.charAt(i));
            i+=2*numRows-2;
        }
        for(int i=1,c=2*(numRows-i-1);i<numRows-1;) {
            int j=i+c;
            int k=i;
            while (k < length || j <length) {
                if (k<length)
                    builder.append(s.charAt(k));
                if (j<length)
                    builder.append(s.charAt(j));
                k+=2*numRows-2;
                j += 2 *numRows - 2;
            }
            i+=1;
            c = 2 * (numRows - i - 1);
        }
        for(int i=numRows-1;i<length;) {
            builder.append(s.charAt(i));
            i+=2*numRows-2;
        }
        return builder.toString();
    }
}