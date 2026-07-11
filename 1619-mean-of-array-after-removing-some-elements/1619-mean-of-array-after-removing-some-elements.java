class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;

        int percentRemove = n/20;

        int sum = 0;

        for(int i = percentRemove ;i< n-percentRemove ; i++){
            sum +=  arr[i];
        }
        return (double) sum/(n- 2*percentRemove);

    }
}