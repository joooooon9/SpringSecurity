package com.example.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository repository;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @AuthenticationPrincipal UserDetail user) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println(user.getNickname());
		System.out.println(user.getPassword());
		System.out.println(user.getNickname());
		System.out.println(user.getAuthorities());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
//		Authentication a = SecurityContextHolder.getContext().getAuthentication();
//		if(a != null) {
//			UserDetail d = (UserDetail)a.getPrincipal();
//			System.out.println(d.getUsername());
//			System.out.println(d.getPassword());
//			System.out.println(d.getNickname());
//			System.out.println(d.getAuthorities());
//		}
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(UserEntity vo) {
		
		vo.setPassword(encoder.encode(vo.getPassword()));
		System.out.println(vo.getPassword());
		repository.save(vo);
		
		//회원가입 할 때 md5 암호화
		//조회할 때 데이터베이스에 id, pw 넘기고 pw를 md5암호화
		
		//id만을 이용해서 데이터베이스에서 조회
		//id, pw
		//사용자가 넘겨준 pw
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
