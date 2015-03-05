public class Solution {
    public int findPeakElement(int[] num) {
        if(num == null) {  //输入为空的情况
            return 0;
        }
        if(num.length == 1) {  //输入数组只有一个元素的情况
            return 0;
        }
        int i = 0;  //初始化游标
        while(i < num.length) {  //当游标未超出尾部时
            if(i == 0) {   //如果当前为第一个元素
                if(num[0] > num[1]) {  //如果第一个元素比第二个元素大，直接返回index 0，否则后移游标
                    return 0;
                }
                i++;
            }
            else if(i == num.length - 1) {  //如果游标已到最后一个元素，则返回最后一个元素的index值，
                return num.length - 1;      //因为我们移动游标的规则决定了如果游标移动到最后一位，最
            }                               //后一位肯定是一个peak
            else if(num[i] > num[i - 1] && num[i] > num[i + 1]) {  //如果游标在数组中间且发现当前元素是peak
                return i;
            }
            else {
                i++;  //如果以上情况皆不是，后移游标
            }
        }
        return i;  //补全程序逻辑以通过编译
    }
}

/**
 * 这题要注意两点，一是最后一个return补全程序逻辑，二是while内部的一系列条件判断,下面是另一种正确写法
 *
 * public class Solution {
 *     public int findPeakElement(int[] num) {
 *         if(num == null) {  //输入为空的情况
 *             return 0;
 *         }
 *         if(num.length == 1) {  //输入数组只有一个元素的情况
 *             return 0;
 *         }
 *         int i = 0;  //初始化游标
 *         while(i < num.length) {  //当游标未超出尾部时
 *             if(i == 0) {   //如果当前为第一个元素
 *                 if(num[0] > num[1]) {  //如果第一个元素比第二个元素大，直接返回index 0,否则游标后移
 *                     return 0;
 *                 }
 *             }
 *             else if(i == num.length - 1) {  //如果游标已到最后一个元素，则返回最后一个元素的index值，
 *                 return num.length - 1;      //因为我们移动游标的规则决定了如果游标移动到最后一位，最
 *             }                               //后一位肯定是一个peak
 *             else if(num[i] > num[i - 1] && num[i] > num[i + 1]) {  //如果游标在数组中间且发现当前元素是peak
 *                 return i;
 *             }
 *             i++;
 *         }
 *         return i;  //补全程序逻辑以通过编译
 *     }
 * }
 * 注意条件控制语句的特点，在进入过某一if/else if分支后（即使在这一分支里什么操作都没做）会跳过后面接续的所有else/else if，
 * 所以连续的if/else if/else相当于n选一的switch，而不是一个接一个的条件判断。要实现连续的判断，应该用连续的if而不出现else。
 *
 * 下面是一种错误写法
 *
 * public class Solution {
 *     public int findPeakElement(int[] num) {
 *         if(num == null) {  //输入为空的情况
 *             return 0;
 *         }
 *         if(num.length == 1) {  //输入数组只有一个元素的情况
 *             return 0;
 *         }
 *         int i = 0;  //初始化游标
 *         while(i < num.length) {  //当游标未超出尾部时
 *             if(i == 0) {   //如果当前为第一个元素
 *                 if(num[0] > num[1]) {  //如果第一个元素比第二个元素大，直接返回index 0,否则游标后移
 *                     return 0;
 *                 }
 *                 i++;
 *             }
 *             else if(i == num.length - 1) {  //如果游标已到最后一个元素，则返回最后一个元素的index值，
 *                 return num.length - 1;      //因为我们移动游标的规则决定了如果游标移动到最后一位，最
 *             }                               //后一位肯定是一个peak
 *             else if(num[i] > num[i - 1] && num[i] > num[i + 1]) {  //如果游标在数组中间且发现当前元素是peak
 *                 return i;
 *             }
 *             i++;
 *         }
 *         return i;  //补全程序逻辑以通过编译
 *     }
 * }
 *
 * 因为
 * if() {
 *     ... 
 * }
 * ...
 * 无论如何是会执行if语句块后面的语句的,因此上面的代码当i=0且不返回i时在i++后会跳到while块的最后再i++一次造成错误，
 * 而最上面的正确代码中
 * if() {
 *     ...  
 * }
 * else {
 *     ...  
 * }
 * 若进入了if语句块就不会再进入else语句块了
 *
 * 还有一种错误代码如下
 *
 * public class Solution {
 *    public int findPeakElement(int[] num) {
 *        if(num == null) {  //输入为空的情况
 *            return 0;
 *        }
 *        if(num.length == 1) {  //输入数组只有一个元素的情况
 *            return 0;
 *        }
 *        int i = 0;  //初始化游标
 *        while(i < num.length) {  //当游标未超出尾部时
 *            if(i == 0 && num[0] > num[1]) {   //如果当前为第一个元素
 *                return 0;
 *            }
 *            else if(i == num.length - 1) {  //如果游标已到最后一个元素，则返回最后一个元素的index值，
 *                return num.length - 1;      //因为我们移动游标的规则决定了如果游标移动到最后一位，最
 *            }                               //后一位肯定是一个peak
 *            else if(num[i] > num[i - 1] && num[i] > num[i + 1]) {  //如果游标在数组中间且发现当前元素是peak
 *                return i;
 *            }
 *            i++;  //如果以上情况皆不是，后移游标
 *        }
 *        return i;  //补全程序逻辑以通过编译
 *    }
 * }
 *
 * 当i=0而num[0]<num[1]时，将跳过前2个条件语句块进行第三个条件判断，此时num[i-1]表述将触发运行错误，因为i-1此时等于-1 