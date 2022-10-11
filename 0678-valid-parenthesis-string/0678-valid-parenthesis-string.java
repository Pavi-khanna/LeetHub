class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') { ++low; ++high; }
            else if(s.charAt(i)=='*') { --low; ++high; }
            else { --low; --high; if(high<0) break; }
            if(low<0) low=0;
        }
        return low==0;
    }
}