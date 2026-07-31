class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
       
       Map<Integer , Integer> mp = new HashMap<>();
       int[] ans = new int[queries.length];

    //    occ of x 

      int occ = 1;

      for(int i = 0 ; i < nums.length ; i++){
         if(nums[i] == x){
            mp.put(occ , i);
            occ++;
         }
      }

    // ans :

    int idx = 0;

    for(int i = 0 ; i< queries.length ; i++){
        if(mp.containsKey(queries[i])){
            ans[idx] = mp.get(queries[i]);
            idx++;
        }else{
           ans[idx] = -1;
           idx++;
        }
    }
       
      return ans;

    }


}