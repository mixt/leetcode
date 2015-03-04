public class Solution {
    public int maxSubArray(int[] A) {
        int sum = A[0];  
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            max = Math.max(max, sum = Math.max(sum, 0) + A[i]);  //每步迭代地更新sum和max
        }
        return max;        
    }
}