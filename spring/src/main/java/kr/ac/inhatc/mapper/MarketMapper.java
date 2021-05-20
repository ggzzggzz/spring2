package kr.ac.inhatc.mapper;

import kr.ac.inhatc.dto.MemberDto;
import kr.ac.inhatc.dto.ProductDto;
import java.util.List;

public interface MarketMapper {
	public MemberDto processLoginMember(MemberDto member) throws Exception;
	public int processAddMember(MemberDto member) throws Exception;
	public MemberDto processInfoMember(MemberDto member) throws Exception;
	public int processUpdateMember(MemberDto member) throws Exception;
	public int deleteMember(MemberDto member) throws Exception;
	public int processAddProduct(ProductDto dto) throws Exception;
	public List<ProductDto> listProducts() throws Exception;
	public ProductDto getProduct(ProductDto dto) throws Exception;
	public int processUpdateProduct(ProductDto dto) throws Exception;
	public int deleteProduct(ProductDto dto) throws Exception;
}
