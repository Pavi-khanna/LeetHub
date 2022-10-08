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
        return oddChar ? length+1 : length;
        
        
//         int[] count = new int[128];
//         for(char c : s.toCharArray()) count[c]++;
//         boolean oddChar = false;
        
//         int ans = 0;
//         for(int freq : count) {
//             if(freq%2 == 0) ans += freq;
//             else {
//                 ans += (freq - 1);
//                 oddChar = true;
//             }
//         }
        
    }
}