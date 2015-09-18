public class AddBinary {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len = Math.max(arr1.length, arr2.length);
        for(int i = 0; i < len; i++) {
            int temp1 = 0;
            int temp2 = 0;
            if(i >= arr1.length) {
                temp2 = (arr2[arr2.length - 1 - i] == '1') ? 1 : 0;
            }
            else if(i >= arr2.length){
                temp1 = (arr1[arr1.length - 1 - i] == '1') ? 1 : 0;
            }
            else {
                temp1 = (arr1[arr1.length - 1 - i] == '1') ? 1 : 0;
                temp2 = (arr2[arr2.length - 1 - i] == '1') ? 1 : 0;
            }
            if(temp1 + temp2 + carry== 0) {
                sb.insert(0, '0');
                carry = 0;
            }
            else if(temp1 + temp2 + carry == 1) {
                sb.insert(0, '1');
                carry = 0;
            }
            else if(temp1 + temp2 + carry == 2) {
                sb.insert(0, '0');
                carry = 1;
            }
            else {
                sb.insert(0, '1');
                carry = 1;
            }
        }
        if(carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
