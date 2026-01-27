package 종합.과제1;

public class WaitingController {
    Waiting[] waitings = new Waiting[100];
    public boolean addWaing(String phone,int count){
        for(int i=0;i< waitings.length;i++){
            if(waitings[i]==null){
                waitings[i]=new Waiting();
                waitings[i].count=count;
                waitings[i].phone=phone;
                return true;
            }
        }
        return false;
    }
    public Waiting[] getWaitingList(){
        return waitings;
    }
}
