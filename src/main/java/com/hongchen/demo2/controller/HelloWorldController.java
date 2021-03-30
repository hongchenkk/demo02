package com.hongchen.demo2.controller;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hongchen.demo2.model.User;
import com.hongchen.demo2.prop.HongchenProp;
import com.hongchen.demo2.service.UserService;
import com.hongchen.demo2.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController {
	
	@Autowired
	private HongchenProp hongchenProp;

	@GetMapping("/hello")
	public String index() {
		return "Hello World";
	}
	
	@GetMapping("/new/user")
	public UserVo getUserVo() {
		UserVo userVo = new UserVo();
		userVo.setName("ch");
		userVo.setAge(12);
		userVo.setSex(Boolean.TRUE);
		userVo.setHop("爱唱歌");
		return userVo;
	}
	
	@GetMapping("/prop1")
	public HongchenProp getHongchenProp() {
		return hongchenProp;
	}
	
	@Autowired
	private ApplicationArguments args;
	
	@GetMapping("/args")
	public List<String> getArgs() {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		log.info("debug: {}", debug);
		return files;
	}
	
	@GetMapping("/system/var")
	public String getVmOrSystemVar() {
		return System.getProperty("com.hongchen.name");
	}
	
	@Value("${com.hongchen.name}")
	private String nameByVal;
	@Value("${com.hongchen.title}")
	private String titleByVal;
	@Value("${paname}")
	private String panameByVal;
	@Value("${palike}")
	private String palikeByVal;
	
	@GetMapping("/byvalue/pair")
	public ImmutablePair<String, String> getPropersByValuePair() {
		ImmutablePair<String, String> pair = ImmutablePair.of(nameByVal, palikeByVal);
		log.info("byvalue-pair:[{}|{}]", pair.getLeft(), pair.getRight());
		return pair; 
	}
	
	@GetMapping("/byvalue/triple")
	public ImmutableTriple<String, String, String> getPropersByValueTriple() {
		ImmutableTriple<String, String, String> triple = ImmutableTriple.of(nameByVal, titleByVal, panameByVal);
		log.info("byvalue-triple:[{}|{}|{}]", triple.getLeft(), triple.getMiddle(), triple.getRight());
		return triple;
	}
	
	@Autowired
	private UserService userService;
	@GetMapping("/async/task1")
	public String getAysncTask1() {
		log.info("getAysncTask1->start");
		User user = new User();
		user.setName("chong");
		user.setAge(26);
		user.setOk(true);
		userService.asyncTask1(user);
		log.info("getAysncTask1->end");
		return "has done!";
	}
}
