class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = reward1.length;
        int totalSum2 = 0;

        for(int r : reward2){
            totalSum2 += r;
        }

        for(int i = 0 ; i< n ; i++){
            pq.add(reward1[i] - reward2[i]);
        }

        int ans = totalSum2;

        while(k != 0){
            ans += pq.poll();
            k--;
        }

        return ans;

    }
}