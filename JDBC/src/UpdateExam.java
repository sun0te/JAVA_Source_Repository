import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateExam {
// 주소, 모바일2 수정하기
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
		Connection con = null;
		Statement stmt  = null;
		ResultSet rs = null;
		
		String user_id, user_addr, user_mobile2;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("테이블 값 수정");
			System.out.print("아이디 입력 : ");
			user_id = br.readLine();
			System.out.print("수정할 주소 입력 : ");
			user_addr = br.readLine();
			System.out.print("수정할 주소 입력 : ");
			user_mobile2 = br.readLine();
			
			String sql = "Update usertbl Set addr = '" + user_addr;
			sql += "', mobile2 = '" + user_mobile2 + "Where user ID = '" + user_id + "'";
			System.out.println(sql);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터베이스 수정 성공 !");
			
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 !");
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
