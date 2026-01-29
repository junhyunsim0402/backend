package 종합.예제5;

import java.util.Scanner;

public class BoardService5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(;;){
            System.out.println("========== MY Community ==========");
            System.out.println("1.게시물 쓰기 | 2.게시물 출력");
            System.out.println("==================================");
            System.out.print("선택>"); int ch=sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    System.out.print("내용:");String content=sc.nextLine();
                    System.out.print("작성자:");String writer=sc.nextLine();
                    boolean result=BoardController.doPost(content,writer);
                    if(result){
                        System.out.println("[안내]글쓰기 성공");
                    }else{
                        System.out.println("[경고]글쓰기 실패");
                    }break;
                case 2:
                    Board[] boards=BoardController.doGet();
                    System.out.println("========== 게시물 목록 ==========");
                    //for(int index=0;index<boards.length;index++){
                    for(Board board:boards){
                    //    if(boards[index]!=null){
                        if(board!=null){
                    //        System.out.printf("작성자:%s,내용:%s\n",boards[index].getContent(),boards[index].getWriter());
                            System.out.printf("작성자:%s,내용:%s\n",board.getWriter(),board.getContent());
                        }
                    }break;
                default:break;
            }
        }
    }
}

//보드 클래스
class Board{
    private String content; //private이란?현재 클래스에서만 허용
    private String writer;
    public Board(){
        this.content=content;
        this.writer=writer;
    }
    public Board(String content,String writer){
        this.content=content;
        this.writer=writer;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}

//컨트롤러 클래스
class BoardController{
    private static final Board[] boards=new Board[100]; //외부접근차단,객체없이,수정금지 boards를 수정은 못하지만 boards[i]같은건 수정 가능
    public static boolean doPost(String content,String writer){
        Board board=new Board(content,writer);
        for(int i=0;i<boards.length;i++) {
            if (boards[i] == null) {
                boards[i]=board;
                return true;
            }
        }
        return false;
    }
    public static Board[] doGet(){
        return boards;
    }
}