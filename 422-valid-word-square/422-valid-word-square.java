class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i=0; i<words.size(); i++) {
            String str = words.get(i);
            for(int j=0; j<str.length(); j++) {
                if(j>=words.size() || words.get(j).length()<=i || words.get(j).charAt(i)!=str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}