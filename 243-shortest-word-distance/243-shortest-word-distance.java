class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // n*m, 1 (m= len of w1 & w2)
        int first=-1, second=-1, distance=wordsDict.length;
        for(int i=0; i<wordsDict.length; i++) {
            // if(distance==1) return distance;
            
            String word = wordsDict[i];
            if(word.equals(word1)) first=i;
            else if(word.equals(word2)) second=i;
            int currDistance = second-first;
            
            if(first!=-1 && second!=-1) distance = Math.min(distance, Math.abs(currDistance));
        }
        return distance;
    }
}