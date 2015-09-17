public class Zigzag-concersion {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        Object[] matrix = new Object[numRows];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<Character>();
        }
        boolean flag = false;
        int len = arr.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(!flag && count < numRows) {
                ((ArrayList<Character>)matrix[count]).add(arr[i]);
                count++;
                if(count == numRows) {
                    if(numRows >= 3) {
                        flag = true;
                    }    
                    count = 0;
                }
            }
            else if(flag && count < numRows - 2) {
                ((ArrayList<Character>)matrix[numRows - 2 - count]).add(arr[i]);
                count++;
                if(count == numRows - 2) {
                    count = 0;
                    flag = false;
                }
            }
        }
        List<Character> total = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            total.addAll((ArrayList<Character>)matrix[i]);
        }
        StringBuilder result = new StringBuilder();
        for(Character character : total) {
            result.append(character);
        }
        return result.toString();
    }
}