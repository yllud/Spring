package com.multi.mvc01;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {

	
	@RequestMapping("foodLike")
	public String foodlike(String like) {	
		System.out.println("좋어하는 음식"+like);
		if(like.equals("커피")) {
			return "foodCoffee";
		}
		else {
			return "redirect:food.jsp";
		}
		
		
	}

	
	
}
