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
		if(dto!=null) {
			session.setAttribute("sessionId", dto.getName());
			session.setAttribute("userId", dto.getId());
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.setViewName("welcome");
		return mv;
	}
	
	@RequestMapping("/member/logoutMember.do")
	public ModelAndView logoutMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return loginMember();
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
	
	@RequestMapping("/member/updateMember.do")
	public ModelAndView updateMember(HttpServletRequest request) throws Exception{
		MemberDto member = new MemberDto();
		HttpSession session = request.getSession();
		member.setId(session.getAttribute("userId").toString());
		System.out.println(member);
		member = marketService.processInfoMember(member);
		System.out.println(member);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", member);
		mv.setViewName("member/updateMember");
		return mv;
	}
	///member/processUpdateMember.do
	@RequestMapping("/member/processUpdateMember.do")
	public ModelAndView processUpdateMember(HttpServletRequest request, MemberDto dto) throws Exception{
		System.out.println(dto);
		marketService.processUpdateMember(dto);
		System.out.println(dto);
		return updateMember(request);
	}
	
	@RequestMapping("/member/deleteMember.do")
	public ModelAndView deleteMember(HttpServletRequest request, MemberDto dto) throws Exception{
		HttpSession session = request.getSession();
		dto.setId(session.getAttribute("userId").toString());
		marketService.deleteMember(dto);
		return logoutMember(request);
	}
}
