public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int[] profit = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++) {
            profit[i - 1] = prices[i] - prices[i - 1];
        }
        int sum = 0;
        int max = 0;
        for(int j : profit) {
            max = Math.max(max, sum = Math.max(sum, 0) + j);
        }
        if(max > 0) {
            return max;
        }
        return 0;
    }
}

/**
 * 这题主要是借用了寻找数组最大子数组和的算法，我们根据prices数组构建一个价格差价
 * 的数组profit，记录的是两个相邻价格之间的差价，于是我们的任务转化为了寻找这个差价
 * 数组中最大子数组和。要注意处理特殊情况，比如prices长为0或1，以及价格一直下跌
 * 完全无利可图的情况。
 */