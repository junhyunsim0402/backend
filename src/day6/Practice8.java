package day6;

import java.util.Scanner;

public class Practice8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        //문제1
//        Printer print=new Printer();
//        print.printMessage();
//
//        //문제2
//        Greeter k=new Greeter();
//        k.greet(sc.next());
//
//        //문제3
//        SimpleCalculator add=new SimpleCalculator();
//        int result=add.Add(sc.nextInt(), sc.nextInt());
//        System.out.println(result);
//
//        //문제 4
//        Checker check=new Checker();
//        int test=sc.nextInt();
//        boolean result=check.isEven(test);
//        if(result){
//            System.out.println("짝수입니다.");
//        }else {
//            System.out.println("홀수입니다.");
//        }
//        //문제 5
//        Lamp lamp=new Lamp();
//        lamp.turnOn();
//        System.out.printf("turnOn:%b\n",lamp.isOn);
//        lamp.turnOff();
//        System.out.printf("turnOff:%b\n",lamp.isOn);
//        //문제 6
//        Product product=new Product();
//        product.stock=10;
//        System.out.print("구매할 수량:");
//        product.sell(sc.nextInt());
//        //문제 7
//        Visualizer visualizer=new Visualizer();
//        System.out.println(visualizer.getStars(5));
        //문제 8
        ParkingLot parkingLot=new ParkingLot();
        System.out.println(parkingLot.calculateFee(65));
        System.out.println(parkingLot.calculateFee(140));
    }
}
