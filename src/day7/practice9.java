package day7;

public class practice9 {
    public static void main(String[] args) {
//        //문제1
//        Book book1=new Book("이것이 자바다","신용권",30000);
//        Book book2=new Book("자바의 정석","남궁성",28000);
//        book1.printInfo();
//        book2.printInfo();
//        //문제2
//        Rectangle rectangle=new Rectangle(10.0f,5.0f);
//        System.out.println(rectangle.getArea());
//        //문제3
//        BankAccount bankAccount=new BankAccount("111-222-3333","유재석",10000);
//        bankAccount.Deposit(5000);
//        bankAccount.Withdraw(3000);
//        System.out.printf("최종 장고:%d원\n",bankAccount.balance);
//        //문제4
//        Goods goods1=new Goods("콜라",2000);
//        Goods goods2=new Goods();
//        goods1.printGoods();
//        goods2.printGoods();
        //문제5
        Member member=new Member();
        System.out.println("아이디: " + member.id);
        System.out.println("로그인 여부: " + member.isLogin);
    }
}
