class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list , new StringBuilder() , 0 , 0 , n);

        return list;
    }

    public void helper(List<String> list , StringBuilder str , int open , int close , int n){
        if(str.length() == n*2){
            list.add(str.toString());
            return ;
        }

        if(open < n){
            helper(list , str.append("(") , open+1 , close , n );
            str.deleteCharAt(str.length() - 1); // backtrack
        }

        if(close < open){
            helper(list , str.append(")") , open , close+1 , n);
            str.deleteCharAt(str.length() - 1); 
        }
    }

}