class Solution {
    public boolean isValid(String s) {
//         Stack<Character> st = new Stack<>();
        
//         for(int i=0; i<s.length(); i++) {
//             char it = s.charAt(i);
            
//             if(it=='(' || it=='{' || it=='[') st.push(it);
//             else {
//                 if(st.isEmpty()) return false;
//                 char top = st.peek();
//                 if((top == '(' && it==')') || (top == '{' && it=='}') || (top == '[' && it==']')) {
//                     st.pop();
//                     continue;
//                 } else return false;
//             }
//         }
//         return st.isEmpty();
        
        
        Map<Character, Character> map = Map.of('(',')','{','}','[',']');
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char it = s.charAt(i);
            
            if(map.containsKey(it)) st.push(it);
            else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if(it != map.get(top)) return false;
            }
        }
        return st.isEmpty();
    }
}