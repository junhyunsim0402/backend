package Project1.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Project1.model.dto.ProductDto;

public class ProductDao {
    private static ProductDao dao = new ProductDao();
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public static ProductDao getInstance() {
        return dao;
    }

    private ProductDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Junhyun Sim님의 DB 설정 유지
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "simjunhyun1@");
            System.out.println("[준비] 데이터베이스 연동 성공");
        } catch (Exception e) {
            System.out.println("DB 연결 실패: " + e);
        }
    }

    // 1. 등록 (SQL 컬럼명: snickname, pname, pcontent, pprice, ppwd, sphone 반영)
    public boolean register(ProductDto dto) {
        String sql = "INSERT INTO products(snickname, pname, pcontent, pprice, ppwd, sphone) VALUES(?,?,?,?,?,?)";

        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, dto.getNickname());
            this.ps.setString(2, dto.getProduct());
            this.ps.setString(3, dto.getContent());
            this.ps.setInt(4, dto.getPrice());
            this.ps.setString(5, dto.getPassword());
            this.ps.setString(6, dto.getContact());
            return this.ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. 전체 목록 조회 (SQL 컬럼명: pno, is_sold, reg_date 등 반영)
    public ArrayList<ProductDto> getList() {
        ArrayList<ProductDto> list = new ArrayList<>();
        // Unknown column 'regDate' 오류 해결: reg_date로 수정
        String sql = "SELECT * FROM products ORDER BY reg_date DESC";

        try {
            this.ps = this.conn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            while(this.rs.next()) {
                // DB 컬럼명과 Dto 필드를 정확히 매칭
                list.add(new ProductDto(
                        this.rs.getInt("pno"),           // productNo -> pno
                        this.rs.getString("snickname"),  // nickname -> snickname
                        this.rs.getString("pname"),      // productName -> pname
                        this.rs.getString("pcontent"),   // content -> pcontent
                        this.rs.getInt("pprice"),        // price -> pprice
                        this.rs.getString("ppwd"),       // password -> ppwd
                        this.rs.getString("sphone"),     // contact -> sphone
                        this.rs.getString("is_sold"),    // status -> is_sold
                        this.rs.getString("reg_date")    // regDate -> reg_date
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 3. 수정 (SQL 컬럼명 반영 및 비밀번호 검증)
    public int update(ProductDto dto, String inputPw) {
        if (!this.checkPw(dto.getProductNo(), inputPw)) {
            return 2; // 비밀번호 불일치
        } else {
            // SQL 컬럼명 반영: pname, pprice, sphone, is_sold, pno
            String sql = "UPDATE products SET pname=?, pprice=?, sphone=?, is_sold=? WHERE pno=?";

            try {
                this.ps = this.conn.prepareStatement(sql);
                this.ps.setString(1, dto.getProduct());
                this.ps.setInt(2, dto.getPrice());
                this.ps.setString(3, dto.getContact());
                this.ps.setString(4, dto.getStatus());
                this.ps.setInt(5, dto.getProductNo());
                return this.ps.executeUpdate() == 1 ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    // 4. 삭제 (SQL 컬럼명 반영)
    public int delete(int no, String inputPw) {
        if (!this.checkPw(no, inputPw)) {
            return 2; // 비밀번호 불일치
        } else {
            String sql = "DELETE FROM products WHERE pno = ?";

            try {
                this.ps = this.conn.prepareStatement(sql);
                this.ps.setInt(1, no);
                return this.ps.executeUpdate() == 1 ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    // [보조] 비밀번호 검증 (SQL 컬럼명: pno, ppwd 반영)
    private boolean checkPw(int no, String pw) {
        String sql = "SELECT * FROM products WHERE pno = ? AND ppwd = ?";

        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, no);
            this.ps.setString(2, pw);
            this.rs = this.ps.executeQuery();
            return this.rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}