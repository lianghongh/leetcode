class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if (s==null||s.length()==0)
            return false;
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else
                    stack.push(')');
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                else
                    stack.push('}');
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty()&&stack.peek()=='[')
                    stack.pop();
                else
                    stack.push(']');
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}