public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(!isRight(c)) {
                stack.push(c);
            }
            else {
                while(!stack.isEmpty() && !isLeft(stack.peek())) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    return false;
                }
                if(isLeft(stack.peek())) {
                    if(!isMatch(stack.peek(), c)) {
                        return false;
                    }
                    else {
                        stack.pop();
                        continue;
                    }
                }
                
            }
        }
        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                char c = stack.pop();
                if(isLeft(c) || isRight(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isLeft(char c) {
        if(c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }
    
    private boolean isRight(char c) {
        if(c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }
    
    private boolean isMatch(char c1, char c2) {
        if(c1 == '(' && c2 == ')') {
            return true;
        }
        if(c1 == '[' && c2 == ']') {
            return true;
        }
        if(c1 == '{' && c2 == '}') {
            return true;
        }
        return false;
    }
}
