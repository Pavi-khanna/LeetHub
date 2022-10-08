class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        boolean oddChar = false;
        for(int i=0; i<s.length(); i++) {
            char element = s.charAt(i);
            freq.put(element, freq.getOrDefault(element, 0)+1);
        }
        // System.out.println(freq);
        int length = 0, maxOdd = 0;
        for(Map.Entry<Character,Integer> entry : freq.entrySet()) {
            if(entry.getValue()%2 == 0) {
                length += entry.getValue();
            } else {
                length += (entry.getValue()-1);
                oddChar = true;
            }
            // System.out.println(entry.getValue() + " "  + length);
        }
        return oddChar ? length+maxOdd+1 : length+maxOdd;
    }
}