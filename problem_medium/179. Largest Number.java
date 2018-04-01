class Solution {
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
            n[i]=nums[i];
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                int i;
                for(i=0;i<s1.length()&&i<s2.length();i++)
                {
                    if(s1.charAt(i)!=s2.charAt(i))
                        return s2.charAt(i)-s1.charAt(i);
                }
                while (i<s1.length())
                {
                    for(int j=0;j<i;j++)
                    {
                        if (s1.charAt(j)<s1.charAt(i))
                            return -1;
                        else if(s1.charAt(j)>s1.charAt(i))
                            return 1;
                    }
                    i++;
                }
                while (i<s2.length())
                {
                    for(int j=0;j<i;j++)
                    {
                        if(s2.charAt(j)<s2.charAt(i))
                            return 1;
                        else if(s2.charAt(j)>s2.charAt(i))
                            return -1;
                    }
                    i++;
                }
                return 0;
            }
        });
        StringBuilder builder=new StringBuilder();
        for (int i:n)
            builder.append(i);
        int k;
        for(k=0;k<builder.length()-1&&builder.charAt(k)=='0';k++);
        return builder.substring(k);
    }
}