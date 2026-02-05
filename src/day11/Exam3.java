package day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam3 {
    public static void main(String[] args) {
        // [JDBC]:자바 데이터베이스 연동 라이브러리
            // mysql-connector-j-9.6.0.jar 파일 준비
            // .jar오른쪽 클릭 -> 하단에[라이브러리 추가] *프로젝트마다 1번만*

        // [연동1] Class.forName("패키지명.JDBC클래스명"); *SQL회사마다 다르다.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // 해당 클래스가 존재하면 동적으로 객체 생성
            // [연동2]
            // String url="jdbc:mysql://ip주소:port번호/데이터베이스명";
            // String user="계정명";
            // String password="계정비밀번호"
            String url="jdbc:mysql://localhost:3306/mydb0205";
            String user="root";
            String password="simjunhyun1@";
            // [연동3] Connection(인터페이스) java.sql 패키지
            // DriverManager.getConnection(C) 구현(객)체 -> 일반예외 -> try,catch로 해결
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println("연동 성공");
            // 연동 이후 DML(select,update,insert,update) 실행
            //
            String sql="insert into buy values(null,'BLK','지갑','가죽',30,10)"; // 실행할 sql문법을 문자열로 작성
            PreparedStatement ps=conn.prepareStatement(sql);     // .prepareStatement(sql)   //sql기재
            int count=ps.executeUpdate();   //기재된 sql실행 후 반영된 레코드 수 반환
            System.out.println("등록된 레코드는:"+count+"개 입니다.");
        }catch (ClassNotFoundException e){
            System.out.println("JDBC 클래스 호출 실패"+e); // 드라이버 클래스 연동 실패
        } catch (SQLException e) {
            System.out.println("등록된 DB서버로 연동 실패"+e);
        }
    }
}