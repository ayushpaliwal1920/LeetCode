class Solution {
    public String winningPlayer(int x, int y) {
        int turn = Math.min(x , y/4);
        if(turn % 2 == 0){
            return "Bob";
        }

        return "Alice";
    }
}