package leetcode.arrays;

//LeetCode easy
//Time Complexity O(n) and space complexity 0(1)
public class BestTimeToBuyAndSellStock {
        public static int maxProfit(int[] prices) {
            int min_price = prices[0];
            int maxprof = 0;

            for(int i=1;i<prices.length;i++){
                maxprof = Math.max(maxprof, prices[i]-min_price);
                min_price = Math.min(prices[i], min_price);
            }
            System.out.println(maxprof);
            return maxprof;
        }

    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
    }

