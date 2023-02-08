package exam_SawonTable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//내가 작성한 코드
public class Ex_SawonTable {
	public static void main(String[] args) {;
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();
			
			if (menu == 6) {
				System.out.println("The End...");
				break;
			}
			
			switch (menu)
			{
				case 1:
					input_sawon();
					break;
				case 2:
					output_sawon();
					break;
				case 3:
					search_sawon();
					break;
				case 4:
					update_sawon();
					break;
				case 5:
					delete_sawon();
					break;
				default: 
				
			}
		}	
	}
	
	static void printMenu()
	{
		System.out.println("*** 사원관리 ***");
		System.out.println("1. 사원정보 입력");
		System.out.println("2. 사원정보 출력");
		System.out.println("3. 사원정보 조회");
		System.out.println("4. 사원정보 수정");
		System.out.println("5. 사원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	//연결 객체 생성 별도의 메소드로 생성
	static Connection connectDB() {
		Connection con = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "123456" );
		} 
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace( );
		}
		
		
		return con;
	}
	
	
	static void input_sawon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "Insert Into sawon(sabun, deptname, irum, gender, email) Values (?,?,?,?,?)";
        String user_sabun, user_deptname, user_irum, user_gender, user_email;
        
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	System.out.println("sawon 테이블에 값 추가하기 .....");
        	System.out.print("사번 입력 : ");
        	user_sabun = br.readLine();
            System.out.print("부서 입력 : ");
            user_deptname = br.readLine();
            System.out.print("이름 입력 : ");
            user_irum = br.readLine();
            System.out.print("성별 입력 : ");
            user_gender = br.readLine(); 
            System.out.print("이메일 입력 : ");
            user_email = br.readLine();
            
            System.out.println(sql);
            
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pw);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_sabun);
            pstmt.setString(2, user_deptname);
            pstmt.setString(3, user_irum);
            pstmt.setString(4, user_gender);
            pstmt.setString(5, user_email);
            //pstmt.executeUpdate();
            int res = pstmt.executeUpdate();
            if(res == 1)
            	System.out.println("데이터 삽입 성공!!!");
        }
        catch(Exception e) {
            System.out.println("이미 입력된 사원입니다! = "+e.getMessage());
        }
        finally {
            try {
                if(con != null) con.close( );
                if(pstmt != null) pstmt.close( );
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
	
	static void output_sawon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
		Connection con = null;
		Statement stmt  = null;
		ResultSet rs = null;
		
		String sql = "Select * from sawon";
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("\t          *** 사원정보 ***");
			System.out.println("===========================================================");
			System.out.println("사원번호    부서명       이름         성별               이메일");
			System.out.println("===========================================================");
			while(rs.next()) {
				System.out.print(rs.getString("sabun") + "\t   ");
				System.out.print(rs.getString("deptname") + "       ");
				System.out.print(rs.getString("irum") + "         ");
				System.out.print(rs.getString("gender") +"               ");
				System.out.print(rs.getString("email"));
			}
			System.out.println("\n===========================================================\n\n");
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 !");
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
	
	static void search_sawon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
		
		Connection con = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		
		String sql = "Select * from sawon where sabun = ?";
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner scan = new Scanner(System.in);
			
			System.out.printf("검색할 사번을 입력하세요 => ");
			String sabun = scan.next();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
	        rs = pstmt.executeQuery();
			
			System.out.println("\t          *** 사원정보 ***");
			System.out.println("===========================================================");
			System.out.println("사원번호    부서명       이름         성별               이메일");
			System.out.println("===========================================================");
			if(rs.next()) {
				System.out.print(rs.getString("sabun") + "\t   ");
				System.out.print(rs.getString("deptname") + "       ");
				System.out.print(rs.getString("irum") + "         ");
				System.out.print(rs.getString("gender") +"               ");
				System.out.print(rs.getString("email"));
				System.out.println("\n===========================================================\n\n");
			}
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 !");
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	
	static void update_sawon()
	{
		Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Update sawon Set deptname = ?, email = ? Where sabun = ?";
		
		
        try {
        	Scanner scan = new Scanner(System.in);
        	Sawon obj = new Sawon();
        	
        	System.out.println("sawon 테이블에 값 수정하기 .....");
        	System.out.print("사번 입력 : ");
        	obj.sabun = scan.next();
            System.out.print("수정할 부서 입력 : ");
            obj.deptname = scan.next();
            System.out.print("수정할 이메일 입력 : ");
            obj.email = scan.next();

            con = connectDB();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, obj.deptname);
            pstmt.setString(2, obj.email);
            pstmt.setString(3, obj.sabun);
            int res = pstmt.executeUpdate();
            
            if(res == 1) 
            	System.out.println("\n데이터 수정 성공!!!\n");
            else
            	System.out.println("\n존재하지 않는 사원번호입니다.\n");
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
        }
        finally {
            try {
                if(con != null) con.close( );
                if(pstmt != null) pstmt.close( );
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
	
	static void delete_sawon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
        Connection con = null;
        PreparedStatement pstmt = null;
        String user_sabun = null;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("usertbl 테이블 값 삭제하기 .....");
            System.out.print("삭제할 사번 입력 : ");
            user_sabun = br.readLine( );

            String sql = "Delete From sawon Where sabun = ?";
            System.out.println(sql);

            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pw);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_sabun);
            pstmt.executeUpdate();
            System.out.println("데이터베이스 내용 삭제 성공!");
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!"+e.getMessage());
        }

        finally {
            try {
                if(pstmt != null) pstmt.close( );
                if(con != null) con.close( );
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }

	}
}