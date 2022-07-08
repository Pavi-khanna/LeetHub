class Solution {
    public boolean isValid(String s) {
        // will it have different types of brackets or single
        // cz if single we could have used counter variable only
        // n,n
        // Stack<Character> st = new Stack<Character>();
        // for (char it : s.toCharArray()) {
        //     if (it == '(' || it == '[' || it == '{')
        //         st.push(it);
        //     else {
        //         if(st.isEmpty()) return false;         // when it is not a starting element
        //         char ch = st.pop(); 
        //         if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{'))                             continue;                        // keep doing it
        //         else return false;
        //     }
        // }
        // return st.isEmpty();
        
        
        Map<Character, Character> map = Map.of('(',')','{','}','[',']');
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (map.containsKey(it))
                st.push(it);
            else {
                if(st.isEmpty()) return false;         // when it is not a starting element
                char open = st.pop(); 
                if(map.get(open) != it) return false;
            }
        }
        return st.isEmpty();
    }
}