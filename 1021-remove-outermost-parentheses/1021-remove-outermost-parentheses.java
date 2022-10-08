class Solution {
    public String removeOuterParentheses(String s) {
        // StringBuilder sb = new StringBuilder();
        // int open=0, close=0,start=0;
        // for(int i=0; i<s.length(); i++) {
        //     if(s.charAt(i)=='(') {
        //         open++;
        //     } else if(s.charAt(i)==')') {
        //         close++;
        //     }
        //     if(open == close) {
        //         sb.append(s.substring(start+1, i));
        //         start = i+1;
        //     }
        // }
        // return sb.toString();
        
        
        int count = 0;
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			if (c == '(' && count++ > 0) { sb.append(c); }
			if (c == ')' && --count > 0) { sb.append(c); }
		}
		return sb.toString();
    }
}