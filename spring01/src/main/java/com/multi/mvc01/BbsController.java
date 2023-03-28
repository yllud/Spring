package com.multi.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BbsController {
	
	@Autowired
	BbsDAO2 dao;
	
	@RequestMapping("bbs_insert")
	public void bbs_insert(BbsVO bag) {
		dao.insert(bag);
		System.out.println("게시판추가 ㅇㅇ요청됨");
		System.out.println(bag);
		System.out.println(dao);
	}
	
	@RequestMapping("bbs_update")
	public void bbs_update(BbsVO bag) {
		dao.update(bag);
		System.out.println("게시판 수정 요청됨");
		System.out.println(bag);
		System.out.println(dao);
	}
	
	@RequestMapping("bbs_delete")
	public void bbs_delete(int no) {
		dao.delete(no);
		System.out.println("게시판 삭제 요청됨");
		System.out.println(no);
	}
	
	@RequestMapping("bbs_one")
	public void bbs_one(int no) {
		System.out.println("게시판 검색 요청됨");
		System.out.println(no);
	}
	
	
}
