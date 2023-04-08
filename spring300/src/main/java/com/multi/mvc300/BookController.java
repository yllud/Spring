package com.multi.mvc300;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	
	@Autowired
	BookDAO dao;
	
	@RequestMapping("bookInsert")
	public void bookInsert(BookVO bag) {
		
		dao.insert(bag);
		
		System.out.println("insert요청");
		System.out.println(bag);
		System.out.println(dao);
	}
	
	@RequestMapping("bookOne")
	public void bookOne(String id,Model model) {
		BookVO bag=dao.one(id);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("bookList")
	public void bookList(Model model) {
		ArrayList<BookVO> list=dao.list();
		System.out.println("리스트"+list);
		model.addAttribute("list", list);
	}
	
	
//	@RequestMapping("login")
//	public String login(MemberVO bag) {
//		System.out.println("login요청");
//		System.out.println(bag);
//		int result=dao.login(bag);
//		
//		if(result==1) {
//			return "login_ok";
//		}else {
//			return "login_no";
//		}
//	}
	
	
}
