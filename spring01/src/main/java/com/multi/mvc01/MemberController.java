package com.multi.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void one(String id,Model model) {
		System.out.println("one요청됨");
		System.out.println(id);
		MemberVO bag=dao.one(id);
		model.addAttribute("bag", bag);
	}
	@RequestMapping("list")
	public void list() {
		System.out.println("lise요청됨");
	}
	
	@RequestMapping("login")
	public String login(MemberVO bag) {
		System.out.println("login요청됨");
		System.out.println(bag);
		int result=dao.login(bag);	//로그인 성공하면 1, 아니면 0
		
		if(result==1) {
			return "login_ok";
		}else {
			return "login_no";
		}
	}
	
	
}
