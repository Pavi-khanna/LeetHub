// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    static class Meeting {
        int start;
        int end;
        int pos;
        
        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    
    static class MeetingComparator implements Comparator<Meeting> {
        
        @Override
        public int compare(Meeting m1, Meeting m2) {
            if(m1.end<m2.end) return -1;
            else if(m1.end>m2.end) return 1;
            else if(m1.pos<m2.pos) return -1;
            
            return 1;
        }
    }
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> meet = new ArrayList<Meeting>();
        if(n==0 || start==null || end==null) return 0;
        
        // store all meetings in new DS
        for(int i=0;i<n;i++) {
            meet.add(new Meeting(start[i], end[i], i+1));
        }
        
        // sort accd to the end time
        //MeetingComparator meetCompare = ;
        Collections.sort(meet, new MeetingComparator());
        // System.out.println(meet);
        List<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        
        // maintain end limit and add to answer while traversing
        for(int i=1;i<meet.size();i++) {
            if(limit<meet.get(i).start) {
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        
        return ans.size();
    }
}
