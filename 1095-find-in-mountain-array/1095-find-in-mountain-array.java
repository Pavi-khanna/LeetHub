/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start =0, end = mountainArr.length()-1;
        int peakIndex = findPeakIndex(mountainArr);
        // System.out.println(peakIndex);
        int right = searchReverse(target, mountainArr, peakIndex+1, end);
        int left = search(target, mountainArr, start, peakIndex);
        // System.out.println(left+" "+right);

        int ans = 0;
        if(left!=-1) ans = left;
        else if(right!=-1) ans = right;
        
        return left==-1 && right==-1 ? -1 : ans;
    }
    
    public int findPeakIndex(MountainArray mountainArr) {
        int start =0, end = mountainArr.length()-1, mid=0, peak = 0, size = mountainArr.length(), left=0,right=0;
        if(size==1) return 0;
        while(start < end) {
            mid = start +(end-start)/2;
            
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) {
                start = mid+1;
            } else {
                end = mid;
            } 
        }
        return start;
    }
    
    public int search(int target, MountainArray mountainArr, int low, int high) {
        int mid;
        while(low<=high) {
            mid = (low +(high-low)/2);
            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid)<target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    
    public int searchReverse(int target, MountainArray mountainArr, int low, int high) {
        int mid;
        while(low<=high) {
            mid = (low +(high-low)/2);
            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid)>target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}