package 종합.예제7.model.dao;

import 종합.예제7.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){connect();}      // 여기서 함수 실행
    private static final BoardDao instance=new BoardDao();
    public static BoardDao getInstance(){return instance;}
    // 데이터베이스 연동
        // 1) 연동할 db 서버의 정보
    private String url="jdbc:mysql://localhost:3306/boardservice6";
    private String user="root"; private String pwd="simjunhyun1@";
        // 2) 연동 인터페이스 선언
    private Connection conn;
        // 3) 연동 함수 정의, dao에 생성자에서 실행
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //mysql 라이브러리 객체 메모리 할당/불러오기
            conn= DriverManager.getConnection(url,user,pwd); // mySQL 구현체로 db연동후 연동 인터페이스에 반환
            System.out.println("[준비]데이터베이스 연동 성공");
        }catch (Exception e){
            System.out.println("[경고]DB 연동실패"+e);
        }
    }
    // [1] 게시물 등록 dao
    public boolean write(String bcontent,String bwriter){
        try {
            // 1) SQL 작성. 저장->c->insert문법, ?와일드카드 기호로 변수값이 들어갈 자리
            String sql = "insert into board(bcontent,bwriter)values(?,?)";  // values(?,?) 1번,2번 물음표
            // 2) 연동된(conn) 인터페이스에 내가 작성한 SQL기재, 반환은 preparedStatement(준비된)
            PreparedStatement ps=conn.prepareStatement(sql);
            // 3) SQL이 기재된 (ps) 인터페이스에 매개변수를 대입
            ps.setString(1,bcontent);   // ps.set타입명(?순서명,값);   // String 타입으로 SQL내 1번 ?에 bcontent를 대입한다.
            ps.setString(2,bwriter);    // String 타입으로 SQL내 2번 ?에 bwriter값을 대입한다.
            // 4) 매개변수까지 대입하여 준비가 끝났으면 SQL실행
            int count=ps.executeUpdate();
            // 5) SQL실행 후 반영된 레코드 수에 따른 결과 제어
            if(count==1){return true;}  // 등록한 레코드수가 1이면 성공
            else{return false;}         // 아니면 실패
        }catch (SQLException e){
            System.out.println("[시스템오류]SQL문법 문제 발생"+e);
        }
        return false;
    }
    public boolean delete(int bno){
        try {
            // SQL 작성한다,?는 매개변수가 들어갈 자리
            String sql = "delete from board where bno=?"; //sql에 bno가 ?이면 삭제
            // 연동된 conn 에 내가 작성한 SQL기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // ?와일드 카드에 매개변수 대입,ps.set???(순서번호,값)
            ps.setInt(1,bno);
            int count=ps.executeUpdate();
            if(count==1){return true;}
            else{return false;}
        }catch (SQLException s){
            System.out.println("[시스템오류]SQL문법 문제 발생");
        }
        return false;
    }
    public boolean update(int bno,String bcontent){
        try {
            String sql = "update board set bcontent=? where bno=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,bcontent);
            ps.setInt(2,bno);
            int count=ps.executeUpdate();
            if(count==1){return true;}
            else {return false;}
        }catch (SQLException s){System.out.println("[시스템오류]SQL문법 문제 발생");}
        return false;
    }// bno와 bcontent를 매개변수로 받아 sql문을 작성해 기재(preParedStatement)한 후 ?번에 각각 저장(set???)한 뒤 count에 값을 업데이트(1)을 저장한뒤 수정이 되었으면 true
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> boards=new ArrayList<>(); // 조회결과 레코드(dto)들을 저장할 리스트/배열 선언
        try{
            // SQL작성
            String sql="select * from board";
            // SQL문 기재
            PreparedStatement ps=conn.prepareStatement(sql);
            // SQL매개변수 대입(?가 없으므로 생략)
            ResultSet rs=ps.executeQuery();
            // [4] SQL실행,executeUpdate():insert/update/delete
                // VS excuteQuery:select
                // ResultSet:select결과물을 제어하는 인터페이스
                    // rs.next(): 조회결과에서 다음 레코드 1번 이동,만약에 레코드가 10개이면 next10번
            while(rs.next()){
                // rs.get타입명(속성명) : 현재 레코드의 속성명에 해당하는 속성값 호출
                int bno=rs.getInt("bno"); String bcontent=rs.getString("bcontent");
                String bwriter=rs.getString("bwriter"); String bdate=rs.getString("bdate");
                // DTO 만들기
                BoardDto boardDto=new BoardDto(bno,bcontent,bwriter,bdate);
                // 리스트에 저장
                boards.add(boardDto);
            }
        }catch (SQLException s){System.out.println("[시스템오류]SQL문법 문제 발생");}
        return boards;  // 리스트 반환
    }
}
// SQL연동법
// url매개변수를 사용해서 url주소를 "jdbc:mysql://localhost:3306/boardservice6";를 저장하고, 유저의 위치를 user(변수), sql비밀번호(pwd)를 저장한뒤
// 연동 인터페이스를 문자열로 연동할걸 선언한뒤 connect()함수같은걸로 Class.forName()함수를 활용해 mySQl과 자바를 연결해주는 클래스 경로("com.mysql.cj.jdbc.Driver")를 함수안에 넣고
// 예외처리(try,catch)를 잡고 그걸 생성자인 private BoardDao(){connect();}에서 함수 실행

// 내용 추가
// 등록이 성공되냐의 여부를 boolean타입의 write함수를 쓰며 sql(변수)에 데이터를 추가하는 SQL코드를 치고
// ex) "insert into board(bcontent,bwriter)values(?,?)"에서 ?에는 ps.setString(1,bcontent); ps.setString(2,bwriter); 를 사용에 각 1번,2번 ?에 각각의 값을 넣는다
// 수정이 완료되면 count값에 ps.executeUpdate();하여 성공하면 1이 넣어지므로 그 값이 충족하면 성공

// 내용 출력
// Dto에 있는 리스트를 불러오고 sql출력 문을 작성한뒤 ps에 기재하고 select결과물을 제어(ResultSet)하는 인터페이스를 활용하여 while문에 rs.next()를 써서 게시물 개수만큼 반복하고
