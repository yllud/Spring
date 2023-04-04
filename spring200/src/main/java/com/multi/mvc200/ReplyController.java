package com.multi.mvc200;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ReplyController {

	@Autowired
	ReplyDAO dao;
	
	
	@RequestMapping("reply_insert")
	@ResponseBody
	public void insert(ReplyVO vo) {
		System.out.println(vo);
		dao.insert(vo);
	}
	
	@RequestMapping("reply_list")
	public void reply_list(int bbsno,Model model) {
		System.out.println("�뵳�딅뮞占쎈뱜占쎌뒄筌ｏ옙");
		ArrayList<ReplyVO> list=dao.list(bbsno);
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("reply_list_writer")
	public void bbs_list_writer(String writer,Model model) {
		System.out.println("writer success");
		ArrayList<ReplyVO> list=dao.listWriter(writer);
		model.addAttribute("list", list);
		
	}
}