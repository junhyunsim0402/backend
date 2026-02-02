package 종합.과제3.view;

import 종합.과제3.controller.BookController;
import 종합.과제3.controller.UserController;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    private UserView(){}
    private static final UserView instance=new UserView();
    public static UserView getInstance(){return instance;}
    UserController uc=UserController.getInstance();
    BookController bc=BookController.getInstance();
    private ArrayList<BookController> bookList=new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void indexView(){
        for(;;){
            System.out.println("=========== 도서 관리 시스템 ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("===================================");
            System.out.print("선택>") ; int num = scan.nextInt();
            if(num ==1){signView(); //회원가입
            } else if(num ==2){loginView();} //로그인
        }
    }
    public void signView(){
        System.out.print("아이디:");String id=scan.next();
        System.out.print("비밀번호:");int pwd=scan.nextInt();
        System.out.print("닉네임:");String nickname=scan.next();
        boolean signResult=uc.userAdd(id,pwd,nickname);
        if(signResult){
            System.out.println("[안내]회원가입 성공하였습니다.");
        }else{
            System.out.println("[경고]회원가입 실패하였습니다.");
        }
    }
    public void loginView(){
        System.out.println("--- 로그인 ---");
        System.out.print("아이디:");String id=scan.next();
        System.out.print("비밀번호:");int pwd=scan.nextInt();
        String nickname=uc.userOutput(id,pwd);
        if(nickname.equals("관리자")){
            System.out.println("관리자님 환영합니다!");
            adminView();
        }else if(nickname.equals("로그인 실패")){
            System.out.println("[경고]다시 로그인 해 주세요");
        }else{
            System.out.printf("환영합니다%s님\n",nickname);
            bookView();
        }
    }
    public void bookView(){
        for(;;){
            int size=bc.bookSize();
            System.out.println("=========== 로그인 후 메뉴 ===========");
            System.out.println("1.도서 대출\n2.도서 반납\n3.내가 대출중인 도서 조회\n4.전체 도서 조회\n5.로그아웃\n");
            System.out.println("===================================");
            System.out.print("선택>") ; int num = scan.nextInt();
            switch (num){
                case 1:
                    for(int i=0;i<size;i++){System.out.printf("%d. 책이름:%s | 가격:%d원\n",i+1,bc.bookname(i),bc.bookprice(i));}
                    System.out.print("대출할 도서 선택해주세요:");int choose1=scan.nextInt();
                    if(choose1>size) {System.out.println("[경고]대출할 도서를 찾지 못했습니다.");}
                    else{System.out.println("[안내]대출 완료!");}
                    break;
                case 2:
                    for(int i=0;i<size;i++){System.out.printf("%d. 책이름:%s | 가격:%d원\n",i+1,bc.bookname(i),bc.bookprice(i));}
                    System.out.print("반납할 도서 선택해주세요:");int choose2=scan.nextInt();
                    break;
                case 3:
                        System.out.println("========== 내가 대출중인 도서 ==========");
                        for (int i = 0; i < size; i++) {
                            System.out.printf("도서 번호:%d | 도서 이름:%s | 가격:%d원\n",
                                    i + 1, bc.bookname(i), bc.bookprice(i));
                        }
                    break;
                case 4:
                    System.out.println("========== 전체 도서 조회 ===========");
                    for(int i=0;i<size;i++) {
                        System.out.printf("도서 이름:%s | 도서 가격:%d원\n", bc.bookname(i),bc.bookprice(i));
                    }
                    break;
                case 5:indexView();
                default:break;
            }
        }
    }
    public void adminView(){
        for(;;){
            int size=bc.bookSize();
            System.out.println("=========== 로그인 후 메뉴 ===========");
            System.out.println("1.도서 대출\n2.도서 반납\n3.내가 대출중인 도서 조회\n4.전체 도서 조회\n5.도서 등록\n6.로그아웃\n");
            System.out.println("===================================");
            System.out.print("선택>") ; int num = scan.nextInt();
            switch (num){
                case 1:
                    for(int i=0;i<size;i++){
                        System.out.printf("%d. 책이름:%s | 가격:%d원\n",i+1,bc.bookname(i),bc.bookprice(i));
                    }
                    System.out.print("대출할 도서 선택해주세요:");int choose=scan.nextInt();
                    if(choose>size) {
                        System.out.println("[경고]대출할 도서를 찾지 못했습니다.");
                    }else{
                        System.out.println("[안내]대출 완료!");
                    }break;
                case 2:break;
                case 3:
                    System.out.println("========== 내가 대출중인 도서 ==========");
                    for (int i = 0; i < size; i++) {
                        System.out.printf("도서 번호:%d | 도서 이름:%s | 가격:%d원\n",
                                i + 1, bc.bookname(i), bc.bookprice(i));
                    }
                    break;
                case 4:
                    System.out.println("========== 전체 도서 조회 ===========");
                    for(int i=0;i<size;i++) {
                        System.out.printf("도서 이름:%s | 도서 가격:%d원\n", bc.bookname(i),bc.bookprice(i));
                    }
                    break;
                case 5:
                    scan.nextLine();
                    System.out.print("등록 도서 이름:");String book=scan.nextLine();
                    System.out.print("등록 도서 가격");int price=scan.nextInt();
                    boolean bookResult=bc.bookAdd(book,price);
                    if(bookResult) {System.out.println("[안내]도서 등록이 완료되었습니다.");
                    }else{System.out.println("[경고]다시 입력해주세요");}
                    break;
                case 6:indexView();
                default:break;
            }
        }
    }
}