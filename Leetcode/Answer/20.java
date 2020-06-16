class Solution {
    public boolean isValid(String s) {
                    List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        left.add('{');
        right.add('}');
        left.add('[');
        right.add(']');
        left.add('(');
        right.add(')');
        if(s.length()==0)
            return  true;
        if(s.length() ==1 )
            return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(left.contains(c))
                stack.push(c);
            else if(right.contains(c))
            {
                if(!stack.isEmpty())
                {
                    if(c == '}' && stack.peek()=='{')
                    {
                        stack.pop();
                    }
                    else if(c == ')' && stack.peek()=='(')
                    {
                        stack.pop();
                    }
                    else if(c == ']' && stack.peek()=='[')
                    {
                        stack.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        
        return stack.isEmpty()?true:false;

    }
}