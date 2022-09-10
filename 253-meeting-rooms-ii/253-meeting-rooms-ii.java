class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // if (intervals == null || intervals.length == 0) return 0;
        // int max = 1;
        // Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        // for (int i = 0; i < intervals.length; i++) {
        //     int count = 0;
        //     for (int j = i + 1; j < intervals.length; j++) {
        //         if (intervals[j][0] < intervals[i][1]) {
        //             count++;
        //         }
        //         max = Math.max(max, count);
        //     }
        // }
        // return max;
        
        
        if(intervals.length == 0 || intervals == null) {return 0;}
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int start=intervals[0][0];
        int end = intervals[0][1];
        
        int count=0, endItr=0;
        for(int i=0; i<intervals.length; i++) {
            // System.out.println(count);
            if(starts[i]<ends[endItr]) { 
                // end = Math.min(end,intervals[i][1]); 
                count++; 
            } else {
                // start = intervals[i][0];
                // end = intervals[i][1];
                endItr++;
            }
        }
        return count;
    }
}