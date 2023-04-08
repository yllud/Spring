package com.multi.mvc300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcertDAO {
	
	
	@Autowired
	SqlSessionTemplate my;
	
	public int insert(ConcertVO bag) {
		int result=my.insert("concert.create",bag);
		return result;
	}

	public int delete(int no) {
		int result=my.delete("concert.del",no);
		return result;

	}

	public int update(ConcertVO bag) {
		int result=my.update("concert.up", bag);
		return result;
	}

	public ConcertVO one(int no) {
		ConcertVO bag=my.selectOne("concert.one", no);
		return bag;
	}
	
	public List<ConcertVO> list(){
		List<ConcertVO> list=my.selectList("concert.all");
		return list;
	}

}
