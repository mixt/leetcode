public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap();
        int limit = num.length / 2;
        if(num.length == 1) {
            return num[0];
        }
        for(int i : num) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            }
            else {
                int temp = map.get(i);
                map.put(i, temp + 1);
                if((temp + 1) > limit) {
                    return i;
                }
            }
        }
        return 0;  //注意此处的返回值，是用来使编译通过的，应对的是逻辑上符合语言要求但不符合题目要求的输入。
    }
}

/**
 * 这题有个很有意思的点，就是如果不加最后一个return 0，程序在逻辑上不完备，但已覆盖了题目要求的输入，为了编译通过必须加这个
 * 在此题中永远不会跑到的return 0。
 *
 * 换句话说，程序需要能覆盖所有语言允许的输入，而不只是题目允许的输入。
 */