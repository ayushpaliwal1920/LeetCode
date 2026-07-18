class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer , Integer> mp = new HashMap<>();

        for(int task : tasks){
            mp.put(task , mp.getOrDefault(task , 0) + 1);
        }

        int round = 0;

        for(int val : mp.keySet()){
            if(mp.get(val) < 2){
                return -1;
            }else{
                if( mp.get(val) > 3){
                    while(mp.get(val) > 3){
                        round++ ;
                        mp.put(val , mp.get(val) - 3);
                    }
                    round++;
                    mp.put(val , 0);
                }else{
                    round++;
                    mp.put(val , 0);
                }
            }
        }

        return round;
    }
}