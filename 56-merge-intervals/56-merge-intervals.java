class Solution {
    public int[][] merge(int[][] intervals) {
        // n^2+nlogn, n
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) {return res.toArray(new int[0][]);}
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int n = intervals.length;
        
        for(int i=0; i<n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(!res.isEmpty()) {
                if(res.get(res.size()-1)[1] >= start) continue;   // res->1,3 | curr->2,4 => 3>2
            }
            for(int j=i+1; j<n; j++) {
                if(end >= intervals[j][0]) {                           // 1,4  >  3,5
                    end = Math.max(end, intervals[j][1]);              // ec : 1,4 & 2,3
                } else 
                    break;
            }
            res.add(new int[]{start, end});
        }
        return res.toArray(new int[0][]);
        
        
        // nlogn+n, n
//         List<int[]> res = new ArrayList<>();
//         if(intervals.length == 0 || intervals == null) {return res.toArray(new int[0][]);}
//         Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
//         int start=intervals[0][0];
//         int end = intervals[0][1];
        
//         for(int[] i: intervals) {
//             if(i[0]<=end) {end = Math.max(end,i[1]);}
//             else {
//                 res.add(new int[]{start,end});
//                 start = i[0]; end = i[1];
//             }
//         }
//         res.add(new int[]{start,end});
//         return res.toArray(new int[0][]);
    }
}