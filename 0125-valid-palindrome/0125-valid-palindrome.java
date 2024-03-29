class Solution {
    public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (i < j && !isLetterOrDigit(s.charAt(i))) i++;
      while (i < j && !isLetterOrDigit(s.charAt(j))) j--;

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        return false;
      }
      return true;
    }
    
    public boolean isLetterOrDigit(char ch) {
        return ((ch >= 'a' && ch<='z') ||
                (ch >= 'A' && ch<='Z') ||
                (ch >= '0' && ch<='9'));
    }
}