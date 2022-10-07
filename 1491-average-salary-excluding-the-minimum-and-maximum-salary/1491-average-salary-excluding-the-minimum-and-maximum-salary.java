class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double total=0;
        for(int s : salary) {
            if(min>s) min = s;
            if(max<s) max = s;
        }
        for(int s : salary) {
            if(s!=min && s!=max) {
                total+=s;
            }
        }
        return total/(salary.length-2);
    }
}