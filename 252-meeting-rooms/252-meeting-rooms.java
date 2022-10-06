class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // n^2, 1
        // for (int i = 0; i < intervals.length; i++) {
        //     for (int j = i + 1; j < intervals.length; j++) {
        //         if (overlap(intervals[i], intervals[j])) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
        
        
        // nlogn, 1
        // if(intervals.length == 0 || intervals == null) { return true; }
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
    
    
    // ___       ____    __    _____
    //  ____   ____     ____    __
    private boolean overlap(int[] interval1, int[] interval2) {
        int start1 = interval1[0], start2 = interval2[0], end1 = interval1[1], end2 = interval2[1];
        return ((start2<=start1 && start1<end2) 
            || (start1<=start2 && start2<end1));
    }
}