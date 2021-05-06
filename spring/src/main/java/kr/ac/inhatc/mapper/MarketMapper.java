package kr.ac.inhatc.mapper;

import kr.ac.inhatc.dto.MemberDto;

public interface MarketMapper {
	public MemberDto processLoginMember(MemberDto dto) throws Exception;
	public int processAddMember(MemberDto dto) throws Exception;
	public MemberDto processInfoMember(MemberDto dto) throws Exception;
	public int processUpdateMember(MemberDto dto) throws Exception;
	public int deleteMember(MemberDto dto) throws Exception;
}
