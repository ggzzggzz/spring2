package kr.ac.inhatc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inhatc.dto.MemberDto;
import kr.ac.inhatc.mapper.MarketMapper;

@Service
public class MarketService {
	@Autowired
	MarketMapper mapper;
	public MemberDto processLoginMember(MemberDto dto) throws Exception{
		return mapper.processLoginMember(dto);
	}
	public int processAddMember(MemberDto dto) throws Exception{
		return mapper.processAddMember(dto);
	}
}
