package kr.ac.inhatc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inhatc.dto.MemberDto;
import kr.ac.inhatc.dto.ProductDto;
import kr.ac.inhatc.service.MarketService;

@Controller
public class MarketController {
	@Autowired
	MarketService marketService;
	
	private static final Logger log = LoggerFactory.getLogger(MarketController.class);

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
	public ModelAndView processLoginMember(HttpServletRequest request,MemberDto member) throws Exception{
		System.out.println(member);
		member = marketService.processLoginMember(member);
		System.out.println(member);
		HttpSession session = request.getSession();
		if(member!=null) {
			session.setAttribute("sessionId", member.getName());
			session.setAttribute("userId", member.getId());
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
	public ModelAndView processAddMember(MemberDto member) throws Exception{
		System.out.println(member);
		marketService.processAddMember(member);
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
	public ModelAndView processUpdateMember(HttpServletRequest request, MemberDto member) throws Exception{
		System.out.println(member);
		marketService.processUpdateMember(member);
		System.out.println(member);
		return updateMember(request);
	}
	
	@RequestMapping("/member/deleteMember.do")
	public ModelAndView deleteMember(HttpServletRequest request, MemberDto member) throws Exception{
		marketService.deleteMember(member);
		HttpSession session = request.getSession();
        session.invalidate();
		return welcome(request);
	}
	//debug -> info -> warn ->error
	@RequestMapping("/products.do")
	public ModelAndView products(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("products");
        List<ProductDto> list = marketService.listProducts();
        mv.addObject("list", list);
        log.info(list.toString());
        return mv;
	}
	@RequestMapping("/addProduct.do")
	public ModelAndView addProduct(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.setViewName("addProduct");
		return mv;
	}
	@RequestMapping("/product/processAddProduct.do")
	public ModelAndView processAddProduct(ProductDto dto, 
			MultipartFile productImage,
			HttpServletRequest request) throws Exception{
		marketService.saveImage(dto, productImage);
		marketService.processAddProduct(dto);
		return products(request);
	}
	// /editProduct.do
	@RequestMapping("/editProduct.do")
	public ModelAndView editProduct(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("editProduct");
        List<ProductDto> list = marketService.listProducts();
        mv.addObject("list", list);
        log.info(list.toString());
        return mv;
	}
	// /updateProduct.do
	@RequestMapping("/updateProduct.do")
	public ModelAndView updateProduct(HttpServletRequest request, ProductDto dto) throws Exception {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("updateProduct");
        dto = marketService.getProduct(dto);
        mv.addObject("dto", dto);
        log.info(dto.toString());
        return mv;
	}
	// /processUpdateProduct.do
	@RequestMapping("/processUpdateProduct.do")
	public ModelAndView processUpdateProduct(ProductDto dto, 
			MultipartFile productImage,
			HttpServletRequest request) throws Exception{
		marketService.saveImage(dto, productImage);
		marketService.processUpdateProduct(dto);
		return products(request);
	}
	// /deleteProduct.do
	@RequestMapping("/deleteProduct.do")
	public ModelAndView deleteProduct(ProductDto dto, 
			MultipartFile productImage,
			HttpServletRequest request) throws Exception{
		marketService.deleteProduct(dto);
		return editProduct(request);
	}
	// /product.do
	@RequestMapping("/product.do")
	public ModelAndView product(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("product");
        List<ProductDto> list = marketService.listProducts();
        mv.addObject("list", list);
        log.info(list.toString());
        return mv;
	}
}
