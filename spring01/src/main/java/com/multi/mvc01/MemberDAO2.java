package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;


@Component	//객체를 싱글톤으로 만들어줌
public class MemberDAO2 {

	public int insert(MemberVO bag) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql ?��결할 �??? ?��?��
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //�? locale?��?��?��?�� 분들�?!!!

			// 2.mysql?�� ?��결해보자.(java --- mysql)
			//String url="jdbc:oracle:thin:@localhost:1521:xe";						//?��?��?��
			//String url = "jdbc:mysql://localhost:3306/multi";						//mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC";	//mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting mysql");

			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//?��바는 �??��조립?��?��?��?��,String?�� ?��?? 문자?��?�� ?��?��?�� �??��?���? ?��?��?���? 못함.
			//?��?��?�� �??��?���? ?��?��?��?���? �? �??��?���? 만들?��주어?�� ?��?��.
			//SQL�??��?���? 만들?��주어?�� ?��.
			//PreparedStatement�? SQL�??��!!
			String sql = "insert into multi.MEMBER values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//con�??��?���? sql?��?��링에 ?��?�� �? SQL�??��?���? 만들?��주세?��.
			//R빼고, ?��?��?�� 0�??�� ?��?��!!
			//?��?��?���? db?�� ?��?��?���? 1�??�� ?��?��!!
			//2. �?방에?�� 값들?�� ?��?��?�� 꺼내?��?��?��. 
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. create sql object");

			result = ps.executeUpdate();
			System.out.println("4. success sending to sql oracle");
			if (result == 1) {
				System.out.println("success sign up");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql ?��결할 �??? ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //�? locale?��?��?��?�� 분들�?!!!

			// 2.mysql?�� ?��결해보자.(java --- mysql)
			//String url = "jdbc:mysql://localhost:3306/multi";						//mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC";	//mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			String sql = "delete from multi.MEMBER where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);
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

	public int update(MemberVO bag) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1.mysql ?��결할 �??? ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //�? locale?��?��?��?�� 분들�?!!!

			// 2.mysql?�� ?��결해보자.(java --- mysql)
			//String url = "jdbc:mysql://localhost:3306/multi";						//mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC";	//mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			String sql = "update multi.MEMBER set tel=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//con�??��?���? sql?��?��링에 ?��?�� �? SQL�??��?���? 만들?��주세?��.
			//R빼고, ?��?��?�� 0�??�� ?��?��!!
			//?��?��?���? db?�� ?��?��?���? 1�??�� ?��?��!!
			//2. �?방에?�� 값들?�� ?��?��?�� 꺼내?��?��?��. 
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
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

	public MemberVO one(String id) {
		// TODO Auto-generated method stub
		ResultSet rs = null; //
		MemberVO bag = null;
		try {
			// 1.mysql ?��결할 �??? ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //�? locale?��?��?��?�� 분들�?!!!

			// 2.mysql?�� ?��결해보자.(java --- mysql)
			//String url = "jdbc:mysql://localhost:3306/multi";						//mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC";	//mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("2. success connecting oracle");

			// (String id, String pw, String name,String tel)
			String sql = "select * from multi.MEMBER where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);
			System.out.println("3. create sql object");

			rs = ps.executeQuery();
			System.out.println("4. success sending to sql oracle");
			if (rs.next()) {
				
				System.out.println("There are select results");
				String id2 = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println(id2 + "\t" + pw + "\t" + name + "\t" + tel + "\t");

				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("no result");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return bag;

	}

	public ArrayList<MemberVO> list() {
		ResultSet rs = null; //?��목명 + 결과 ?��?��?���? ?���? ?��?�� ?��?���? 
		
		//�?방들 ?��?���? ?�� 컨테?��?�� ?��?��?�� �??��?�� ?��?��!
		//ArrayList<MemberVO> ==> MemberVO�? ?��?���? arraylist?��?�� ?���?
		ArrayList<MemberVO> list = new ArrayList<>();
		
		MemberVO bag = null;
		try {
			// 1.?��?��?�� 11g?? ?��결한 �??�� ?��?��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. success mysql setting");
//			Locale.setDefault(Locale.US); //�? locale?��?��?��?�� 분들�?!!!

			// 2.mysql?�� ?��결해보자.(java --- mysql)
			//String url = "jdbc:mysql://localhost:3306/multi";						//mysql 5버전
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezome=UTC";	//mysql 8버전
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("?��름입?��"); //String, ?��?��무개 
			System.out.println("2. ?��?��?�� ?���? ?���?.");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//?��바는 �??��조립?��?��?��?��,String?�� ?��?? 문자?��?�� ?��?��?�� �??��?���? ?��?��?���? 못함.
			//?��?��?�� �??��?���? ?��?��?��?���? �? �??��?���? 만들?��주어?�� ?��?��.
			//SQL�??��?���? 만들?��주어?�� ?��.
			//PreparedStatement�? SQL�??��!!
			
			String sql = "select * from multi.MEMBER";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			// ps.setString(1, id);
			System.out.println("3. SQL�? �??��(객체)?���? 만들?��주기 ?���?.");
			
			rs = ps.executeQuery(); //select�? ?��?��?��  
			System.out.println("4. SQL�? ?��?��?���? 보내�? ?���?.");
			while(rs.next()) { //�??��결과�? ?��?���? ?���??�� rs.next() 
				//true?���? ?��?��?��?�� ?���?, false?���? ?��?��?��?�� ?���? 
				//1. �??��겨로�?�? ?��?���?, 
				//System.out.println("�??��결과 ?��?��. ?���?.");
				//2. �? 컬럼?��?�� 값들?�� 꺼내?��?��. 
				String id = rs.getString(1); //id
				String pw = rs.getString(2); //pw
				String name = rs.getString(3); //name
				String tel = rs.getString(4); //tel
				//System.out.println(	id + " " 
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				//�??��결과�? �??��?���? UI�?분을 주어?�� ?��.
				//3. �?방을 만들?��.
				bag = new MemberVO();
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				//4. list?�� bag?�� 추�??��주자.
				list.add(bag);
			}
			//System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return id, pw, name, tel?? XXXXX!
		//return ?��?��?�� 반드?�� ?��?�� ?��?��?���? 묶어?�� 리턴?��주어?�� ?��.
		//�??��결과�? ?��?�� ?��?�� bag?�� ?��?��?���? ?��?��?��?��. 
		//�??��결과�? ?��?�� ?��?�� bag?�� 무엇?�� ?��?��?��?��? null
		return list;
		
	}
}
