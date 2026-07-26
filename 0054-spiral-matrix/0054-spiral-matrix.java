class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int firstClm = 0;
        int lastClm = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while (firstRow <= lastRow && firstClm <= lastClm) {

          
            for (int j = firstClm; j <= lastClm; j++) {
                ans.add(matrix[firstRow][j]);
            }
            firstRow++;

            for (int i = firstRow; i <= lastRow; i++) {
                ans.add(matrix[i][lastClm]);
            }
            lastClm--;

        
            if (firstRow <= lastRow) {
                for (int j = lastClm; j >= firstClm; j--) {
                    ans.add(matrix[lastRow][j]);
                }
                lastRow--;
            }

        
            if (firstClm <= lastClm) {
                for (int i = lastRow; i >= firstRow; i--) {
                    ans.add(matrix[i][firstClm]);
                }
                firstClm++;
            }
        }

        return ans;
    }
}
