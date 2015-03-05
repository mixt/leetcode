public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(0));
        if(n == 0) {
            return list;
        }
        else {
            list.add(new Integer(1));
            int i = 2;
            while(i <= n) {
                for(int j = list.size(); j > 0; j--) {
                    list.add(new Integer(list.get(j - 1) + (int)Math.pow(2, i - 1)));
                }
                i++;
            }
            return list;
        }
    }
}

/**
 * 求解思路：
 * 对于n=2,序列是：
 * 00，01，11，10
 * 那对于n=3,如何利用n=2的序列呢？一个方法是，先在n=2的四个序列前加0（这其实是保持不变），然后再考虑把最高位变成1，只需要把方向反过来就可以了
 * 000，001，011，010
 * 100，101，111，110－> 110,111,101,100
 * 把这两行合起来就可以得到新的序列。
 *
 * 于是先创建基本情况即只包含一个0的list，一方面作为输入为0时的返回值，另一方面作为其他输入下计算的起始值。检查输入值，处理输入为0的情况。
 * 对于其他输入，则从输入为2的情况开始迭代地求解，直到计算到输入值的情况返回。
 */