public class Solution {
    public String convertToTitle(int n) {
        int m = 0;
        String s = "";
        while(n != 0) {
            m = n % 26;
            if(m != 0) {
                s = (char)(m + 64) + s;
                n = (n - m) / 26;
            }
            else {
                s = (char)(90) + s;
                n = (n - 26) / 26;
            }
        }
        return s;
    }
}