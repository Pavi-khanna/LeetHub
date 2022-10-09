class Solution {
    public String reverseWords(String s) {
//         String[] words = s.trim().split(" ");
//         StringBuilder res = new StringBuilder();
        
//         for(int i=words.length-1;i>=0;i--) {
//             if(!words[i].isEmpty())
//                 res.append(words[i]).append(" ");
//         }
//         return res.toString().trim();
        
        // \\s+
        
        // reverse str and then each word
        StringBuilder sb = trimSpaces(s.trim());
        reverse(sb, 0, sb.length()-1);
        reverseEachWord(sb);
        
        return sb.toString();
        
        // stack
    }
    
    public void reverse(StringBuilder sb, int left, int right) {
        while(left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }
    
    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        
        while(start<n) {
            while(end<n && sb.charAt(end)!=' ') ++end;
            reverse(sb, start, end-1);
            start = end+1;
            ++end;
        }
    }
    
    public StringBuilder trimSpaces(String s) {
        int left=0, right=s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);

            if(c!=' ') sb.append(c);
            else if(sb.charAt(sb.length()-1) != ' ') sb.append(c);
            ++left;
        }
        return sb;
    }
}