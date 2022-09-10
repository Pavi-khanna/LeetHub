class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart=newInterval[0], newEnd=newInterval[1];
        int idx=0, n=intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        // intervals before insertion - mutually exclusive
        while(idx<n && newStart>intervals[idx][1])
            ans.add(intervals[idx++]);
        
        // inserted interval
        int[] interval = new int[2];
        while(idx<n && intervals[idx][0]<=newEnd) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            ++idx;
        }
        ans.add(new int[]{newStart, newEnd});
        
        // add all intervals after insertion
        while(idx<n)
            ans.add(intervals[idx++]);
        
        return ans.toArray(new int[0][0]);
    }
}