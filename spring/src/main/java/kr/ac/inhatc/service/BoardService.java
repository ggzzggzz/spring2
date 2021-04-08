package kr.ac.inhatc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inhatc.dto.BoardDto;
import kr.ac.inhatc.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	public List<?> selectSubjectList(String name) throws Exception{
		return boardMapper.selectSubjectList(name);
	}
	public List<BoardDto> selectSubjectList2(String name) throws Exception{
		return boardMapper.selectSubjectList2(name);
	}
	public int selectSubjectListCount(String name) throws Exception{
		return boardMapper.selectSubjectListCount(name);
	}
	public int insertSubject(HashMap<String, String> map)throws Exception{
		return boardMapper.insertSubject(map);
	}
	public HashMap<String, String> boardDetail(String no)throws Exception{
		return boardMapper.boardDetail(no);
	}
	public int modifySubject(HashMap<String, String> map)throws Exception{
		return boardMapper.modifySubject(map);
	}
}
