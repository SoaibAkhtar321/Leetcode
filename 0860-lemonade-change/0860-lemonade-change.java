class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five  =0;
        int ten=0;

        for(int bill:bills){
            if(bill ==5){
                five++;
            }
            else if(bill==10){
                if(five==0) return false;
                ten++;
                five--;
            }
            // if bill is 20
            else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }
                else if(five>=3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
       
       return true;
    }
}