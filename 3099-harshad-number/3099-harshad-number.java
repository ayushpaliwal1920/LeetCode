class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {

        if (isHarshad(x)) {
            int n = x;
            int sum = 0;

            while (n > 0) {
                int r = n % 10;
                sum += r;
                n /= 10;
            }

            return sum;
        }

        return -1;
    }

    public boolean isHarshad(int n) {
        int x = n;
        int sum = 0;

        while (x > 0) {
            int r = x % 10;
            sum += r;
            x /= 10;
        }

        return n % sum == 0;
    }
}