class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        // for (char c: letters)
        //     if (c > target) return c;
        // return letters[0];
        
        
        int start = 0, end = letters.length-1;
        char res=letters[0];
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if(letters[mid]<=target) {
                start = mid+1;
            } else if (letters[mid]>target) {
                res = letters[mid];
                end = mid-1;
            }
        }
        return res;
    }
}