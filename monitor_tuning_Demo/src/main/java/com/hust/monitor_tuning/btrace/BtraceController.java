package com.hust.monitor_tuning.btrace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hust.monitor_tuning.monitortools.User;

@RestController
@RequestMapping("btrace")
public class BtraceController {
	
	@RequestMapping("/constructor")
	public User constructor( User user) {
		return user;
	}
	
	
	@RequestMapping("/arg1")
	public String arg1(@RequestParam("name")String name) {
		return "hello,"+name;
	}
	
	@RequestMapping("/arg2")
	public User arg2(User user) {
		return user;
	}
	
	
	
	@RequestMapping("/same1")
	public String same(@RequestParam("name")String name) {
		return "hello,"+name;
	}
	@RequestMapping("/same2")
	public String same(@RequestParam("name")String name,@RequestParam("id")int id) {
		return "hello,"+name+","+id;
	}
	
	@RequestMapping("/exception")
	public String exception() {
		try {
			// 即使这里异常进行捕捉了，btrace仍然可以拿到异常
			System.out.println("start...");
			System.out.println(1/0);
			System.out.println("end...");
		}catch(Exception e) {
			
		}
		return "success";
	}

}
