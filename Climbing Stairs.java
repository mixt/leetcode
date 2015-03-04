public class Solution {
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        int ways[] = new int[n + 1];
        ways[1] = 1;
        ways[0] = 1;
        for(int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];   
        }
        return ways[n];
    }
}

/**
 * 使用动态规划求解，先想出递推式，考虑最后一步有跨一级台阶和跨两级台阶2种情况。
 * 所以wanys[n] = ways[n-1] + ways[n-2]，然后确定ways[0]和ways[1]
 */