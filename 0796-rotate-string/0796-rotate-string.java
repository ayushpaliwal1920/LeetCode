class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        String addedstring = s+s;

        return addedstring.contains(goal);
    }
}