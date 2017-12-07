class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._stack=list()
        self._top=-1
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self._stack.append(x)
        self._top+=1
        

    def pop(self):
        """
        :rtype: void
        """
        if self._top!=-1:
            self._top-=1
            return self._stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        if self._top!=-1:
            return self._stack[self._top]
        

    def getMin(self):
        """
        :rtype: int
        """
        if self._top!=-1:
            return min(self._stack)
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()