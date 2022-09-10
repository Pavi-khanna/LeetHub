class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals == null) {return true;}
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int start=intervals[0][0];
        int end = intervals[0][1];
        
        int count=0;
        for(int i=1; i<intervals.length; i++) {
            if(end>intervals[i][0]) { end = Math.min(end,intervals[i][1]); return false; }       
            else {
                end = intervals[i][1];
            }
        }
        return true;
    }
}