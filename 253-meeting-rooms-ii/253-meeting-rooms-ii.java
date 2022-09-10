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
        
        
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int[] i:intervals){
            if(!pq.isEmpty()&&pq.peek()[1]<=i[0]){
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
        
        
//         if(intervals.length == 0 || intervals == null) {return 0;}
        
//         int[] starts = new int[intervals.length];
//         int[] ends = new int[intervals.length];
//         for (int i = 0; i < intervals.length; i++) {
//             starts[i] = intervals[i][0];
//             ends[i] = intervals[i][1];
//         }
//         Arrays.sort(starts);
//         Arrays.sort(ends);
        
//         int count=0, endItr=0;
//         for(int i=0; i<intervals.length; i++) {
            
//             if(starts[i]<ends[endItr]) { 
//                 count++; 
//             } else {
//                 endItr++;
//             }
//             System.out.println(endItr);
//         }
//         return count;
    }
}