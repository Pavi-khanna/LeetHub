class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long column = 1;
        
        for(int i=0; i<=rowIndex; i++) {
            // System.out.println((int)column);
            res.add((int)column);
            column = (column * (rowIndex-i)) / (i+1);// if int then cannot store big nos and flips to -ive
        }
        return res;
    }
}