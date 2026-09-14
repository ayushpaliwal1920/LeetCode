class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x = Math.min(rec2[2] , rec1[2]) - Math.max(rec1[0] , rec2[0]);
        int y = Math.min(rec2[3] , rec1[3]) - Math.max(rec1[1] , rec2[1]);

        if( x > 0 && y > 0){
            return true;
        }

        return false;
    }
}