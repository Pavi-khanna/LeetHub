class Solution {
    public boolean isHappy(int n) {
        // logn, logn
        // Set<Integer> seen = new HashSet<>();
        // while(n!=1 && !seen.contains(n)) {
        //     seen.add(n);
        //     n = getNext(n);
        // }
        // return n==1;
        
        // logn, 1
        int slow = n, fast = getNext(n);
        while(fast!=1 && slow != fast) {
           slow = getNext(slow);
           fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
    
    private int getNext(int n) {
        int totalSum=0;
        while(n>0) {
            int rem = n%10;
            totalSum += rem*rem;
            n/=10;
        }
        return totalSum;
    }
}