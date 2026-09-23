class Solution {
    public int[][] merge(int[][] arr) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); 

        int n = arr.length;
        int end = arr[0][1];
        int st = arr[0][0];

        for(int i = 1 ; i < n; i++){

            if(end >= arr[i][0]){
                end = Math.max(end , arr[i][1]);
            }else{

                list.add(new int[]{st , end});
                st = arr[i][0];
                end = arr[i][1];
            }
        }

        // last interval : i forgot  to add

        list.add(new int[]{st , end});


        return list.toArray(new int[list.size()][]);


    }
}