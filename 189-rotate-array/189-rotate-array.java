class Solution {
    public void rotate(int[] nums, int k) {
        // k*n, 1
        // k%=nums.length;
        // for(int i=0; i<k; i++) {
        //     rotateByOne(nums);
        // }
        
        
        // n, n
        int n = nums.length;
        // int[] temp = new int[n];
        // for(int i=0; i<n; i++) temp[(i+k)%n] = nums[i];
        // for(int i=0; i<n; i++) nums[i]=temp[i];
        
        
        // n, 1
        // k%=n;
        // reverse(nums, 0, n-1);
        // reverse(nums, 0, k-1);
        // reverse(nums, k, n-1);
        
        
        k %= n;
        k = n-k;
        
        for(int i=0; i<gcd(k, n); i++) {
            int temp = nums[i], j = i;
            
            while (true) {
				int d = j + k;
                if (d >= n)
                    d = d - n;
                if (d == i)
                    break;
                nums[j] = nums[d];
                j = d;
			}
			nums[j] = temp;
        }
    }
    
    public void reverse(int[] a, int start, int end) {
        while(start < end) {
            int num = a[start];
            a[start++] = a[end];
            a[end--] = num;
        }
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    
    public void rotateByOne(int[] a) {
        int lastNum = a[a.length-1];
        for(int i=a.length-1; i>=1; i--) {
            a[i] = a[i-1];
        }
        a[0]=lastNum;
    }
}