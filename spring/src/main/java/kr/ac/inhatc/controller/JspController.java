package kr.ac.inhatc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inhatc.dto.BoardDto;
import kr.ac.inhatc.service.BoardService;

@Controller
public class JspController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String hello(Model model, String id) {
		model.addAttribute("data", "sample data");
		model.addAttribute("data2", "korea");
		model.addAttribute("id", id);
		return "hello";
	}
	//파라미터로 id를 입력 받고
	//이 id를 화면에서 출력?
	@RequestMapping("testdb.do")
	public String board(Model model, 
			@RequestParam(name = "searchKeyword",required = false,defaultValue = "연습페이지")String id) {
		model.addAttribute("id",id);
		try {
			List<?> l = boardService.selectSubjectList(id,1);
			//int count = boardService.selectSubjectListCount(id);
			model.addAttribute("subjectList",l);
			//model.addAttribute("count",count);
			System.out.println(l.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board2";
	}
	@RequestMapping("testdb2")
	public String board2(Model model, 
			@RequestParam(name = "test",required = false,defaultValue = "연습페이지")String id) {
		model.addAttribute("id",id);
		try {
			List<BoardDto> l = boardService.selectSubjectList2("심리학");
			model.addAttribute("subjectList",l);
			System.out.println(l.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board3";
	}
	@RequestMapping("testdb")
	public ModelAndView board1( 
			@RequestParam(name = "searchKeyword",required = false,defaultValue = "")String id,
			@RequestParam(name = "page",required = false,defaultValue = "1")Integer page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("board4");
		try {
			List<?> l = boardService.selectSubjectList(id, page);
			int count = boardService.selectSubjectListCount(id);
			mv.addObject("cnt",count);
			mv.addObject("selectSubjectList",l);
			System.out.println(l.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/boardDetail.do")
	public ModelAndView boardDetail(String no)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "상세");
		mv.setViewName("boardDetail");
		mv.addObject("detail",boardService.boardDetail(no));
		return mv;
	}
	@RequestMapping("/regSubject.do")
	public ModelAndView regSubject()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "등록");
		mv.setViewName("boardDetail");
		return mv;
	}
	@RequestMapping("/insertSubject.do")
	public ModelAndView insertSubject(String subject, String grade, 
			String useYn, String description, String regUser)throws Exception{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("subject",subject);
		hashMap.put("grade",grade);
		hashMap.put("useYn",useYn);
		hashMap.put("description",description);
		hashMap.put("regUser",regUser);
		boardService.insertSubject(hashMap);
		return boardDetail("");
	}
	
	@RequestMapping("/modifySubject.do")
	public ModelAndView modifySubject(String id,String subject, String grade, 
			String useYn, String description, String regUser)throws Exception{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("subject",subject);
		hashMap.put("grade",grade);
		hashMap.put("useYn",useYn);
		hashMap.put("description",description);
		hashMap.put("regUser",regUser);
		hashMap.put("id", id);
		boardService.modifySubject(hashMap);
		return boardDetail("id");
	}
	@RequestMapping("/deleteSubject.do")
	public ModelAndView deleteSubject(String id) throws Exception {
		boardService.deleteSubject(id);
		return board1("",1);
	}
}
