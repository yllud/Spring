package com.multi.myStagebox;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO { // CRUD

	// mybatis 싱글톤 객체 찾아서 주소 넣어줌
	@Autowired
	SqlSessionTemplate my;

//특정한 방법으로 실행하는 클래스(model, 방법) 
//	public int login(MemberVO bag) {
//		return result;
//	}
//
//	public ArrayList<MemberVO> list() {
//		return list;
//	}
//
//	// 메서드를 만드는 것 ==> 메서드 정의(define)!
//	// 메서드를 정의했다고 실행되는 것은 아니다.!
//	// 메서드를 쓰는 것 ==> 메서드 호출(call)!

	public int insert(MemberVO bag) {
		int result = my.insert("member.create", bag);
		return result;
	}

	public int update(MemberVO bag) {
		int result=my.update("member.up",bag);
		return result;
	}
	
	public int delete(String id) {
		int result = my.delete("member.del", id);
		return result;
	}
	
	public MemberVO one(String id) {
		MemberVO bag=my.selectOne("member.one", id);
		System.out.println(bag);
		return bag;
	}
	
	public List<MemberVO> list(){
		List<MemberVO> list=my.selectList("member.all");
		
		return list;
	}

}