class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        String phoneDigits;
        
        if(digits.length() == 0) return combinations;
        
        phoneDigits = digits;
        backtrack(0, new StringBuilder(), combinations, letters, phoneDigits);
        return combinations;
    }
    
    private void backtrack(int index, StringBuilder path, List<String> combinations, Map<Character, String> letters, String phoneDigits) {
        
        if(path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }
        
        String possibleChars = letters.get(phoneDigits.charAt(index));
        for(char letter : possibleChars.toCharArray()) {
            path.append(letter);
            backtrack(index+1, path, combinations, letters, phoneDigits);
            path.deleteCharAt(path.length()-1);
        }
    }
}