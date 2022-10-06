class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDistance = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                for (int j = 0; j < wordsDict.length; j++) {
                    if (wordsDict[j].equals(word2)) {
                        minDistance = Math.min(minDistance, Math.abs(i - j));
                    }
                }
            }
        }
        return minDistance;
        
        
        
        // n*m, 1 (m= len of w1 & w2)
//         int first=-1, second=-1, distance=wordsDict.length;
//         for(int i=0; i<wordsDict.length; i++) {
//             // if(distance==1) return distance;
            
//             String word = wordsDict[i];
//             if(word.equals(word1)) first=i;
//             else if(word.equals(word2)) second=i;
//             int currDistance = second-first;
            
//             if(first!=-1 && second!=-1) distance = Math.min(distance, Math.abs(currDistance));
//         }
//         return distance;
    }
}