package com.multi.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	
	@Autowired	//싱글톤으로 만든 다오의 주소를 넣어줌
	MemberDAO2 dao;
	
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		
		dao.insert(bag);
		
		System.out.println("insert요청됨");
		System.out.println(bag);
		System.out.println(dao);
	}
	
	@RequestMapping("update")
	public void update(MemberVO bag) {
		dao.update(bag);
		System.out.println("update요청됨");
		System.out.println(bag);
	}
	
	@RequestMapping("delete")
	public void delete(String id) {
		dao.delete(id);
		System.out.println("delete요청됨");
		System.out.println(id);
	}
	
	@RequestMapping("one")
	public void one(String id) {
		System.out.println("one요청됨");
		System.out.println(id);
	}
	@RequestMapping("list")
	public void list() {
		System.out.println("lise요청됨");
	}
	
	
}
