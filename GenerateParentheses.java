public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, result, "");
        return result;
    }

    private void generate(int n, int left, int right, List<String> result, String current) {
        if(left == n && right == n) {
            result.add(current);
        }
        if(left < right) {
            return;
        }
        if(left < n) {
            generate(n, left + 1, right, result, current + "(");
        }
        generate(n, left, right + 1, result, current + ")");
    }
}