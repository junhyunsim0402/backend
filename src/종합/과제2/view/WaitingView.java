package 종합.과제2.view;

import 종합.과제2.controller.WaitingController;
import 종합.과제2.model.dto.WaitingDto;
import 종합.예제6.controller.BoardController;
import 종합.예제6.model.dto.BoardDto;
import 종합.예제6.view.BoardView;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    private  Scanner sc=new Scanner(System.in);
    private WaitingView(){}
    private  static final WaitingView instance=new WaitingView();
    public static  final WaitingView getInstance(){
        return instance;
    }
    private WaitingController wc=WaitingController.getInstance();
    public void writeView(){
        System.out.println("전화번호:");String phone=sc.next();
        System.out.println("인원수:");int count=sc.nextInt();
        boolean result=wc.add(phone,count);
        if(result) {
            System.out.println("[안내]대기 등록 성공!");
        }else{
            System.out.println("[경고]대기 등록 실패");
        }
    }
    public void indexView(){
        for(;;){
            System.out.println("========== 맛집 대기 시스템 =========== ");
            System.out.println("1.대기 등록 2.대기 현황");
            System.out.println("=================================== ");
            System.out.print("선택>");
            int ch=sc.nextInt();
            if(ch==1){writeView();}
            else if(ch==2){printView();}
        }
    }
    public void printView(){
        ArrayList<WaitingDto> waitings=wc.doGet();
        for(WaitingDto waitingDto:waitings){
            System.out.printf("번호:%d\n전화번호:%s\n인원수:%d\n",
                    waitingDto.getNo(),waitingDto.getPhone(),waitingDto.getCount());
        }
    }
}