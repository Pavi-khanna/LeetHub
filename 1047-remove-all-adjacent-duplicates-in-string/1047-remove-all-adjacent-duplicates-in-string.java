class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> ch = new ArrayDeque<>();
//        Stack<Character> ch = new Stack<>();
        for(int i=s.length()-1; i>=0; i--) {
            if(!ch.isEmpty() && s.charAt(i) == ch.peek()) {
                ch.pop();
            } else {
                ch.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while(!ch.isEmpty()){
            result.append(ch.removeFirst());
//            result.append(ch.pop());
        }
        return result.toString();
    }
}