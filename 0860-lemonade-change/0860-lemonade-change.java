class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten = 0;
        for(int bill : bills) {
            switch(bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if(five==0) return false;
                    five--;
                    ten++;
                    break;
                case 20:
                    if(five>0 && ten>0) {
                        five--; ten--;
                    }
                    else if(five>=3) five-=3;
                    else return false;
            }
        }
        return true;
    }
}