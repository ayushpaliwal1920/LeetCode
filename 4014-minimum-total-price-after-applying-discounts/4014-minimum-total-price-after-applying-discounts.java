class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        int i = n-1;
        int j = m-1;

        double sum = 0;

        while(j >= 0 && i >= 0){
            double p = (prices[i] * (100.0 - discounts[j]))/100.0;
            sum += p;
            i--;
            j--;
        }

        while(i >= 0){
            sum += prices[i];
            i--;
        }

        return sum;

    }
}