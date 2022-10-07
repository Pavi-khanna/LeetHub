class Solution {
    public int subtractProductAndSum(int n) {
        if(n==1) return 0;
        
        int product=1, sum=0, digit=n;
        for(int i=0; i< Math.log10(n); i++) {
            int unit = digit%10;
            digit/=10;
            product *= unit;
            sum += unit;
        }
        return product-sum;
    }
}