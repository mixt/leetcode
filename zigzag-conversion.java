public class zigzag-conersion {
    public String convert(String s, int numRows) {
        char[] arr = s.toCharArray();
        Object[] matrix = new Object[numRows];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<Character>();
        }
        boolean flag = false;
        int len = arr.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(!flag) {
                (ArrayList<Character>)matrix[count].add(arr[i]);
                count++;
                if(count >= numRows) {
                    flag = true;
                    count = 1;
                }
            }
            else {
                (ArrayList<Character>)matrix[count].add(arr[i]);
                count = count + 2;
                if(count >= numRows) {
                    flag = false;
                    count = 0;
                }
            }
        }
        List<Character> total = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            total.addAll((ArrayList<Character>)matrix[i]);
        }
        return new String(total);
    }
}