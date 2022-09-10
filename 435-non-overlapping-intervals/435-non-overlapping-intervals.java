class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
//         if(intervals.length == 0 || intervals == null) {return 0;}
//         Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
//         int n = intervals.length;
        
//         int count = 0;
//         for(int i=0; i<n; i++) {
//             int start = intervals[i][0], end = intervals[i][1];
            
//             for(int j=i+1; j<n; j++) {
//                 // not mutually exclusive
//                 if(end > intervals[j][0]) {                           // 1,4  >  3,5
//                     end = intervals[j][1];              // ec : 1,4 & 2,3
//                     count++;
//                 } else 
//                     break;
//             }
//         }
//         return count;
        
        
        
//         if (intervals.length == 0) return 0;
//         Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
//         int end = intervals[0][1];
        
//         int count = 0;
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] < end) {
//                 count++;
//             } else {
//                 end = intervals[i][1];
//             }
//         }
//         return count;
        
        
        // List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) {return 0;}
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int start=intervals[0][0];
        int end = intervals[0][1];
        
        int count=0;
        for(int i=1; i<intervals.length; i++) {
            if(end>intervals[i][0]) { end = Math.min(end,intervals[i][1]); count++; }       
            // 1,3 & 2,4
            else {
                // res.add(new int[]{start,end});                // 1,3 & 5,6
                end = intervals[i][1];
            }
        }
        // res.add(new int[]{start,end});                        // last one
        return count;
    }
}