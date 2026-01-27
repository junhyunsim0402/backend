package 종합.과제1;

import 종합.예제4.BoardController;

import java.util.Scanner;

public class WaitingService {
    public static void main(String[] args) {
        WaitingController wc=new WaitingController();
        for(;;) {
            System.out.println("========== 맛집 대기 시스템 =========== ");
            System.out.println("1.대기 등록 2.대기 현황");
            System.out.println("=================================== ");
            System.out.print("선택>");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            scan.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("전화번호:");
                    String phone = scan.nextLine();
                    System.out.print("인원수:");
                    int count = scan.nextInt();
                    boolean result = wc.addWaing(phone, count);
                    if (result) {
                        System.out.println("[안내] 대기 등록이 완료 되었습니다");
                    } else {
                        System.out.println("[경고]더 이상 대기 등록을 할 수 없습니다.");
                    }
                    break;
                case 2:
                    System.out.println("===========대기 현황===========");
                    Waiting[] waitingList=wc.getWaitingList();
                    for(int i=0;i<waitingList.length;i++) {
                        if (waitingList[i] != null) {
                            System.out.printf("%d. 연락처: %s - 인원: %d 명\n", i, waitingList[i].phone, waitingList[i].count);
                        }
                    }break;
                default:break;
            }
        }
    }
}
