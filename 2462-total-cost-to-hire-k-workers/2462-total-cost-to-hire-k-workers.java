class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
     
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        int n = costs.length;
        int l = 0 ;
        int r = n - 1;

        long cost = 0;

        while( l <= r && pq1.size() < candidates){
            pq1.add(new int[]{costs[l] , l});
            l++;
        }


        while( l <= r && pq2.size() < candidates){
            pq2.add(new int[]{costs[r] , r});
            r--;
        }

        for(int i = 0 ; i<k ; i++){
            if(!pq1.isEmpty() && !pq2.isEmpty()){

                int[] t1 = pq1.peek();
                int[] t2 = pq2.peek();

                if(t1[0] <= t2[0]){
                    int[] t = pq1.poll();
                    cost += t[0];

                    if( l <= r){
                        pq1.offer(new int[]{costs[l] , l});
                        l++;
                    }
                }else{
                    int[] t = pq2.poll();
                    cost += t[0];
                    if(l <= r){
                        pq2.offer(new int[]{costs[r] , r});
                        r--;
                    }
                } 
            }else if(!pq1.isEmpty()){
                int[] t = pq1.poll();
                cost += t[0];
                if(l <= r){
                    pq1.offer(new int[]{costs[l] , l});
                    l++;
                }
            }else{
                int[] t = pq2.poll();
                cost += t[0];
                if(l <= r){
                    pq2.offer(new int[]{costs[r] , r});
                    r--;
                }
            }

        }

        return cost;

    }
}