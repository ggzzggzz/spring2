package kr.ac.inhatc.mapper;

import java.util.HashMap;
import java.util.List;

import kr.ac.inhatc.dto.BoardDto;

public interface BoardMapper {
	List<?> selectSubjectList(String name) throws Exception;
	List<BoardDto> selectSubjectList2(String name) throws Exception;
	int selectSubjectListCount(String name) throws Exception;
	public int insertSubject(HashMap<String, String> map)throws Exception;
}
