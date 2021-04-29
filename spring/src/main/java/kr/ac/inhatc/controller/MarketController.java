package kr.ac.inhatc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inhatc.dto.MemberDto;
import kr.ac.inhatc.service.MarketService;

@Controller
public class MarketController {
	@Autowired
	MarketService marketService;
	
	@RequestMapping("/welcome.do")
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.setViewName("welcome");
		return mv;
	}
	
	@RequestMapping("/member/loginMember.do")
	public ModelAndView loginMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/loginMember");
		return mv;
	}
	
	@RequestMapping("/member/processLoginMember.do")
	public ModelAndView processLoginMember(HttpServletRequest request,MemberDto dto) throws Exception{
		System.out.println(dto);
		dto = marketService.processLoginMember(dto);
		System.out.println(dto);
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", dto.getName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.setViewName("welcome");
		return mv;
	}
	
	@RequestMapping("/member/addMember.do")
	public ModelAndView addMember() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/addMember");
		return mv;
	}
	// /member/processAddMember.do
	@RequestMapping("/member/processAddMember.do")
	public ModelAndView processAddMember(MemberDto dto) throws Exception{
		System.out.println(dto);
		marketService.processAddMember(dto);
		return loginMember();
	}
}
