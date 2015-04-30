public class Solution {
    public int numTrees(int n) {
        int[] record = new int[n + 1];  // 用于记录中间值的数组
        record[0] = 1;  // 初始化边界条件
        record[1] = 1;
        return caculate(n, record);
    }

    private int caculate(int n, int[] record) {
        if(record[n] != 0) {    // 查询是否是已计算的中间值
            return record[n];
        }
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result += caculate(i - 1, record) * caculate(n - i, record);   // 注意这里的运算符是乘号不是加号
        }
        record[n] = result;   // 记录本次计算的中间值
        return result;
    }
}


/**
 * 注意这又是一个典型的动态规划题，应该记住的是，由于需要创建数据结构记录中间值，
 * 而这一数据结构的创建不能在递归的方法内部二必须在外部，同时递归方法又要使用这一数据结构，即
 * 该数据结构应该作为参数传入递归方法中，所以一般来说我们需要两个方法，一个就是主要的递归计算
 * 的方法，另一个是驱动方法，用于创建存储中间值的数据结构，初始化数据结构中的边界值，并启动计算。
 * 也可以采用将数据结构设为类的私有域，然后在驱动方法中初始化的方法。
 */