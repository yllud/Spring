package com.multi.mvc300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BbsDAO {
	
	
	@Autowired
	SqlSessionTemplate my;
	
	public int insert(BbsVO bag) {
		int result=my.insert("bbs.create",bag);
		return result;
	}

	public int delete(int no) {
		int result=my.delete("bbs.del",no);
		return result;

	}

	public int update(BbsVO bag) {
		int result=my.update("bbs.up", bag);
		return result;
	}

	public BbsVO one(int no) {
		BbsVO bag=my.selectOne("bbs.one", no);
		return bag;
	}

}
