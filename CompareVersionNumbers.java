public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        if(v1.length == 0) {
            v1 = new String[1];
            v1[0] = version1;
        }
        String[] v2 = version2.split("\\.");
        if(v2.length == 0) {
            v2 = new String[1];
            v2[0] = version2;
        }
        int i = 0;
        int num1 = 0;
        int num2 = 0;
        while(i < v1.length || i < v2.length) {
            if(i >= v1.length) {
                num1 = 0;
            }
            else {
                num1 = Integer.parseInt(v1[i]);
            }
            if(i >= v2.length) {
                num2 = 0;
            }
            else {
                num2 = Integer.parseInt(v2[i]);
            }
            if(num1 > num2) {
                return 1;
            }
            else if(num1 < num2) {
                return -1;
            }
            else if(num1 == num2) {
                if(v1.length == v2.length && i == v1.length - 1) {
                    return 0;
                }
                else {
                    i++;
                }
            }
        }
        return 0;
    }
}