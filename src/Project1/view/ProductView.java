package Project1.view;

import Project1.controller.ProductController;
import java.util.InputMismatchException;
import java.util.Scanner;
import Project1.model.dto.ProductDto;

public class ProductView {
    private static final ProductView instance = new ProductView();
    private ProductController pc = ProductController.getInstance();
    private Scanner sc;

    private ProductView() {
        this.sc = new Scanner(System.in);
    }

    public static ProductView getInstance() {
        return instance;
    }

    public void index() {
        while(true) {
            try {
                System.out.println("\n========== 익명 중고 거래 플랫폼 =========== ");
                System.out.println("1.물품 등록 2.물품 목록 3.정보 수정 4.물품 삭제 5.종료");
                System.out.println("=========================================== ");
                System.out.print("선택>");
                int ch = this.sc.nextInt();
                if (ch == 1) {
                    this.writeView();
                } else if (ch == 2) {
                    this.findAll();
                } else if (ch == 3) {
                    this.update();
                } else if (ch == 4) {
                    this.delete();
                } else {
                    if (ch == 5) {
                        return;
                    }

                    System.out.println("[경고] 없는 기능 번호입니다.");
                }
            } catch (InputMismatchException var2) {
                System.out.println("[경고] 잘못된 입력 방식입니다. 숫자만 입력해주세요.");
                this.sc = new Scanner(System.in);
            } catch (Exception e) {
                System.out.println("[시스템오류] 관리자에게 문의: " + e.getMessage());
            }
        }
    }

    public void writeView() {
        System.out.println("--- 물품 등록 ---");
        System.out.print("판매자 닉네임: ");
        String nickname = this.sc.next();
        this.sc.nextLine();
        System.out.print("물품명: ");
        String product = this.sc.nextLine();
        System.out.print("설명: ");
        String content = this.sc.nextLine();
        System.out.print("가격: ");
        int price = this.sc.nextInt();
        System.out.print("비밀번호(문자/숫자): ");
        String pwd = this.sc.next();
        System.out.print("연락처: ");
        String phone = this.sc.next();
        boolean result = this.pc.write(nickname, product, content, price, pwd, phone);
        if (result) {
            System.out.println("[안내] 등록 성공");
        } else {
            System.out.println("[경고] 등록 실패");
        }

    }

    public void findAll() {
        System.out.println("--- 전체 물품 목록 (최신순) ---");

        for(ProductDto dto : this.pc.findAll()) {
            System.out.printf("번호:%d | [%s] %s | 가격:%d | 판매자:%s | 연락처:%s | 등록일:%s\n", dto.getProductNo(), dto.getStatus(), dto.getProduct(), dto.getPrice(), dto.getNickname(), dto.getContact(), dto.getRegDate());
        }

    }

    public void update() {
        System.out.println("--- 물품 정보 수정 ---");
        System.out.print("수정할 물품 번호: ");
        int pno = this.sc.nextInt();
        System.out.print("게시물 비밀번호 확인: ");
        String pwd = this.sc.next();
        this.sc.nextLine();
        System.out.print("새 물품명: ");
        String product = this.sc.nextLine();
        System.out.print("새 가격: ");
        int price = this.sc.nextInt();
        System.out.print("새 연락처: ");
        String phone = this.sc.next();
        System.out.print("상태변경(판매중/판매완료): ");
        String status = this.sc.next();
        int result = this.pc.update(pno, pwd, product, price, phone, status);
        if (result == 1) {
            System.out.println("[안내] 수정 성공");
        } else if (result == 2) {
            System.out.println("[경고] 비밀번호가 일치하지 않습니다.");
        } else {
            System.out.println("[경고] 수정 실패 (존재하지 않는 번호 등)");
        }

    }

    public void delete() {
        System.out.println("--- 물품 삭제 ---");
        System.out.print("삭제할 물품 번호: ");
        int pno = this.sc.nextInt();
        System.out.print("게시물 비밀번호 확인: ");
        String pwd = this.sc.next();
        int result = this.pc.delete(pno, pwd);
        if (result == 1) {
            System.out.println("[안내] 삭제 성공");
        } else if (result == 2) {
            System.out.println("[경고] 비밀번호가 일치하지 않습니다.");
        } else {
            System.out.println("[경고] 삭제 실패");
        }

    }
}
