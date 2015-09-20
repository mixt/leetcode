public class AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        int temp = 0;
        while(sum >= 10) {
            temp = sum;
            while(temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            
        }
        return sum;
    }
}