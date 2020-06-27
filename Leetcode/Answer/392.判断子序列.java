class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for (int k = 0; k < s.length(); k++)
            if (!t.contains(String.valueOf(s.charAt(k))))
                return false;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                stack.push(t.charAt(j));
                i = i + 1;
            }

        }
        if (stack.size() == s.length() + 1)
            return true;
        else
            return false;
}
}