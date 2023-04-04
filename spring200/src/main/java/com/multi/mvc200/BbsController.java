package com.multi.mvc200;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BbsController {
	
	@Autowired
	BbsDAO2 dao;
	
	@Autowired
	ReplyDAO dao2;
	
//	@RequestMapping("bbs_insert")
//	public void bbs_insert(BbsVO bag) {
//		dao.insert(bag);
//		System.out.println("野껊슣�뻻占쎈솇�빊遺쏙옙 占쎈�뗰옙�뗰옙�뒄筌ｏ옙占쎈쭡");
//		System.out.println(bag);
//		System.out.println(dao);
//	}
//	
//	@RequestMapping("bbs_update")
//	public void bbs_update(BbsVO bag) {
//		dao.update(bag);
//		System.out.println("野껊슣�뻻占쎈솇 占쎈땾占쎌젟 占쎌뒄筌ｏ옙占쎈쭡");
//		System.out.println(bag);
//		System.out.println(dao);
//	}
//	
//	@RequestMapping("bbs_delete")
//	public void bbs_delete(int no) {
//		dao.delete(no);
//		System.out.println("野껊슣�뻻占쎈솇 占쎄텣占쎌젫 占쎌뒄筌ｏ옙占쎈쭡");
//		System.out.println(no);
//	}
	
	
	@RequestMapping("bbsOne")
	public void bbs_one(int no,Model model) {
		System.out.println("野껊슣�뻻占쎈솇 野껓옙占쎄퉳 占쎌뒄筌ｏ옙占쎈쭡");
		System.out.println(no);
		BbsVO bag=dao.select(no);
		ArrayList<ReplyVO> list=dao2.list(no);
		
		model.addAttribute("bag", bag);
		model.addAttribute("list", list);
	}
	
	
	
	@RequestMapping("bbs_list")
	public void bbs_list(Model model) {
		//System.out.println("list 불러옴");
		ArrayList<BbsVO> list=dao.list();
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("bbs_list_writer")
	public void bbs_list_writer(String writer,Model model) {
		System.out.println("writer success");
		ArrayList<BbsVO> list=dao.listWriter(writer);
		model.addAttribute("list", list);
		
	}

	
	
}
