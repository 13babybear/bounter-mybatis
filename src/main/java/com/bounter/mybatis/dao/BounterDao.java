package com.bounter.mybatis.dao;

import java.util.List;

import com.bounter.mybatis.entity.Bounter;

public interface BounterDao {
	
	Bounter findById(Long id);
	
	List<Bounter> findAll();
	
	void add(Bounter bounter);
	
	void batchAdd(List<Bounter> bounterList);
	
	void modify(Bounter bounter);
	
	void deleteById(Long id);
}
