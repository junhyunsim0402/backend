package 원격;

import java.util.Scanner;

public class WaitingService {
    public static void main(String[] args) {
        WaitingController wc=new WaitingController();
        Scanner sc=new Scanner(System.in);
        for(;;){
            System.out.println("========== 맛집 대기 시스템 ==========");
            System.out.println("1.대기 등록 | 2. 대기 현황");
            System.out.println("====================================");
            System.out.print("선택>");int ch=sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    System.out.print("전호번호:");String phone=sc.nextLine();
                    System.out.print("인원수:");int count=sc.nextInt();
                    boolean result=wc.addWaiting(phone,count);
                    if(result){
                        System.out.println("[안내] 등록 완료");
                    }else{
                        System.out.println("[경로] 등록 실패");
                    }break;
                case 2:
                    System.out.println("===========대기 현황===========");
                    Waiting[] waitingList=wc.getWaiting();
                    for(int i=0;i<waitingList.length;i++){
                        if(waitingList[i]!=null){
                            System.out.printf("%d. 연락처:%s - 인원: %d\n",i+1,waitingList[i].phone,waitingList[i].count);
                        }
                    }break;
                default:break;
            }
        }
    }
}
