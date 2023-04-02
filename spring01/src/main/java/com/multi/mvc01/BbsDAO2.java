package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BbsDAO2 {
	public int insert(BbsVO bag) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql 연결할 부풀 설정
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!

			// 2.mysql에 연결해보자.(java --- mysql)
			// String url="jdbc:oracle:thin:@localhost:1521:xe"; //오라클
			// String url = "jdbc:mysql://localhost:3306/multi"; //mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC"; // mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting mysql");

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// 자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!!
			String sql = "insert into multi.BBS(title, content, writer) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R빼고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			//ps.setInt(1,bag.getNo());
			ps.setString(1, bag.getTitle());
			ps.setString(3, bag.getWriter());
			ps.setString(2, bag.getContent());
			System.out.println("3. create sql object");

			result = ps.executeUpdate();
			System.out.println("4. success sending to sql oracle");
			if (result == 1) {
				System.out.println("success insert");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql 연결할 부풀 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!

			// 2.mysql에 연결해보자.(java --- mysql)
			// String url = "jdbc:mysql://localhost:3306/multi"; //mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC"; // mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			String sql = "delete from multi.BBS where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R빼고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setInt(1, no);
			System.out.println("3. create sql object");

			result = ps.executeUpdate();
			System.out.println("4. success sending to sql oracle");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;

	}

	public int update(BbsVO bag) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql 연결할 부풀 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!

			// 2.mysql에 연결해보자.(java --- mysql)
			// String url = "jdbc:mysql://localhost:3306/multi"; //mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC"; // mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			String sql = "update multi.BBS set content=? where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R빼고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setString(1, bag.getContent());
			ps.setInt(2, bag.getNo());
			System.out.println("3. create sql object");

			result = ps.executeUpdate();
			System.out.println("4. success sending to sql oracle");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);
		return result;

	}

	public BbsVO select(int no) {
		// TODO Auto-generated method stub
		ResultSet rs = null; //
		BbsVO bag = null;
		try {
			// 1.mysql 연결할 부풀 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!

			// 2.mysql에 연결해보자.(java --- mysql)
			// String url = "jdbc:mysql://localhost:3306/multi"; //mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC"; // mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			// (String id, String pw, String name,String tel)
			String sql = "select * from multi.BBS where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R빼고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setInt(1, no);
			System.out.println("3. create sql object");

			rs = ps.executeQuery();
			System.out.println("4. success sending to sql oracle");
			if (rs.next()) {

				System.out.println("There are select results");
				int no2 = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(4);
				String content = rs.getString(3);
				

				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setWriter(writer);
				bag.setContent(content);
			} else {
				System.out.println("no result");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bag;

	}

	public ArrayList<BbsVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		// ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<BbsVO> list = new ArrayList<>();

		BbsVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!

			// 2.mysql에 연결해보자.(java --- mysql)
			// String url = "jdbc:mysql://localhost:3306/multi"; //mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC"; // mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공.");

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// 자바는 부품조립식이여서,String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!!

			String sql = "select * from multi.BBS";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// 삭제!!!! ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				// 1. 검색겨로가가 있으면,
				// System.out.println("검색결과 있음. 성공.");
				// 2. 각 컬럼에서 값들을 꺼내오자.
				int no = rs.getInt(1); // id
				String title = rs.getString(2); // pw
				String content = rs.getString(3); // name
				String writer = rs.getString(4); // tel
				// System.out.println( id2 + " "
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				// 검색결과를 검색화면 UI부분을 주어야 함.
				// 3. 가방을 만들자.
				bag = new BbsVO();
				bag.setNo(no);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);

				// 4. list에 bag을 추가해주자.
				list.add(bag);
			}
			// System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel은 XXXXX!
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함.
		// 검색결과가 있을 때는 bag에 데이터가 들어있음.
		// 검색결과가 없을 때는 bag에 무엇이 들어있나? null
		return list;

	}
}
