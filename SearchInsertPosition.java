public class Solution {
    public int searchInsert(int[] A, int target) {
        int i = 0;  //初始化当前检查的位置
        if(A == null) {  //数组为空的情况
            return i;
        }
        while(target > A[i]) {  //当target大于当前位置的数组元素时迭代地后移位置
            i++;
            if(i == A.length) {  //超出数组尾部的情况
                return i;
            }
            else if(target <= A[i]) { //小于等于当前检查位置的数组元素值的情况
                return i;
            }
        }
        return i; //target小于等于第一个数组元素的情况
    }
}