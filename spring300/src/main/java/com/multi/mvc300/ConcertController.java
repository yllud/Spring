package com.multi.mvc300;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ConcertController {
	
	@Autowired
	ConcertDAO dao;
	
	@RequestMapping("concertInsert")
	public void concertInsert(ConcertVO bag,Model model) {
		dao.insert(bag);
		System.out.println("공연 추가 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		model.addAttribute("bag",bag);
	}
	
	@RequestMapping("concertUpdate")
	public void concertUpdate(ConcertVO bag,Model model) {
		dao.update(bag);
		System.out.println("공연 수정 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		model.addAttribute("bag",bag);
	}
	
	@RequestMapping("concertDelete")
	public void concertDelete(int no,Model model) {
		dao.delete(no);
		System.out.println("공연 삭제 요청됨");
		System.out.println(no);
		model.addAttribute("no",no);
	}
	
	@RequestMapping("concertOne")
	public void concertOne(int no,Model model) {
		ConcertVO bag= dao.one(no);
		System.out.println("공연 삭제 요청됨");
		System.out.println(no);
		model.addAttribute("bag", bag);
	}
	
	@RequestMapping("concertList")
	public void concertList(Model model) {
		List<ConcertVO> list=dao.list();
		model.addAttribute("list", list);
	}
	

	
	
}
