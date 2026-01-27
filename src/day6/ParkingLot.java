package day6;

public class ParkingLot {
    int money;
    public int calculateFee(int time){
        if(time>=0&&time<=30) {
            money = 1000;
        } else if (time<430) {
            if (time % 10 == 0) {
                money = 1000 + (((int) (time - 30) / 10) * 500);
            } else {
                money=1000 + (((int) (time - 30) / 10+1) * 500);
            }
        }else{
            money=20000;
        }
        return money;
    }
}
