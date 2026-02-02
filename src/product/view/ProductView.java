package product.view;

import product.controller.ProductController;
import product.controller.UserController;
import product.model.dao.ProductDao;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    //회원가입 화면
    Scanner scan = new Scanner(System.in);
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){
        return instance;
    }
    private ProductController pc= ProductController.getInstance();
    private UserController uc= UserController.getInstance();
    private ArrayList<ProductDao> productList=new ArrayList<>();
    int choose=0;
    //메인페이지
    public void indexView(){
        for(;;){
            Scanner scan = new Scanner(System.in);
            System.out.println("=========== 회원제 중고거래 시스템 ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("===================================");
            System.out.print("선택>") ; int num = scan.nextInt();
            if(num ==1){signView(); //회원가입
            } else if(num ==2){loginView();} //로그인
        }
    }
    //회원가입
    public void signView(){
        scan.nextLine();
        System.out.print("아이디 : "); String id = scan.nextLine();
        System.out.print("비밀번호 : "); int pwd = scan.nextInt();
        System.out.print("닉네임 : "); String nickname = scan.next();
        System.out.print("연락처 : "); String phone = scan.next();
        boolean saveResult = uc.userAdd(id , pwd , nickname , phone);
        //2. 받은 결과에 따른 화면 출력
        if(saveResult){
            System.out.println("[안내] 회원가입이 완료되었습니다.");
        }else{System.out.println("[경고] 회원가입 실패");}
    }
    //로그인
    public void loginView(){
        System.out.println("---로그인---");
        System.out.printf("아이디 : "); String id = scan.next();
        System.out.println("비밀번호 : "); int pwd = scan.nextInt();
        String  loginResult=uc.loginResult(id,pwd);
        System.out.println("[안내]"+loginResult+"님 환영합니다.");
        productView();
    }
    public void productView(){
        for(;;){
            int size=pc.productSize();
            Scanner scan = new Scanner(System.in);
            System.out.println("=========== 로그인 후 메뉴 ===========");
            System.out.println("1.물품등록\n2.전체 물품 조회\n3.구매의사신청\n4.내판매물폼조회\n5.내구매신청목록\n6.로그아웃");
            System.out.println("===================================");
            System.out.print("선택>") ; int num = scan.nextInt();
            switch (num){
                case 1:
                    scan.nextLine();
                    System.out.print("--- 물품 등록 ---\n상품명:");String product=scan.nextLine();
                    System.out.print("가격:");int price=scan.nextInt();
                    scan.nextLine();
                    System.out.print("설명:");String content=scan.nextLine();
                    pc.productadd(product,price,content);
                    System.out.println("[안내]물품 등록이 완료 되었습니다.");
                case 2:
                    System.out.println("========== 전체 물품 목록==========");
                    for (int i=0;i<size;i++) {
                        System.out.printf("제품번호: %d | 제품명: %s | 가격: %d원 | 내용: %s \n",
                                pc.getProductNo(i),
                                pc.getProductName(i),
                                pc.getProductPrice(i),
                                pc.getProductContent(i));
                    }break;
                case 3:
                    System.out.println("--- 구매 의사 신청 ---");
                    System.out.print("구매 의사를 신청할 제품 번호:");choose=scan.nextInt();
                    System.out.println("[안내] 구매 의사 신청이 완료되었습니다.");break;
                case 4:
                    System.out.println("========== 내 판매 물폼 목록 ==========");
                    for (int i=0;i<size;i++) {
                    System.out.printf("제품 번호: %d | 제품명: %s | 가격: %d원 | 구매의사신청: %d명 \n",
                            pc.getProductNo(i),pc.getProductName(i),pc.getProductPrice(i),choose);
                    }break;
                case 5:
                    System.out.println("========== 내 구매 신청 목록 ==========");
                    for (int i=0;i<size;i++) {
                        System.out.printf("제품번호 : %d | %s | %d원\n",
                                pc.getProductNo(i),pc.getProductName(i),pc.getProductPrice(i));
                    }break;
                case 6:System.out.println("[안내]로그아웃 되었습니다.");indexView();break;
                default:break;
            }
        }
    }
}
