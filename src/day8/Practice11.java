package day8;

import day7.package1.B;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        //문제1
        ArrayList<String> nameList=new ArrayList<>();
        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");
        for(int index=0;index<nameList.size();index++){
            System.out.println(nameList.get(index));
        }
        //문제2
        ArrayList<String> fruits=new ArrayList<>();
        fruits.add("사과");fruits.add("바나나");fruits.add("딸기");
        for(int index=0;index<fruits.size();index++){
            System.out.printf("인덱스 %d:%s\n",index,fruits.get(index));
        }
        //문제3
        int k=1;
        for(String fruit:fruits){
            System.out.println("fruit"+k+"= " + fruit);
            k++;
        }
        //문제4
        ArrayList<Character> charList=new ArrayList<>();
        charList.add('A');charList.add('B');charList.add('C');charList.add('D');charList.add('E');
        charList.remove(2);
        System.out.println(charList);
        //문제5
        ArrayList<String> lan=new ArrayList<>();
        lan.add("자바");lan.add("파이썬");lan.add("C++");
        lan.add(1,"자바스크립트");
        for(int i=0;i< lan.size();i++){
            System.out.printf("%d:%s\n",i,lan.get(i));
        }
        //문제6
        ArrayList<Book> library=new ArrayList<>();
        Book book1=new Book("제목1","저자1");
        Book book2=new Book("제목2","저자2");
        Book book3=new Book("제목3","저자3");
        library.add(book1);library.add(book2);library.add(book3);
        for(Book book:library){
            System.out.printf("제목 : %s | 저자:%s\n",book.title,book.author);
        }
        //문제7
        Scanner sc=new Scanner(System.in);
        ArrayList<String> arrayList=new ArrayList<>();
        for(;;){
            arrayList.add(sc.nextLine());
            if(arrayList.contains("종료")){
                arrayList.remove("종료");
                System.out.println(arrayList);
                break;
            }
        }
        //문제8
        ArrayList<String> subject=new ArrayList<>();
        subject.add("국어");subject.add("수학");subject.add("사회");subject.add("과학");
        subject.set(1,"영어");System.out.println(subject);
    }
}
class Book{
    String title;
    String author;
    public Book(String title,String author) {
        this.author = author;
        this.title=title;
    }
}