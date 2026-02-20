package day14;

public class practice16 {
    public static void main(String[] args) {
        // 문제1
        System.out.println("[문제1]");
        Thread thread=new Thread(new DeliveryTask());
        thread.start();
        try{
            for(int i=0;i<3;i++) {
                Thread.sleep(1000);
                System.out.printf("[메인] 주문 화면 갱신 %d\n",i+1);
            }
        }catch (Exception e){}
        System.out.println("[안내] 배달 처리 종료 출력");
        // 문제2
        Thread UserAThread=new Thread();
        Thread UserBThread=new Thread();
        Cart cart=new Cart();
        for(int i=0;i<5;i++){

        }
    }
}
class DeliveryTask implements Runnable{
    @Override
    public void run(){
        try{
            for(int i=0;i<3;i++) {
                Thread.sleep(1000);
                System.out.printf("[배달기사]이동중 %d\n",i+1);}
        }catch (Exception e){}
    }
}
class Cart{
    int total;
    public synchronized void addPrice(int price){
        try {
            total += price;
            Thread.sleep(500);
        }catch (Exception e){}

    }
}