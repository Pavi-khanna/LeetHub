//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // int sum=0,start=0,end=0;
        // for(int i=0;i<n;i++) {
        //     int currentSum=0;
        //     //start = i;
        //     for(int j=i;j<n;j++) {
        //         currentSum+=arr[j];
        //         if(currentSum==0) { sum = Math.max(sum, j-i+1); start = i; end = j+1;}
        //     }
        // }
        // System.out.println(start+" "+end);
        // return sum;
        
        
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0, max=0;
        
        for(int i=0;i<n;i++) {
            sum+=arr[i];
            if(sum==0) max = i+1;
            else {
                if(map.containsKey(sum)) {
                    max = Math.max(max, i-map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}