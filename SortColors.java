public class Solution {
    public void sortColors(int[] A) {
        int one = 0;
        int two = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                A[i] = A[two];
                A[two] = A[one];
                A[one] = 0;
                one++;
                two++;
            }
            else if(A[i] == 1) {
                A[i] = A[two];
                A[two] = 1;
                two++;
            }
        }
    }
}

/**
 * 这个解法的主要思想有两点，1.用两个指针分别指向当前1序列和2序列的开头；2.遍历
 * 数组时，当发现0时，把当前两个指针指向的元素“后移”，分别转存到A[i]和A[two]中，
 * 并把0插入当前0序列的结尾即1序列的开头，后移两个指针，这样既扩充了0序列又保存了
 * 因0序列增长而被挤占的原A[one]和A[two]的值。同理当发现1时，把当前A[two]的值
 * 转存到A[i],然后插入1到1序列末尾，后移two指针。
 */