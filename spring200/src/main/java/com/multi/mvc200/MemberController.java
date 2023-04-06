package com.multi.mvc200;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
//	public BbsVO bbs_one_json(int no) {
//		System.out.println("野껊슣�뻻占쎈솇 野껓옙占쎄퉳 占쎌뒄筌ｏ옙占쎈쭡");
//		System.out.println(no);
//		BbsVO bag=dao.select(no);
//		return bag;
//
//	}
	
	@RequestMapping("memberOne_json")
	@ResponseBody
	public MemberVO memberOne_json(String id) {
		System.out.println("one요청됨");
		System.out.println(id);
		MemberVO bag=dao.one(id);
		return bag;
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		System.out.println("list요청됨");
		
		ArrayList<MemberVO> list=dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("list_json")
	@ResponseBody
	public ArrayList<MemberVO> list() {
		System.out.println("list요청됨");
		ArrayList<MemberVO> list=dao.list();
		return list;
	}
	
	@RequestMapping("login")
	public String login(MemberVO bag, HttpSession session) {
		System.out.println("login요청됨");
		System.out.println(bag);
		int result=dao.login(bag);	//로그인 성공하면 1, 아니면 0
		
		
		if(result==1) {
			session.setAttribute("id", bag.getId());
			return "login_ok";
		}else {
			return "login_no";
		}
	}
	
//	@RequestMapping("jsonResponse5")
//	@ResponseBody // 요청을 받으면 return되는 데이터를 json으로 만들어서 요청하는 곳으로 다시 보냄,
//	public MapVO kakaoMap() {
//		MapVO bag = new MapVO();
//		bag.setLat(37.5117);
//		bag.setLon(127.0592);
//		
//		System.out.println(bag);
//		return bag;
//	}
	
	
}
