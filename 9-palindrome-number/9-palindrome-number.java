class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x % 10 == 0 && x != 0)) return false; // eg 1 0
        
        int reversed=0;
        while(x>reversed) {
            reversed = reversed*10 + (x%10);
            x /= 10;
        }
        System.out.println(reversed+" "+x);
        return x == reversed || x == reversed/10; // eg 12 1
    }
}