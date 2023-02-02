import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteExam {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
		Connection con = null;
		Statement stmt  = null;
		ResultSet rs = null;
		
		String user_id, user_addr = null, user_mobile2;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("테이블 값 삭제");
			System.out.print("삭제할 아이디 입력 : ");
			user_id = br.readLine();
			String sql = "Delete From usertbl Where userID '" + user_id + "'";
			System.out.println(sql);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터베이스 삭제 성공 !");
			
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
