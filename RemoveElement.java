public class Solution {
    public int removeElement(int[] A, int elem) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[count++] = A[i];    
            }
        }
        return count;
    }
}

/**
 * 这题的解法实际上用了两个游标，即i和count。i负责原数组成员的迭代遍历，
 * count负责指示重新填充的数组的位置。这给了我们以启示，即在对数组、列表进行
 * 遍历时游标可以不止一个，完全可以同时有多个游标，不同游标负责指示不同意义的位置。
 */