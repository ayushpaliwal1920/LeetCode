class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>(); 

        Arrays.sort(deck);

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }
        int[] ans = new int[n];
        int i =0;

        while(q.size() > 0){
        
          ans[q.poll()] = deck[i++];

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

       

        return ans;
    }
}