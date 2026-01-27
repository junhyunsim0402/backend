package 원격;

public class WaitingController {
    Waiting[] waiting=new Waiting[100];
    public boolean addWaiting(String phone,int count){
        for(int i=0;i<waiting.length;i++){
            if(waiting[i]==null){
                waiting[i]=new Waiting();
                waiting[i].phone=phone;
                waiting[i].count=count;
                return true;
            }
        }
        return false;
    }
    public Waiting[] getWaiting(){
        return waiting;
    }
}