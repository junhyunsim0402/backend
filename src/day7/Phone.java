package day7;

public class Phone {
    //1.맴버변수-속성
    String model;
    String color;
    int price;
    //2.생성자
    Phone(){}
    Phone(String model,String color) {
        this.model=model;
        this.color=color;
    }
    Phone(String model,String color,int price) {
        this.model=model;
        this.color=color;
        this.price=(int)(price*0.8);
    }
    //3.맴버함수-메소드
}
