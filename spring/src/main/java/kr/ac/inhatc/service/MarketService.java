package kr.ac.inhatc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.inhatc.dto.MemberDto;
import kr.ac.inhatc.dto.ProductDto;
import kr.ac.inhatc.mapper.MarketMapper;

@Service
public class MarketService {
	@Autowired
	MarketMapper mapper;
	@Value("${upload.path}")
	String rootPath;
	@Value("${upload.url.path}")
	String urlPath;
	
	public MemberDto processLoginMember(MemberDto member) throws Exception{
		return mapper.processLoginMember(member);
	}
	public int processAddMember(MemberDto member) throws Exception{
		return mapper.processAddMember(member);
	}
	public MemberDto processInfoMember(MemberDto member) throws Exception{
		return mapper.processInfoMember(member);
	}
	public int processUpdateMember(MemberDto member) throws Exception{
		return mapper.processUpdateMember(member);
	}
	public int deleteMember(MemberDto member) throws Exception{
		return mapper.deleteMember(member);
	}
	public int processAddProduct(ProductDto dto) throws Exception{
		return mapper.processAddProduct(dto);
	}
	public void saveImage(ProductDto dto, MultipartFile productImage) throws IllegalStateException, IOException {
		try {
			File file = new File(rootPath+"/"+productImage.getOriginalFilename());
			productImage.transferTo(file);
			dto.setFileName(urlPath+file.getName());
		} catch (Exception e) {
			//TODO handle exception
		}
	}
	public List<ProductDto> listProducts() throws Exception{
		return mapper.listProducts();
	}
	public ProductDto getProduct(ProductDto dto) throws Exception{
		return mapper.getProduct(dto);
	}
	public int processUpdateProduct(ProductDto dto) throws Exception{
		return mapper.processUpdateProduct(dto);
	}
	// deleteProduct
	public int deleteProduct(ProductDto dto) throws Exception{
		return mapper.deleteProduct(dto);
	}
}
