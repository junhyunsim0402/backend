package day9;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;

public class practice12 {
    public static void main(String[] args) {
        //문제1
        Student student=new Student();
        student.name="심준현";
        student.studentId=20000000;
        System.out.println("[문제1]\n이름:"+student.name+"\n학번:"+student.studentId);
        //문제2
        Cat cat=new Cat();
        cat.makeSound();
        //문제3
        Computer computer=new Computer();
        //문제4
        Figure f=new Triamgle();    //하위클래스의 값이 상위클래스의 타입으로 강제변환 되고 초기값이 정해져있지 않아 5.5->0으로 출력
        System.out.println("[문제4]\n"+f.a);
        //문제5
        Shape shape=new Circle();
        shape.draw();   //하위클래스(Circle)에서 draw메소드를 재정의 하였기 떄문에 부모클래스.메소드를 해도 재정의(오버라이딩)한 메소드가 나오게된다
        //문제6
        Vehicle vehicle=new Bus();
        if(vehicle instanceof Bus){
            ((Bus) vehicle).checkFare();
        }
        //문제7
        Beverage[] beverage={new Coffee(),new Coke()};
        System.out.println("[문제7]");
        for(Beverage b:beverage){
            b.drink();
        }
        //문제8
        System.out.println("[문제8]");
        Character character=new Character();
        character.use(new Gun());
        character.use(new Sword());
        //문제9
        System.out.println("[문제9]");
        SuperClass obj=new SubClass();
        System.out.println(obj.name);
        obj.method();
        //변수는 오버라이딩이 적용이 되지않아 obj.name은 그대로 상위클래스의 값이 나오고
        //메소드는 오버라이딩이 적용이 되므로 하위클래스 메소드가 적용된다

        //문제10
        System.out.println("[문제10]");
        Laptop laptop=new Laptop();
        System.out.println((Device)laptop);
        //System.out.println((Electronic)laptop); error
    }
}
// 문제1
class Person{
    String name;
}
class Student extends Person{
    int studentId;
}

// 문제2
class Animal{
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("[문제2]\n고양이가 야옹하고 웁니다");
    }
}
//문제3
class Machine{
    Machine(){
        System.out.println("[문제3]\n부모 클래스 생성자 실행");
    }
}
class Computer extends Machine{
    Computer(){
        System.out.println("자식 클래스 생성자 실행");
    }
}
// 문제4
class Figure{int a;}
class Triamgle extends Figure{float a=5.5f;}
// 문제5
class Shape{
    void draw(){
        System.out.println("도형을 그립니다");
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("[문제5]\n원을 그립니다.");
    }
}
// 문제6
class Vehicle{}
class Bus extends Vehicle{
    void checkFare(){
        System.out.println("[문제6]\n요금을 확인합니다");
    }
}
// 문제7
class Beverage{
    void drink(){
        System.out.println("음료를 마십니다.");
    }
}
class Coke extends Beverage{
    void drink(){
        System.out.println("콜라를 마십니다.");
    }
}
class Coffee extends Beverage{
    void drink(){
        System.out.println("커피를 마십니다.");
    }
}
//문제8
class Weapon{
    void attack(){
        System.out.println("무기로 공격합니다");
    }
}
class Sword extends Weapon{
    void attack(){
        System.out.println("검으로 공격합니다");
    }
}
class Gun extends Weapon{
    void attack(){
        System.out.println("총으로 공격합니다");
    }
}
class Character{
    void use(Weapon weapon){
        weapon.attack();
    }
}
//문제9
class SuperClass{
    String name="상위";
    void method(){
        System.out.println("상위 메소드");
    }
}
class SubClass extends SuperClass{
    String name="하위";
    void method(){
        System.out.println("하위 메소드");
    }
}
//문제10
class Device{}
class Electronic extends Device{}
class Laptop extends Device{}