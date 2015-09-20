public class AddDigits {
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }
        int sum = num;
        int temp = 0;
        while(sum >= 10) {
            temp = sum;
            sum = 0;
            while(temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            
        }
        return sum;
    }
}