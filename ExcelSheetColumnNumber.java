public class Solution {
    public int titleToNumber(String s) {
        int i = s.length();
        int j = 0;
        for(byte b : s.getBytes()) {
            int p = 1;
            for(int k = i; k > 1; k--) {
                p *= 26;
            }
            j += (b - 64) * p;
            i--;
        }
        return j;
    }
}