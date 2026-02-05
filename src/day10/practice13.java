package day10;

public class practice13 {
    public static void main(String[] args) {
        //문제1
        System.out.println("[문제1]");
        Soundable cat=new Cat();
        Soundable dog=new Dog();
        cat.makeSound();
        dog.makeSound();
        //문제2
        System.out.println("[문제2]");
        System.out.println(RemoteControl.MAX_VOLUME);
        System.out.println(RemoteControl.MIN_VOLUME);
        //문제3
        System.out.println("[문제3]");
        Runnable personrun=new Person();
        Runnable carrun=new Car();
        personrun.run();carrun.run();
        //문제4
        System.out.println("[문제4]");
        Character character=new Character();
        Attackable sword=new Sword();
        Attackable gun=new Gun();
        character.useWeapon(sword);
        character.useWeapon(gun);
        //문제5
        System.out.println("[문제5]");
        Duck duck=new Duck();
        duck.fly(); duck.swimmable();
        //문제6
        System.out.println("[문제6]");
        Object duck1=new Duck();
        if(duck1 instanceof Flyable){
            Flyable f=(Flyable) duck1;
            f.fly();
        }
        if (duck1 instanceof Swimmalbe){
            Swimmalbe s=(Swimmalbe) duck1;
            s.swimmable();
        }
        //문제7
        System.out.println("[문제7]");
        DataAccessObject dao;
        dao=new OracleDao();dao.save();
        dao=new MySqlDao();dao.save();
        //문제8
        System.out.println("[문제8]");
        Greeting g=new Greeting() {
            @Override
            public void welecome() {
                System.out.println("환영합니다");
            }
        };
        g.welecome();
        //문제9
        //문제10
        System.out.println("[문제10]");
        Calculator.plus(10,20);//아직 못함
    }
}
//문제3
class Person implements Runnable{
    public void run(){System.out.println("사람이 달립니다.");}
}
class Car implements Runnable{
    public void run(){System.out.println("자동차가 달립니다");}
}
//문제4
interface Attackable {void attack();}
class Sword implements Attackable{
    @Override
    public void attack(){System.out.println("검으로 공격");}}
class Gun implements Attackable{
    @Override
    public void attack() {System.out.println("총으로 공격");}}
class Character{
    public void useWeapon(Attackable weapon){weapon.attack();}}
//문제5,6
interface Flyable{void fly();}
interface Swimmalbe{void swimmable();}
class Duck implements Flyable,Swimmalbe{
    public void fly(){
        System.out.println("하늘을 납니다");
    }
    public void swimmable(){
        System.out.println("물에서 헤엄칩니다.");
    }
}
//문제7
interface DataAccessObject{void save();}
class OracleDao implements DataAccessObject{
    @Override public void save() {
        System.out.println("Oracle DB에 저장");}}

class MySqlDao implements DataAccessObject{
    @Override public void save()
    {System.out.println("MySQL DB에 저장");}}
//문제8
interface Greeting{
    void welecome();
}
//문제9
//문제10
interface Calculator{
    static void plus(int x,int y){};
}