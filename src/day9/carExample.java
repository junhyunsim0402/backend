package day9;

public class carExample {
    public static void main(String[] args) {
        Car myCar=new Car();    //null
        myCar.tire=new Tire();
        myCar.run();            //일반
        myCar.tire=new HankookTire();
        myCar.run();            //한국
        myCar.tire=new KumhoTire();
        myCar.run();            //금호
        System.out.println(myCar.tire instanceof Tire); //현재 타이어는 금호이므로 참
        System.out.println(myCar.tire instanceof KumhoTire);    //true
        System.out.println(myCar.tire instanceof HankookTire);  //false
    }
}
class Car{
    Tire tire;
    void run(){this.tire.roll();}
}
class Tire{
    void roll(){
        System.out.println("[일반] 타이어가 회전");
    }
}
class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국]타이어가 회전(업그레이드)");
    }
}
class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호]타이어가 회전(업그레이드)");
    }
}