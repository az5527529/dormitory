package com.controller;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.A;
import com.service.TestSpringService;

@Controller
@RequestMapping("/a")
public class AController {
	@Resource
	private TestSpringService testSpringService;
	
	@RequestMapping(value="/show", method = RequestMethod.POST)
	@ResponseBody
	public  String list(){
		Random r1 = new Random(10);
		A a = new A();
		a.setAaid(r1.nextInt(1000)+"");
		a.setName('f');
		testSpringService.saveA(a);
		System.out.println("进入a");
		return "/pages/b.jsp";
	}	
}
