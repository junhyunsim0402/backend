package day9;

public class Exam2 {
    public static void main(String[] args) {
        // [1] 자바의 모든 클래스는 Object클래스로부터 자동 상속받음
        A a=new A();    //총 객체:A+Object(기본값이라 안보임)-> 총 2개(슈퍼클래스)
        B b=new B();    // [2] 자바의 모든 상속관계에서는 객체생성시 부모객체먼저 생성 -> 총 3개(B<-A<-Object)
        C c=new C();    // [3] 타입변환시 업/다운 캐스팅만 가능 -> 총 3개(C<-A<-Object)
        D d=new D();    // [4] 자식 객체가 생성되면 부모 객체도 같이 생성된다 -> 총 4개(D<-B<-A<-Object)
        E e=new E();    //                                              -> 총 4개(E<-C<-A<-Object)
        // 즉] 자바는 상속관계를 메모리(저장소)로 표현한다

        // [5] 자동타입변환
        A a2=b;
        Object o2=a2;   // b->a->Object
        // B b2=c; // C객체가 생성될때는 b는 생성되지 않음

        // [6] 강제타입변환
        B b2=(B)a2; //a2의 태생은 b객체이므로 가능
        //C c1=(C)a2; //error, a2의 태생은 b객체이므로 b가 태어날때 c는 생성되지 않음

        // [7] 타입확인, 객체 instanseof 클래스명/타입명
        System.out.println(a2 instanceof Object);
        // a 객체가 Object가 생성되었는지 확인
        System.out.println(a2 instanceof C); // => false
        // b 객체가 생성될때 C가 생성되었는지 확인
        System.out.println(e instanceof A);
        System.out.println(b instanceof D); // => false
            // b객체가 생성될때 D가 생성되었는지 확인
        // 즉]해당 객체가 생성될때 부모객체는 생성되지만 자식객체는 생성안된다
        // 다운캐스팅이 안되는 전제조건

    }
}
class A{
    A(){
        System.out.println("A객체 생성");
    }
}
class B extends A{
    B(){
        System.out.println("B객체 생성");
    }
}
class C extends A{
    C(){
        System.out.println("C객체 생성");
    }
}
class D extends B{
    D(){
        System.out.println("D객체 생성");
    }
}class E extends C{
    E(){
        System.out.println("E객체 생성");
    }
}