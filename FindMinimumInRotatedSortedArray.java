public class Solution {
    public int findMin(int[] num) {
        if(num.length == 1) {  //输入数组只有一个元素的情况
            return num[0];
        }
        else if(num.length == 2) {  //输入数组只有2个元素的情况
            return Math.min(num[0], num[1]);
        }
        int i = 0;  //迭代步数
        while(i < num.length - 2 && (num[i] - num[i + 1]) * (num[i + 1] - num[i + 2]) >= 0) {  //在数组范围内检查是否出现rotate
            i++;  //若这一步没有发现rotate，进入下一步迭代
        } 
        if(i < num.length - 2) {  //迭代结束后如果停在数组中间，则存在rotate
            if(num[0] - num[1] > 0) {  //rotate过的递减数组
                return Math.min(num[i + 1], num[num.length - 1]);
            }
            else {   //rotate过的递增数组
                return Math.min(num[0], num[i + 2]);
            }
        }
        else {    //迭代结束后停在数组末尾，不存在rotate
            return Math.min(num[0], num[num.length - 1]);
        }
    }
}