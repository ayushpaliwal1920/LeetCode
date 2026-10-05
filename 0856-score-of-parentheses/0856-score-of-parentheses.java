class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> st = new Stack();
        
        int i = 0;
        int n = 0; /// 2 raise to power is n
        int ans = 0;

        while(i < s.length()){
            if(s.charAt(i) == '('){
                st.push('(');
                n++;
            }else {
                st.pop();
                n--;
                if(i > 0 && s.charAt(i-1) == '('){
                    ans += 1 << n;
                }
            }
            i++;
        }

        return ans;
    }
}