public class Solution {
    private int[][] map;
    public int uniquePaths(int m, int n) {
        map = new int[m][n];
        return fillgrid(m, n);
    }

    private int fillgrid(int m, int n) {
        if(m == 1 || n == 1) {  //边界条件，对应于grid只有一行或只有一列的情况
            return 1;
        }
        if(map[m - 1][n - 1] != 0) {  //如果中间值已被计算过
            return map[m - 1][n - 1];
        }
        int s = fillgrid(m - 1, n) + fillgrid(m, n - 1);  //递推式
        map[m - 1][n - 1] = s;  //存储中间值
        return s;
    }
}

/**
 * 又是一道典型的动态规划题。虽然看上去用排列组合来算很简单，但对于计算机来说
 * 其计算的中间值会过大，超出数据类型的范围。所以用动态规划递推地求解。
 * 由于path的最后一步只有right和down两种情况，因此(m,n)的结果其实是(m-1,n)
 * 的结果加一步down或(m,n-1)的结果加一步right。所以
 * uniquePaths(m,n) = uniquePaths(m-1,n) + uniquePaths(m,n-1)
 * 
 * 这时很自然的想法是直接递归求解，从而写出下面的代码：
 * public class Solution {
 *     public int uniquePaths(int m, int n) {
 *         if(m == 1 || n == 1) {
 *             return 1;
 *         }
 *         return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
 *     }
 * }
 * 但是需要注意的是递归过程中会计算很多的uniquePaths(p, q)即中间值，而由于
 * 这是一个二维的递归，所以同一中间值在不同的递归层中会被多次重复计算，造成性能和时间上的
 * 巨额浪费。因此合理的做法是用一个二维数组存储中间值，当要用到的时候直接从中获取（如果已被
 * 计算过），所以就有了上面的代码。
 */