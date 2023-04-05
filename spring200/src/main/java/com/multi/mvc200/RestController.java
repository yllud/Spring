package com.multi.mvc200;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	@RequestMapping("json1")
	@ResponseBody	//요청을받으면 return되는 데이터를 json으로 만들어서 다시 보내줌
	public MemberVO json1() {
		MemberVO bag=new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		return bag;	//{"id":"root", "pw":"1234", ...}
	}
	
	@RequestMapping("json2")
	@ResponseBody
	public BbsVO json2() {
		BbsVO bag=new BbsVO();
		bag.setNo(0);
		bag.setTitle("제목");
		bag.setWriter("hong");
		bag.setContent("내용!");
		
		return bag;
	}
	
	@RequestMapping("json3")
	@ResponseBody
	public ArrayList<MemberVO> json3() {
		MemberVO bag = new MemberVO();
		bag.setId("root");
		bag.setPw("1234");
		bag.setName("hong");
		bag.setTel("011");
		MemberVO bag2 = new MemberVO();
		bag2.setId("root2");
		bag2.setPw("12342");
		bag2.setName("hong2");
		bag2.setTel("0112");
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(bag);
		list.add(bag2);
		
		return list;  //{"id" : "root", "pw" : "1234", "name" : "hong", "tel":"011"}
	}
	
	@RequestMapping("json4")
	@ResponseBody
	public String json4() {
		JSONObject json = new JSONObject();
		json.put("high", "10000");
		json.put("low", "8000");
		json.put("end", "9000");

		//out.print(json.toJSONString());

		JSONObject json2 = new JSONObject();
		json2.put("high", "9000");
		json2.put("low", "70000");
		json2.put("end", "8000");

		JSONArray array = new JSONArray();
		array.add(json);
		array.add(json2);
		
		return array.toString();  //{"id" : "root", "pw" : "1234", "name" : "hong", "tel":"011"}
	}
}
