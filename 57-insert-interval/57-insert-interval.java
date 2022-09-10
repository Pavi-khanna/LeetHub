class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
//         int newStart=newInterval[0], newEnd=newInterval[1];
//         int idx=0, n=intervals.length;
//         List<int[]> ans = new ArrayList<>();
        
//         // intervals before insertion - mutually exclusive
//         while(idx<n && newStart>intervals[idx][1])
//             ans.add(intervals[idx++]);
        
//         // inserted interval
//         int[] interval = new int[2];
//         while(idx<n && intervals[idx][0]<=newEnd) {
//             newStart = Math.min(newStart, intervals[idx][0]);
//             newEnd = Math.max(newEnd, intervals[idx][1]);
//             ++idx;
//         }
//         ans.add(new int[]{newStart, newEnd});
        
//         // add all intervals after insertion
//         while(idx<n)
//             ans.add(intervals[idx++]);
        
//         return ans.toArray(new int[0][0]);
        
        List<int[]> result = new ArrayList();
        
        for(int i = 0; i < intervals.length; i++){
            if(newInterval[1] < intervals[i][0]){
                result.add(newInterval);
                newInterval = intervals[i];
            } else if(newInterval[0] <= intervals[i][1]){
                newInterval[0] = Math.min(intervals[i][0],  newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],  newInterval[1]);
            } else { 
                result.add(intervals[i]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}