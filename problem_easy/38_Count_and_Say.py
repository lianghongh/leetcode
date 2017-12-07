class Solution:
    
    def nextStr(self,s):
        result=[]
        i=0
        while i<len(s):
            count=0
            j=i
            while j<len(s) and s[i]==s[j]:
                j+=1
                count+=1
            result.append(str(count))
            result.append(s[i])
            i=j
        return ''.join(result)
    
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s="1"
        for i in range(n-1):
            s=self.nextStr(s)

        return s